package com.pekall.test.mdm.support.service;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pekall.test.mdm.support.util.MyAssert;
import com.pekall.test.mdm.support.util.WebInfos;


public class UserManager {
	private static UserManager instance;
	private WebDriver driver = Service.getInstance(MyDriver.USE);;
	
	public static UserManager getInstance(){
		if(instance == null){
			instance = new UserManager();
		}
		return instance;
	}
	
	
	public void addSimple(String account,String name,String phone) throws InterruptedException{
	    driver.findElement(By.id("account")).sendKeys(account);
	    driver.findElement(By.id("name")).sendKeys(name);
	    driver.findElement(By.id("phone")).sendKeys(phone);
	   // driver.findElement(By.className("r_password")).sendKeys(r_password);
	   // driver.findElement(By.className("phone_number")).sendKeys(phone_number);
	   // driver.findElement(By.className("cell_number")).sendKeys(cell_number);
	   
	//	WebElement el=driver.findElement(By.xpath("//a/span[2][text()='自动化测试']/parent::a/parent::li/span[@class='button chk checkbox_false_full']"));
		//if(!el.isSelected()){
			//el.click();
	//	}
	    driver.findElement(By.id("confirm")).click();
	    Thread.sleep(5000);
	}
	

	public void addBatch(String path) throws InterruptedException{
		driver.findElement(By.id("file_select")).sendKeys(path);
		Thread.sleep(3000);
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(3000);
	}
	
	public void addGroup(String name,String member,String desc)throws InterruptedException{
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("search_content")).sendKeys(member);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[@data-account='"+member+"']")).click();
		driver.findElement(By.id("description")).sendKeys(desc);
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(6000);
	}
	
	public void registDevice() throws InterruptedException{
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[2]")).getAttribute("id"));
		
	}
	
	public void gotoUserList() throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(By.id("user")).click();
		driver.findElement(By.id("user-list")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("face-content");
	}
	
	public void gotoUserGroupList()throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(By.id("user")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("user-group-list")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("face-content");
	}
	
	public void changePloy(String ployName) throws InterruptedException{
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[3]/div/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='"+ployName+"']")).click();
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(10000);
	}
	
	public void sendMsg(String message_title,String message_body) throws InterruptedException{
		driver.findElement(By.id("message_title")).sendKeys(message_title);
		driver.findElement(By.id("message_body")).sendKeys(message_body);
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(10000);
	}
	
	public void distributeAction(String subject) throws InterruptedException{
		driver.findElement(By.id("search_content")).sendKeys(subject);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[@data-name='"+subject+"']")).click();
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(10000);
	}
	
}
