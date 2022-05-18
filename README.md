# riim

Riim.

## Installation

You can use the mod browser to install the latest version of Riim. Open it from
Menu > Mods > Mod Browser then search for `iarkn/riim`.

If you don't want to use the mod browser for some reason, you can get the
pre-built packages from [here](https://github.com/iarkn/riim/releases).

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md).

## Building

### Prerequisites

- [Maven](https://maven.apache.org/download.cgi)
- [JDK](https://adoptium.net/temurin/releases) (>= 17)
- [Android SDK](https://developer.android.com/studio#command-tools)[^1]

### Desktop

Run the following:

    $ mvn package

The build output should be in `target/riim-<version>.jar`. Copy the JAR file to
Mindustry's mods directory:

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

Open the terminal and change directory to the Android SDK root directory. Get
the Android SDK platform and build tools (replace the version with the latest):

    $ cd $ANDROID_SDK_ROOT/cmdline-tools/latest/bin
    $ ./sdkmanager "build-tools;32.0.0" "platforms;android-32"

Add `$ANDROID_SDK_ROOT/build-tools/32.0.0` to your PATH. On Windows, replace
`$ANDROID_SDK_ROOT` with `%ANDROID_SDK_ROOT%`. Change directory to where the
project is and do the following:

    $ cd tools
    $ mvn install
    $ cd ..
    $ mvn package riim-tools:dex

Build output should be in `target/riim-<version>-android.jar`.

[^1]: Required for Android builds. You only need the command-line tools to
      build this mod.

## License

GPL-3.0-or-later
