package com.pekall.test.mdm.support.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pekall.test.mdm.support.util.WaitForElement;
import com.pekall.test.mdm.support.util.WebInfos;

public class DeviceManager {
	private static DeviceManager instance;
	private WebDriver driver = Service.getInstance(MyDriver.USE);
	private WaitForElement wait = WaitForElement.getInstance();
	
	public static DeviceManager getInstance(){
		if(instance == null){
			instance = new DeviceManager();
		}
		return instance;
	}
	
	public void gotoDeviceList() throws InterruptedException{
		wait.waitAndClick(By.id("device"));
		wait.waitAndClick(By.id("device-list"));
		wait.waitAndSwitchToFrame("face-content");
	}
	
	public void gotoDeviceGroupList() throws InterruptedException{
		wait.waitAndClick(By.id("device"));
		wait.waitAndClick(By.id("device-group-list"));
		wait.waitAndSwitchToFrame("face-content");
	}
	public void addDevice(String account) throws InterruptedException{
		wait.wait(By.id("account")).sendKeys(account);
		wait.waitAndClick(By.xpath("//p[@data-account='"+account+"']"));
		wait.waitAndClick(By.id("confirm"));
		wait.waitAndSwitchToFrame(By.xpath("/html/body/iframe[2]"));
	}
	
	public void selectDevice(String deviceName){
		wait.waitAndClick(By.id("chk_title"));
		
	}
	
	public void lock(String pwd) throws InterruptedException{
		wait.wait(By.id("password")).sendKeys(pwd);
		wait.waitAndClick(By.id("confirm"));
	}
	
	public void unlock() throws InterruptedException{
		wait.waitAndClick(By.id("device_lockscreen_ok"));
	}
	
	public void partClear() {
		wait.waitAndClick(By.id("device_lockscreen_ok"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addDeviceGroup(String deviceType, String system, String brand,String name,String desc) throws InterruptedException {
		wait.waitAndClick(By.xpath("/html/body/div/div/div/div/button"));
		wait.waitAndClick(By.xpath("//span[text()='手机']"));
		wait.waitAndClick(By.xpath("/html/body/div/div/div[2]/div/button"));
		wait.waitAndClick(By.xpath("//span[text()='Android']"));
		wait.waitAndClick(By.xpath("/html/body/div/div/div[2]/div/button"));
		wait.waitAndClick(By.xpath("/html/body/div/div[1]/div[6]/div/button"));                     
		wait.waitAndClick(By.xpath("//span[text()='google']"));
		wait.waitAndClick(By.xpath("/html/body/div/div[1]/div[6]/div/button"));                     
		wait.waitAndClick(By.id("create_group"));
		wait.waitAndSwitchToFrame(By.xpath("/html/body/iframe"));
		wait.wait(By.id("name")).sendKeys(name);;
		wait.wait(By.id("description")).sendKeys(desc);
		wait.waitAndClick(By.id("confirm"));
	}
}
