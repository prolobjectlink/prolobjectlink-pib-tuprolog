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

import java.util.Arrays;
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
import io.github.prolobjectlink.prolog.PrologList;
import io.github.prolobjectlink.prolog.PrologProvider;
import io.github.prolobjectlink.prolog.PrologQuery;
import io.github.prolobjectlink.prolog.PrologTerm;
import io.github.prolobjectlink.prolog.PrologVariable;

public class TuPrologBenchmarkRunner extends AbstractBenchmarkRunner implements BenchmarkRunner {

	@State(Scope.Benchmark)
	public static class ExecutionPlan {

		PrologProvider provider;
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

			// index
			engine.assertz(provider.newAtom("index_clause"),

					provider.newStructure("p", provider.newAtom("a")),
					provider.newStructure("p", provider.newList(provider.newAtom("a"))),
					provider.newStructure("p", provider.newStructure("s", provider.newAtom("a"))),
					provider.newStructure("p", provider.newAtom("b")),
					provider.newStructure("p", provider.newList(provider.newAtom("b"))),
					provider.newStructure("p", provider.newStructure("t", provider.newAtom("b"))),
					provider.newStructure("p", provider.newAtom("c")),
					provider.newStructure("p", provider.newList(provider.newAtom("c"))),
					provider.newStructure("p", provider.newStructure("u", provider.newAtom("c"))),
					provider.newStructure("p", provider.newAtom("d")),
					provider.newStructure("p", provider.newList(provider.newAtom("d"))),
					provider.newStructure("p", provider.newStructure("v", provider.newAtom("d"))),
					provider.newStructure("p", provider.newAtom("e")),
					provider.newStructure("p", provider.newList(provider.newAtom("e"))),
					provider.newStructure("p", provider.newStructure("w", provider.newAtom("e"))),
					provider.newStructure("p", provider.newAtom("f")),
					provider.newStructure("p", provider.newList(provider.newAtom("f"))),
					provider.newStructure("p", provider.newStructure("x", provider.newAtom("f"))),
					provider.newStructure("p", provider.newAtom("g")),
					provider.newStructure("p", provider.newList(provider.newAtom("g"))),

					provider.newStructure("p", provider.newStructure("y", provider.newAtom("g")))

			);

			engine.assertz(provider.newStructure("p", provider.newAtom("a")));
			engine.assertz(provider.newStructure("p", provider.newList(provider.newAtom("a"))));
			engine.assertz(provider.newStructure("p", provider.newStructure("s", provider.newAtom("a"))));
			engine.assertz(provider.newStructure("p", provider.newAtom("b")));
			engine.assertz(provider.newStructure("p", provider.newList(provider.newAtom("b"))));
			engine.assertz(provider.newStructure("p", provider.newStructure("t", provider.newAtom("b"))));
			engine.assertz(provider.newStructure("p", provider.newAtom("c")));
			engine.assertz(provider.newStructure("p", provider.newList(provider.newAtom("c"))));
			engine.assertz(provider.newStructure("p", provider.newStructure("u", provider.newAtom("c"))));
			engine.assertz(provider.newStructure("p", provider.newAtom("d")));
			engine.assertz(provider.newStructure("p", provider.newList(provider.newAtom("d"))));
			engine.assertz(provider.newStructure("p", provider.newStructure("v", provider.newAtom("d"))));
			engine.assertz(provider.newStructure("p", provider.newAtom("e")));
			engine.assertz(provider.newStructure("p", provider.newList(provider.newAtom("e"))));
			engine.assertz(provider.newStructure("p", provider.newStructure("w", provider.newAtom("e"))));
			engine.assertz(provider.newStructure("p", provider.newAtom("f")));
			engine.assertz(provider.newStructure("p", provider.newList(provider.newAtom("f"))));
			engine.assertz(provider.newStructure("p", provider.newStructure("x", provider.newAtom("f"))));
			engine.assertz(provider.newStructure("p", provider.newAtom("g")));
			engine.assertz(provider.newStructure("p", provider.newList(provider.newAtom("g"))));
			engine.assertz(provider.newStructure("p", provider.newStructure("y", provider.newAtom("g"))));

