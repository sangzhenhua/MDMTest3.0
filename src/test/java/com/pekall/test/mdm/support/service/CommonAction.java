package com.pekall.test.mdm.support.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pekall.test.mdm.support.util.MyAssert;
import com.pekall.test.mdm.support.util.WebInfos;

public class CommonAction {
	private static CommonAction instance;
	private WebDriver driver = Service.getInstance(MyDriver.USE);
	
	public static CommonAction getInstance(){
		if(instance == null){
			instance = new CommonAction();
		}
		return instance;
	}
	
	public void selectByInfo(String info) throws InterruptedException{
		WebElement element = driver.findElement(By.xpath("//*[text()='"+info+"']"));
		element.click();
		Thread.sleep(1000);
	}
	
	public void selectByTotalCheck(String id){
		WebElement element = driver.findElement(By.id(id));
		if (!element.isSelected()){
			element.click();
		}
	}
	
	public void gotoAction(String actionId,String actionClass,String subActionId,String subActionClass) throws InterruptedException{
		if(actionId != null){
			driver.findElement(By.id(actionId)).click();
			Thread.sleep(1000);
		}
		
		if(actionClass != null){
			driver.findElement(By.cssSelector(actionClass)).click();
			Thread.sleep(1000);
		}
		
		if(subActionId!=null){
			driver.findElement(By.id(subActionId)).click();
		}
		if(subActionClass!=null){
			driver.findElement(By.className(subActionClass)).click();
		}
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")).getAttribute("id"));
		
	}
	
	public void gotoAction(By by,By subBy) throws InterruptedException{
		if(by != null){
			driver.findElement(by).click();
			Thread.sleep(2000);
		}
		
		if(subBy != null){
		
			driver.findElement(subBy).click();
			Thread.sleep(1000);
		}
		
	    driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")).getAttribute("id"));
		
	}
	
	public void gotoCancelDistribute(By by,By subBy) throws InterruptedException{
		driver.findElement(by).click();
		driver.findElement(subBy).click();
		Thread.sleep(3000);
	}
	
