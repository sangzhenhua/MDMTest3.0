package com.pekall.test.mdm.step;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pekall.test.mdm.support.service.ActionType;
import com.pekall.test.mdm.support.service.CommonAction;
import com.pekall.test.mdm.support.service.ContactsManager;
import com.pekall.test.mdm.support.service.DeviceManager;
import com.pekall.test.mdm.support.service.MyDriver;
import com.pekall.test.mdm.support.service.Service;
import com.pekall.test.mdm.support.service.UserManager;

import cucumber.api.DataTable;
import cucumber.api.java.zh_cn.当;


public class DeviceManager_step {
	
	DeviceManager deviceManager = DeviceManager.getInstance();
	CommonAction commonAction = CommonAction.getInstance();
	WebDriver driver = Service.getInstance(MyDriver.USE);
	UserManager userManager = UserManager.getInstance();
	
	@当("^添加设备$")
	public void 添加设备(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map<String,String> map = list.get(0);
		deviceManager.gotoDeviceList();
	    commonAction.gotoAction("add_device",null,null, null);
	    deviceManager.addDevice(map.get("账号"));
	}
	
	@当("^选择设备$")
	public void 选择设备(DataTable  table) throws Throwable {
		System.out.println("when select device");
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map<String,String> map = list.get(0);
	    deviceManager.gotoDeviceList();
	    commonAction.search((String)map.get("账号"));
	    commonAction.selectByInfo((String)map.get("设备名称"));;
	   
	}
	
	@当("^定位设备$")
	public void 定位设备() throws Throwable {
		commonAction.gotoAction("location", null,null, null);
	}
	
