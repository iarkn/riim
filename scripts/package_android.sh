#!/bin/sh

# Compile Java bytecode to DEX bytecode using d8. Make sure that the
# ANDROID_SDK_ROOT environment variable is set to where your Android SDK
# directory is.
#
# Usage: ./package_android.sh [options] FILE
#
#   -o <path>        output path, defaults to FILE-android.jar if not set
#                    or path is a directory
#   -api <level>     level of Android API
#   -game <version>  game version

# $@ - text
err_die() {
    echo "error: $@" >&2
    exit 1
}

while [ $# -gt 0 ]; do
    case "$1" in
        -o)
            OUT_FILE="$2"
            shift 2
            ;;
        -api)
            API_LEVEL="$2"
            shift 2
            ;;
        -game)
            GAME_VER="$2"
            shift 2
            ;;
        -*)
            err_die "unknown option '$1'"
            ;;
        *)
            FILE="$1"
            shift
            ;;
    esac
done

[ -d "$OUT_FILE" ] && OUT_FILE="$OUT_FILE/${FILE%.*}-android.jar"
[ -z "$OUT_FILE" ] && OUT_FILE="${FILE%.*}-android.jar"

OUT_DIR="$(dirname $OUT_FILE)"

[ -z "$GAME_VER" ]  && err_die "game version is not specifed, use the '-game <version>' option"
[ -z "$API_LEVEL" ] && err_die "api level is not specified, use the '-api <level>' option"

[ -z "$FILE" ]   && err_die 'file is not specified'
[ ! -e "$FILE" ] && err_die "file '$FILE' does not exist"

SDK_ROOT="${ANDROID_SDK_ROOT:-$ANDROID_HOME}"
ANDROID_JAR="$SDK_ROOT/platforms/android-$API_LEVEL/android.jar"
MIND_JAR="$HOME/.m2/repository/com/github/anuken/mindustry/core/$GAME_VER/core-$GAME_VER.jar"
ARC_JAR="$HOME/.m2/repository/com/github/anuken/arc/arc-core/$GAME_VER/arc-core-$GAME_VER.jar"

[ ! -d "$SDK_ROOT" ] && \
    err_die "couldn't find '$SDK_ROOT', make sure that ANDROID_SDK_ROOT is set properly"
[ ! -e "$ANDROID_JAR" ] && \
    err_die "couldn't find '$ANDROID_JAR', make sure 'platforms;android-$API_LEVEL' is installed"

rm -f "$OUT_FILE"
cp "$FILE" "$OUT_FILE"

d8 "$FILE" \
    --lib "$ANDROID_JAR" --classpath "$ARC_JAR" --classpath "$MIND_JAR" \
    --min-api 14 --output "$OUT_DIR"

zip -qg "$OUT_FILE" "$OUT_DIR/classes.dex"
rm -f "$OUT_DIR/classes.dex"