	public void actionSuccessCheck(ActionType actionType){
		//driver.switchTo().defaultContent();
		//driver.switchTo().frame(driver.findElement(By.id("dialog_msg_iframe")));
		switch(actionType){
		case UserAddSimple:
			MyAssert.assert_True("用户单个添加失败",driver.getPageSource().contains(WebInfos.user单个添加成功提示)||driver.getPageSource().contains(WebInfos.user添加重复提示));
			break;
		case UserAddBatch:
			MyAssert.assert_True("用户批量添加失败",driver.getPageSource().contains(WebInfos.user批量添加成功提示)||driver.getPageSource().contains(WebInfos.user添加重复提示));
			break;
		case UserSendMsg:
			MyAssert.assert_True("用户发送消息失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case UserDelete:
			MyAssert.assert_True("用户删除失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case DevicePosition:
			break;
		case DevicePartClear:
			MyAssert.assert_True("设备部分擦除失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case DeviceLock:
			MyAssert.assert_True("设备锁定失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case DeviceUnlock:
			MyAssert.assert_True("设备解锁失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case AndroidPWDConfigAdd:
			MyAssert.assert_True("Android密码策略添加失败",driver.getPageSource().contains(WebInfos.action成功提示)||driver.getPageSource().contains(WebInfos.配置添加重复提示));
			break;
		case AndroidPWDConfigUpdate:
			MyAssert.assert_True("Android密码策略更新失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case AndroidPWDConfigIssueGroup:
			MyAssert.assert_True("Android密码策略下发到分组失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case AndroidPWDConfigIssueUser:
			MyAssert.assert_True("Android密码策略下发到用户失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case AndroidPWDConfigDelete:
			MyAssert.assert_True("Android密码策略删除失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		
		case AndroidRestrictConfigAdd:
			MyAssert.assert_True("Android限制策略添加失败",driver.getPageSource().contains(WebInfos.action成功提示)||driver.getPageSource().contains(WebInfos.配置添加重复提示));
			break;
			
		case AndroidRestrictConfigUpdate:
			MyAssert.assert_True("Android限制策略更新失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
			
		case AndroidRestrictConfigIssueGroup:
			MyAssert.assert_True("Android限制策略下发到分组失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case AndroidRestrictConfigIssueUser:
			MyAssert.assert_True("Android限制策略下发到用户失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case AndroidRestrictConfigDelete:
			MyAssert.assert_True("Android限制策略删除失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		
		case WIFIConfigAdd:
			MyAssert.assert_True("WIFI配置添加失败",driver.getPageSource().contains(WebInfos.action成功提示)||driver.getPageSource().contains(WebInfos.配置添加重复提示));
			break;
		case WIFIConfigUpdate:
			MyAssert.assert_True("WIFI配置更新失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case WIFIConfigIssueGroup:
			MyAssert.assert_True("WIFI配置更新失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case WIFIConfigIssueUser:
			MyAssert.assert_True("WIFI配置下发到用户失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case WIFIConfigDelete:
			MyAssert.assert_True("WIFI配置删除失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case EmailConfigAdd:
			MyAssert.assert_True("Email配置添加失败",driver.getPageSource().contains(WebInfos.action成功提示)||driver.getPageSource().contains(WebInfos.配置添加重复提示));
			break;
		case EmailConfigUpdate:
			MyAssert.assert_True("Email配置更新失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case EmailConfigIssueGroup:
			MyAssert.assert_True("Email配置下发到分组失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case EmailConfigIssueUser:
			MyAssert.assert_True("Email配置下发到用户失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case EmailConfigDelete:
			MyAssert.assert_True("Email配置删除失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case DocumentAdd:
			MyAssert.assert_True("文档添加失败",driver.getPageSource().contains(WebInfos.doc添加成功提示));
			break;
		case DocumentIssueGroup:
			MyAssert.assert_True("文档下发到分组失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case DocumentIssueUser:
			MyAssert.assert_True("文档下发到用户失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case DocumentDelete:
			MyAssert.assert_True("文档删除失败",driver.getPageSource().contains(WebInfos.doc删除成功提示));
			break;
		case ContactsAdd:
			MyAssert.assert_True("通讯录添加失败",driver.getPageSource().contains(WebInfos.contact添加成功提示)||driver.getPageSource().contains(WebInfos.contact添加重复提示));
			break;
		case ContactsUpdate:
			MyAssert.assert_True("通讯录更新失败",driver.getPageSource().contains(WebInfos.contact更新成功提示));
			break;
		case ContactsIssueGroup:
			MyAssert.assert_True("通讯录下发到分组失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case ContactsIssueUser:
			MyAssert.assert_True("通讯录下发到用户失败",driver.getPageSource().contains(WebInfos.action成功提示));
			break;
		case ContactsDelete:
			MyAssert.assert_True("通讯录删除失败",driver.getPageSource().contains(WebInfos.contact删除成功提示));
			break;
		case EmailModify:
			MyAssert.assert_True("邮件修改失败",driver.getPageSource().contains(WebInfos.邮件修改成功提示));
			break;
		}
		
		if(driver.findElement(By.cssSelector(".btn.btn-success"))!=null){
			driver.findElement(By.cssSelector(".btn.btn-success")).click();
		}
		
		if(driver.findElement(By.cssSelector(".btn.btn-danger"))!=null){
			driver.findElement(By.cssSelector(".btn.btn-danger")).click();
		}
	
		switch(actionType){
		case AndroidPWDConfigDelete:
			
			
		
		}
	}
	
	public void deleteConfirm(String id) throws InterruptedException{
		driver.findElement(By.id(id)).click();
		Thread.sleep(1000);
	}
	
	public void relateGroup(String group) throws InterruptedException{
		driver.findElement(By.xpath("/html/body/div/div/div/div/li/span[@id='tree_1_switch']")).click();		
		driver.findElement(By.id("tree_2_switch")).click();
		Thread.sleep(1000);
		                          
		driver.findElement(By.xpath("//a/span[2][text()='"+group+"']/parent::a/parent::li/span[@class='button chk checkbox_false_full']")).click();
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(2000);
	}
	
	public void search(String info) throws InterruptedException{
		driver.findElement(By.id("search_input")).sendKeys(info);
		Thread.sleep(1000);
		driver.findElement(By.id("search")).click();
		Thread.sleep(2000);
	}
	
	public boolean search(String info,ActionType type) throws InterruptedException{
		boolean result = true;
		driver.findElement(By.id("search_input")).sendKeys(info);
		Thread.sleep(1000);
		driver.findElement(By.id("search")).click();
		Thread.sleep(2000);
		switch(type){
		case UserSearch:
			result = driver.getPageSource().contains(info);
			break;
		case DeviceSearch:
			result = !driver.getPageSource().contains(WebInfos.device未搜索到提示);
			break;
		case PloySearch:
			result = !driver.getPageSource().contains(WebInfos.策略未搜索到提示);
			break;
		case ConfigSearch:
			result = !driver.getPageSource().contains(WebInfos.配置未搜索到提示);
			break;
		case DocSearch:
			result = !driver.getPageSource().contains(WebInfos.文档未搜索到提示);
			break;
		case ContactsSearch:
			result = !driver.getPageSource().contains(WebInfos.通讯录未搜索到提示);
			break;
		}
		//System.out.println(driver.getPageSource());
		System.out.println(result);
		return result;
	}
		
	public void relateUser(List<String> list,ActionType type) throws InterruptedException{
	    boolean result =this.search(list.get(1),type);
	    System.out.println(result);
	    if(result){
	    	this.selectByTotalCheck("all_check");
	    }
	    driver.findElement(By.id("confirm")).click();
	    Thread.sleep(1000);
	}
}
