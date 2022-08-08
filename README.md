# Kotlin Kata Base
[![Kotlin CI with Gradle](https://github.com/rstraub/kotlin-kata-base/actions/workflows/gradle.yml/badge.svg)](https://github.com/rstraub/kotlin-kata-base/actions/workflows/gradle.yml)

Starter project for Code Katas in Kotlin. Batteries included.

Included:

| Tool                                                  | Type                         |
|-------------------------------------------------------|------------------------------|
| [Gradle](https://gradle.org)                          | Build Tool                   |
| [Junit 5](https://junit.org/junit5/)                  | Testing Library              |
| [Kotest](https://kotest.io)                           | Testing Library              |
| [Mockk](https://mockk.io)                             | Mocking Library              |
| [Github Actions](https://github.com/features/actions) | Continuous Integration       |
| [Github Dependabot](https://github.com/dependabot)    | Automatic Dependency Updates |

## Installation

This project requires some tooling on your machine, as described in the `.sdkmanrc`. If you use
sdkman `cd` into the root of this project and run:

```shell
sdk env install
```

to install the required sdks. You can also install them yourself.

## Run

```shell
gradle run
```

## Compile

```shell
gradle compile
```

## Tests

Run unit tests:

```shell
gradle test
```
