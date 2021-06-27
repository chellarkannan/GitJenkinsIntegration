#!/bin/bash
javadoc -docletpath target/dockerproject1-0.0.1-SNAPSHOT-jar-with-dependencies.jar -doclet dockerproject1.dockerproject1.Doclet "$@"
