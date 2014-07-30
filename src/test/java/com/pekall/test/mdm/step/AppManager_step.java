package com.pekall.test.mdm.step;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pekall.test.mdm.support.service.AppManager;
import com.pekall.test.mdm.support.service.CommonAction;
import com.pekall.test.mdm.support.service.DocManager;
import com.pekall.test.mdm.support.service.MyDriver;
import com.pekall.test.mdm.support.service.Service;
import com.pekall.test.mdm.support.util.WaitForElement;
import com.pekall.test.mdm.support.util.WebInfos;

import cucumber.api.DataTable;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;

public class AppManager_step {
	AppManager appManager = AppManager.getInstance();
	CommonAction commonAction = CommonAction.getInstance();
	WebDriver driver = Service.getInstance(MyDriver.USE);
	WaitForElement wait = WaitForElement.getInstance();
	@当("^添加应用$")
	public void 添加应用(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map<String,String> map = list.get(0);
		appManager.gotoAppList();
		commonAction.gotoAction(By.id("add_apps"), By.xpath("//a[text()='企业Android应用']"));
	    appManager.addApp(map.get("应用apk路径"),map.get("应用截图路径"), map.get("应用类别"),map.get("应用描述"));
	}
	

	@当("^添加应用:应用路径(.*?)应用截图路径(.*?)应用类别(.*?)应用描述(.*?)$")
	public void 添加应用_应用路径_应用截图路径_应用类别_应用描述(String apkPath, String picPath, String type, String desc) throws Throwable {
		appManager.gotoAppList();
		commonAction.gotoAction(By.id("add_apps"), By.xpath("//a[text()='企业Android应用']"));
	    appManager.addApp(apkPath,picPath, type,desc);
	}
	
	@当("^添加百度应用:应用名称(.*?)安全策略(.*?)分发类别(.*?)分发到(.*?)$")
	public void 添加百度应用_应用名称_安全策略_分发类别_分发到(String name,String ploy,String distributeType,String distributeTo) throws Throwable {
	   appManager.gotoAppList();
	   commonAction.gotoAction(By.id("add_apps"), By.xpath("//a[text()='百度Android应用']"));
	   appManager.addBaiduApp(name,ploy, distributeType,distributeTo);
	}

	
	@当("^选择应用$")
	public void 选择应用(DataTable table) throws Throwable {
		List<String> list = table.asList(String.class);
		appManager.gotoAppList();
	    commonAction.search(list.get(1));  
	    commonAction.selectByInfo(list.get(1));
	}

	@当("^应用下发到用户$")
	public void 应用下发到用户(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction(By.xpath("//button[@name='app-apply']"), null);
		appManager.distributeActionByUser((String)map.get("账号"));
	}

	@当("^应用下发到设备$")
	public void 应用下发到设备(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction(By.xpath("//button[@name='app-apply']"), null);
		appManager.distributeActionByDevice((String)map.get("设备名称"));
	}

	
	@当("^取消分发应用$")
	public void 取消分发应用(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		wait.waitAndClick(By.xpath("//a[text()='分发记录']"));
		String name = (String)map.get("用户名称");
		wait.waitAndClick(By.xpath("//td[text()='"+name+"']/parent::tr/td/div/a/i[@data-tooltip-type='error']"));
	}
	

	@当("^删除应用$")
	public void 删除应用() throws Throwable {
		wait.waitAndClick(By.xpath("//button[@name='app-delete']"));
		driver.switchTo().defaultContent();
		wait.waitAndClick(By.id("cOk"));
		wait.waitAndClick(By.id("cOk"));
	}
	
	@当("^删除所有自动化测试应用$")
	public void 删除所有自动化测试应用() throws Throwable {
		appManager.gotoAppList();;
		
		wait.waitAndClick(By.xpath("//a[text()='2048']/parent::label/parent::td/parent::tr/td/label/span[@class='lbl']"));
		WebElement e = driver.findElement(By.xpath("//a[text()='万年历']/parent::label/parent::td/parent::tr/td/label/span[@class='lbl']"));
	
		driver.findElement(By.xpath("//a[text()='万年历']/parent::label/parent::td/parent::tr/td/label/span[@class='lbl']")).click();
		driver.findElement(By.xpath("//a[text()='新華字典']/parent::label/parent::td/parent::tr/td/label/span[@class='lbl']")).click();
		driver.findElement(By.xpath("//a[text()='墨迹天气']/parent::label/parent::td/parent::tr/td/label/span[@class='lbl']")).click();
		driver.findElement(By.xpath("//a[text()='note']/parent::label/parent::td/parent::tr/td/label/span[@class='lbl']")).click();
	
		wait.waitAndClick(By.xpath("//button[@data-id='remove_app']"));
		wait.waitAndSwitchToFrame(By.xpath("/html/body/iframe"));
		wait.waitAndClick(By.id("confirm"));
		driver.switchTo().defaultContent();
		if(wait.wait(WebInfos.doc删除时取消分发提示, 3000)){
			wait.waitAndClick(By.id("cOk"));
		}
	}

}
