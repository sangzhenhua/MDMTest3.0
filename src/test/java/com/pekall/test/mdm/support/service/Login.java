package com.pekall.test.mdm.support.service;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pekall.test.mdm.support.util.MyAssert;
import com.pekall.test.mdm.support.util.WaitForElement;
import com.pekall.test.mdm.support.util.WebInfos;


public class Login{
	private static Login instance;
	public static Login getInstance() {
		// TODO Auto-generated method stub
		if(instance == null)
		{
			instance = new Login();
		}
		return instance;
	}
	
	
	
	public void login() throws InterruptedException, IOException{
		WaitForElement wait = WaitForElement.getInstance();
		WebDriver driver = Service.getInstance(MyDriver.USE);
		driver.get(WebInfos.LoginUrl);
		wait.wait(By.id("account")).sendKeys(WebInfos.UserName);
		wait.wait(By.id("password")).sendKeys(WebInfos.Password);
		wait.waitAndClick(By.id("login"));
	    driver.manage().window().maximize();
	    wait.wait(WebInfos.登陆成功提示);
	}

}
