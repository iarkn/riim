# riim

Riim.

## Installation

You can use the mod browser to install the latest version of Riim. Open it from
Menu > Mods > Mod Browser then search for `iarkn/riim`.

If you don't want to use the mod browser for some reason, you can get the
latest build from [here](https://github.com/iarkn/riim/releases/latest).

## Building

### Prerequisites

- [Git](https://git-scm.org/downloads)
- [Maven](https://maven.apache.org/download.cgi)
- [JDK](https://adoptium.net/temurin/releases) (>= 8)
- [Android SDK cmdline-tools](https://developer.android.com/studio#command-tools)[^1]

The process should be the same no matter what operating system you are using:

    $ git clone https://github.com/iarkn/riim.git
    $ cd riim
    $ mvn package

If nothing goes wrong, the build output should be in the `target/` directory in
the form of `riim-<version>.jar`. Copy the JAR file to Mindustry's mods
directory:

- Linux: `~/.local/share/Mindustry/mods`
- Windows: `%AppData%\Roaming\Mindustry\mods`
- MacOS: `~/Library/Application Support/Mindustry/mods`
- Steam: `steam/steamapps/common/Mindustry/mods`

### Android

Make sure the `ANDROID_SDK_ROOT` environment variable is set to the parent
directory of where you unzipped the Android SDK command-line tools. Set it up
like below:

    android/ <-- value of ANDROID_SDK_ROOT
      cmdline-tools/
        latest/
          bin/
          lib/
          NOTICE.txt
          source.properties

Open the terminal and change directory to the Android SDK root directory.
After that, do the following:

    $ cd $ANDROID_SDK_ROOT/cmdline-tools/latest/bin
    $ ./sdkmanager "build-tools;32.0.0" "platforms;android-32" "platform-tools"

Add `$ANDROID_SDK_ROOT/build-tools/32.0.0` to your PATH. To build, make sure
you have ran `mvn package` first. Change directory to where the project is
and run

    $ ./scripts/package_android.sh -api 32 -game <game_version>

Build output should be in `target/` in the form of `riim-<version>-android.jar`.
This script will not work on Windows[^2], so you have to do it manually:

    $ d8 target\riim-<version>.jar ^
        --lib %ANDROID_SDK_ROOT%\platforms\android-32\android.jar ^
        --classpath %HOME%\.m2\repository\com\github\anuken\arc\arc-core\<game_version>\arc-core-<game_version>.jar ^
        --classpath %HOME%\.m2\repository\com\github\anuken\mindustry\core\<game_version>\core-<game_version>.jar ^
        --min-api 14 ^
        --output target

This will output a `classes.dex` file in the `target` folder. Put it inside the
main JAR file (or put inside a copied JAR file) and that's it.

[^1]: Required for Android builds.
[^2]: If you know batch scripting on Windows, feel free to port the script and
      submit a patch.

## License

GPL-3.0-or-later
