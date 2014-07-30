package com.pekall.test.mdm.support.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pekall.test.mdm.support.util.WaitForElement;

	public class DocManager {
		private static DocManager instance;
		private WebDriver driver = Service.getInstance(MyDriver.USE);
		private WaitForElement wait = WaitForElement.getInstance();
		
		public static DocManager getInstance(){
			if(instance == null){
				instance = new DocManager();
			}
			return instance;
		}
		
		public void gotoDocList() throws InterruptedException{
			wait.waitAndClick(By.id("doc"));
			wait.waitAndSwitchToFrame("face-content");
		}
		
		public void addDoc(String name,String desc,String path) throws InterruptedException{
			wait.wait(By.id("doc-name")).sendKeys(name);
			wait.wait(By.id("doc-tag")).sendKeys(desc);
			wait.wait(By.id("doc_file")).sendKeys(path);
			wait.waitAndClick(By.id("confirm"));
		}
	
}
