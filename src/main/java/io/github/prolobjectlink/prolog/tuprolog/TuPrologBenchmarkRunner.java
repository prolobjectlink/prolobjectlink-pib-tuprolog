/*-
 * #%L
 * prolobjectlink-jpi-benchmark
 * %%
 * Copyright (C) 2012 - 2019 Prolobjectlink Project
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */
package io.github.prolobjectlink.prolog.tuprolog;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import io.github.prolobjectlink.prolog.AbstractBenchmarkRunner;
import io.github.prolobjectlink.prolog.BenchmarkRunner;
import io.github.prolobjectlink.prolog.Prolog;
import io.github.prolobjectlink.prolog.PrologEngine;
import io.github.prolobjectlink.prolog.PrologProvider;
import io.github.prolobjectlink.prolog.PrologQuery;
import io.github.prolobjectlink.prolog.PrologTerm;
import io.github.prolobjectlink.prolog.PrologVariable;
import io.github.prolobjectlink.prolog.tuprolog.TuProlog;

public class TuPrologBenchmarkRunner extends AbstractBenchmarkRunner implements BenchmarkRunner {

	@State(Scope.Benchmark)
	public static class ExecutionPlan {

		PrologEngine engine;
		PrologQuery query;

		@Setup(Level.Invocation)
		public void setUp() {

			PrologProvider provider = Prolog.getProvider(TuProlog.class);

			//
			engine = provider.newEngine();

			//
			engine.asserta(provider.newStructure("pop", provider.newAtom("china"), provider.newInteger(8250)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("india"), provider.newInteger(5863)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("ussr"), provider.newInteger(2521)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("usa"), provider.newInteger(2129)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("indonesia"), provider.newInteger(1276)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("japan"), provider.newInteger(1097)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("brazil"), provider.newInteger(1042)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("bangladesh"), provider.newInteger(750)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("pakistan"), provider.newInteger(682)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("w_germany"), provider.newInteger(620)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("nigeria"), provider.newInteger(613)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("mexico"), provider.newInteger(581)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("uk"), provider.newInteger(559)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("italy"), provider.newInteger(554)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("france"), provider.newInteger(525)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("philippines"), provider.newInteger(415)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("thailand"), provider.newInteger(410)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("turkey"), provider.newInteger(383)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("egypt"), provider.newInteger(364)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("spain"), provider.newInteger(352)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("poland"), provider.newInteger(337)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("s_korea"), provider.newInteger(335)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("iran"), provider.newInteger(320)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("ethiopia"), provider.newInteger(272)));
			engine.asserta(provider.newStructure("pop", provider.newAtom("argentina"), provider.newInteger(251)));

			//
			engine.asserta(provider.newStructure("area", provider.newAtom("china"), provider.newInteger(3380)));
			engine.asserta(provider.newStructure("area", provider.newAtom("india"), provider.newInteger(1139)));
			engine.asserta(provider.newStructure("area", provider.newAtom("ussr"), provider.newInteger(8708)));
			engine.asserta(provider.newStructure("area", provider.newAtom("usa"), provider.newInteger(3609)));
			engine.asserta(provider.newStructure("area", provider.newAtom("indonesia"), provider.newInteger(570)));
			engine.asserta(provider.newStructure("area", provider.newAtom("japan"), provider.newInteger(148)));
			engine.asserta(provider.newStructure("area", provider.newAtom("brazil"), provider.newInteger(3288)));
			engine.asserta(provider.newStructure("area", provider.newAtom("bangladesh"), provider.newInteger(55)));
			engine.asserta(provider.newStructure("area", provider.newAtom("pakistan"), provider.newInteger(311)));
			engine.asserta(provider.newStructure("area", provider.newAtom("w_germany"), provider.newInteger(96)));
			engine.asserta(provider.newStructure("area", provider.newAtom("nigeria"), provider.newInteger(373)));
			engine.asserta(provider.newStructure("area", provider.newAtom("mexico"), provider.newInteger(764)));
			engine.asserta(provider.newStructure("area", provider.newAtom("uk"), provider.newInteger(86)));
			engine.asserta(provider.newStructure("area", provider.newAtom("italy"), provider.newInteger(116)));
			engine.asserta(provider.newStructure("area", provider.newAtom("france"), provider.newInteger(213)));
			engine.asserta(provider.newStructure("area", provider.newAtom("philippines"), provider.newInteger(90)));
			engine.asserta(provider.newStructure("area", provider.newAtom("thailand"), provider.newInteger(200)));
			engine.asserta(provider.newStructure("area", provider.newAtom("turkey"), provider.newInteger(296)));
			engine.asserta(provider.newStructure("area", provider.newAtom("egypt"), provider.newInteger(386)));
			engine.asserta(provider.newStructure("area", provider.newAtom("spain"), provider.newInteger(190)));
			engine.asserta(provider.newStructure("area", provider.newAtom("poland"), provider.newInteger(121)));
			engine.asserta(provider.newStructure("area", provider.newAtom("s_korea"), provider.newInteger(37)));
			engine.asserta(provider.newStructure("area", provider.newAtom("iran"), provider.newInteger(628)));
			engine.asserta(provider.newStructure("area", provider.newAtom("ethiopia"), provider.newInteger(350)));
			engine.asserta(provider.newStructure("area", provider.newAtom("argentina"), provider.newInteger(1080)));

//        query :- 
//              density( C1, D1 ), 
//              density( C2, D2 ), 
//              D1 > D2, 
//              20 * D1 < 21 * D2.
			PrologVariable c1 = provider.newVariable(0);
			PrologVariable d1 = provider.newVariable("D1", 1);
			PrologVariable c2 = provider.newVariable(2);
			PrologVariable d2 = provider.newVariable("D2", 3);
			PrologTerm left = provider.newStructure(provider.newInteger(20), "'*'", d1);
			PrologTerm rigth = provider.newStructure(provider.newInteger(21), "'*'", d2);
			engine.asserta(provider.newAtom("query"), /* :- */
					provider.newStructure("density", c1, d1), provider.newStructure("density", c2, d2),
					provider.newStructure(d1, "'>'", d2), provider.newStructure(left, "'<'", rigth));

//        density( C, D ) :- 
//                  pop( C, P ), 
//                  area( C, A ), 
//                  D is ( P * 100 ) / A.
			PrologVariable c = provider.newVariable("C", 0);
			PrologVariable d = provider.newVariable("D", 1);
			PrologVariable p = provider.newVariable("P", 1);
			PrologVariable a = provider.newVariable("A", 1);
			engine.asserta(provider.newStructure("density", c, d), /* :- */
					provider.newStructure("pop", c, p), provider.newStructure("area", c, a),
					provider.newStructure(d, "is", provider
							.newStructure(provider.newStructure(p, "'*'", provider.newInteger(100)), "'/'", a)));

			// employee relationship
			engine.assertz("employee( mcardon, 1, 5 )");
			engine.assertz("employee( treeman, 2, 3 )");
			engine.assertz("employee( chapman, 1, 2 )");
			engine.assertz("employee( claessen, 4, 1 )");
			engine.assertz("employee( petersen, 5, 8 )");
			engine.assertz("employee( cohn, 1, 7 )");
			engine.assertz("employee( duffy, 1, 9 )");

			// department relationship
			engine.assertz("department( 1, board )");
			engine.assertz("department( 2, human_resources )");
			engine.assertz("department( 3, production )");
			engine.assertz("department( 4, technical_services )");
			engine.assertz("department( 5, administration )");

			// salary relationship
			engine.assertz("salary( 1, 1000 )");
			engine.assertz("salary( 2, 1500 )");
			engine.assertz("salary( 3, 2000 )");
			engine.assertz("salary( 4, 2500 )");
			engine.assertz("salary( 5, 3000 )");
			engine.assertz("salary( 6, 3500 )");
			engine.assertz("salary( 7, 4000 )");
			engine.assertz("salary( 8, 4500 )");
			engine.assertz("salary( 9, 5000 )");

		}
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void benchQuery(ExecutionPlan plan) {
		plan.engine.query("query").oneSolution();
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void benchQueryAll(ExecutionPlan plan) {
		plan.engine.query("employee(Name,Dpto,Scale),department(Dpto,DepartmentName),salary(Scale,Money)")
				.allSolutions();
	}

	public static void main(String[] args) throws RunnerException {

		OptionsBuilder builder = new OptionsBuilder();
		builder.include(TuPrologBenchmarkRunner.class.getSimpleName());
		Options opt = builder.build();
		Collection<RunResult> run = new Runner(opt).run();
		new TuPrologBenchmarkRunner().output(run);

	}

}
