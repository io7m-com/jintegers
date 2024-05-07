jintegers
===

[![Maven Central](https://img.shields.io/maven-central/v/com.io7m.jintegers/com.io7m.jintegers.svg?style=flat-square)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.io7m.jintegers%22)
[![Maven Central (snapshot)](https://img.shields.io/nexus/s/com.io7m.jintegers/com.io7m.jintegers?server=https%3A%2F%2Fs01.oss.sonatype.org&style=flat-square)](https://s01.oss.sonatype.org/content/repositories/snapshots/com/io7m/jintegers/)
[![Codecov](https://img.shields.io/codecov/c/github/io7m-com/jintegers.svg?style=flat-square)](https://codecov.io/gh/io7m-com/jintegers)
![Java Version](https://img.shields.io/badge/21-java?label=java&color=007fff)

![com.io7m.jintegers](./src/site/resources/jintegers.jpg?raw=true)

| JVM | Platform | Status |
|-----|----------|--------|
| OpenJDK (Temurin) Current | Linux | [![Build (OpenJDK (Temurin) Current, Linux)](https://img.shields.io/github/actions/workflow/status/io7m-com/jintegers/main.linux.temurin.current.yml)](https://www.github.com/io7m-com/jintegers/actions?query=workflow%3Amain.linux.temurin.current)|
| OpenJDK (Temurin) LTS | Linux | [![Build (OpenJDK (Temurin) LTS, Linux)](https://img.shields.io/github/actions/workflow/status/io7m-com/jintegers/main.linux.temurin.lts.yml)](https://www.github.com/io7m-com/jintegers/actions?query=workflow%3Amain.linux.temurin.lts)|
| OpenJDK (Temurin) Current | Windows | [![Build (OpenJDK (Temurin) Current, Windows)](https://img.shields.io/github/actions/workflow/status/io7m-com/jintegers/main.windows.temurin.current.yml)](https://www.github.com/io7m-com/jintegers/actions?query=workflow%3Amain.windows.temurin.current)|
| OpenJDK (Temurin) LTS | Windows | [![Build (OpenJDK (Temurin) LTS, Windows)](https://img.shields.io/github/actions/workflow/status/io7m-com/jintegers/main.windows.temurin.lts.yml)](https://www.github.com/io7m-com/jintegers/actions?query=workflow%3Amain.windows.temurin.lts)|

## jintegers

The `jintegers` package provides basic functions to pack and unpack integers
to/from byte arrays in specific byte orders.

## Status

As the Java platform evolves, libraries that may have been necessary in the
past can become unnecessary due to new platform features. The `jintegers`
package falls into this category: The new
[Foreign Function And Memory API](https://openjdk.org/jeps/424) makes much
of the functionality here redundant.

This package is in maintenance mode and will not see any new functionality.

## Features

* High coverage test suite.
* Written in pure Java 21.
* [OSGi-ready](https://www.osgi.org/)
* [JPMS-ready](https://en.wikipedia.org/wiki/Java_Platform_Module_System)
* ISC license.

## Usage

```
byte data[] = new byte[4];

Signed32.packToBytesLittleEndian(23, data);

int r = Signed32.unpackFromBytesLittleEndian(data);
```

