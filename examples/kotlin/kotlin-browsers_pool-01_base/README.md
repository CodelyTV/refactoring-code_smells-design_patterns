# Kotlin Bootstrap (base / project skeleton)

[![Software License][ico-license]][link-license]

## Introduction

This is a repository intended to serve as a starting point if you want to bootstrap a project in Kotlin.

It could be useful if you want to start from scratch a kata or a little exercise or project. The idea is that you don't have to worry about the boilerplate
* Latest stable kotlin version
* Best practices applied:
    * [`README.md`][link-readme]
    * [`LICENSE`][link-license]
    * [`build.gradle.kts`][link-build-gradle]
    * [`.gitignore`][link-gitignore]
* Some useful resources to start coding

## How To Start

You just need to manually clone [this repo](https://github.com/CodelyTV/kotlin-basic-skeleton)

### Cloning the repository

We recommend to follow the next step by step process in order to avoid adding the bootstrap project commits to your project Git history:

1. [Use this repositoy template](https://github.com/CodelyTV/kotlin-basic-skeleton/generate)
2. Clone your project
3. Move to the project directory: `cd your-project-name`
5. Build the project for the first time: `./gradlew build`
6. Run all the checks: `./gradlew check`. This will do some checks that you can perform with isolated commands:
    1. [Klint](https://ktlint.github.io/) using [Spotless](https://github.com/diffplug/spotless): `./gradlew spotlessCheck`. If you want to fix style issues automatically: `./gradlew spotlessApply`.
    2. [Kotlin test](https://kotlinlang.org/api/latest/kotlin.test/): `./gradlew test`.
7. To just run the project execute: `./gradlew run`
7. Start coding!

## Helpful resources

### Kotlin

* [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
* [Comparison between Kotlin and Java](https://kotlinlang.org/docs/comparison-to-java.html)

### Kotlin test

* [Test code using JUnit in JVM - tutorial](https://kotlinlang.org/docs/jvm-test-using-junit.html)
* [JUnit5 assertions](https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html)


## About

This hopefully helpful utility has been developed by [CodelyTV][link-author] and [contributors][link-contributors].

We'll try to maintain this project as simple as possible, but Pull Requests are welcome!

## License

The MIT License (MIT). Please see [License File][link-license] for more information.

[ico-license]: https://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat-square

[link-license]: LICENSE
[link-readme]: README.md
[link-gitignore]: .gitignore
[link-build-gradle]: build.gradle.kts
[link-author]: https://github.com/CodelyTV
[link-contributors]: https://github.com/CodelyTV/kotlin-basic-skeleton/graphs/contributors
