package com.pekall.test.mdm.step;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pekall.test.mdm.support.service.ActionType;
import com.pekall.test.mdm.support.service.CommonAction;
import com.pekall.test.mdm.support.service.MyDriver;
import com.pekall.test.mdm.support.service.Service;
import com.pekall.test.mdm.support.service.UserManager;
import com.pekall.test.mdm.support.util.MyAssert;
import com.pekall.test.mdm.support.util.WebInfos;

import cucumber.api.DataTable;
import cucumber.api.java.zh_cn.当;


public class UserManager_step {
	UserManager userManager = UserManager.getInstance();
	CommonAction commonAction = CommonAction.getInstance();
	WebDriver driver = Service.getInstance(MyDriver.USE);
	
	@当("^添加单个用户:账户名(.*?)姓名(.*?)电话(.*?)$")
	public void 添加单个用户_账户名_姓名_电话(String account, String name, String phone) throws Throwable {
		userManager.gotoUserList();
		commonAction.gotoAction(null,".btn.btn-sm.btn-primary.dropdown-toggle", "add_user",null);
		userManager.addSimple(account, name,phone);
	}
	
	@当("^导入文件(.*?)批量添加用户$")
	public void 导入文件_批量添加用户(String file) throws Throwable {
		//userManager.gotoAddBatch();
		userManager.gotoUserList();
		commonAction.gotoAction(null,".btn.btn-sm.btn-primary.dropdown-toggle", "add_batch_users",null);
		userManager.addBatch(file);
	}

	@当("^选择用户$")
	public void 选择用户(DataTable table) throws Throwable {
		List<String> list = table.asList(String.class);
		userManager.gotoUserList();
	    commonAction.search(list.get(1));  
	    commonAction.selectByInfo(list.get(1));
	    Thread.sleep(1000);
	}
	
	@当("^注册设备$")
	public void 注册设备() throws Throwable {
		commonAction.gotoAction("register", null, null, null);
		userManager.registDevice();
	}

	@当("^给用户更改策略$")
	public void 给用户更改策略(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("more_button", null, "change_policy", null);
		userManager.changePloy((String)map.get("策略名称"));
	}

	
	@当("^给用户发送消息$")
	public void 给用户发送消息(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("send_message", null, null, null);
		userManager.sendMsg((String)map.get("主题"),(String) map.get("消息"));
	}
	
	@当("^去激活用户$")
	public void 去激活用户() throws Throwable {
		driver.findElement(By.id("active")).click();
		Thread.sleep(3000);
		MyAssert.assert_True("不能进入去激活界面",driver.getPageSource().contains(WebInfos.user去激活提示语));
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(3000);
	}

	@当("^给用户分发应用$")
	public void 给用户分发应用(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("more_button", null, "distribute_app", null);
		userManager.distributeAction((String)map.get("应用名称"));
	}

	@当("^给用户分发文档$")
	public void 给用户分发文档(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("more_button", null, "distribute_doc", null);
		userManager.distributeAction((String)map.get("文档名称"));
	}

