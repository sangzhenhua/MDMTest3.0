package com.pekall.test.mdm.support.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pekall.test.mdm.support.util.WaitForElement;

public class AppManager {
	private static AppManager instance;
	private WebDriver driver = Service.getInstance(MyDriver.USE);
	private WaitForElement wait = WaitForElement.getInstance();
//	private WaitForElement wait = WaitForElement.getInstance();
	
	public static AppManager getInstance(){
		if(instance == null){
			instance = new AppManager();
		}
		return instance;
	}

	public void gotoAppList() throws InterruptedException {
		wait.waitAndClick(By.id("app"));
		wait.waitAndSwitchToFrame("face-content");
	}
	
	
	public void addApp(String apkPath, String picPath, String type,String desc) throws InterruptedException {
		wait.wait(By.id("app_file")).sendKeys(apkPath);
		wait.wait(By.id("app_screen_file")).sendKeys(picPath);
		wait.wait(By.id("desc")).sendKeys(desc);
		wait.waitAndClick(By.id("confirm"));
	}
	
	public void distributeActionByUserGroup(String userGroup)throws InterruptedException{
		wait.waitAndClick(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div[3]/button"));	                      
		wait.waitAndClick(By.xpath("//span[text()='"+userGroup+"']"));
		wait.waitAndClick(By.id("confirm"));
	}
	
	public void distributeActionByDeviceGroup(String deviceGroup)throws InterruptedException{
		wait.waitAndClick(By.xpath("//button[@title='用户组']"));
		wait.waitAndClick(By.xpath("//span[text()='设备组']"));
		wait.waitAndClick(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div[3]/button"));          
		wait.waitAndClick(By.xpath("//span[text()='"+deviceGroup+"']"));
		wait.waitAndClick(By.id("confirm"));
	}
	
	public void distributeActionByDevice(String device)throws InterruptedException{
		wait.waitAndClick(By.xpath("//button[@title='用户组']"));
		wait.waitAndClick(By.xpath("//span[text()='指定设备']"));
		wait.wait(By.xpath("//input[@name='input_target']")).sendKeys(device);
		wait.waitAndClick(By.xpath("//li[text()='1qaz2wsx-Galaxy Nexus']"));
		wait.waitAndClick(By.id("confirm"));
	}
	
	public void distributeActionByUser(String account) throws InterruptedException{
		wait.waitAndClick(By.xpath("//button[@title='用户组']"));
		wait.waitAndClick(By.xpath("//span[text()='指定用户']"));
		wait.wait(By.xpath("//input[@name='input_target']")).sendKeys(account);;
		wait.waitAndClick(By.xpath("//li[text()='zhenhua.sang@pekall.com(1qaz2wsx)']"));
		wait.waitAndClick(By.id("confirm"));
	}

	public void addBaiduApp(String name, String ploy, String distributeType,
			String distributeTo) throws InterruptedException {
		wait.wait(By.id("search_input")).sendKeys(name);
		wait.waitAndClick(By.xpath("//span[text()='note']"));
		if(ploy!=null && !ploy.isEmpty()){
			wait.waitAndClick(By.xpath("/html/body/div/div[2]/div/div/div[2]/div/div/ins"));
		}
		if(distributeType!=null && !distributeType.isEmpty()){
			wait.waitAndClick(By.xpath("/html/body/div/div[2]/div/div/div[3]/div/div/div[1]/button"));
			wait.waitAndClick(By.xpath("//span[text()='"+distributeType+"']"));
		}
		
		if(distributeTo!=null && !distributeTo.isEmpty()){
			if(distributeType.equals("用户组") || distributeType.equals("设备组")){
			
				wait.waitAndClick(By.xpath("/html/body/div/div[2]/div/div/div[3]/div/div/div[3]/button"));
				wait.waitAndClick(By.xpath("//span[text()='"+distributeTo+"']"));
			}
			if(distributeType.equals("指定用户") || distributeType.equals("指定设备")){
				System.out.println("distribute != null");
				wait.wait(By.xpath("/html/body/div/div[2]/div/div/div[3]/div/div/input")).sendKeys(distributeTo);
				wait.waitAndClick(By.xpath("//li[contains(text(),'"+distributeTo+"')]"));
			}
		}
		
		wait.waitAndClick(By.id("confirm"));
	}
}
