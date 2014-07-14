package com.pekall.test.mdm.support.util;



import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.pekall.test.mdm.RunCukesTest;
import com.pekall.test.mdm.support.service.MyDriver;
import com.pekall.test.mdm.support.service.Service;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	public static Process p;
	
	@Before
	public void before(Scenario scenario) throws InterruptedException {
		System.out.println("before");
		System.out.println("scenario name:"+scenario.getName());
	    p = CmdExcute.logcat(RunCukesTest.phoneSystemLogPath,scenario.getName());
	}

	
	
	@After
	public void after(Scenario scenario) throws InterruptedException, IOException {
		System.out.println("after");
		scenario.write("status:"+scenario.getStatus());
		CmdExcute.killAdbProcess();
	
	}
}
