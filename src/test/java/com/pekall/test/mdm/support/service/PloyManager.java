package com.pekall.test.mdm.support.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pekall.test.mdm.support.util.MyAssert;
import com.pekall.test.mdm.support.util.WebInfos;

public class PloyManager {
	private static PloyManager instance;
	private WebDriver driver = Service.getInstance(MyDriver.USE);
	
	public static PloyManager getInstance(){
		if(instance == null){
			instance = new PloyManager();
		}
		return instance;
	}
	
	public void addAndroidPWDPloy(String name,String desc,String level) throws InterruptedException{
		WebElement element =null;
		if(name!=null){
			driver.findElement(By.id("name")).sendKeys(name);
		}
		if(desc!=null){
			element = driver.findElement(By.id("description"));
			element.clear();
			element.sendKeys(desc);
		}
		
		driver.findElement(By.id("password_page_btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='lbl']")).click();
		//driver.findElement(By.cssSelector(".btn.btn-success")).click()
		//driver.findElement(By.cssSelector(".ace.configure_page")).click();
		driver.manage().window().maximize();
		driver.findElement(By.id("save")).click();
		Thread.sleep(3000);
	}
	
	public void addAndroidPWDPloy(String name,String desc,String level,String min_length,String complex_min_num,String max_valid_day,String no_pwd_max_time,String history_num,String max_fail_time ) throws InterruptedException{
		WebElement element =null;
		if(name!=null){
			driver.findElement(By.id("name")).sendKeys(name);
		}
		if(desc!=null){
			element = driver.findElement(By.id("description"));
			element.clear();
			element.sendKeys(desc);
		}
		
		driver.findElement(By.id("password_page_btn")).click();
		driver.findElement(By.xpath("//ins[@class='iCheck-helper']")).click();
//		
//		if(level!=null){
//			Select oSingleSelection = new Select(driver.findElement(By.id("password_level")));  
//			oSingleSelection.selectByVisibleText(level); 
//		}
//		
//		if(min_length!=null){
//			Select oSingleSelection = new Select(driver.findElement(By.id("password_min_length")));  
//			oSingleSelection.selectByVisibleText(min_length); 
//		}
//		
//		if(level!=null && level.equals("混合") && complex_min_num != null){
//			Select oSingleSelection = new Select(driver.findElement(By.id("complex_min_num")));  
//			oSingleSelection.selectByVisibleText(complex_min_num); 
//		}
//		
//		if(max_valid_day!=null){
//			element = driver.findElement(By.id("max_valid_day"));
//			element.clear();
//			element.sendKeys(max_valid_day);
//		}
//		
//		
//		if(no_pwd_max_time!=null){
//			Select oSingleSelection = new Select(driver.findElement(By.id("no_password_max_time")));  
//			oSingleSelection.selectByVisibleText(no_pwd_max_time); 
//		}
//		
//		if(history_num!=null){
//			element = driver.findElement(By.id("history_num"));
//			element.clear();
//			element.sendKeys(history_num);
//		}
//		
//		
//		if(max_fail_time!=null){
//			Select oSingleSelection = new Select(driver.findElement(By.id("max_fail_time")));  
//			oSingleSelection.selectByVisibleText(max_fail_time); 
//		}
//	
		
		//String js="myDocumentElements=document.getElementsByTagName_r('body'); myBody=myDocumentElements.item(0);myBodyElement=myBody.getElementsById('save');myBodyElement.click();";

	   //JavascriptExecutor jse= (JavascriptExecutor)driver;
	   //jse.executeScript(js, null);  
		driver.manage().window().maximize();
		driver.findElement(By.id("save")).click();
		Thread.sleep(3000);
	}
	
	
	public void gotoPloyList() throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(By.id("security")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("security-policy-list")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("face-content");
	}
	
	public void gotoRuleList() throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(By.id("security")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("security-rule-manage")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("face-content");
	}
	
