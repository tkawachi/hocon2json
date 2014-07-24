# hocon2json

A simple command to convert [Typesafe config](https://github.com/typesafehub/config) (including HOCON) to JSON.
It prints JSON to stdout.

    Usage: hocon2json [-p] srcFile [path]

Arguments

* `srcFile`: Source Typesafe config file
* `path`: Root path for generated JSON. When the source is `{"a":{"b":{"c":1}}}` and path is `a.b`, then JSON will be `{"c":1}`.

Options

* `-p`: pretty print JSON

## Installation

Use [Conscript](https://github.com/n8han/conscript) to install hocon2json.

    cs tkawachi/hocon2json
