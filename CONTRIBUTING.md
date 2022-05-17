# Contributing

Pull requests containing only code formatting or (re)sprites are not accepted.

## Bugs

Submit bug reports [here](https://github.com/iarkn/riim/issues/new/choose). Keep
in mind that the issue tracker is only used for reporting bugs. If you have any
questions or suggestions, send threats to me on Matrix (@iarkn:envs.net).

## Code

### Follow the Kotlin coding conventions

For enum and compile-time constants, use `SCREAMING_CASE`:

```kt
enum class Planet(legs: Int) {
    DONKEY(2),
    TABLE(5),
    SHRIMP(13),
    FISH(1),
}

const val HORSE_LEGS = 5 // compile-time constant
val immutableValue = someFunction() // not compile-time constant
```

### Keep the text width close to 80 columns, at most 90

Statements that exceed the limit should be broken to several parts (see the
Kotlin coding conventions). This way, you don't have scroll sideways just to see
what the long statement does, especially for devices with narrow display and
people using split view in their text editors.

### See also

* [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html)
* [Mindustry contributing guidelines](https://github.com/Anuken/Mindustry/blob/master/CONTRIBUTING.md)