	public void gotoAppConfigList() throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div[3]/ul/li[4]/div[@id='ploy_config']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div[3]/ul/li[4]/ul/li[3]/div[@id='config_app']")).click();
		driver.switchTo().frame("main_container");
	}
	
	
	
	public void updateAndroidPWDPloy(String name,String desc,String level,String min_length,String complex_min_num,String max_valid_day,String no_pwd_max_time,String history_num,String max_fail_time ) throws InterruptedException{
		this.addAndroidPWDPloy(name, desc, level, min_length, complex_min_num, max_valid_day, no_pwd_max_time, history_num, max_fail_time);
	}
	
	public void addAndroidRestrictPloy(String name,String desc,String ploy) throws InterruptedException{
		WebElement element =null;
		if(name!=null){
			driver.findElement(By.id("name")).sendKeys(name);
		}
		if(desc!=null){
			element = driver.findElement(By.id("description"));
			element.clear();
			element.sendKeys(desc);
		}
		if(ploy!=null){
			Select oSingleSelection = new Select(driver.findElement(By.id("allow_use_Camera")));  
			oSingleSelection.selectByVisibleText(ploy); 
		}
		
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(1000);
	}
	
	public void addWIFIConfig(String name,String desc,String ssid,String isAutoJoin,String isHiddenNetwork,String security_type,String proxy_type,String password) throws InterruptedException{
		WebElement element =null;
		if(name!=null){
			driver.findElement(By.id("name")).sendKeys(name);
		}
		if(desc!=null){
			element = driver.findElement(By.id("description"));
			element.clear();
			element.sendKeys(desc);
		}
		
		if(ssid!=null){
			element = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/ul/li[3]/input"));
			element.clear();
			element.sendKeys(ssid);
		}
		
		if(isAutoJoin!=null){
			if(isAutoJoin.equals("是")){
				if(!(driver.findElement(By.className("auto_join")).isSelected())){
					driver.findElement(By.className("auto_join")).click();
				}
			}
			if(isAutoJoin.equals("否")){
				if((driver.findElement(By.className("auto_join")).isSelected())){
					driver.findElement(By.className("auto_join")).click();
				}
			}
		}
		
		if(isHiddenNetwork!=null){
			if(isHiddenNetwork.equals("是")){
				if(!(driver.findElement(By.className("hidden_network")).isSelected())){
					driver.findElement(By.className("hidden_network")).click();
				}
			}
			if(isHiddenNetwork.equals("否")){
				if((driver.findElement(By.className("hidden_network")).isSelected())){
					driver.findElement(By.className("hidden_network")).click();
				}
			}
		}
		
		if(security_type!=null){
			Select oSingleSelection = new Select(driver.findElement(By.className("security_type")));  
			oSingleSelection.selectByVisibleText(security_type); 
			if(password!=null){
				element = driver.findElement(By.className("person_password"));
				element.clear();
				element.sendKeys(password);
			}
		}
		
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(1000);
	}
	
		
	public void addEmailConfig(String name,String desc,String accout_desc,String accout_type,String path_prefix,String account_name,String email,String allow_move,String incoming_host_name,String incoming_port,String incoming_server_username,String incoming_identify_type,String incoming_server_password,String incoming_use_ssl,String outgoing_host_name,String outgoing_port,String outgoing_server_username,String outgoing_identify_type,String outgoing_server_password,String outgoing_use_ssl) throws InterruptedException{
		WebElement element =null;
		if(name!=null){
			driver.findElement(By.id("name")).sendKeys(name);
		}
		if(desc!=null){
			element = driver.findElement(By.id("description"));
			element.clear();
			element.sendKeys(desc);
		}
		
		if(accout_desc!=null){
			element = driver.findElement(By.id("account_description"));
			element.clear();
			element.sendKeys(accout_desc);
		}
		
		if(accout_type!=null){
			Select oSingleSelection = new Select(driver.findElement(By.id("account_type")));  
			oSingleSelection.selectByVisibleText(accout_type);
		}
		
		if(path_prefix!=null){
			element = driver.findElement(By.id("path_prefix"));
			element.clear();
			element.sendKeys(path_prefix);
		}
		
		if(account_name!=null){
			element = driver.findElement(By.id("account_name"));
			element.clear();
			element.sendKeys(account_name);
		}
		if(email!=null){
			element = driver.findElement(By.id("email"));
			element.clear();
			element.sendKeys(email);
		}
		
		if(allow_move!=null){
			if(allow_move.equals("是")){
				if(!(driver.findElement(By.id("allow_move")).isSelected())){
					driver.findElement(By.id("allow_move")).click();
				}
			}
			if(allow_move.equals("否")){
				if((driver.findElement(By.id("allow_move")).isSelected())){
					driver.findElement(By.id("allow_move")).click();
				}
			}
		}
		
		if(incoming_host_name!=null){
			element = driver.findElement(By.id("incoming_host_name"));
			element.clear();
			element.sendKeys(incoming_host_name);
		}
		
		if(incoming_port!=null){
			element = driver.findElement(By.id("incoming_port"));
			element.clear();
			element.sendKeys(incoming_port);
		}
		
		if(incoming_server_username!=null){
			element = driver.findElement(By.id("incoming_server_username"));
			element.clear();
			element.sendKeys(incoming_server_username);
		}
		
		if(incoming_server_username!=null){
			element = driver.findElement(By.id("incoming_server_username"));
			element.clear();
			element.sendKeys(incoming_server_username);
		}
		
		if(!incoming_identify_type.equals("")){
			Select oSingleSelection = new Select(driver.findElement(By.id("incoming_identify_type")));  
			oSingleSelection.selectByVisibleText(incoming_identify_type);
			if(incoming_server_password!=null){
				element = driver.findElement(By.id("incoming_server_password"));
				element.clear();
				element.sendKeys(incoming_server_password);
			}
		}
		
		if(incoming_use_ssl!=null){
			if(allow_move.equals("是")){
				if(!(driver.findElement(By.id("incoming_use_ssl")).isSelected())){
					driver.findElement(By.id("incoming_use_ssl")).click();
				}
			}
			if(incoming_use_ssl.equals("否")){
				if((driver.findElement(By.id("incoming_use_ssl")).isSelected())){
					driver.findElement(By.id("incoming_use_ssl")).click();
				}
			}
		}
		
		driver.findElement(By.id("send_mail")).click();
		if(outgoing_host_name!=null){
			element = driver.findElement(By.id("outgoing_host_name"));
			element.clear();
			element.sendKeys(outgoing_host_name);
		}
		
		if(outgoing_port!=null){
			element = driver.findElement(By.id("outgoing_port"));
			element.clear();
			element.sendKeys(outgoing_port);
		}
		
		if(outgoing_server_username!=null){
			element = driver.findElement(By.id("outgoing_server_username"));
			element.clear();
			element.sendKeys(outgoing_server_username);
		}
		
		if(outgoing_server_username!=null){
			element = driver.findElement(By.id("outgoing_server_username"));
			element.clear();
			element.sendKeys(outgoing_server_username);
		}
		
		if(!outgoing_identify_type.equals("")){
			Select oSingleSelection = new Select(driver.findElement(By.id("outgoing_identify_type")));  
			oSingleSelection.selectByVisibleText(outgoing_identify_type);
			if(outgoing_server_password!=null){
				element = driver.findElement(By.id("outgoing_server_password"));
				element.clear();
				element.sendKeys(outgoing_server_password);
			}
		}
		
		if(outgoing_use_ssl!=null){
			if(allow_move.equals("是")){
				if(!(driver.findElement(By.id("outgoing_use_ssl")).isSelected())){
					driver.findElement(By.id("outgoing_use_ssl")).click();
				}
			}
			if(incoming_use_ssl.equals("否")){
				if((driver.findElement(By.id("outgoing_use_ssl")).isSelected())){
					driver.findElement(By.id("outgoing_use_ssl")).click();
				}
			}
		}
		
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(1000);
	}
	
	 public void gotoConfigUpdate (String name,ActionType actionType) throws InterruptedException{
		driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td[2][text()='"+name+"']/parent::tr/td/a[text()='更新']")).click();              	
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")).getAttribute("id"));
		switch(actionType){
		case AndroidPWDConfigUpdate:
			MyAssert.assert_True("不能进入Android密码策略更新界面", driver.getPageSource().contains(WebInfos.Android密码策略更新标题));
			break;
		case AndroidRestrictConfigUpdate:
			MyAssert.assert_True("不能进入android限制策略更新界面",driver.getPageSource().contains(WebInfos.Android限制策略添加标题));
			break;
		case WIFIConfigUpdate:
			MyAssert.assert_True("不能进入WIFI配置更新界面",driver.getPageSource().contains(WebInfos.WIFI配置更新标题));
			break;
		case EmailConfigUpdate:
			MyAssert.assert_True("不能进入Email配置更新界面",driver.getPageSource().contains(WebInfos.Email配置更新标题));
			break;
		}
	 }

	public void selectWIFIPloy(List<String> configList) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td[2][text()='"+configList.get(1)+"']/parent::tr/td/input[@type='checkbox']")).click();              	
		Thread.sleep(1000);
		
	}
	 
	
}