			// boresea
			engine.assertz(provider.newAtom("boresea"), provider.newAtom("lips1"));
			engine.assertz(provider.newAtom("lips1"), provider.newAtom("lips2"));
			engine.assertz(provider.newAtom("lips2"), provider.newAtom("lips3"));
			engine.assertz(provider.newAtom("lips3"), provider.newAtom("lips4"));
			engine.assertz(provider.newAtom("lips4"), provider.newAtom("lips5"));
			engine.assertz(provider.newAtom("lips5"), provider.newAtom("lips6"));
			engine.assertz(provider.newAtom("lips6"), provider.newAtom("lips7"));
			engine.assertz(provider.newAtom("lips7"), provider.newAtom("lips8"));
			engine.assertz(provider.newAtom("lips8"), provider.newAtom("lips9"));
			engine.assertz(provider.newAtom("lips9"), provider.newAtom("lips10"));
			engine.assertz(provider.newAtom("lips10"), provider.newAtom("lips11"));
			engine.assertz(provider.newAtom("lips11"), provider.newAtom("lips12"));
			engine.assertz(provider.newAtom("lips12"), provider.newAtom("lips13"));
			engine.assertz(provider.newAtom("lips13"), provider.newAtom("lips14"));
			engine.assertz(provider.newAtom("lips14"), provider.newAtom("lips15"));
			engine.assertz(provider.newAtom("lips15"), provider.newAtom("lips16"));
			engine.assertz(provider.newAtom("lips16"), provider.newAtom("lips17"));
			engine.assertz(provider.newAtom("lips17"), provider.newAtom("lips18"));
			engine.assertz(provider.newAtom("lips18"), provider.newAtom("lips19"));
			engine.assertz(provider.newAtom("lips19"), provider.newAtom("lips20"));
			engine.assertz(provider.newAtom("lips20"), provider.newAtom("lips21"));
			engine.assertz(provider.newAtom("lips21"), provider.newAtom("lips22"));
			engine.assertz(provider.newAtom("lips22"), provider.newAtom("lips23"));
			engine.assertz(provider.newAtom("lips23"), provider.newAtom("lips24"));
			engine.assertz(provider.newAtom("lips24"), provider.newAtom("lips25"));
			engine.assertz(provider.newAtom("lips25"), provider.newAtom("lips26"));
			engine.assertz(provider.newAtom("lips26"), provider.newAtom("lips27"));
			engine.assertz(provider.newAtom("lips27"), provider.newAtom("lips28"));
			engine.assertz(provider.newAtom("lips28"), provider.newAtom("lips29"));
			engine.assertz(provider.newAtom("lips29"), provider.newAtom("lips30"));
			engine.assertz(provider.newAtom("lips30"), provider.newAtom("lips31"));
			engine.assertz(provider.newAtom("lips31"), provider.newAtom("lips32"));
			engine.assertz(provider.newAtom("lips32"), provider.newAtom("lips33"));
			engine.assertz(provider.newAtom("lips33"), provider.newAtom("lips34"));
			engine.assertz(provider.newAtom("lips34"), provider.newAtom("lips35"));
			engine.assertz(provider.newAtom("lips35"), provider.newAtom("lips36"));
			engine.assertz(provider.newAtom("lips36"), provider.newAtom("lips37"));
			engine.assertz(provider.newAtom("lips37"), provider.newAtom("lips38"));
			engine.assertz(provider.newAtom("lips38"), provider.newAtom("lips39"));
			engine.assertz(provider.newAtom("lips39"), provider.newAtom("lips40"));
			engine.assertz(provider.newAtom("lips40"), provider.newAtom("lips41"));
			engine.assertz(provider.newAtom("lips41"), provider.newAtom("lips42"));
			engine.assertz(provider.newAtom("lips42"), provider.newAtom("lips43"));
			engine.assertz(provider.newAtom("lips43"), provider.newAtom("lips44"));
			engine.assertz(provider.newAtom("lips44"), provider.newAtom("lips45"));
			engine.assertz(provider.newAtom("lips45"), provider.newAtom("lips46"));
			engine.assertz(provider.newAtom("lips46"), provider.newAtom("lips47"));
			engine.assertz(provider.newAtom("lips47"), provider.newAtom("lips48"));
			engine.assertz(provider.newAtom("lips48"), provider.newAtom("lips49"));
			engine.assertz(provider.newAtom("lips49"), provider.newAtom("lips50"));
			engine.assertz(provider.newAtom("lips50"), provider.newAtom("lips51"));
			engine.assertz(provider.newAtom("lips51"), provider.newAtom("lips52"));
			engine.assertz(provider.newAtom("lips52"), provider.newAtom("lips53"));
			engine.assertz(provider.newAtom("lips53"), provider.newAtom("lips54"));
			engine.assertz(provider.newAtom("lips54"), provider.newAtom("lips55"));
			engine.assertz(provider.newAtom("lips55"), provider.newAtom("lips56"));
			engine.assertz(provider.newAtom("lips56"), provider.newAtom("lips57"));
			engine.assertz(provider.newAtom("lips57"), provider.newAtom("lips58"));
			engine.assertz(provider.newAtom("lips58"), provider.newAtom("lips59"));
			engine.assertz(provider.newAtom("lips59"), provider.newAtom("lips60"));
			engine.assertz(provider.newAtom("lips60"), provider.newAtom("lips61"));
			engine.assertz(provider.newAtom("lips61"), provider.newAtom("lips62"));
			engine.assertz(provider.newAtom("lips62"), provider.newAtom("lips63"));
			engine.assertz(provider.newAtom("lips63"), provider.newAtom("lips64"));
			engine.assertz(provider.newAtom("lips64"), provider.newAtom("lips65"));
			engine.assertz(provider.newAtom("lips65"), provider.newAtom("lips66"));
			engine.assertz(provider.newAtom("lips66"), provider.newAtom("lips67"));
			engine.assertz(provider.newAtom("lips67"), provider.newAtom("lips68"));
			engine.assertz(provider.newAtom("lips68"), provider.newAtom("lips69"));
			engine.assertz(provider.newAtom("lips69"), provider.newAtom("lips70"));
			engine.assertz(provider.newAtom("lips70"), provider.newAtom("lips71"));
			engine.assertz(provider.newAtom("lips71"), provider.newAtom("lips72"));
			engine.assertz(provider.newAtom("lips72"), provider.newAtom("lips73"));
			engine.assertz(provider.newAtom("lips73"), provider.newAtom("lips74"));
			engine.assertz(provider.newAtom("lips74"), provider.newAtom("lips75"));
			engine.assertz(provider.newAtom("lips75"), provider.newAtom("lips76"));
			engine.assertz(provider.newAtom("lips76"), provider.newAtom("lips77"));
			engine.assertz(provider.newAtom("lips77"), provider.newAtom("lips78"));
			engine.assertz(provider.newAtom("lips78"), provider.newAtom("lips79"));
			engine.assertz(provider.newAtom("lips79"), provider.newAtom("lips80"));
			engine.assertz(provider.newAtom("lips80"), provider.newAtom("lips81"));
			engine.assertz(provider.newAtom("lips81"), provider.newAtom("lips82"));
			engine.assertz(provider.newAtom("lips82"), provider.newAtom("lips83"));
			engine.assertz(provider.newAtom("lips83"), provider.newAtom("lips84"));
			engine.assertz(provider.newAtom("lips84"), provider.newAtom("lips85"));
			engine.assertz(provider.newAtom("lips85"), provider.newAtom("lips86"));
			engine.assertz(provider.newAtom("lips86"), provider.newAtom("lips87"));
			engine.assertz(provider.newAtom("lips87"), provider.newAtom("lips88"));
			engine.assertz(provider.newAtom("lips88"), provider.newAtom("lips89"));
			engine.assertz(provider.newAtom("lips89"), provider.newAtom("lips90"));
			engine.assertz(provider.newAtom("lips90"), provider.newAtom("lips91"));
			engine.assertz(provider.newAtom("lips91"), provider.newAtom("lips92"));
			engine.assertz(provider.newAtom("lips92"), provider.newAtom("lips93"));
			engine.assertz(provider.newAtom("lips93"), provider.newAtom("lips94"));
			engine.assertz(provider.newAtom("lips94"), provider.newAtom("lips95"));
			engine.assertz(provider.newAtom("lips95"), provider.newAtom("lips96"));
			engine.assertz(provider.newAtom("lips96"), provider.newAtom("lips97"));
			engine.assertz(provider.newAtom("lips97"), provider.newAtom("lips98"));
			engine.assertz(provider.newAtom("lips98"), provider.newAtom("lips99"));
			engine.assertz(provider.newAtom("lips99"), provider.newAtom("lips100"));
			engine.assertz(provider.newAtom("lips100"), provider.newAtom("lips101"));
			engine.assertz(provider.newAtom("lips101"), provider.newAtom("lips102"));
			engine.assertz(provider.newAtom("lips102"), provider.newAtom("lips103"));
			engine.assertz(provider.newAtom("lips103"), provider.newAtom("lips104"));
			engine.assertz(provider.newAtom("lips104"), provider.newAtom("lips105"));
			engine.assertz(provider.newAtom("lips105"), provider.newAtom("lips106"));
			engine.assertz(provider.newAtom("lips106"), provider.newAtom("lips107"));
			engine.assertz(provider.newAtom("lips107"), provider.newAtom("lips108"));
			engine.assertz(provider.newAtom("lips108"), provider.newAtom("lips109"));
			engine.assertz(provider.newAtom("lips109"), provider.newAtom("lips110"));
			engine.assertz(provider.newAtom("lips110"), provider.newAtom("lips111"));
			engine.assertz(provider.newAtom("lips111"), provider.newAtom("lips112"));
			engine.assertz(provider.newAtom("lips112"), provider.newAtom("lips113"));
			engine.assertz(provider.newAtom("lips113"), provider.newAtom("lips114"));
			engine.assertz(provider.newAtom("lips114"), provider.newAtom("lips115"));
			engine.assertz(provider.newAtom("lips115"), provider.newAtom("lips116"));
			engine.assertz(provider.newAtom("lips116"), provider.newAtom("lips117"));
			engine.assertz(provider.newAtom("lips117"), provider.newAtom("lips118"));
			engine.assertz(provider.newAtom("lips118"), provider.newAtom("lips119"));
			engine.assertz(provider.newAtom("lips119"), provider.newAtom("lips120"));
			engine.assertz(provider.newAtom("lips120"), provider.newAtom("lips121"));
			engine.assertz(provider.newAtom("lips121"), provider.newAtom("lips122"));
			engine.assertz(provider.newAtom("lips122"), provider.newAtom("lips123"));
			engine.assertz(provider.newAtom("lips123"), provider.newAtom("lips124"));
			engine.assertz(provider.newAtom("lips124"), provider.newAtom("lips125"));
			engine.assertz(provider.newAtom("lips125"), provider.newAtom("lips126"));
			engine.assertz(provider.newAtom("lips126"), provider.newAtom("lips127"));
			engine.assertz(provider.newAtom("lips127"), provider.newAtom("lips128"));
			engine.assertz(provider.newAtom("lips128"), provider.newAtom("lips129"));
			engine.assertz(provider.newAtom("lips129"), provider.newAtom("lips130"));
			engine.assertz(provider.newAtom("lips130"), provider.newAtom("lips131"));
			engine.assertz(provider.newAtom("lips131"), provider.newAtom("lips132"));
			engine.assertz(provider.newAtom("lips132"), provider.newAtom("lips133"));
			engine.assertz(provider.newAtom("lips133"), provider.newAtom("lips134"));
			engine.assertz(provider.newAtom("lips134"), provider.newAtom("lips135"));
			engine.assertz(provider.newAtom("lips135"), provider.newAtom("lips136"));
			engine.assertz(provider.newAtom("lips136"), provider.newAtom("lips137"));
			engine.assertz(provider.newAtom("lips137"), provider.newAtom("lips138"));
			engine.assertz(provider.newAtom("lips138"), provider.newAtom("lips139"));
			engine.assertz(provider.newAtom("lips139"), provider.newAtom("lips140"));
			engine.assertz(provider.newAtom("lips140"), provider.newAtom("lips141"));
			engine.assertz(provider.newAtom("lips141"), provider.newAtom("lips142"));
			engine.assertz(provider.newAtom("lips142"), provider.newAtom("lips143"));
			engine.assertz(provider.newAtom("lips143"), provider.newAtom("lips144"));
			engine.assertz(provider.newAtom("lips144"), provider.newAtom("lips145"));
			engine.assertz(provider.newAtom("lips145"), provider.newAtom("lips146"));
			engine.assertz(provider.newAtom("lips146"), provider.newAtom("lips147"));
			engine.assertz(provider.newAtom("lips147"), provider.newAtom("lips148"));
			engine.assertz(provider.newAtom("lips148"), provider.newAtom("lips149"));
			engine.assertz(provider.newAtom("lips149"), provider.newAtom("lips150"));
			engine.assertz(provider.newAtom("lips150"), provider.newAtom("lips151"));
			engine.assertz(provider.newAtom("lips151"), provider.newAtom("lips152"));
			engine.assertz(provider.newAtom("lips152"), provider.newAtom("lips153"));
			engine.assertz(provider.newAtom("lips153"), provider.newAtom("lips154"));
			engine.assertz(provider.newAtom("lips154"), provider.newAtom("lips155"));
			engine.assertz(provider.newAtom("lips155"), provider.newAtom("lips156"));
			engine.assertz(provider.newAtom("lips156"), provider.newAtom("lips157"));
			engine.assertz(provider.newAtom("lips157"), provider.newAtom("lips158"));
			engine.assertz(provider.newAtom("lips158"), provider.newAtom("lips159"));
			engine.assertz(provider.newAtom("lips159"), provider.newAtom("lips160"));
			engine.assertz(provider.newAtom("lips160"), provider.newAtom("lips161"));
			engine.assertz(provider.newAtom("lips161"), provider.newAtom("lips162"));
			engine.assertz(provider.newAtom("lips162"), provider.newAtom("lips163"));
			engine.assertz(provider.newAtom("lips163"), provider.newAtom("lips164"));
			engine.assertz(provider.newAtom("lips164"), provider.newAtom("lips165"));
			engine.assertz(provider.newAtom("lips165"), provider.newAtom("lips166"));
			engine.assertz(provider.newAtom("lips166"), provider.newAtom("lips167"));
			engine.assertz(provider.newAtom("lips167"), provider.newAtom("lips168"));
			engine.assertz(provider.newAtom("lips168"), provider.newAtom("lips169"));
			engine.assertz(provider.newAtom("lips169"), provider.newAtom("lips170"));
			engine.assertz(provider.newAtom("lips170"), provider.newAtom("lips171"));
			engine.assertz(provider.newAtom("lips171"), provider.newAtom("lips172"));
			engine.assertz(provider.newAtom("lips172"), provider.newAtom("lips173"));
			engine.assertz(provider.newAtom("lips173"), provider.newAtom("lips174"));
			engine.assertz(provider.newAtom("lips174"), provider.newAtom("lips175"));
			engine.assertz(provider.newAtom("lips175"), provider.newAtom("lips176"));
			engine.assertz(provider.newAtom("lips176"), provider.newAtom("lips177"));
			engine.assertz(provider.newAtom("lips177"), provider.newAtom("lips178"));
			engine.assertz(provider.newAtom("lips178"), provider.newAtom("lips179"));
			engine.assertz(provider.newAtom("lips179"), provider.newAtom("lips180"));
			engine.assertz(provider.newAtom("lips180"), provider.newAtom("lips181"));
			engine.assertz(provider.newAtom("lips181"), provider.newAtom("lips182"));
			engine.assertz(provider.newAtom("lips182"), provider.newAtom("lips183"));
			engine.assertz(provider.newAtom("lips183"), provider.newAtom("lips184"));
			engine.assertz(provider.newAtom("lips184"), provider.newAtom("lips185"));
			engine.assertz(provider.newAtom("lips185"), provider.newAtom("lips186"));
			engine.assertz(provider.newAtom("lips186"), provider.newAtom("lips187"));
			engine.assertz(provider.newAtom("lips187"), provider.newAtom("lips188"));
			engine.assertz(provider.newAtom("lips188"), provider.newAtom("lips189"));
			engine.assertz(provider.newAtom("lips189"), provider.newAtom("lips190"));
			engine.assertz(provider.newAtom("lips190"), provider.newAtom("lips191"));
			engine.assertz(provider.newAtom("lips191"), provider.newAtom("lips192"));
			engine.assertz(provider.newAtom("lips192"), provider.newAtom("lips193"));
			engine.assertz(provider.newAtom("lips193"), provider.newAtom("lips194"));
			engine.assertz(provider.newAtom("lips194"), provider.newAtom("lips195"));
			engine.assertz(provider.newAtom("lips195"), provider.newAtom("lips196"));
			engine.assertz(provider.newAtom("lips196"), provider.newAtom("lips197"));
			engine.assertz(provider.newAtom("lips197"), provider.newAtom("lips198"));
			engine.assertz(provider.newAtom("lips198"), provider.newAtom("lips199"));
			engine.assertz(provider.newAtom("lips199"), provider.newAtom("lips200"));
			engine.assertz(provider.newAtom("lips200"));

