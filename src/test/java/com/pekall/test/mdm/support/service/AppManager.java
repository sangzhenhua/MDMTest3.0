package com.pekall.test.mdm.support.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppManager {
	private static AppManager instance;
	private WebDriver driver = Service.getInstance(MyDriver.USE);;
	
	public static AppManager getInstance(){
		if(instance == null){
			instance = new AppManager();
		}
		return instance;
	}

	public void gotoAppList() throws InterruptedException {
		driver.findElement(By.id("app")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("face-content");
	}
	
	
	public void addApp(String apkPath, String picPath, String type,String desc) throws InterruptedException {
		driver.findElement(By.id("app_file")).sendKeys(apkPath);
		Thread.sleep(2000);
		driver.findElement(By.id("app_screen_file")).sendKeys(picPath);
		Thread.sleep(2000);
		driver.findElement(By.id("desc")).sendKeys(desc);
	
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(6000);
	}
	
	public void distributeActionByUserGroup(String userGroup)throws InterruptedException{
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div[3]/button")).click();	                      
		driver.findElement(By.xpath("//span[text()='"+userGroup+"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(8000);
	}
	
	public void distributeActionByDeviceGroup(String deviceGroup)throws InterruptedException{
		driver.findElement(By.xpath("//button[@title='用户组']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='设备组']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div[3]/button")).click();          
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='"+deviceGroup+"']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(8000);
	}
	
	public void distributeActionByDevice(String device)throws InterruptedException{
		driver.findElement(By.xpath("//button[@title='用户组']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='指定设备']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='input_target']")).sendKeys(device);;
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='1qaz2wsx-Galaxy Nexus']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(8000);
	}
	
	public void distributeActionByUser(String account) throws InterruptedException{
		driver.findElement(By.xpath("//button[@title='用户组']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='指定用户']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='input_target']")).sendKeys(account);;
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='zhenhua.sang@pekall.com(1qaz2wsx)']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(8000);
	}

	public void addBaiduApp(String name, String ploy, String distributeType,
			String distributeTo) throws InterruptedException {
		driver.findElement(By.id("search_input")).sendKeys(name);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='note']")).click();
		Thread.sleep(2000);
		if(ploy!=null && !ploy.isEmpty()){
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div/div/ins")).click();
		}
		if(distributeType!=null && !distributeType.isEmpty()){
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[3]/div/div/div[1]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='"+distributeType+"']")).click();
			Thread.sleep(1000);
		}
		
		if(distributeTo!=null && !distributeTo.isEmpty()){
			if(distributeType.equals("用户组") || distributeType.equals("设备组")){
			
				driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[3]/div/div/div[3]/button")).click();
				driver.findElement(By.xpath("//span[text()='"+distributeTo+"']")).click();
			}
			if(distributeType.equals("指定用户") || distributeType.equals("指定设备")){
				System.out.println("distribute != null");
				driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[3]/div/div/input")).sendKeys(distributeTo);
				driver.findElement(By.xpath("//li[contains(text(),'"+distributeTo+"')]")).click();
			}
		}
		
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(6000);
	}
}
