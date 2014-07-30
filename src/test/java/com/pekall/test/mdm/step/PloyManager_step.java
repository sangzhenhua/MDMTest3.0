package com.pekall.test.mdm.step;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pekall.test.mdm.support.service.AppManager;
import com.pekall.test.mdm.support.service.CommonAction;
import com.pekall.test.mdm.support.service.MyDriver;
import com.pekall.test.mdm.support.service.PloyManager;
import com.pekall.test.mdm.support.service.ActionType;
import com.pekall.test.mdm.support.service.Service;
import com.pekall.test.mdm.support.util.WaitForElement;

import cucumber.api.DataTable;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.而且;


public class PloyManager_step {
	List<String> ployList =null;
	List<String> configList = null;
	PloyManager ployManager = PloyManager.getInstance();
	CommonAction commonAction = CommonAction.getInstance();
	WebDriver driver = Service.getInstance(MyDriver.USE);
	AppManager appManager = AppManager.getInstance();
	WaitForElement wait = WaitForElement.getInstance();
	
	@当("^添加Android密码策略：策略名称(.*?)策略描述(.*?)密码等级(.*?)$")
	public void 添加android密码策略_策略名称_策略描述_密码等级(String name, String desc, String level) throws Throwable {
		ployManager.gotoPloyList();
		wait.waitAndClick(By.id("add_policy_android"));
		ployManager.addAndroidPWDPloy(name, desc, level);
	}
	
	@当("^添加Android邮箱策略：策略名称(.*?)策略描述(.*?)配置类型(.*?)接收邮件服务器主机名(.*?)接收邮件服务器端口(.*?)发送邮件服务器主机名(.*?)发送邮件服务器端口(.*?)$")
	public void 添加android邮箱策略_策略名称_策略描述_配置类型_接收邮件服务器主机名_接收邮件服务器端口_发送邮件服务器主机名_发送邮件服务器端口(String name, String desc, String type,String receiveServer,String receivePort,String sendServer,String sendPort) throws Throwable {
		ployManager.gotoPloyList();
		wait.waitAndClick(By.id("add_policy_android"));
		ployManager.addAndroidEmailPloy(name, desc, type,receiveServer,receivePort,sendServer,sendPort);
	}

	@当("^选择Android密码策略$")
	public void 选择android密码策略(DataTable table) throws Throwable {
		List<String> list = table.asList(String.class);
	    ployManager.gotoPloyList();
	    commonAction.search(list.get(1));  
	}

	@而且("^Android密码策略下发到用户$")
	public void 下发到用户(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
	    wait.waitAndClick(By.xpath("//i[@data-original-title='<p>分发</p>']"));
	    wait.waitAndSwitchToFrame(By.xpath("/html/body/iframe"));
	    appManager.distributeActionByUser((String)map.get("账号"));
	}
	
	
	
	
}
