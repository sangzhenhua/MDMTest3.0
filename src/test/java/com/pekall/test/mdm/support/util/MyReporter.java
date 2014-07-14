package com.pekall.test.mdm.support.util;

import java.util.List;


import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.Background;
import gherkin.formatter.model.Examples;
import gherkin.formatter.model.Feature;
import gherkin.formatter.model.Match;
import gherkin.formatter.model.Result;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.ScenarioOutline;
import gherkin.formatter.model.Step;

public class MyReporter implements Formatter, Reporter {

	private Scenario scenario;
	
	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public void after(Match arg0, Result arg1) {
		

	}

	public void before(Match arg0, Result arg1) {
		// TODO Auto-generated method stub

	}

	public void embedding(String arg0, byte[] arg1) {
		// TODO Auto-generated method stub

	}

	public void match(Match arg0) {
		// TODO Auto-generated method stub

	}

	public void result(Result arg0) {
		// TODO Auto-generated method stub

	}

	public void write(String arg0) {
		// TODO Auto-generated method stub

	}

	public void background(Background arg0) {
		// TODO Auto-generated method stub

	}

	public void close() {
		// TODO Auto-generated method stub

	}

	public void done() {
		// TODO Auto-generated method stub

	}

	public void endOfScenarioLifeCycle(Scenario arg0) {
		// TODO Auto-generated method stub

	}

	public void eof() {
		// TODO Auto-generated method stub

	}

	public void examples(Examples arg0) {
		// TODO Auto-generated method stub

	}

	public void feature(Feature arg0) {
		// TODO Auto-generated method stub

	}

	public void scenario(Scenario arg0) {
		setScenario(arg0);

	}

	public void scenarioOutline(ScenarioOutline arg0) {
		// TODO Auto-generated method stub

	}

	public void startOfScenarioLifeCycle(Scenario arg0) {
		// TODO Auto-generated method stub

	}

	public void step(Step arg0) {
		// TODO Auto-generated method stub

	}

	public void syntaxError(String arg0, String arg1, List<String> arg2,
			String arg3, Integer arg4) {
		// TODO Auto-generated method stub

	}

	public void uri(String arg0) {
		// TODO Auto-generated method stub

	}
	
	

}
