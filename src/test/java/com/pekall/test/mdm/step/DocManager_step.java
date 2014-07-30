package com.pekall.test.mdm.step;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pekall.test.mdm.support.service.ActionType;
import com.pekall.test.mdm.support.service.AppManager;
import com.pekall.test.mdm.support.service.CommonAction;
import com.pekall.test.mdm.support.service.DocManager;
import com.pekall.test.mdm.support.service.MyDriver;
import com.pekall.test.mdm.support.service.Service;
import com.pekall.test.mdm.support.service.UserManager;
import com.pekall.test.mdm.support.util.WaitForElement;
import com.pekall.test.mdm.support.util.WebInfos;

import cucumber.api.DataTable;
import cucumber.api.java.zh_cn.当;

public class DocManager_step {
	DocManager docManager = DocManager.getInstance();
	CommonAction commonAction = CommonAction.getInstance();
	AppManager appManager = AppManager.getInstance();
	WebDriver driver = Service.getInstance(MyDriver.USE);
	WaitForElement wait = WaitForElement.getInstance();
	
	@当("^添加文档:文档名称(.*?)文档标签(.*?)文档路径(.*?)$")
	public void 添加文档_文档名称_文档标签_文档路径(String name, String tag, String path) throws Throwable {
		docManager.gotoDocList();
	    commonAction.gotoAction(null,".btn.btn-sm.btn-primary",null, null);
	    docManager.addDoc(name,tag, path);
	}
	
	@当("^选择文档$")
	public void 选择文档(DataTable table) throws Throwable {
		List<String> list = table.asList(String.class);
		docManager.gotoDocList();
	    commonAction.search(list.get(1));  
	    commonAction.selectByInfo(list.get(1));
	}

	@当("^文档下发到分组$")
	public void 文档下发到分组(DataTable table) throws Throwable {
		List<String> list = table.asList(String.class);
		commonAction.gotoAction("distribute_to_group",null, null,null);
		commonAction.relateGroup(list.get(1));
	}
	
	@当("^文档下发到设备分组$")
	public void 文档下发到设备分组(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction(By.xpath("//button[@name='doc-apply']"), null);
		appManager.distributeActionByDeviceGroup((String)map.get("设备分组名称"));
	}
	
	@当("^文档下发到用户$")
	public void 文档下发到用户(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction(By.xpath("//button[@name='doc-apply']"), null);
		appManager.distributeActionByUser((String)map.get("账号"));
	}
	
	@当("^取消分发文档$")
	public void 取消分发文档(DataTable table) throws Throwable {
	  new AppManager_step().取消分发应用(table);
	}

	@当("^删除文档$")
	public void 删除文档() throws Throwable {
		wait.waitAndClick(By.xpath("//button[@name='doc-delete']"));
		driver.switchTo().defaultContent();
		wait.waitAndClick(By.id("cOk"));
		wait.waitAndClick(By.id("cOk"));
	}

	@当("^删除所有自动化测试文档$")
	public void 删除所有自动化测试文档() throws Throwable {
		docManager.gotoDocList();
		commonAction.search("自动化测试");  
		wait.waitAndClick(By.xpath("//span[@class='lbl']"));
		wait.waitAndClick(By.xpath("//button[@data-id='remove_doc']"));
		wait.waitAndSwitchToFrame(By.xpath("/html/body/iframe"));
		wait.waitAndClick(By.id("confirm"));
		driver.switchTo().defaultContent();
		if(wait.wait(WebInfos.doc删除时取消分发提示, 3000)){
			wait.waitAndClick(By.id("cOk"));
		}
	}

}
