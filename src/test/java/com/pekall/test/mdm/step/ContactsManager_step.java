package com.pekall.test.mdm.step;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pekall.test.mdm.support.service.ActionType;
import com.pekall.test.mdm.support.service.AppManager;
import com.pekall.test.mdm.support.service.CommonAction;
import com.pekall.test.mdm.support.service.ContactsManager;
import com.pekall.test.mdm.support.service.MyDriver;
import com.pekall.test.mdm.support.service.Service;
import com.pekall.test.mdm.support.util.WaitForElement;
import com.pekall.test.mdm.support.util.WebInfos;

import cucumber.api.DataTable;
import cucumber.api.java.zh_cn.当;

public class ContactsManager_step {
	List<String> list =null;
	ContactsManager contactsManager = ContactsManager.getInstance();
	CommonAction commonAction = CommonAction.getInstance();
	AppManager appManager = AppManager.getInstance();
	WebDriver driver = Service.getInstance(MyDriver.USE);
	WaitForElement wait = WaitForElement.getInstance();
	@当("^添加企业通讯录$")
	public void 添加企业通讯录(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map<String,String> map = list.get(0);
		contactsManager.gotoContactsList();
		commonAction.gotoAction(By.xpath("//button[@data-id='add']"), null);
	    contactsManager.addContacts(map.get("通讯录名称"),map.get("通讯录路径"));
	}
	
	@当("^添加企业通讯录:通讯录名称(.*?)通讯录路径(.*?)$")
	public void 添加企业通讯录_通讯录名称_通讯录路径(String name,String path) throws Throwable {
		contactsManager.gotoContactsList();
		commonAction.gotoAction(By.xpath("//button[@data-id='add']"), null);
	    contactsManager.addContacts(name,path);
	}
	
	@当("^选择通讯录$")
	public void 选择通讯录(DataTable table) throws Throwable {
		List<String> list = table.asList(String.class);
		contactsManager.gotoContactsList();
	    commonAction.search(list.get(1));  
	    commonAction.selectByInfo(list.get(1));
	}

	@当("^通讯录下发到分组$")
	public void 通讯录下发到分组(DataTable table) throws Throwable {
		List<String> list = table.asList(String.class);
		commonAction.gotoAction("rel2group",null,null, null);
		commonAction.relateGroup(list.get(1));
	}

	@当("^通讯录下发到用户分组$")
	public void 通讯录下发到用户分组(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction(By.xpath("//button[@name='contacts-apply']"), null);
		appManager.distributeActionByUserGroup((String)map.get("用户分组名称"));
	}
	
	@当("^通讯录下发到设备$")
	public void 通讯录下发到设备(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction(By.xpath("//button[@name='contacts-apply']"), null);
		appManager.distributeActionByDevice((String)map.get("设备名称"));
	}

	@当("^取消分发通讯录$")
	public void 取消分发通讯录(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		wait.waitAndClick(By.xpath("//a[text()='分发记录']"));
		String name = (String)map.get("用户分组名称");
		wait.waitAndClick(By.xpath("//td[text()='"+name+"']/parent::tr/td/div/a/i[@data-tooltip-type='error']"));
	}

	
	@当("^更新通讯录$")
	public void 更新通讯录(DataTable table) throws Throwable {
		List<Map<String, String>> listContacts = table.asMaps(String.class, String.class);
		Map<String,String> map = listContacts.get(0);
		commonAction.gotoAction(By.xpath("//button[@name='contacts-update']"), null);
		contactsManager.addContacts(null, map.get("通讯录路径"));
	}

	@当("^删除通讯录$")
	public void 删除通讯录() throws Throwable {
		wait.waitAndClick(By.xpath("//button[@name='contacts-delete']"));
		driver.switchTo().defaultContent();
		wait.waitAndClick(By.id("cOk"));
	}


	@当("^删除所有自动化测试通讯录$")
	public void 删除所有自动化测试通讯录() throws Throwable {
		contactsManager.gotoContactsList();
		commonAction.search("自动化测试");  
		wait.waitAndClick(By.xpath("//span[@class='lbl']"));
		wait.waitAndClick(By.xpath("//button[@data-id='remove']"));
		wait.waitAndSwitchToFrame(By.xpath("/html/body/iframe"));
		wait.waitAndClick(By.id("confirm"));
		driver.switchTo().defaultContent();
		if(wait.wait(WebInfos.doc删除时取消分发提示, 3000)){
			wait.waitAndClick(By.id("cOk"));
		}
	}

}
