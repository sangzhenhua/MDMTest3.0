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
	
	@当("^添加Android密码策略：策略名称(.*?)策略描述(.*?)密码等级(.*?)$")
	public void 添加android密码策略_策略名称_策略描述_密码等级(String name, String desc, String level) throws Throwable {
		ployManager.gotoPloyList();
		driver.findElement(By.id("add_policy_android")).click();
		Thread.sleep(1000);
		ployManager.addAndroidPWDPloy(name, desc, level);
	}
	

	@当("^选择Android密码策略$")
	public void 选择android密码策略(DataTable table) throws Throwable {
		List<String> list = table.asList(String.class);
	    ployManager.gotoPloyList();
	    commonAction.search(list.get(1));  
	    Thread.sleep(1000);
	}

	@当("^Android密码策略下发到分组$")
	public void 下发到分组(DataTable table) throws Throwable {
		List<String> list = table.asList(String.class);
		commonAction.gotoAction("relate_group", null, null,null);
	    commonAction.relateGroup(list.get(1));
	}
	
	@而且("^Android密码策略下发到用户$")
	public void 下发到用户(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map map = list.get(0);
		driver.manage().window().maximize();
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//i[@data-original-title='<p>分发</p>']")).click();
	    Thread.sleep(1000);
	    driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")).getAttribute("id"));
		
	    appManager.distributeActionByUser((String)map.get("账号"));
	}
	
	@假如("^更新Android密码策略$")
	public void 更新android密码策略(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map<String,String> map = list.get(0);
		ployManager.gotoConfigUpdate(ployList.get(1), ActionType.AndroidPWDConfigUpdate);
		ployManager.updateAndroidPWDPloy(null, map.get("策略描述"), map.get("密码等级"), map.get("最小密码长度"), map.get("最小特殊字符个数"), map.get("最大期限天数"), map.get("最长宽限时间"), map.get("保存次数"), map.get("失败次数"));	
	}

	@当("^删除Android密码策略$")
	public void 删除android密码策略() throws Throwable {
		commonAction.gotoAction("delete_ploy", null, null,null);
		commonAction.deleteConfirm("confirm");
	}
	
	@当("^添加Android限制策略$")
	public void 添加android限制策略(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map<String,String> map = list.get(0);
		ployManager.gotoPloyList();
		commonAction.gotoAction("add_ploy", "add_android_restrict_ploy",null, null);
		ployManager.addAndroidRestrictPloy(map.get("策略名称"), map.get("策略描述"), map.get("相机策略"));
	}

	@当("^选择Android限制策略$")
	public void 选择android限制策略(DataTable table) throws Throwable {
		选择android密码策略(table);
	}

	@当("^Android限制策略下发到分组$")
	public void android限制策略下发到分组(DataTable table) throws Throwable {
		this.下发到分组(table);
	}

	@当("^Android限制策略下发到用户$")
	public void android限制策略下发到用户(DataTable table) throws Throwable {
		this.下发到用户(table);
	}

	@当("^删除Android限制策略$")
	public void 删除android限制策略() throws Throwable {
		commonAction.gotoAction("delete_ploy", null, null,null);
		commonAction.deleteConfirm("confirm");
	}

	@当("^添加WIFI配置$")
	public void 添加wifi配置(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map<String,String> map = list.get(0);
		//ployManager.gotoDeviceConfigList();
		commonAction.gotoAction("add_config", "add_wifi_config", null,null);
		ployManager.addWIFIConfig(map.get("配置名称"), map.get("配置描述"), map.get("SSID"), map.get("自动加入"), map.get("隐藏网络"), map.get("安全类型"), map.get("代理服务器URL"), map.get("密码"));
	}
	
	@当("^添加Email配置$")
	public void 添加email配置(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map<String,String> map = list.get(0);
		ployManager.gotoAppConfigList();
		commonAction.gotoAction("add_config", "add_email_config",null, null);
	    ployManager.addEmailConfig(map.get("配置名称"), map.get("配置描述"), map.get("账户描述"), map.get("账户类型"), map.get("路径前缀"), map.get("用户名称"), map.get("电子邮件"), map.get("允许移动"), map.get("发送服务器主机名称"), map.get("发送服务器端口号"), map.get("发送服务器用户名"), map.get("发送服务器鉴定类型"), map.get("发送服务器密码"), map.get("发送服务器使用ssl"),map.get("接收服务器主机名称"), map.get("接收服务器端口号"), map.get("接收服务器用户名"), map.get("接收服务器鉴定类型"), map.get("接收服务器密码"), map.get("接收服务器使用ssl"));
	   
	}

	@当("^选择WIFI策略$")
	public void 选择wifi策略(DataTable table) throws Throwable {
		configList = table.asList(String.class);
	   // ployManager.gotoDeviceConfigList();
	    boolean result =commonAction.search(configList.get(1), ActionType.ConfigSearch);
	    System.out.println(result);
	    if(result){
	    	ployManager.selectWIFIPloy(configList);
	    }
	}
	
	@当("^WIFI配置下发到分组$")
	public void wifi配置下发到分组(DataTable table) throws Throwable {
		List<String> list = table.asList(String.class);
	    commonAction.gotoAction("relate_group", null, null, null);
	    commonAction.relateGroup(list.get(1));
	}
	
	@当("^选择Email策略$")
	public void 选择email策略(DataTable table) throws Throwable {
		configList = table.asList(String.class);
	    ployManager.gotoAppConfigList();
	    boolean result =commonAction.search(configList.get(1), ActionType.ConfigSearch);
	    System.out.println(result);
	    if(result){
	    	commonAction.selectByTotalCheck("all_check");
	    }
	}

	@当("^Email配置下发到用户$")
	public void Email配置下发到用户(DataTable table) throws Throwable {
		List<String> list = table.asList(String.class);
		commonAction.gotoAction("relate_user", null, null,null);
	    commonAction.relateUser(list, ActionType.EmailConfigIssueUser);
	}

	@当("^更新WIFI配置$")
	public void 更新wifi配置(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map<String,String> map = list.get(0);
		ployManager.gotoConfigUpdate(configList.get(1), ActionType.WIFIConfigUpdate);;
		ployManager.addWIFIConfig(null, map.get("配置描述"), map.get("SSID"), map.get("自动加入"), map.get("隐藏网络"), map.get("安全类型"), map.get("代理服务器URL"), map.get("密码"));
	}

	@当("^更新Email配置$")
	public void 更新email配置(DataTable table) throws Throwable {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		Map<String,String> map = list.get(0);
		ployManager.gotoConfigUpdate(configList.get(1), ActionType.EmailConfigUpdate);;
		ployManager.addEmailConfig(null,map.get("配置描述"), map.get("账户描述"), map.get("账户类型"), map.get("路径前缀"), map.get("用户名称"), map.get("电子邮件"), map.get("允许移动"), map.get("发送服务器主机名称"), map.get("发送服务器端口号"), map.get("发送服务器用户名"), map.get("发送服务器鉴定类型"), map.get("发送服务器密码"), map.get("发送服务器使用ssl"),map.get("接收服务器主机名称"), map.get("接收服务器端口号"), map.get("接收服务器用户名"), map.get("接收服务器鉴定类型"), map.get("接收服务器密码"), map.get("接收服务器使用ssl"));
		   
	}

	@当("^删除WIFI配置$")
	public void 删除wifi配置() throws Throwable {
		commonAction.gotoAction("delete_config", null, null,null);
		commonAction.deleteConfirm("confirm");
	}

	@当("^删除Email配置$")
	public void 删除email配置() throws Throwable {
		commonAction.gotoAction("delete_config", null, null,null);
		commonAction.deleteConfirm("confirm");
	}

}
