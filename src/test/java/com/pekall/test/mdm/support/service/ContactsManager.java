package com.pekall.test.mdm.support.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pekall.test.mdm.support.util.MyAssert;
import com.pekall.test.mdm.support.util.WaitForElement;
import com.pekall.test.mdm.support.util.WebInfos;

public class ContactsManager {
	private static ContactsManager instance;
	private WebDriver driver = Service.getInstance(MyDriver.USE);
	private WaitForElement wait = WaitForElement.getInstance();
	
	public static ContactsManager getInstance(){
		if(instance == null){
			instance = new ContactsManager();
		}
		return instance;
	}

	public void gotoContactsList() throws InterruptedException {
		wait.waitAndClick(By.id("contacts"));
		wait.waitAndSwitchToFrame("face-content");
	}
	
	public void addContacts(String name,String path) throws InterruptedException{
		if(name!=null){
			wait.wait(By.id("contact-list-name")).sendKeys(name);
		}
		wait.wait(By.id("contact_file")).sendKeys(path);
		wait.waitAndClick(By.id("confirm"));
	}

}