			// cut
			String cutt1 = "cutt1";
			PrologTerm cut = provider.prologCut();
			PrologTerm x = provider.newVariable("X", 0);
			PrologTerm l = provider.newVariable("L", 1);
			PrologTerm[] arguments = new PrologTerm[100];
			Arrays.fill(arguments, provider.newInteger(100));
			PrologList list = provider.newList(arguments);
			PrologTerm exp1 = provider.newStructure(x, "=", provider.newInteger(100));
			PrologTerm exp2 = provider.newStructure(x, ">", provider.newInteger(100));
			PrologTerm xl = provider.newList(provider.newVariable("X", 0), provider.newVariable("L", 1));
			engine.assertz(provider.newAtom("cut_100_times"), provider.newStructure(cutt1, list));
			engine.assertz(provider.newStructure(cutt1, provider.prologEmpty()));
			engine.assertz(provider.newStructure(cutt1, xl), provider.newStructure(cutt1, exp1),
					provider.newStructure(cutt1, cut), provider.newStructure(cutt1, l));
			engine.assertz(provider.newStructure(cutt1, xl), provider.newStructure(cutt1, exp2),
					provider.newStructure(cutt1, l));

			// enviroment
			engine.assertz(provider.newAtom("enviroment"), provider.newStructure("env0", provider.newVariable("X", 0),
					provider.newVariable("Y", 1), provider.newVariable("Z", 2)));