	@当("^给用户分发通讯录$")
	public void 给用户分发通讯录(DataTable table ) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("more_button", null, "distribute_contacts", null);
		userManager.distributeAction((String)map.get("通讯录名称"));
	}
	
	@当("^取消给用户分发的应用$")
	public void 取消给用户分发的应用(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		driver.findElement(By.xpath("//a[text()='应用分发记录']")).click();
		Thread.sleep(1000);
		String name = (String)map.get("应用名称");
		driver.findElement(By.xpath("//td/a[text()='"+name+"']/parent::td/parent::tr/td/i[@data-tooltip-type='error']")).click();
		Thread.sleep(10000);
	}

	@当("^取消给用户分发的文档$")
	public void 取消给用户分发的文档(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		driver.findElement(By.xpath("//a[text()='文档分发记录']")).click();
		Thread.sleep(1000);
		String name = (String)map.get("文档名称");
		driver.findElement(By.xpath("//td/a[text()='"+name+"']/parent::td/parent::tr/td/i[@data-tooltip-type='error']")).click();
		Thread.sleep(10000);
	}

	@当("^取消给用户分发的通讯录$")
	public void 取消给用户分发的通讯录(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		driver.findElement(By.xpath("//a[text()='通讯录分发记录']")).click();
		Thread.sleep(1000);
		String name = (String)map.get("通讯录名称");
		driver.findElement(By.xpath("//td/a[text()='"+name+"']/parent::td/parent::tr/td/i[@data-tooltip-type='error']")).click();
		Thread.sleep(10000);
	}

	@当("^添加分组$")
	public void 添加分组(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map<String,String> map = list.get(0);
		userManager.gotoUserGroupList();
	    commonAction.gotoAction("add_group",null,null, null);
	    userManager.addGroup(map.get("分组名称"),map.get("分组成员"), map.get("描述"));
	}

	@当("^选择用户分组$")
	public void 选择用户分组(DataTable table) throws Throwable {
		List<String> list = table.asList(String.class);
		userManager.gotoUserGroupList();;
	    boolean result =commonAction.search(list.get(1), ActionType.UserSearch);
	    System.out.println(result);
	    if(result){
	    	commonAction.selectByInfo(list.get(1));
	    }
	    Thread.sleep(1000);
	}

	@当("^给用户分组更改策略$")
	public void 给用户更分组改策略(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("more_button", null, "change_policy", null);
		userManager.changePloy((String)map.get("策略名称"));
	}
	
	@当("^给用户分组发送消息$")
	public void 给用户分组发送消息(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
	
		commonAction.gotoAction(By.id("send_message"), null);
		userManager.sendMsg((String)map.get("主题"),(String) map.get("消息"));
	}

	
	@当("^给用户分组注册设备$")
	public void 给用户分组注册设备() throws Throwable {
		commonAction.gotoAction("add_device", null, null, null);
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(3000);
		
	}


	@当("^搜索用户分组$")
	public void 搜索用户分组(DataTable table) throws Throwable {
		List<String> list = table.asList(String.class);
		userManager.gotoUserGroupList();
	    boolean result =commonAction.search(list.get(1), ActionType.UserSearch);
	    driver.manage().window().maximize();
	    Thread.sleep(1000);
	   
	}

	@当("^给用户分组分发应用$")
	public void 给用户分组分发应用(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("more_button", null, "distribute_app", null);
		userManager.distributeAction((String)map.get("应用名称"));
	}

	@当("^给用户分组分发文档$")
	public void 给用户分组分发文档(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("more_button", null, "distribute_doc", null);
		userManager.distributeAction((String)map.get("文档名称"));
	}

	@当("^给用户分组分发通讯录$")
	public void 给用户分组分发通讯录(DataTable table ) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("more_button", null, "distribute_contacts", null);
		userManager.distributeAction((String)map.get("通讯录名称"));
	}
	
	@当("^取消给用户分组分发的应用$")
	public void 取消给用户分组分发的应用(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		driver.findElement(By.xpath("//a[text()='应用分发记录']")).click();
		Thread.sleep(1000);
		String name = (String)map.get("应用名称");
		driver.findElement(By.xpath("//td/a[text()='"+name+"']/parent::td/parent::tr/td/i[@data-tooltip-type='error']")).click();
		Thread.sleep(10000);
	}

	@当("^取消给用户分组分发的文档$")
	public void 取消给用户分组分发的文档(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		driver.findElement(By.xpath("//a[text()='文档分发记录']")).click();
		Thread.sleep(1000);
		String name = (String)map.get("文档名称");
		driver.findElement(By.xpath("//td/a[text()='"+name+"']/parent::td/parent::tr/td/i[@data-tooltip-type='error']")).click();
		Thread.sleep(10000);
	}

	@当("^取消给用户分组分发的通讯录$")
	public void 取消给用户分组分发的通讯录(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		driver.findElement(By.xpath("//a[text()='通讯录分发记录']")).click();
		Thread.sleep(1000);
		String name = (String)map.get("通讯录名称");
		driver.findElement(By.xpath("//td/a[text()='"+name+"']/parent::td/parent::tr/td/i[@data-tooltip-type='error']")).click();
		Thread.sleep(10000);
	}


	@当("^删除用户$")
	public void 删除用户() throws Throwable {
		commonAction.gotoAction("delete_user", null, null,null);
		commonAction.deleteConfirm("user_deleteuser_ok");
	}
	
	
}
