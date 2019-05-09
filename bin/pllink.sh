#!/usr/bin/bash
java -classpath "$(dirname "$(pwd)")/lib/*" org.prolobjectlink.prolog.tuprolog.TuPrologBenchmarkRunner ${1+"$@"}