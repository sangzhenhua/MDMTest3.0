package com.pekall.test.mdm.support.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pekall.test.mdm.support.util.WebInfos;

public class DeviceManager {
	private static DeviceManager instance;
	private WebDriver driver = Service.getInstance(MyDriver.USE);
	
	public static DeviceManager getInstance(){
		if(instance == null){
			instance = new DeviceManager();
		}
		return instance;
	}
	
	public void gotoDeviceList() throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(By.id("device")).click();
		driver.findElement(By.id("device-list")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("face-content");
	}
	
	public void gotoDeviceGroupList() throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(By.id("device")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("device-group-list")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("face-content");
	}
	public void addDevice(String account) throws InterruptedException{
		driver.findElement(By.id("account")).sendKeys(account);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[@data-account='"+account+"']")).click();
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(6000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[2]")).getAttribute("id"));
		
	}
	
	public void selectDevice(String deviceName){
		System.out.println("select device");
		//WebElement element = driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td[2]/a[text()='"+userlist.get(1)+"']/parent::td/parent::tr/td/input[@type='checkbox']"));
		WebElement element = driver.findElement(By.id("chk_title"));
		if (!element.isSelected()){
			element.click();
		}	
		else{
			System.out.println("element already selected");
		}
	}
	
	public void lock(String pwd) throws InterruptedException{
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(5000);
	}
	
	public void unlock() throws InterruptedException{
		driver.findElement(By.id("device_lockscreen_ok")).click();
		Thread.sleep(1000);
	}
	
	public void partClear() {
		driver.findElement(By.id("device_lockscreen_ok")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addDeviceGroup(String deviceType, String system, String brand,String name,String desc) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div/div/div/div/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='手机']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Android']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[6]/div/button")).click();                     
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='google']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[6]/div/button")).click();                     
		Thread.sleep(1000);
		driver.findElement(By.id("create_group")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")).getAttribute("id"));
		driver.findElement(By.id("name")).sendKeys(name);;
		driver.findElement(By.id("description")).sendKeys(desc);
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(5000);
	}
}
