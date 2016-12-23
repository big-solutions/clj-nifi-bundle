# clj-nifi-bundle

A Boot template for clj-nifi projects.

## Usage

Crete new projects from template:

`boot -d clj-nifi-bundle/boot-template:0.1.0-SNAPSHOT -d seancorfield/boot-new new -t clj-nifi-bundle -n YOUR-PROJECT-NAME`

Optionally, if your IDE needs a `project.clj` to resolve dependencies, you can generate it like this:


    cd YOUR-PROJECT-NAME
    boot -d onetom/boot-lein-generate generate

If, for whatever reason, you need to declare this template as a dependency, this is its id:

[![Clojars Project](https://img.shields.io/clojars/v/clj-nifi-bundle/boot-template.svg)](https://clojars.org/clj-nifi-bundle/boot-template)

## See also

- [clj-nifi](https:/github.com/big-solutions/clj-nifi) - a Clojure DSL for Apache NiFi
- [boot-nifi](https:/github.com/big-solutions/boot-nifi) - a Clojure DSL for Apache NiFi

## License

Copyright © 2016 Big Solutions

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
