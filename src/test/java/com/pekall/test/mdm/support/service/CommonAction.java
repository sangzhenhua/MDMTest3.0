package com.pekall.test.mdm.support.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pekall.test.mdm.support.util.MyAssert;
import com.pekall.test.mdm.support.util.WaitForElement;
import com.pekall.test.mdm.support.util.WebInfos;

public class CommonAction {
	private static CommonAction instance;
	private WebDriver driver = Service.getInstance(MyDriver.USE);
	private WaitForElement wait = WaitForElement.getInstance();
	
	public static CommonAction getInstance(){
		if(instance == null){
			instance = new CommonAction();
		}
		return instance;
	}
	
	public void selectByInfo(String info) throws InterruptedException{
		wait.waitAndClick(By.xpath("//*[text()='"+info+"']"));
	}
	
	public void selectByTotalCheck(String id){
		WebElement element = driver.findElement(By.id(id));
		if (!element.isSelected()){
			element.click();
		}
	}
	
	public void gotoAction(String actionId,String actionClass,String subActionId,String subActionClass) throws InterruptedException{
		if(actionId != null){
			wait.waitAndClick(By.id(actionId));
		}
		
		if(actionClass != null){
			wait.waitAndClick(By.cssSelector(actionClass));
		}
		
		if(subActionId!=null){
			wait.waitAndClick(By.id(subActionId));
		}
		if(subActionClass!=null){
			wait.waitAndClick(By.className(subActionClass));
		}
		wait.waitAndSwitchToFrame(By.xpath("/html/body/iframe"));
		
	}
	
	public void gotoAction(By by,By subBy) throws InterruptedException{
		if(by != null){
			wait.waitAndClick(by);
		}
		
		if(subBy != null){
			wait.waitAndClick(subBy);
		}
		wait.waitAndSwitchToFrame(By.xpath("/html/body/iframe"));
	}
	
	public void gotoCancelDistribute(By by,By subBy) throws InterruptedException{
		wait.waitAndClick(by);
		wait.waitAndClick(subBy);
	}
	
	public void deleteConfirm(String id) throws InterruptedException{
		wait.waitAndClick(By.id(id));
	}
	
	public void relateGroup(String group) throws InterruptedException{
		wait.waitAndClick(By.xpath("/html/body/div/div/div/div/li/span[@id='tree_1_switch']"));		
		wait.waitAndClick(By.id("tree_2_switch"));
		                         
		wait.waitAndClick(By.xpath("//a/span[2][text()='"+group+"']/parent::a/parent::li/span[@class='button chk checkbox_false_full']"));
		wait.waitAndClick(By.id("confirm"));
	}
	
	public void search(String info) throws InterruptedException{
		wait.wait(By.id("search_input")).sendKeys(info);
		wait.waitAndClick(By.id("search"));
	}
	
}
