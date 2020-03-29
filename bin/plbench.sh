#!/usr/bin/bash
java -classpath "$(dirname "$(pwd)")/lib/*" io.github.prolobjectlink.prolog.tuprolog.TuPrologBenchmarkRunner ${1+"$@"}