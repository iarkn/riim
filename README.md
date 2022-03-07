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

## License

GPL-3.0-or-later