	@当("^锁屏$")
	public void 锁屏() throws Throwable {
		driver.findElement(By.id("more_button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("lock_screen")).click();
		Thread.sleep(3000);
		
	}


	@当("^锁定设备$")
	public void 锁定设备(DataTable  table) throws Throwable {
	  List<String> list = table.asList(String.class);
	  commonAction.gotoAction("more_button", null, "lock_device", null);
	  deviceManager.lock(list.get(1));
	}

	@当("^解锁设备$")
	public void 解锁设备() throws Throwable {
		driver.findElement(By.id("more_button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("unlock_device")).click();
		Thread.sleep(3000);
	}
	
	@当("^给设备发送消息$")
	public void 给设备发送消息(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("more_button", null, "send_message", null);
		userManager.sendMsg((String)map.get("主题"),(String) map.get("消息"));
	}

	@当("^给设备分发应用$")
	public void 给设备分发应用(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("more_button", null, "distribute_app", null);
		userManager.distributeAction((String)map.get("应用名称"));
	}

	@当("^给设备分发文档$")
	public void 给设备分发文档(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("more_button", null, "distribute_doc", null);
		userManager.distributeAction((String)map.get("文档名称"));
	}
	
	@当("^给设备分发通讯录$")
	public void 给设备分发通讯录(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("more_button", null, "distribute_contacts", null);
		userManager.distributeAction((String)map.get("通讯录名称"));
	}

	@当("^取消给设备分发的应用$")
	public void 取消给设备分发的应用(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		driver.findElement(By.xpath("//a[text()='应用分发记录']")).click();
		Thread.sleep(1000);
		String name = (String)map.get("应用名称");
		driver.findElement(By.xpath("//td/a[text()='"+name+"']/parent::td/parent::tr/td/i[@data-tooltip-type='error']")).click();
		Thread.sleep(6000);
	}
	
	@当("^取消给设备分发的文档$")
	public void 取消给设备分发的文档(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		driver.findElement(By.xpath("//a[text()='文档分发记录']")).click();
		Thread.sleep(1000);
		String name = (String)map.get("文档名称");
		driver.findElement(By.xpath("//td/a[text()='"+name+"']/parent::td/parent::tr/td/i[@data-tooltip-type='error']")).click();
		Thread.sleep(8000);
	}
	
	@当("^取消给设备分发的通讯录$")
	public void 取消给设备分发的通讯录(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		driver.findElement(By.xpath("//a[text()='通讯录分发记录']")).click();
		Thread.sleep(1000);
		String name = (String)map.get("通讯录名称");
		driver.findElement(By.xpath("//td/a[text()='"+name+"']/parent::td/parent::tr/td/i[@data-tooltip-type='error']")).click();
		Thread.sleep(8000);
	}

	
	@当("^部分擦除设备$")
	public void 部分擦除设备() throws Throwable {
		commonAction.gotoAction("more", null, null,"device_part_clear");
		deviceManager.partClear();
	}
	
	@当("^添加设备分组$")
	public void 添加设备分组(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map<String,String> map = list.get(0);
		deviceManager.gotoDeviceGroupList();
		driver.findElement(By.id("add_group")).click();
		Thread.sleep(1000);
	    deviceManager.addDeviceGroup((String)map.get("设备类型"),(String)map.get("系统"),(String)map.get("品牌"),(String)map.get("设备分组名称"),(String)map.get("设备分组描述"));
	}
	
	@当("^选择设备分组$")
	public void 选择设备分组(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map<String,String> map = list.get(0);
	    deviceManager.gotoDeviceGroupList();
	    commonAction.selectByInfo((String)map.get("设备分组名称"));;
	}

	@当("^给设备分组发送消息$")
	public void 给设备分组发送消息(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("send_message",  null,null,null);
		userManager.sendMsg((String)map.get("主题"),(String) map.get("消息"));
	}
	
	@当("^给设备分组分发应用$")
	public void 给设备分组分发应用(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("distribute_app", null, null, null);
		userManager.distributeAction((String)map.get("应用名称"));
	}
	
	@当("^给设备分组分发文档$")
	public void 给设备分组分发文档(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("distribute_doc", null, null, null);
		userManager.distributeAction((String)map.get("文档名称"));
	}
	
	@当("^给设备分组分发通讯录$")
	public void 给设备分组分发通讯录(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("distribute_contacts", null, null, null);
		userManager.distributeAction((String)map.get("通讯录名称"));
	}

	@当("^取消给设备分组分发的应用$")
	public void 取消给设备分组分发的应用(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		driver.findElement(By.xpath("//a[text()='应用分发记录']")).click();
		Thread.sleep(1000);
		String name = (String)map.get("应用名称");
		driver.findElement(By.xpath("//td/a[text()='"+name+"']/parent::td/parent::tr/td/i[@data-tooltip-type='error']")).click();
		Thread.sleep(6000);
	}

	@当("^取消给设备分组分发的文档$")
	public void 取消给设备分组分发的文档(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		driver.findElement(By.xpath("//a[text()='文档分发记录']")).click();
		Thread.sleep(1000);
		String name = (String)map.get("文档名称");
		driver.findElement(By.xpath("//td/a[text()='"+name+"']/parent::td/parent::tr/td/i[@data-tooltip-type='error']")).click();
		Thread.sleep(10000);
	}
	
	@当("^取消给设备分组分发的通讯录$")
	public void 取消给设备分组分发的通讯录(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		driver.findElement(By.xpath("//a[text()='通讯录分发记录']")).click();
		Thread.sleep(1000);
		String name = (String)map.get("通讯录名称");
		driver.findElement(By.xpath("//td/a[text()='"+name+"']/parent::td/parent::tr/td/i[@data-tooltip-type='error']")).click();
		Thread.sleep(10000);
	}

	@当("^给设备更改策略$")
	public void 给设备更改策略(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("change_policy", null, null, null);
		userManager.changePloy((String)map.get("策略名称"));
	}
	
	@当("^给设备分组更改策略$")
	public void 给设备分组更改策略(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		commonAction.gotoAction("change_policy", null, null, null);
		userManager.changePloy((String)map.get("策略名称"));
	}

}
