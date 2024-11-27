# Before you start
run `mvn clean install` first, then start the app

# AspectJ CTW ( compile time weavering)
This does not require `-javaagent` injiect into VM

# Java
I'm using java 11, and set module's `language level` to 8.
I don't know how it works, but it works.

# Pom
Take a look of the `dependencies` and `plugins`, CTW requires AspectJ complier engaged in the compiling.
Because, it needs to do bytecode enhance during compiling time.