			engine.assertz(
					provider.newStructure("env0", provider.newVariable("X", 0), provider.newVariable("Y", 1),
							provider.newVariable("Z", 2)), // :-
					provider.newStructure("env1", provider.newVariable("Z", 0), provider.newVariable("Y", 1),
							provider.newVariable("X", 2)),
					provider.newStructure("env2", provider.newVariable("Y", 0), provider.newVariable("Z", 1),
							provider.newVariable("X", 2)));

			engine.assertz(
					provider.newStructure("env1", provider.newVariable("X", 0), provider.newVariable("Y", 1),
							provider.newVariable("Z", 2)), // :-
					provider.newStructure("env3", provider.newVariable("Z", 0), provider.newVariable("Y", 1),
							provider.newVariable("X", 2)),
					provider.newStructure("env4", provider.newVariable("Y", 0), provider.newVariable("Z", 1),
							provider.newVariable("X", 2)));
			engine.assertz(
					provider.newStructure("env2", provider.newVariable("X", 0), provider.newVariable("Y", 1),
							provider.newVariable("Z", 2)), // :-
					provider.newStructure("env3", provider.newVariable("Z", 0), provider.newVariable("Y", 1),
							provider.newVariable("X", 2)),
					provider.newStructure("env4", provider.newVariable("Y", 0), provider.newVariable("Z", 1),
							provider.newVariable("X", 2)));
			engine.assertz(
					provider.newStructure("env3", provider.newVariable("X", 0), provider.newVariable("Y", 1),
							provider.newVariable("Z", 2)), // :-
					provider.newStructure("env5", provider.newVariable("Z", 0), provider.newVariable("Y", 1),
							provider.newVariable("X", 2)),
					provider.newStructure("env6", provider.newVariable("Y", 0), provider.newVariable("Z", 1),
							provider.newVariable("X", 2)));
			engine.assertz(
					provider.newStructure("env4", provider.newVariable("X", 0), provider.newVariable("Y", 1),
							provider.newVariable("Z", 2)), // :-
					provider.newStructure("env5", provider.newVariable("Z", 0), provider.newVariable("Y", 1),
							provider.newVariable("X", 2)),
					provider.newStructure("env6", provider.newVariable("Y", 0), provider.newVariable("Z", 1),
							provider.newVariable("X", 2)));
			engine.assertz(
					provider.newStructure("env5", provider.newVariable("X", 0), provider.newVariable("Y", 1),
							provider.newVariable("Z", 2)), // :-
					provider.newStructure("env7", provider.newVariable("Z", 0), provider.newVariable("Y", 1),
							provider.newVariable("X", 2)),
					provider.newStructure("env8", provider.newVariable("Y", 0), provider.newVariable("Z", 1),
							provider.newVariable("X", 2)));
			engine.assertz(
					provider.newStructure("env6", provider.newVariable("X", 0), provider.newVariable("Y", 1),
							provider.newVariable("Z", 2)), // :-
					provider.newStructure("env7", provider.newVariable("Z", 0), provider.newVariable("Y", 1),
							provider.newVariable("X", 2)),
					provider.newStructure("env8", provider.newVariable("Y", 0), provider.newVariable("Z", 1),
							provider.newVariable("X", 2)));
			engine.assertz(
					provider.newStructure("env7", provider.newVariable("X", 0), provider.newVariable("Y", 1),
							provider.newVariable("Z", 2)), // :-
					provider.newStructure("env9", provider.newVariable("Z", 0), provider.newVariable("Y", 1),
							provider.newVariable("X", 2)),
					provider.newStructure("env10", provider.newVariable("Y", 0), provider.newVariable("Z", 1),
							provider.newVariable("X", 2)));
			engine.assertz(
					provider.newStructure("env8", provider.newVariable("X", 0), provider.newVariable("Y", 1),
							provider.newVariable("Z", 2)), // :-
					provider.newStructure("env9", provider.newVariable("Z", 0), provider.newVariable("Y", 1),
							provider.newVariable("X", 2)),
					provider.newStructure("env10", provider.newVariable("Y", 0), provider.newVariable("Z", 1),
							provider.newVariable("X", 2)));
			engine.assertz(
					provider.newStructure("env9", provider.newVariable("X", 0), provider.newVariable("Y", 1),
							provider.newVariable("Z", 2)), // :-
					provider.newStructure("env11", provider.newVariable("Z", 0), provider.newVariable("Y", 1),
							provider.newVariable("X", 2)),
					provider.newStructure("env12", provider.newVariable("Y", 0), provider.newVariable("Z", 1),
							provider.newVariable("X", 2)));
			engine.assertz(
					provider.newStructure("env10", provider.newVariable("X", 0), provider.newVariable("Y", 1),
							provider.newVariable("Z", 2)), // :-
					provider.newStructure("env12", provider.newVariable("Z", 0), provider.newVariable("Y", 1),
							provider.newVariable("X", 2)),
					provider.newStructure("env12", provider.newVariable("Y", 0), provider.newVariable("Z", 1),
							provider.newVariable("X", 2)));
			engine.assertz(
					provider.newStructure("env11", provider.newVariable("X", 0), provider.newVariable("Y", 1),
							provider.newVariable("Z", 2)), // :-
					provider.newStructure("env12", provider.newVariable("Z", 0), provider.newVariable("Y", 1),
							provider.newVariable("X", 2)),
					provider.newStructure("env12", provider.newVariable("Y", 0), provider.newVariable("Z", 1),
							provider.newVariable("X", 2)));
			engine.assertz(provider.newStructure("env12", provider.newVariable("_X", 0), provider.newVariable("_Y", 1),
					provider.newVariable("_Z", 2)));

