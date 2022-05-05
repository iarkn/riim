package riim.tools;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

import org.apache.maven.artifact.*;
import org.apache.maven.plugin.*;
import org.apache.maven.plugins.annotations.*;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.project.*;

/** Compiles Java bytecode to DEX bytecode using d8. */
@Mojo(name = "dex", requiresDependencyResolution = ResolutionScope.COMPILE_PLUS_RUNTIME)
public class DexMojo extends AbstractMojo {
    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException {
        var sdkRoot = System.getenv("ANDROID_SDK_ROOT");
        if (sdkRoot == null) sdkRoot = System.getenv("ANDROID_HOME");

        if (sdkRoot == null || !new File(sdkRoot).isDirectory()) {
            throw new MojoExecutionException(
                "Could not find path to Android SDK, make sure that you have set up " +
                "the ANDROID_SDK_ROOT environment variable correctly");
        }

        var platDirs = new File(sdkRoot, "platforms")
            .listFiles(f -> new File(f, "android.jar").exists());
        if (platDirs == null) {
            throw new MojoExecutionException(
                "Could not find the android.jar file, make sure that an " +
                "Android SDK platform is installed");
        }

        Arrays.sort(platDirs, Collections.reverseOrder());
        var androidJar = new File(platDirs[0], "android.jar");

        var build = project.getBuild();
        var buildDir = build.getDirectory();
        var buildFile = new File(buildDir, build.getFinalName() + ".jar");
        if (!buildFile.exists()) {
            throw new MojoExecutionException(
                "Could not find project artifact, run the 'package' phase first");
        }

        try {
            Set<Artifact> artifacts = project.getArtifacts();
            var classpath = artifacts.stream()
                .map(a -> "--classpath " + a.getFile().getPath())
                .collect(Collectors.joining(" "));

            var out = Path.of(buildDir, build.getFinalName() + "-android.jar");
            Files.copy(buildFile.toPath(), out, StandardCopyOption.REPLACE_EXISTING);

            exec("d8 --min-api 14 --lib " + androidJar.getPath() + " " +
                 classpath + " " + buildFile.getPath());
            exec("jar -uf " + out.toString() + " classes.dex");
            Files.deleteIfExists(Path.of("classes.dex"));
        } catch (Exception e) {
            throw new MojoExecutionException(e);
        }
    }

    /** Executes the command and waits until the process finishes. */
    private void exec(String command) throws Exception {
        try {
            var p = Runtime.getRuntime().exec(command);
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new Exception(e);
        }
    }
}
