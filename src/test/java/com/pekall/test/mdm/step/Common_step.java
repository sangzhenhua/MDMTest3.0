package com.pekall.test.mdm.step;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pekall.test.mdm.support.service.ActionType;
import com.pekall.test.mdm.support.service.CommonAction;
import com.pekall.test.mdm.support.service.Login;
import com.pekall.test.mdm.support.service.MyDriver;
import com.pekall.test.mdm.support.service.Service;
import com.pekall.test.mdm.support.util.CmdExcute;
import com.pekall.test.mdm.support.util.MyAssert;
import com.pekall.test.mdm.support.util.UiTestInfos;
import com.pekall.test.mdm.support.util.WebInfos;

import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.那么;

public class Common_step {
	private WebDriver driver = Service.getInstance(MyDriver.USE);
	
	@假如("^登陆MDM服务器$")
	public void 登陆mdm服务器() throws Throwable {
		Login login = Login.getInstance();
		login.login();
	}

	@那么("^(.*?)成功$")
	public void _成功(String actionStr) throws Throwable {
		ActionType type =null;
		//Thread.sleep(3000);
		if(actionStr.contains("客户端用户消息接收")){
			CmdExcute.run(1000,UiTestInfos.Msg模块,UiTestInfos.Msg模块_检查用户消息接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Msg模块_检查用户消息接收方法));
			return;
		}
		if(actionStr.contains("客户端用户分组消息接收")){
			CmdExcute.run(1000,UiTestInfos.Msg模块,UiTestInfos.Msg模块_检查用户分组消息接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Msg模块_检查用户分组消息接收方法));
			return;
		}
		if(actionStr.contains("客户端设备消息接收")){
			CmdExcute.run(1000,UiTestInfos.Msg模块,UiTestInfos.Msg模块_检查设备消息接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Msg模块_检查设备消息接收方法));
			return;
		}
		if(actionStr.contains("客户端设备分组消息接收")){
			CmdExcute.run(1000,UiTestInfos.Msg模块,UiTestInfos.Msg模块_检查设备分组消息接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Msg模块_检查设备分组消息接收方法));
			return;
		}
		if(actionStr.contains("客户端用户应用接收")){
			CmdExcute.run(1000,UiTestInfos.App模块,UiTestInfos.App模块_检查用户应用接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查用户应用接收方法));
			return;
		}
		
		if(actionStr.contains("客户端用户应用应用列表界面下载暂停安装")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查用户应用下载安装方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查用户应用下载安装方法));
			return;
		}
		if(actionStr.contains("客户端用户分组应用接收")){
			CmdExcute.run(1000,UiTestInfos.App模块,UiTestInfos.App模块_检查用户分组应用接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查用户分组应用接收方法));
			return;
		}
		if(actionStr.contains("客户端用户分组应用应用详情界面下载安装")){
			CmdExcute.run(1000,UiTestInfos.App模块,UiTestInfos.App模块_检查用户分组应用下载安装方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查用户分组应用下载安装方法));
			return;
		}
		if(actionStr.contains("客户端用户分组应用更新")){
			CmdExcute.run(1000,UiTestInfos.App模块,UiTestInfos.App模块_检查用户分组应用更新方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查用户分组应用更新方法));
			return;
		}
		
		if(actionStr.contains("客户端设备应用接收")){
			CmdExcute.run(1000,UiTestInfos.App模块,UiTestInfos.App模块_检查设备应用接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查设备应用接收方法));
			return;
		}
		
		if(actionStr.contains("客户端设备应用应用列表界面下载暂停安装")){
			CmdExcute.run(1000,UiTestInfos.App模块,UiTestInfos.App模块_检查设备应用下载安装方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查设备应用下载安装方法));
			return;
		}
		
		if(actionStr.contains("客户端设备分组应用接收")){
			CmdExcute.run(1000,UiTestInfos.App模块,UiTestInfos.App模块_检查设备分组应用接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查设备分组应用接收方法));
			return;
		}if(actionStr.contains("客户端应用1接收")){
			CmdExcute.run(1000,UiTestInfos.App模块,UiTestInfos.App模块_检查应用1接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查应用1接收方法));
			return;
		}
		if(actionStr.contains("客户端应用2接收")){
			CmdExcute.run(1000,UiTestInfos.App模块,UiTestInfos.App模块_检查应用2接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查应用2接收方法));
			return;
		}
		if(actionStr.contains("客户端用户应用取消并卸载")){
			CmdExcute.run(1000,UiTestInfos.App模块,UiTestInfos.App模块_检查用户应用取消并卸载方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查用户应用取消并卸载方法));
			return;
		}
		if(actionStr.contains("客户端用户分组应用取消并卸载")){
			CmdExcute.run(1000,UiTestInfos.App模块,UiTestInfos.App模块_检查用户分组应用取消并卸载方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查用户分组应用取消并卸载方法));
			return;
		}
		if(actionStr.contains("客户端设备应用取消并卸载")){
			CmdExcute.run(1000,UiTestInfos.App模块,UiTestInfos.App模块_检查设备应用取消并卸载方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查设备应用取消并卸载方法));
			return;
		}
		if(actionStr.contains("客户端设备分组应用取消")){
			CmdExcute.run(1000,UiTestInfos.App模块,UiTestInfos.App模块_检查设备分组应用取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查设备分组应用取消方法));
			return;
		}
		if(actionStr.contains("客户端应用1取消")){
			CmdExcute.run(1000,UiTestInfos.App模块,UiTestInfos.App模块_检查应用1取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查应用1取消方法));
			return;
		}
		if(actionStr.contains("客户端应用2删除")){
			CmdExcute.run(1000,UiTestInfos.App模块,UiTestInfos.App模块_检查应用2删除方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查应用2删除方法));
			return;
		}
		if(actionStr.contains("客户端用户文档接收")){
			CmdExcute.run(1000,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查用户文档接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查用户文档接收方法));
			return;
		}
		if(actionStr.contains("客户端用户分组文档接收")){
			CmdExcute.run(1000,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查用户分组文档接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查用户分组文档接收方法));
			return;
		}
		if(actionStr.contains("客户端设备文档接收")){
			CmdExcute.run(1000,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查设备文档接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查设备文档接收方法));
			return;
		}
		if(actionStr.contains("客户端设备分组文档接收")){
			CmdExcute.run(1000,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查设备分组文档接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查设备分组文档接收方法));
			return;
		}
		if(actionStr.contains("客户端文档1接收")){
			CmdExcute.run(1000,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查文档1接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查文档1接收方法));
			return;
		}
		if(actionStr.contains("客户端文档2接收")){
			CmdExcute.run(1000,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查文档2接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查文档2接收方法));
			return;
		}
		if(actionStr.contains("客户端用户文档取消")){
			CmdExcute.run(1000,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查用户文档取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查用户文档取消方法));
			return;
		}
		if(actionStr.contains("客户端用户分组文档取消")){
			CmdExcute.run(1000,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查用户分组文档取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查用户分组文档取消方法));
			return;
		}
		if(actionStr.contains("客户端设备文档取消")){
			CmdExcute.run(1000,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查设备文档取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查设备文档取消方法));
			return;
		}
		if(actionStr.contains("客户端设备分组文档取消")){
			CmdExcute.run(1000,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查设备分组文档取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查设备分组文档取消方法));
			return;
		}
		if(actionStr.contains("客户端文档1取消")){
			CmdExcute.run(1000,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查文档1取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查文档1取消方法));
			return;
		}
		if(actionStr.contains("客户端文档2删除")){
			CmdExcute.run(1000,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查文档2删除方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查文档2删除方法));
			return;
		}
		
		if(actionStr.contains("客户端用户通讯录接收")){
			CmdExcute.run(1000,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查用户通讯录接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查用户通讯录接收方法));
			return;
		}
		if(actionStr.contains("客户端用户分组通讯录接收")){
			CmdExcute.run(1000,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查用户分组通讯录接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查用户分组通讯录接收方法));
			return;
		}if(actionStr.contains("客户端设备通讯录接收")){
			CmdExcute.run(1000,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查设备通讯录接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查设备通讯录接收方法));
			return;
		}if(actionStr.contains("客户端设备分组通讯录接收")){
			CmdExcute.run(1000,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查设备分组通讯录接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查设备分组通讯录接收方法));
			return;
		}
		
		if(actionStr.contains("客户端通讯录1接收")){
			CmdExcute.run(1000,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查通讯录1接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查通讯录1接收方法));
			return;
		}
		if(actionStr.contains("客户端通讯录2接收")){
			CmdExcute.run(1000,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查通讯录2接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查通讯录2接收方法));
			return;
		}
		if(actionStr.contains("客户端用户通讯录取消")){
			CmdExcute.run(1000,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查用户通讯录取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查用户通讯录取消方法));
			return;
		}
		if(actionStr.contains("客户端用户分组通讯录取消")){
			CmdExcute.run(1000,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查用户分组通讯录取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查用户分组通讯录取消方法));
			return;
		}
		
		if(actionStr.contains("客户端设备通讯录取消")){
			CmdExcute.run(1000,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查设备通讯录取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查设备通讯录取消方法));
			return;
		}
		if(actionStr.contains("客户端设备分组通讯录取消")){
			CmdExcute.run(1000,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查设备分组通讯录取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查设备分组通讯录取消方法));
			return;
		}
		if(actionStr.contains("客户端通讯录1取消")){
			CmdExcute.run(1000,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查通讯录1取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查通讯录1取消方法));
			return;
		}
		
		if(actionStr.contains("客户端通讯录2更新")){
			CmdExcute.run(1000,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查通讯录2更新方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查通讯录2更新方法));
			return;
		}
		
		if(actionStr.contains("客户端通讯录2删除")){
			CmdExcute.run(1000,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查通讯录2删除方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查通讯录2删除方法));
			return;
		}
		
		if(actionStr.contains("客户端锁屏")){
			CmdExcute.run(1000,UiTestInfos.Device模块,UiTestInfos.Device模块_检查设备锁屏方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Device模块_检查设备锁屏方法));
			return;
		}
		
		if(actionStr.contains("客户端设备锁定")){
			CmdExcute.run(1000,UiTestInfos.Device模块,UiTestInfos.Device模块_检查设备锁定方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Device模块_检查设备锁定方法));
			return;
		}
		
		if(actionStr.contains("客户端设备解锁")){
			CmdExcute.run(0,UiTestInfos.Device模块,UiTestInfos.Device模块_设备锁定方法);
			CmdExcute.run(1000,UiTestInfos.Device模块,UiTestInfos.Device模块_检查设备解锁方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Device模块_检查设备解锁方法));
			return;
		}
		
		
		if(actionStr.contains("客户端用户策略更改")){
			CmdExcute.run(1000,UiTestInfos.PloyAndConfig模块,UiTestInfos.PloyAndConfig模块_检查用户策略更改方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.PloyAndConfig模块_检查用户策略更改方法));
			return;
		}

		if(actionStr.contains("客户端用户分组策略更改")){
			CmdExcute.run(1000,UiTestInfos.PloyAndConfig模块,UiTestInfos.PloyAndConfig模块_检查用户分组策略更改方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.PloyAndConfig模块_检查用户分组策略更改方法));
			return;
		}

		if(actionStr.contains("客户端设备策略更改")){
			CmdExcute.run(1000,UiTestInfos.PloyAndConfig模块,UiTestInfos.PloyAndConfig模块_检查设备策略更改方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.PloyAndConfig模块_检查设备策略更改方法));
			return;
		}

		if(actionStr.contains("客户端设备分组策略更改")){
			CmdExcute.run(1000,UiTestInfos.PloyAndConfig模块,UiTestInfos.PloyAndConfig模块_检查设备分组策略更改方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.PloyAndConfig模块_检查设备分组策略更改方法));
			return;
		}
		
		if(actionStr.contains("客户端Android密码策略接收")){
			CmdExcute.run(1000,UiTestInfos.PloyAndConfig模块,UiTestInfos.PloyAndConfig模块_检查Android密码策略接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.PloyAndConfig模块_检查Android密码策略接收方法));
			return;
		}
		
		
		
		
		else if(actionStr.contains("服务器注册设备")){
			//type = ActionType.UserSendMsg;
			MyAssert.assert_True("用户注册设备失败",driver.getPageSource().contains(WebInfos.user注册设备成功提示));
			return;
		}
		
		else if(actionStr.contains("服务器去激活")){
			MyAssert.assert_True("去激活失败",driver.getPageSource().contains(WebInfos.user去激活成功提示));
			return;
		}
		else if(actionStr.contains("服务器") && actionStr.contains("消息")){	
			driver.switchTo().defaultContent();
			MyAssert.assert_True("消息发送失败",driver.getPageSource().contains(WebInfos.action成功提示));
			return;
		}
		
		else if(actionStr.contains("服务器") && actionStr.contains("分发") && !actionStr.contains("取消")){	
			driver.switchTo().defaultContent();
			MyAssert.assert_True("分发失败",driver.getPageSource().contains("成功")||driver.getPageSource().contains(WebInfos.distribute重复提示));
			return;
		}
		else if(actionStr.contains("服务器") && actionStr.contains("取消")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("服务器取消分发失败",driver.getPageSource().contains(WebInfos.distribute取消成功提示));
			return;
		}
		else if(actionStr.contains("服务器") && actionStr.contains("删除")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("服务器删除失败",driver.getPageSource().contains("成功"));
			return;
		}
		else if(actionStr.contains("服务器") && actionStr.contains("更改")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("服务器更改失败",driver.getPageSource().contains("成功"));
		}
		else if(actionStr.contains("服务器") && actionStr.contains("更新")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("服务器更新失败",driver.getPageSource().contains("成功"));
			return;
		}
		
		else if(actionStr.contains("服务器") && actionStr.contains("添加")){
			driver.switchTo().defaultContent();
			if(actionStr.contains("设备") && !actionStr.contains("分组")){
				driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[2]")).getAttribute("id"));
			}
			
			MyAssert.assert_True("服务器添加失败",driver.getPageSource().contains("成功")||driver.getPageSource().contains("占用")||driver.getPageSource().contains("存在"));
			
			return;
		}
	
		else if(actionStr.contains("服务器用户分组注册设备")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("用户分组注册设备失败",driver.getPageSource().contains("成功"));
			return;
		}
		
		
		else if(actionStr.contains("服务器设备定位")){
			Thread.sleep(5000);
			MyAssert.assert_True("设备定位失败",driver.findElement(By.id("map"))!=null);
			return;
		}
		else if(actionStr.contains("服务器设备锁定")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("设备锁定失败",driver.getPageSource().contains(WebInfos.action成功提示));
			return;
		}
		else if(actionStr.contains("服务器对设备锁屏")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("锁屏失败",driver.getPageSource().contains(WebInfos.action成功提示));
			return;
		}
		else if(actionStr.contains("服务器设备解锁")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("设备解锁失败",driver.getPageSource().contains(WebInfos.action成功提示));
			return;
		}
		
		
	}
}
