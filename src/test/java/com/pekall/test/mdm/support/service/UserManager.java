package com.pekall.test.mdm.support.service;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pekall.test.mdm.support.util.MyAssert;
import com.pekall.test.mdm.support.util.WaitForElement;
import com.pekall.test.mdm.support.util.WebInfos;


public class UserManager {
	private static UserManager instance;
	private WebDriver driver = Service.getInstance(MyDriver.USE);;
	private WaitForElement wait = WaitForElement.getInstance();
	public static UserManager getInstance(){
		if(instance == null){
			instance = new UserManager();
		}
		return instance;
	}
	
	
	public void addSimple(String account,String name,String phone) throws InterruptedException{
	    wait.wait(By.id("account")).sendKeys(account);
	    wait.wait(By.id("name")).sendKeys(name);
	    wait.wait(By.id("phone")).sendKeys(phone);
	    wait.waitAndClick(By.id("confirm"));
	}
	

	public void addBatch(String path) throws InterruptedException{
		wait.wait(By.id("file_select")).sendKeys(path);
		wait.waitAndClick(By.id("confirm"));
	}
	
	public void addGroup(String name,String member,String desc)throws InterruptedException{
		wait.wait(By.id("name")).sendKeys(name);
		wait.wait(By.id("search_content")).sendKeys(member);
		wait.waitAndClick(By.xpath("//p[@data-account='"+member+"']"));
		wait.wait(By.id("description")).sendKeys(desc);
		wait.waitAndClick(By.id("confirm"));
	}
	
	public void registDevice() throws InterruptedException{
		wait.waitAndClick(By.id("confirm"));
		wait.waitAndSwitchToFrame(By.xpath("/html/body/iframe[2]"));
	}
	
	public void gotoUserList() throws InterruptedException{
		wait.waitAndClick(By.id("user"));
		wait.waitAndClick(By.id("user-list"));
		wait.waitAndSwitchToFrame("face-content");
	}
	
	public void gotoUserGroupList()throws InterruptedException{
		wait.waitAndClick(By.id("user"));
		wait.waitAndClick(By.id("user-group-list"));
		wait.waitAndSwitchToFrame("face-content");
	}
	
	public void changePloy(String ployName) throws InterruptedException{
		wait.waitAndClick(By.xpath("/html/body/div/div[2]/div/div/div[3]/div/button"));
		wait.waitAndClick(By.xpath("//span[text()='"+ployName+"']"));
		wait.waitAndClick(By.id("confirm"));
	}
	
	public void sendMsg(String message_title,String message_body) throws InterruptedException{
		wait.wait(By.id("message_title")).sendKeys(message_title);
		wait.wait(By.id("message_body")).sendKeys(message_body);
		wait.waitAndClick(By.id("confirm"));
	}
	
	public void distributeAction(String subject) throws InterruptedException{
		wait.wait(By.id("search_content")).sendKeys(subject);
		wait.waitAndClick(By.xpath("//p[@data-name='"+subject+"']"));
		wait.waitAndClick(By.id("confirm"));
	}
	
}
