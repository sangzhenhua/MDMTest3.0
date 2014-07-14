package com.pekall.test.mdm.support.service;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pekall.test.mdm.support.util.MyAssert;
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
		WebDriver driver = Service.getInstance(MyDriver.USE);
		System.out.println("longin driver:"+driver);
		driver.get(WebInfos.LoginUrl);
		driver.findElement(By.id("account")).sendKeys(WebInfos.UserName);
	    driver.findElement(By.id("password")).sendKeys(WebInfos.Password);
	    driver.findElement(By.id("login")).click();
	    driver.manage().window().maximize();
	    Thread.sleep(6000);
	  
	    MyAssert.assert_True("登陆失败",driver.getPageSource().contains(WebInfos.登陆成功提示));
	  
	}

}
