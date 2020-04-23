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

			// dereference
			engine.assertz("dereference:-"

					+ "make_list(500, L1, _),"

					+ "make_list(500, L2, Last),"

					+ "bind_forward(L1),"

					+ "bind_backward(L2),"

					+ "L2 = [a|_],"

					+ "bind_refs(L1, Last)");

			engine.assertz("bind_refs(First, Last):-"

					+ "ref(First),"

					+ "ref(Last)");

			engine.assertz("ref(Cons) :-"

					+ "Cons = [a|_],"

					+ "Cons = [a|_],"

					+ "Cons = [a|_],"

					+ "Cons = [a|_],"

					+ "Cons = [a|_],"

					+ "Cons = [a|_],"

					+ "Cons = [a|_],"

					+ "Cons = [a|_],"

					+ "Cons = [a|_]");

			engine.assertz("bind_forward([a]) :- !");
			engine.assertz("bind_forward([X, Y|T]) :-"

					+ "equal(X, Y),"

					+ "bind_forward([Y|T])");

			engine.assertz("bind_backward([_X]) :- !");
			engine.assertz("bind_backward([X, Y|T]) :-"

					+ "bind_backward([Y|T]),"

					+ "equal(X, Y)");

			engine.assertz("equal(X, X)");

			engine.assertz("make_list(1, L, L) :- L = [_X]");
			engine.assertz("make_list(N, [_X|Rest], Last) :-"

					+ "N > 1,"

					+ "N1 is N - 1,"

					+ "make_list(N1, Rest, Last)");

			// choice point

			engine.assertz("choice_point:-ccp1(0,0,0)");
			engine.assertz("choice_point0ar:-ccp1_0");

			engine.assertz("backtrack1:-pd(_,_,_)");
			engine.assertz("backtrack2:-ps(_,a,d)");

			engine.assertz("ccp1(X,Y,Z):-ccp2(X,Y,Z)");
			engine.assertz("ccp1(_X,_Y,_Z)");
			engine.assertz("ccp2(X,Y,Z):-ccp3(X,Y,Z)");
			engine.assertz("ccp2(_X,_Y,_Z)");
			engine.assertz("ccp3(X,Y,Z):-ccp4(X,Y,Z)");
			engine.assertz("ccp3(_X,_Y,_Z)");
			engine.assertz("ccp4(X,Y,Z):-ccp5(X,Y,Z)");
			engine.assertz("ccp4(_X,_Y,_Z)");
			engine.assertz("ccp5(X,Y,Z):-ccp6(X,Y,Z)");
			engine.assertz("ccp5(_X,_Y,_Z)");
			engine.assertz("ccp6(X,Y,Z):-ccp7(X,Y,Z)");
			engine.assertz("ccp6(_X,_Y,_Z)");
			engine.assertz("ccp7(X,Y,Z):-ccp8(X,Y,Z)");
			engine.assertz("ccp7(_X,_Y,_Z)");
			engine.assertz("ccp8(X,Y,Z):-ccp9(X,Y,Z)");
			engine.assertz("ccp8(_X,_Y,_Z)");
			engine.assertz("ccp9(X,Y,Z):-ccp10(X,Y,Z)");
			engine.assertz("ccp9(_X,_Y,_Z)");
			engine.assertz("ccp10(X,Y,Z):-ccp11(X,Y,Z)");
			engine.assertz("ccp10(_X,_Y,_Z)");
			engine.assertz("ccp11(X,Y,Z):-ccp12(X,Y,Z)");
			engine.assertz("ccp11(_X,_Y,_Z)");
			engine.assertz("ccp12(X,Y,Z):-ccp13(X,Y,Z)");
			engine.assertz("ccp12(_X,_Y,_Z)");
			engine.assertz("ccp13(X,Y,Z):-ccp14(X,Y,Z)");
			engine.assertz("ccp13(_X,_Y,_Z)");
			engine.assertz("ccp14(X,Y,Z):-ccp15(X,Y,Z)");
			engine.assertz("ccp14(_X,_Y,_Z)");
			engine.assertz("ccp15(X,Y,Z):-ccp16(X,Y,Z)");
			engine.assertz("ccp15(_X,_Y,_Z)");
			engine.assertz("ccp16(X,Y,Z):-ccp17(X,Y,Z)");
			engine.assertz("ccp16(_X,_Y,_Z)");
			engine.assertz("ccp17(X,Y,Z):-ccp18(X,Y,Z)");
			engine.assertz("ccp17(_X,_Y,_Z)");
			engine.assertz("ccp18(X,Y,Z):-ccp19(X,Y,Z)");
			engine.assertz("ccp18(_X,_Y,_Z)");
			engine.assertz("ccp19(X,Y,Z):-ccp20(X,Y,Z)");
			engine.assertz("ccp19(_X,_Y,_Z)");
			engine.assertz("ccp20(_X,_Y,_Z)");
			engine.assertz("ccp20(_X,_Y,_Z)");

			engine.assertz("ccp1_0:-ccp2_0");
			engine.assertz("ccp1_0");
			engine.assertz("ccp2_0:-ccp3_0");
			engine.assertz("ccp2_0");
			engine.assertz("ccp3_0:-ccp4_0");
			engine.assertz("ccp3_0");
			engine.assertz("ccp4_0:-ccp5_0");
			engine.assertz("ccp4_0");
			engine.assertz("ccp5_0:-ccp6_0");
			engine.assertz("ccp5_0");
			engine.assertz("ccp6_0:-ccp7_0");
			engine.assertz("ccp6_0");
			engine.assertz("ccp7_0:-ccp8_0");
			engine.assertz("ccp7_0");
			engine.assertz("ccp8_0:-ccp9_0");
			engine.assertz("ccp8_0");
			engine.assertz("ccp9_0:-ccp10_0");
			engine.assertz("ccp9_0");
			engine.assertz("ccp10_0:-ccp11_0");
			engine.assertz("ccp10_0");
			engine.assertz("ccp11_0:-ccp12_0");
			engine.assertz("ccp11_0");
			engine.assertz("ccp12_0:-ccp13_0");
			engine.assertz("ccp12_0");
			engine.assertz("ccp13_0:-ccp14_0");
			engine.assertz("ccp13_0");
			engine.assertz("ccp14_0:-ccp15_0");
			engine.assertz("ccp14_0");
			engine.assertz("ccp15_0:-ccp16_0");
			engine.assertz("ccp15_0");
			engine.assertz("ccp16_0:-ccp17_0");
			engine.assertz("ccp16_0");
			engine.assertz("ccp17_0:-ccp18_0");
			engine.assertz("ccp17_0");
			engine.assertz("ccp18_0:-ccp19_0");
			engine.assertz("ccp18_0");
			engine.assertz("ccp19_0:-ccp20_0");
			engine.assertz("ccp19_0");
			engine.assertz("ccp20_0");
			engine.assertz("ccp20_0");

			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(X1,X2,_):-q(X1,X2,a)");
			engine.assertz("pd(_X1,_X2,_)");

			engine.assertz("q(_X1,_X2,b)");

			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,X,X)");
			engine.assertz("ps(_,_,_)");

			// unif
			engine.assertz("create_list:-cl1(_, _, _)");

			engine.assertz("match_list:-list100(Z),cl1(Z, Z, Z)");

			engine.assertz("create_struct:-cs1(_, _, _)");

			engine.assertz("match_struct:-structure100(Z),cs1(Z, Z, Z)");

			engine.assertz("match_nested_structure:-nested_structure1(Z),nested_structure1(Z)");

			engine.assertz("unification:-nested_structure1(A),nested_structure2(B),unify(A, B)");

			engine.assertz("unify(X, X)");

			engine.assertz(
					"nested_structure1([a([a1([1, 2, 3], a), a2([4, 5, 6], b), a3([7, 8, 9], c)], [a4([0, 1, 2], d), a5([3, 4, 5], e), a6([6, 7, 8], f)], [a7([9, 0, 1], g), a8([2, 3, 4], h), a9([5, 6, 7], i)]), b([b1([1, 2, 3], a), b2([4, 5, 6], b), b3([7, 8, 9], c)], [b4([0, 1, 2], d), b5([3, 4, 5], e), b6([6, 7, 8], f)], [b7([9, 0, 1], g), b8([2, 3, 4], h), b9([5, 6, 7], i)]), c([c1([1, 2, 3], a), c2([4, 5, 6], b), c3([7, 8, 9], c)], [c4([0, 1, 2], d), c5([3, 4, 5], e), c6([6, 7, 8], f)], [c7([9, 0, 1], g), c8([2, 3, 4], h), c9([5, 6, 7], i)])])");

			engine.assertz(
					"nested_structure2([a([a1([1, 2, 3], a), a2([4, 5, 6], b), a3([7, 8, 9], c)], [a4([0, 1, 2], d), a5([3, 4, 5], e), a6([6, 7, 8], f)], [a7([9, 0, 1], g), a8([2, 3, 4], h), a9([5, 6, 7], i)]), b([b1([1, 2, 3], a), b2([4, 5, 6], b), b3([7, 8, 9], c)], [b4([0, 1, 2], d), b5([3, 4, 5], e), b6([6, 7, 8], f)], [b7([9, 0, 1], g), b8([2, 3, 4], h), b9([5, 6, 7], i)]), c([c1([1, 2, 3], a), c2([4, 5, 6], b), c3([7, 8, 9], c)], [c4([0, 1, 2], d), c5([3, 4, 5], e), c6([6, 7, 8], f)], [c7([9, 0, 1], g), c8([2, 3, 4], h), c9([5, 6, 7], i)])])");

			engine.assertz(
					"list100([a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a])");

			engine.assertz(
					"structure100(st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, st(a, nil)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))");

			engine.assertz("cl1([a|X], [a|Y], [a|Z]):-cl2(X, Y, Z)");
			engine.assertz("cl2([a|X], [a|Y], [a|Z]):-cl3(X, Y, Z)");
			engine.assertz("cl3([a|X], [a|Y], [a|Z]):-cl4(X, Y, Z)");
			engine.assertz("cl4([a|X], [a|Y], [a|Z]):-cl5(X, Y, Z)");
			engine.assertz("cl5([a|X], [a|Y], [a|Z]):-cl6(X, Y, Z)");
			engine.assertz("cl6([a|X], [a|Y], [a|Z]):-cl7(X, Y, Z)");
			engine.assertz("cl7([a|X], [a|Y], [a|Z]):-cl8(X, Y, Z)");
			engine.assertz("cl8([a|X], [a|Y], [a|Z]):-cl9(X, Y, Z)");
			engine.assertz("cl9([a|X], [a|Y], [a|Z]):-cl10(X, Y, Z)");
			engine.assertz("cl10([a|X], [a|Y], [a|Z]):-cl11(X, Y, Z)");
			engine.assertz("cl11([a|X], [a|Y], [a|Z]):-cl12(X, Y, Z)");
			engine.assertz("cl12([a|X], [a|Y], [a|Z]):-cl13(X, Y, Z)");
			engine.assertz("cl13([a|X], [a|Y], [a|Z]):-cl14(X, Y, Z)");
			engine.assertz("cl14([a|X], [a|Y], [a|Z]):-cl15(X, Y, Z)");
			engine.assertz("cl15([a|X], [a|Y], [a|Z]):-cl16(X, Y, Z)");
			engine.assertz("cl16([a|X], [a|Y], [a|Z]):-cl17(X, Y, Z)");
			engine.assertz("cl17([a|X], [a|Y], [a|Z]):-cl18(X, Y, Z)");
			engine.assertz("cl18([a|X], [a|Y], [a|Z]):-cl19(X, Y, Z)");
			engine.assertz("cl19([a|X], [a|Y], [a|Z]):-cl20(X, Y, Z)");
			engine.assertz("cl20([a|X], [a|Y], [a|Z]):-cl21(X, Y, Z)");
			engine.assertz("cl21([a|X], [a|Y], [a|Z]):-cl22(X, Y, Z)");
			engine.assertz("cl22([a|X], [a|Y], [a|Z]):-cl23(X, Y, Z)");
			engine.assertz("cl23([a|X], [a|Y], [a|Z]):-cl24(X, Y, Z)");
			engine.assertz("cl24([a|X], [a|Y], [a|Z]):-cl25(X, Y, Z)");
			engine.assertz("cl25([a|X], [a|Y], [a|Z]):-cl26(X, Y, Z)");
			engine.assertz("cl26([a|X], [a|Y], [a|Z]):-cl27(X, Y, Z)");
			engine.assertz("cl27([a|X], [a|Y], [a|Z]):-cl28(X, Y, Z)");
			engine.assertz("cl28([a|X], [a|Y], [a|Z]):-cl29(X, Y, Z)");
			engine.assertz("cl29([a|X], [a|Y], [a|Z]):-cl30(X, Y, Z)");
			engine.assertz("cl30([a|X], [a|Y], [a|Z]):-cl31(X, Y, Z)");
			engine.assertz("cl31([a|X], [a|Y], [a|Z]):-cl32(X, Y, Z)");
			engine.assertz("cl32([a|X], [a|Y], [a|Z]):-cl33(X, Y, Z)");
			engine.assertz("cl33([a|X], [a|Y], [a|Z]):-cl34(X, Y, Z)");
			engine.assertz("cl34([a|X], [a|Y], [a|Z]):-cl35(X, Y, Z)");
			engine.assertz("cl35([a|X], [a|Y], [a|Z]):-cl36(X, Y, Z)");
			engine.assertz("cl36([a|X], [a|Y], [a|Z]):-cl37(X, Y, Z)");
			engine.assertz("cl37([a|X], [a|Y], [a|Z]):-cl38(X, Y, Z)");
			engine.assertz("cl38([a|X], [a|Y], [a|Z]):-cl39(X, Y, Z)");
			engine.assertz("cl39([a|X], [a|Y], [a|Z]):-cl40(X, Y, Z)");
			engine.assertz("cl40([a|X], [a|Y], [a|Z]):-cl41(X, Y, Z)");
			engine.assertz("cl41([a|X], [a|Y], [a|Z]):-cl42(X, Y, Z)");
			engine.assertz("cl42([a|X], [a|Y], [a|Z]):-cl43(X, Y, Z)");
			engine.assertz("cl43([a|X], [a|Y], [a|Z]):-cl44(X, Y, Z)");
			engine.assertz("cl44([a|X], [a|Y], [a|Z]):-cl45(X, Y, Z)");
			engine.assertz("cl45([a|X], [a|Y], [a|Z]):-cl46(X, Y, Z)");
			engine.assertz("cl46([a|X], [a|Y], [a|Z]):-cl47(X, Y, Z)");
			engine.assertz("cl47([a|X], [a|Y], [a|Z]):-cl48(X, Y, Z)");
			engine.assertz("cl48([a|X], [a|Y], [a|Z]):-cl49(X, Y, Z)");
			engine.assertz("cl49([a|X], [a|Y], [a|Z]):-cl50(X, Y, Z)");
			engine.assertz("cl50([a|X], [a|Y], [a|Z]):-cl51(X, Y, Z)");
			engine.assertz("cl51([a|X], [a|Y], [a|Z]):-cl52(X, Y, Z)");
			engine.assertz("cl52([a|X], [a|Y], [a|Z]):-cl53(X, Y, Z)");
			engine.assertz("cl53([a|X], [a|Y], [a|Z]):-cl54(X, Y, Z)");
			engine.assertz("cl54([a|X], [a|Y], [a|Z]):-cl55(X, Y, Z)");
			engine.assertz("cl55([a|X], [a|Y], [a|Z]):-cl56(X, Y, Z)");
			engine.assertz("cl56([a|X], [a|Y], [a|Z]):-cl57(X, Y, Z)");
			engine.assertz("cl57([a|X], [a|Y], [a|Z]):-cl58(X, Y, Z)");
			engine.assertz("cl58([a|X], [a|Y], [a|Z]):-cl59(X, Y, Z)");
			engine.assertz("cl59([a|X], [a|Y], [a|Z]):-cl60(X, Y, Z)");
			engine.assertz("cl60([a|X], [a|Y], [a|Z]):-cl61(X, Y, Z)");
			engine.assertz("cl61([a|X], [a|Y], [a|Z]):-cl62(X, Y, Z)");
			engine.assertz("cl62([a|X], [a|Y], [a|Z]):-cl63(X, Y, Z)");
			engine.assertz("cl63([a|X], [a|Y], [a|Z]):-cl64(X, Y, Z)");
			engine.assertz("cl64([a|X], [a|Y], [a|Z]):-cl65(X, Y, Z)");
			engine.assertz("cl65([a|X], [a|Y], [a|Z]):-cl66(X, Y, Z)");
			engine.assertz("cl66([a|X], [a|Y], [a|Z]):-cl67(X, Y, Z)");
			engine.assertz("cl67([a|X], [a|Y], [a|Z]):-cl68(X, Y, Z)");
			engine.assertz("cl68([a|X], [a|Y], [a|Z]):-cl69(X, Y, Z)");
			engine.assertz("cl69([a|X], [a|Y], [a|Z]):-cl70(X, Y, Z)");
			engine.assertz("cl70([a|X], [a|Y], [a|Z]):-cl71(X, Y, Z)");
			engine.assertz("cl71([a|X], [a|Y], [a|Z]):-cl72(X, Y, Z)");
			engine.assertz("cl72([a|X], [a|Y], [a|Z]):-cl73(X, Y, Z)");
			engine.assertz("cl73([a|X], [a|Y], [a|Z]):-cl74(X, Y, Z)");
			engine.assertz("cl74([a|X], [a|Y], [a|Z]):-cl75(X, Y, Z)");
			engine.assertz("cl75([a|X], [a|Y], [a|Z]):-cl76(X, Y, Z)");
			engine.assertz("cl76([a|X], [a|Y], [a|Z]):-cl77(X, Y, Z)");
			engine.assertz("cl77([a|X], [a|Y], [a|Z]):-cl78(X, Y, Z)");
			engine.assertz("cl78([a|X], [a|Y], [a|Z]):-cl79(X, Y, Z)");
			engine.assertz("cl79([a|X], [a|Y], [a|Z]):-cl80(X, Y, Z)");
			engine.assertz("cl80([a|X], [a|Y], [a|Z]):-cl81(X, Y, Z)");
			engine.assertz("cl81([a|X], [a|Y], [a|Z]):-cl82(X, Y, Z)");
			engine.assertz("cl82([a|X], [a|Y], [a|Z]):-cl83(X, Y, Z)");
			engine.assertz("cl83([a|X], [a|Y], [a|Z]):-cl84(X, Y, Z)");
			engine.assertz("cl84([a|X], [a|Y], [a|Z]):-cl85(X, Y, Z)");
			engine.assertz("cl85([a|X], [a|Y], [a|Z]):-cl86(X, Y, Z)");
			engine.assertz("cl86([a|X], [a|Y], [a|Z]):-cl87(X, Y, Z)");
			engine.assertz("cl87([a|X], [a|Y], [a|Z]):-cl88(X, Y, Z)");
			engine.assertz("cl88([a|X], [a|Y], [a|Z]):-cl89(X, Y, Z)");
			engine.assertz("cl89([a|X], [a|Y], [a|Z]):-cl90(X, Y, Z)");
			engine.assertz("cl90([a|X], [a|Y], [a|Z]):-cl91(X, Y, Z)");
			engine.assertz("cl91([a|X], [a|Y], [a|Z]):-cl92(X, Y, Z)");
			engine.assertz("cl92([a|X], [a|Y], [a|Z]):-cl93(X, Y, Z)");
			engine.assertz("cl93([a|X], [a|Y], [a|Z]):-cl94(X, Y, Z)");
			engine.assertz("cl94([a|X], [a|Y], [a|Z]):-cl95(X, Y, Z)");
			engine.assertz("cl95([a|X], [a|Y], [a|Z]):-cl96(X, Y, Z)");
			engine.assertz("cl96([a|X], [a|Y], [a|Z]):-cl97(X, Y, Z)");
			engine.assertz("cl97([a|X], [a|Y], [a|Z]):-cl98(X, Y, Z)");
			engine.assertz("cl98([a|X], [a|Y], [a|Z]):-cl99(X, Y, Z)");
			engine.assertz("cl99([a|X], [a|Y], [a|Z]):-cl100(X, Y, Z)");
			engine.assertz("cl100([a], [a], [a])");

			engine.assertz("cs1(st(a, X), st(a, Y), st(a, Z)):-cs2(X, Y, Z)");
			engine.assertz("cs2(st(a, X), st(a, Y), st(a, Z)):-cs3(X, Y, Z)");
			engine.assertz("cs3(st(a, X), st(a, Y), st(a, Z)):-cs4(X, Y, Z)");
			engine.assertz("cs4(st(a, X), st(a, Y), st(a, Z)):-cs5(X, Y, Z)");
			engine.assertz("cs5(st(a, X), st(a, Y), st(a, Z)):-cs6(X, Y, Z)");
			engine.assertz("cs6(st(a, X), st(a, Y), st(a, Z)):-cs7(X, Y, Z)");
			engine.assertz("cs7(st(a, X), st(a, Y), st(a, Z)):-cs8(X, Y, Z)");
			engine.assertz("cs8(st(a, X), st(a, Y), st(a, Z)):-cs9(X, Y, Z)");
			engine.assertz("cs9(st(a, X), st(a, Y), st(a, Z)):-cs10(X, Y, Z)");
			engine.assertz("cs10(st(a, X), st(a, Y), st(a, Z)):-cs11(X, Y, Z)");
			engine.assertz("cs11(st(a, X), st(a, Y), st(a, Z)):-cs12(X, Y, Z)");
			engine.assertz("cs12(st(a, X), st(a, Y), st(a, Z)):-cs13(X, Y, Z)");
			engine.assertz("cs13(st(a, X), st(a, Y), st(a, Z)):-cs14(X, Y, Z)");
			engine.assertz("cs14(st(a, X), st(a, Y), st(a, Z)):-cs15(X, Y, Z)");
			engine.assertz("cs15(st(a, X), st(a, Y), st(a, Z)):-cs16(X, Y, Z)");
			engine.assertz("cs16(st(a, X), st(a, Y), st(a, Z)):-cs17(X, Y, Z)");
			engine.assertz("cs17(st(a, X), st(a, Y), st(a, Z)):-cs18(X, Y, Z)");
			engine.assertz("cs18(st(a, X), st(a, Y), st(a, Z)):-cs19(X, Y, Z)");
			engine.assertz("cs19(st(a, X), st(a, Y), st(a, Z)):-cs20(X, Y, Z)");
			engine.assertz("cs20(st(a, X), st(a, Y), st(a, Z)):-cs21(X, Y, Z)");
			engine.assertz("cs21(st(a, X), st(a, Y), st(a, Z)):-cs22(X, Y, Z)");
			engine.assertz("cs22(st(a, X), st(a, Y), st(a, Z)):-cs23(X, Y, Z)");
			engine.assertz("cs23(st(a, X), st(a, Y), st(a, Z)):-cs24(X, Y, Z)");
			engine.assertz("cs24(st(a, X), st(a, Y), st(a, Z)):-cs25(X, Y, Z)");
			engine.assertz("cs25(st(a, X), st(a, Y), st(a, Z)):-cs26(X, Y, Z)");
			engine.assertz("cs26(st(a, X), st(a, Y), st(a, Z)):-cs27(X, Y, Z)");
			engine.assertz("cs27(st(a, X), st(a, Y), st(a, Z)):-cs28(X, Y, Z)");
			engine.assertz("cs28(st(a, X), st(a, Y), st(a, Z)):-cs29(X, Y, Z)");
			engine.assertz("cs29(st(a, X), st(a, Y), st(a, Z)):-cs30(X, Y, Z)");
			engine.assertz("cs30(st(a, X), st(a, Y), st(a, Z)):-cs31(X, Y, Z)");
			engine.assertz("cs31(st(a, X), st(a, Y), st(a, Z)):-cs32(X, Y, Z)");
			engine.assertz("cs32(st(a, X), st(a, Y), st(a, Z)):-cs33(X, Y, Z)");
			engine.assertz("cs33(st(a, X), st(a, Y), st(a, Z)):-cs34(X, Y, Z)");
			engine.assertz("cs34(st(a, X), st(a, Y), st(a, Z)):-cs35(X, Y, Z)");
			engine.assertz("cs35(st(a, X), st(a, Y), st(a, Z)):-cs36(X, Y, Z)");
			engine.assertz("cs36(st(a, X), st(a, Y), st(a, Z)):-cs37(X, Y, Z)");
			engine.assertz("cs37(st(a, X), st(a, Y), st(a, Z)):-cs38(X, Y, Z)");
			engine.assertz("cs38(st(a, X), st(a, Y), st(a, Z)):-cs39(X, Y, Z)");
			engine.assertz("cs39(st(a, X), st(a, Y), st(a, Z)):-cs40(X, Y, Z)");
			engine.assertz("cs40(st(a, X), st(a, Y), st(a, Z)):-cs41(X, Y, Z)");
			engine.assertz("cs41(st(a, X), st(a, Y), st(a, Z)):-cs42(X, Y, Z)");
			engine.assertz("cs42(st(a, X), st(a, Y), st(a, Z)):-cs43(X, Y, Z)");
			engine.assertz("cs43(st(a, X), st(a, Y), st(a, Z)):-cs44(X, Y, Z)");
			engine.assertz("cs44(st(a, X), st(a, Y), st(a, Z)):-cs45(X, Y, Z)");
			engine.assertz("cs45(st(a, X), st(a, Y), st(a, Z)):-cs46(X, Y, Z)");
			engine.assertz("cs46(st(a, X), st(a, Y), st(a, Z)):-cs47(X, Y, Z)");
			engine.assertz("cs47(st(a, X), st(a, Y), st(a, Z)):-cs48(X, Y, Z)");
			engine.assertz("cs48(st(a, X), st(a, Y), st(a, Z)):-cs49(X, Y, Z)");
			engine.assertz("cs49(st(a, X), st(a, Y), st(a, Z)):-cs50(X, Y, Z)");
			engine.assertz("cs50(st(a, X), st(a, Y), st(a, Z)):-cs51(X, Y, Z)");
			engine.assertz("cs51(st(a, X), st(a, Y), st(a, Z)):-cs52(X, Y, Z)");
			engine.assertz("cs52(st(a, X), st(a, Y), st(a, Z)):-cs53(X, Y, Z)");
			engine.assertz("cs53(st(a, X), st(a, Y), st(a, Z)):-cs54(X, Y, Z)");
			engine.assertz("cs54(st(a, X), st(a, Y), st(a, Z)):-cs55(X, Y, Z)");
			engine.assertz("cs55(st(a, X), st(a, Y), st(a, Z)):-cs56(X, Y, Z)");
			engine.assertz("cs56(st(a, X), st(a, Y), st(a, Z)):-cs57(X, Y, Z)");
			engine.assertz("cs57(st(a, X), st(a, Y), st(a, Z)):-cs58(X, Y, Z)");
			engine.assertz("cs58(st(a, X), st(a, Y), st(a, Z)):-cs59(X, Y, Z)");
			engine.assertz("cs59(st(a, X), st(a, Y), st(a, Z)):-cs60(X, Y, Z)");
			engine.assertz("cs60(st(a, X), st(a, Y), st(a, Z)):-cs61(X, Y, Z)");
			engine.assertz("cs61(st(a, X), st(a, Y), st(a, Z)):-cs62(X, Y, Z)");
			engine.assertz("cs62(st(a, X), st(a, Y), st(a, Z)):-cs63(X, Y, Z)");
			engine.assertz("cs63(st(a, X), st(a, Y), st(a, Z)):-cs64(X, Y, Z)");
			engine.assertz("cs64(st(a, X), st(a, Y), st(a, Z)):-cs65(X, Y, Z)");
			engine.assertz("cs65(st(a, X), st(a, Y), st(a, Z)):-cs66(X, Y, Z)");
			engine.assertz("cs66(st(a, X), st(a, Y), st(a, Z)):-cs67(X, Y, Z)");
			engine.assertz("cs67(st(a, X), st(a, Y), st(a, Z)):-cs68(X, Y, Z)");
			engine.assertz("cs68(st(a, X), st(a, Y), st(a, Z)):-cs69(X, Y, Z)");
			engine.assertz("cs69(st(a, X), st(a, Y), st(a, Z)):-cs70(X, Y, Z)");
			engine.assertz("cs70(st(a, X), st(a, Y), st(a, Z)):-cs71(X, Y, Z)");
			engine.assertz("cs71(st(a, X), st(a, Y), st(a, Z)):-cs72(X, Y, Z)");
			engine.assertz("cs72(st(a, X), st(a, Y), st(a, Z)):-cs73(X, Y, Z)");
			engine.assertz("cs73(st(a, X), st(a, Y), st(a, Z)):-cs74(X, Y, Z)");
			engine.assertz("cs74(st(a, X), st(a, Y), st(a, Z)):-cs75(X, Y, Z)");
			engine.assertz("cs75(st(a, X), st(a, Y), st(a, Z)):-cs76(X, Y, Z)");
			engine.assertz("cs76(st(a, X), st(a, Y), st(a, Z)):-cs77(X, Y, Z)");
			engine.assertz("cs77(st(a, X), st(a, Y), st(a, Z)):-cs78(X, Y, Z)");
			engine.assertz("cs78(st(a, X), st(a, Y), st(a, Z)):-cs79(X, Y, Z)");
			engine.assertz("cs79(st(a, X), st(a, Y), st(a, Z)):-cs80(X, Y, Z)");
			engine.assertz("cs80(st(a, X), st(a, Y), st(a, Z)):-cs81(X, Y, Z)");
			engine.assertz("cs81(st(a, X), st(a, Y), st(a, Z)):-cs82(X, Y, Z)");
			engine.assertz("cs82(st(a, X), st(a, Y), st(a, Z)):-cs83(X, Y, Z)");
			engine.assertz("cs83(st(a, X), st(a, Y), st(a, Z)):-cs84(X, Y, Z)");
			engine.assertz("cs84(st(a, X), st(a, Y), st(a, Z)):-cs85(X, Y, Z)");
			engine.assertz("cs85(st(a, X), st(a, Y), st(a, Z)):-cs86(X, Y, Z)");
			engine.assertz("cs86(st(a, X), st(a, Y), st(a, Z)):-cs87(X, Y, Z)");
			engine.assertz("cs87(st(a, X), st(a, Y), st(a, Z)):-cs88(X, Y, Z)");
			engine.assertz("cs88(st(a, X), st(a, Y), st(a, Z)):-cs89(X, Y, Z)");
			engine.assertz("cs89(st(a, X), st(a, Y), st(a, Z)):-cs90(X, Y, Z)");
			engine.assertz("cs90(st(a, X), st(a, Y), st(a, Z)):-cs91(X, Y, Z)");
			engine.assertz("cs91(st(a, X), st(a, Y), st(a, Z)):-cs92(X, Y, Z)");
			engine.assertz("cs92(st(a, X), st(a, Y), st(a, Z)):-cs93(X, Y, Z)");
			engine.assertz("cs93(st(a, X), st(a, Y), st(a, Z)):-cs94(X, Y, Z)");
			engine.assertz("cs94(st(a, X), st(a, Y), st(a, Z)):-cs95(X, Y, Z)");
			engine.assertz("cs95(st(a, X), st(a, Y), st(a, Z)):-cs96(X, Y, Z)");
			engine.assertz("cs96(st(a, X), st(a, Y), st(a, Z)):-cs97(X, Y, Z)");
			engine.assertz("cs97(st(a, X), st(a, Y), st(a, Z)):-cs98(X, Y, Z)");
			engine.assertz("cs98(st(a, X), st(a, Y), st(a, Z)):-cs99(X, Y, Z)");
			engine.assertz("cs99(st(a, X), st(a, Y), st(a, Z)):-cs100(X, Y, Z)");
			engine.assertz("cs100(st(a, nil), st(a, nil), st(a, nil))");

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

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void dereference(ExecutionPlan plan) {
		plan.engine.query("dereference").oneSolution();
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void choicePoint(ExecutionPlan plan) {
		plan.engine.query("choice_point").oneSolution();
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void choicePoint0Arg(ExecutionPlan plan) {
		plan.engine.query("choice_point0ar").oneSolution();
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void backtrack1(ExecutionPlan plan) {
		plan.engine.query("backtrack1").oneSolution();
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void backtrack2(ExecutionPlan plan) {
		plan.engine.query("backtrack2").oneSolution();
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void createList(ExecutionPlan plan) {
		plan.engine.query("create_list").oneSolution();
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void createStruct(ExecutionPlan plan) {
		plan.engine.query("create_struct").oneSolution();
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void matchList(ExecutionPlan plan) {
		plan.engine.query("match_list").oneSolution();
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void matchStruct(ExecutionPlan plan) {
		plan.engine.query("match_struct").oneSolution();
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void unification(ExecutionPlan plan) {
		plan.engine.query("unification").oneSolution();
	}

	public static void main(String[] args) throws RunnerException {

		OptionsBuilder builder = new OptionsBuilder();
		builder.include(TuPrologBenchmarkRunner.class.getSimpleName());
		Options opt = builder.build();
		Collection<RunResult> run = new Runner(opt).run();
		new TuPrologBenchmarkRunner().output(run);

	}

}
