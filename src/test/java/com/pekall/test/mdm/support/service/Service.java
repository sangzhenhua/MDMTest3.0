package com.pekall.test.mdm.support.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.pekall.test.mdm.support.util.MyChromeDriver;
import com.pekall.test.mdm.support.util.WebInfos;


public  class Service {
		private static WebDriver instance;
		public static WebDriver getInstance(Driver driver) {
			if (instance == null) {
				switch(driver)
				{
				case CHROME:
					System.setProperty("webdriver.chrome.driver", WebInfos.ChromeDriverPath);
					instance = new MyChromeDriver(); break;
				case FIREFOX: instance = new FirefoxDriver();break;
				}	
			}
			return instance;
		}	
		
		public static void setWebDriver(WebDriver driver){
			instance = driver;
		}
}
