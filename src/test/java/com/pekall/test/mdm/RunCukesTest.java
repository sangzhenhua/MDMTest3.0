package com.pekall.test.mdm;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.pekall.test.mdm.support.service.MyDriver;
import com.pekall.test.mdm.support.service.Service;
import com.pekall.test.mdm.support.util.ClearFolder;
import com.pekall.test.mdm.support.util.CmdExcute;
import com.pekall.test.mdm.support.util.FTP;
import com.pekall.test.mdm.support.util.UiTestInfos;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
// mvn install -Dcucumber.options="--tags @wip --format json:t
// arget/cucumber-report-myReport.json --format
// html:target/cucumber-html-report-my
// Report"
@CucumberOptions(tags = { "@wip" }, format = { "html:target/cucumber" ,"json:target/cucumber-html-reports/cucumber.json","junit:target/cucumber-junit/Webpage.xml"})
// @CucumberOptions(tags = { "@wip"}, format = {"html:target/cucumber"})
// @Cucumber.Options(tags = { "~@wip"},format = {"pretty",
// "html:target/cucumber-htmlreport","junit:target/cucumber-junit/Webpage.xml"})
public class RunCukesTest {
	public static String timeFolderName;
	public static String webScreenshotPath;
	public static String phoneScreenshotPath;
	public static String phoneUiTestLogPath;
	public static String phoneSystemLogPath;

	@BeforeClass
	public static void beforeAll() throws InterruptedException, IOException {
		System.out.println("beforeall");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmm");
		timeFolderName = sdf.format(new Date());

		webScreenshotPath = "logAndScreenshot\\" + timeFolderName
				+ "\\webScreenshot";
		phoneScreenshotPath = "logAndScreenshot\\" + timeFolderName
				+ "\\phoneScreenshot";
		phoneUiTestLogPath = "logAndScreenshot\\" + timeFolderName
				+ "\\phoneUiTestLog";
		phoneSystemLogPath = "logAndScreenshot\\" + timeFolderName
				+ "\\phoneSystemLog";
		new File(webScreenshotPath).mkdirs();
		new File(phoneScreenshotPath).mkdirs();
		new File(phoneUiTestLogPath).mkdirs();
		new File(phoneSystemLogPath).mkdirs();
		new File("apk").mkdir();
		ClearFolder.clear("apk");
		CmdExcute.buildJar(UiTestInfos.UITestProjectDir,
				UiTestInfos.MDMTestProjectDir + "\\" + phoneUiTestLogPath);
		Assert.assertTrue(CmdExcute.analyzeResult("build"));
		System.out.println("build ready");
		CmdExcute.pushJarToPhone(UiTestInfos.UITestProjectDir);
		CmdExcute.mkMdmdir();
		CmdExcute.clearMdmdir();
		new FTP().downFile("192.168.10.210","pekall", "pekall", "/storage/MDM_Release/MDM3.0_Internal", "apk", "apk");
		CmdExcute.run(0, UiTestInfos.Setup模块, UiTestInfos.Setup模块_初始化方法);
		CmdExcute.installApk(UiTestInfos.MDMTestProjectDir + "\\" + phoneUiTestLogPath);
	}

	@AfterClass
	public static void afterAll() throws InterruptedException, IOException {
		System.out.println("afterAll");
		CmdExcute.pullScreenshot(phoneScreenshotPath);
		Service.getInstance(MyDriver.USE).close();
		CmdExcute.killDriverProcess();
		
	}
}