			engine.assertz(provider.newAtom("enviroment0ar"), provider.newAtom("env0_0"));

			engine.assertz(provider.newAtom("env0_0"), provider.newAtom("env1_0"), provider.newAtom("env2_0"));
			engine.assertz(provider.newAtom("env1_0"), provider.newAtom("env3_0"), provider.newAtom("env4_0"));
			engine.assertz(provider.newAtom("env2_0"), provider.newAtom("env3_0"), provider.newAtom("env4_0"));
			engine.assertz(provider.newAtom("env3_0"), provider.newAtom("env5_0"), provider.newAtom("env6_0"));
			engine.assertz(provider.newAtom("env4_0"), provider.newAtom("env5_0"), provider.newAtom("env6_0"));
			engine.assertz(provider.newAtom("env5_0"), provider.newAtom("env7_0"), provider.newAtom("env8_0"));
			engine.assertz(provider.newAtom("env6_0"), provider.newAtom("env7_0"), provider.newAtom("env8_0"));
			engine.assertz(provider.newAtom("env7_0"), provider.newAtom("env9_0"), provider.newAtom("env10_0"));
			engine.assertz(provider.newAtom("env8_0"), provider.newAtom("env9_0"), provider.newAtom("env10_0"));
			engine.assertz(provider.newAtom("env9_0"), provider.newAtom("env11_0"), provider.newAtom("env12_0"));
			engine.assertz(provider.newAtom("env10_0"), provider.newAtom("env12_0"), provider.newAtom("env12_0"));
			engine.assertz(provider.newAtom("env11_0"), provider.newAtom("env12_0"), provider.newAtom("env12_0"));

			engine.assertz(provider.newAtom("env12_0"));

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

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void indexClause(ExecutionPlan plan) {
		plan.engine.query("index_clause").oneSolution();
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void boresea(ExecutionPlan plan) {
		plan.engine.query("boresea").oneSolution();
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void cut100Times(ExecutionPlan plan) {
		plan.engine.query("cut_100_times").oneSolution();
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void enviroment(ExecutionPlan plan) {
		plan.engine.query("enviroment").oneSolution();
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void enviroment0Arg(ExecutionPlan plan) {
		plan.engine.query("enviroment0ar").oneSolution();
	}

	public static void main(String[] args) throws RunnerException {

		OptionsBuilder builder = new OptionsBuilder();
		builder.include(TuPrologBenchmarkRunner.class.getSimpleName());
		Options opt = builder.build();
		Collection<RunResult> run = new Runner(opt).run();
		new TuPrologBenchmarkRunner().output(run);

	}

}
