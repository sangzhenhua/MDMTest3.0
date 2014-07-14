package com.pekall.test.mdm.support.util;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.pekall.test.mdm.RunCukesTest;
import com.pekall.test.mdm.support.service.MyDriver;
import com.pekall.test.mdm.support.service.Service;

public class CaptureScreenshot {
	public static void screenShot(String fileName){
		WebDriver driver = Service.getInstance(MyDriver.USE);
		String dirName = RunCukesTest.webScreenshotPath;  
        TakesScreenshot tsDriver = (TakesScreenshot) driver;
        File image = new File(dirName+File.separator+fileName+".png");
        tsDriver.getScreenshotAs(OutputType.FILE).renameTo(image);
	}
}
