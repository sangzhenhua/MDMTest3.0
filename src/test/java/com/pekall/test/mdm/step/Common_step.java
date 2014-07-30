package com.pekall.test.mdm.step;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

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
import com.pekall.test.mdm.support.util.WaitForElement;
import com.pekall.test.mdm.support.util.WebInfos;

import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.那么;

public class Common_step {
	private WebDriver driver = Service.getInstance(MyDriver.USE);
	private WaitForElement wait = WaitForElement.getInstance();
	
	@假如("^登陆MDM服务器$")
	public void 登陆mdm服务器() throws Throwable {
		Login login = Login.getInstance();
		login.login();
		System.out.println("cookies start:");
		System.out.println(driver.manage().getCookies().toString());
		System.out.println("cookies end");
	}

	@那么("^(.*?)成功$")
	public void _成功(String actionStr) throws Throwable {
		ActionType type =null;
		if(actionStr.contains("客户端用户消息接收")){
			CmdExcute.run(0,UiTestInfos.Msg模块,UiTestInfos.Msg模块_检查用户消息接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Msg模块_检查用户消息接收方法));
			return;
		}
		
		if(actionStr.contains("客户端用户消息删除")){
			CmdExcute.run(0,UiTestInfos.Msg模块,UiTestInfos.Msg模块_检查用户消息删除方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Msg模块_检查用户消息删除方法));
			return;
		}
		
		if(actionStr.contains("客户端用户分组消息接收")){
			CmdExcute.run(0,UiTestInfos.Msg模块,UiTestInfos.Msg模块_检查用户分组消息接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Msg模块_检查用户分组消息接收方法));
			return;
		}
		
		if(actionStr.contains("客户端用户分组消息复制")){
			CmdExcute.run(0,UiTestInfos.Msg模块,UiTestInfos.Msg模块_检查用户分组消息复制方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Msg模块_检查用户分组消息复制方法));
			return;
		}
		
		if(actionStr.contains("客户端设备消息通知栏接收并查看详情")){
			CmdExcute.run(0,UiTestInfos.Msg模块,UiTestInfos.Msg模块_检查设备消息通知栏接收并查看详情方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Msg模块_检查设备消息通知栏接收并查看详情方法));
			return;
		}
		if(actionStr.contains("客户端设备分组消息接收")){
			CmdExcute.run(0,UiTestInfos.Msg模块,UiTestInfos.Msg模块_检查设备分组消息接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Msg模块_检查设备分组消息接收方法));
			return;
		}
		if(actionStr.contains("客户端用户应用接收")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查用户应用接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查用户应用接收方法));
			return;
		}
		
		if(actionStr.contains("客户端用户应用应用列表界面下载暂停安装")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查用户应用下载安装方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查用户应用下载安装方法));
			return;
		}
		if(actionStr.contains("客户端用户分组应用接收")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查用户分组应用接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查用户分组应用接收方法));
			return;
		}
		if(actionStr.contains("客户端用户分组应用应用详情界面下载安装")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查用户分组应用下载安装方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查用户分组应用下载安装方法));
			return;
		}
		if(actionStr.contains("客户端用户分组应用更新")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查用户分组应用更新方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查用户分组应用更新方法));
			return;
		}
		
		if(actionStr.contains("客户端设备应用接收")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查设备应用接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查设备应用接收方法));
			return;
		}
		
		if(actionStr.contains("客户端设备应用应用列表界面下载暂停安装")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查设备应用下载安装方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查设备应用下载安装方法));
			return;
		}
		
		if(actionStr.contains("客户端设备分组应用接收")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查设备分组应用接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查设备分组应用接收方法));
			return;
		}if(actionStr.contains("客户端应用1接收")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查应用1接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查应用1接收方法));
			return;
		}
		if(actionStr.contains("客户端应用2接收")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查应用2接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查应用2接收方法));
			return;
		}
		if(actionStr.contains("客户端用户应用取消并卸载")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查用户应用取消并卸载方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查用户应用取消并卸载方法));
			return;
		}
		if(actionStr.contains("客户端用户分组应用取消并卸载")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查用户分组应用取消并卸载方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查用户分组应用取消并卸载方法));
			return;
		}
		if(actionStr.contains("客户端设备应用取消并卸载")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查设备应用取消并卸载方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查设备应用取消并卸载方法));
			return;
		}
		if(actionStr.contains("客户端设备分组应用取消")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查设备分组应用取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查设备分组应用取消方法));
			return;
		}
		if(actionStr.contains("客户端应用1取消")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查应用1取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查应用1取消方法));
			return;
		}
		if(actionStr.contains("客户端应用2删除")){
			CmdExcute.run(0,UiTestInfos.App模块,UiTestInfos.App模块_检查应用2删除方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.App模块_检查应用2删除方法));
			return;
		}
		if(actionStr.contains("客户端用户文档接收并下载打开本地文档查看")){
			CmdExcute.run(0,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查用户文档接收并下载打开本地文档查看方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查用户文档接收并下载打开本地文档查看方法));
			return;
		}
		if(actionStr.contains("客户端用户分组文档通知栏接收并下载打开本地文档查看")){
			CmdExcute.run(0,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查用户分组文档通知栏接收并下载打开本地文档查看方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查用户分组文档通知栏接收并下载打开本地文档查看方法));
			return;
		}
		if(actionStr.contains("客户端设备文档接收并下载删除")){
			CmdExcute.run(0,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查设备文档接收并下载删除方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查设备文档接收并下载删除方法));
			return;
		}
		if(actionStr.contains("客户端设备分组文档接收并搜索")){
			CmdExcute.run(0,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查设备分组文档接收并搜索方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查设备分组文档接收并搜索方法));
			return;
		}
		if(actionStr.contains("客户端文档1接收")){
			CmdExcute.run(0,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查文档1接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查文档1接收方法));
			return;
		}
		if(actionStr.contains("客户端文档2接收")){
			CmdExcute.run(0,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查文档2接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查文档2接收方法));
			return;
		}
		if(actionStr.contains("客户端用户文档取消")){
			CmdExcute.run(0,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查用户文档取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查用户文档取消方法));
			return;
		}
		if(actionStr.contains("客户端用户分组文档取消")){
			CmdExcute.run(0,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查用户分组文档取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查用户分组文档取消方法));
			return;
		}
		if(actionStr.contains("客户端设备文档取消")){
			CmdExcute.run(0,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查设备文档取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查设备文档取消方法));
			return;
		}
		if(actionStr.contains("客户端设备分组文档取消")){
			CmdExcute.run(0,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查设备分组文档取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查设备分组文档取消方法));
			return;
		}
		if(actionStr.contains("客户端文档1取消")){
			CmdExcute.run(0,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查文档1取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查文档1取消方法));
			return;
		}
		if(actionStr.contains("客户端文档2删除")){
			CmdExcute.run(0,UiTestInfos.Doc模块,UiTestInfos.Doc模块_检查文档2删除方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Doc模块_检查文档2删除方法));
			return;
		}
		
		if(actionStr.contains("客户端用户通讯录接收并进入详情添加和取消重要联系人")){
			CmdExcute.run(0,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查用户通讯录接收并进入详情添加和取消重要联系人方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查用户通讯录接收并进入详情添加和取消重要联系人方法));
			return;
		}
		if(actionStr.contains("客户端用户分组通讯录通知栏接收并详情拨打电话查看通话记录")){
			CmdExcute.run(0,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查用户分组通讯录通知栏接收并详情拨打电话查看通话记录方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查用户分组通讯录通知栏接收并详情拨打电话查看通话记录方法));
			return;
		}if(actionStr.contains("客户端设备通讯录接收并详情拨打手机查看通话记录")){
			CmdExcute.run(0,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查设备通讯录接收并详情拨打手机查看通话记录方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查设备通讯录接收并详情拨打手机查看通话记录方法));
			return;
		}if(actionStr.contains("客户端设备分组通讯录接收")){
			CmdExcute.run(0,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查设备分组通讯录接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查设备分组通讯录接收方法));
			return;
		}
		
		if(actionStr.contains("客户端通讯录1接收")){
			CmdExcute.run(0,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查通讯录1接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查通讯录1接收方法));
			return;
		}
		if(actionStr.contains("客户端通讯录2接收")){
			CmdExcute.run(0,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查通讯录2接收方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查通讯录2接收方法));
			return;
		}
		if(actionStr.contains("客户端用户通讯录取消")){
			CmdExcute.run(0,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查用户通讯录取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查用户通讯录取消方法));
			return;
		}
		if(actionStr.contains("客户端用户分组通讯录取消")){
			CmdExcute.run(0,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查用户分组通讯录取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查用户分组通讯录取消方法));
			return;
		}
		
		if(actionStr.contains("客户端设备通讯录取消")){
			CmdExcute.run(0,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查设备通讯录取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查设备通讯录取消方法));
			return;
		}
		if(actionStr.contains("客户端设备分组通讯录取消")){
			CmdExcute.run(0,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查设备分组通讯录取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查设备分组通讯录取消方法));
			return;
		}
		if(actionStr.contains("客户端通讯录1取消")){
			CmdExcute.run(0,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查通讯录1取消方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查通讯录1取消方法));
			return;
		}
		
		if(actionStr.contains("客户端通讯录2更新")){
			CmdExcute.run(0,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查通讯录2更新方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查通讯录2更新方法));
			return;
		}
		
		if(actionStr.contains("客户端通讯录2删除")){
			CmdExcute.run(0,UiTestInfos.Contacts模块,UiTestInfos.Contacts模块_检查通讯录2删除方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Contacts模块_检查通讯录2删除方法));
			return;
		}
		
		if(actionStr.contains("客户端注册设备")){
			CmdExcute.run(1000,UiTestInfos.Device模块,UiTestInfos.Device模块_检查注册设备方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Device模块_检查注册设备方法));
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
		
		if(actionStr.contains("客户端Android邮箱策略接收并登陆邮箱")){
			CmdExcute.run(0,UiTestInfos.PloyAndConfig模块,UiTestInfos.PloyAndConfig模块_检查Android邮箱策略接收并登陆邮箱方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.PloyAndConfig模块_检查Android邮箱策略接收并登陆邮箱方法));
			return;
		}
		if(actionStr.contains("客户端发送接收查看邮件")){
			CmdExcute.run(0,UiTestInfos.Email模块,UiTestInfos.Email模块_Email发送接收查看方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Email模块_Email发送接收查看方法));
			return;
		}
		
		if(actionStr.contains("客户端邮箱查看保存附件")){
			CmdExcute.run(0,UiTestInfos.Email模块,UiTestInfos.Email模块_Email附件保存查看方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Email模块_Email附件保存查看方法));
			return;
		}
		
		
		if(actionStr.contains("客户端删除邮件并进入已删除邮件文件夹查看")){
			CmdExcute.run(0,UiTestInfos.Email模块,UiTestInfos.Email模块_删除邮件并进入已删除邮件文件夹查看方法);
			Assert.assertTrue(CmdExcute.analyzeResult(UiTestInfos.Email模块_删除邮件并进入已删除邮件文件夹查看方法));
			return;
		}
		
		else if(actionStr.contains("服务器注册设备")){
			MyAssert.assert_True("用户注册设备失败",wait.wait(WebInfos.user注册设备成功提示));
			File registerInfo = new File("deviceRegisterInfo.txt");
			FileWriter fw = new FileWriter(registerInfo);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("company_id:"+wait.wait(By.id("company_id")).getText());
			bw.write(":"+"email:"+wait.wait(By.id("email")).getText());
			bw.write(":"+"code:"+wait.wait(By.id("code")).getText());
			bw.close();
			CmdExcute.pushRegisterFileToPhone();
		}
		else if(actionStr.contains("服务器去激活")){
			MyAssert.assert_True("去激活失败",wait.wait(WebInfos.user去激活成功提示));
			return;
		}
		else if(actionStr.contains("服务器") && actionStr.contains("消息")){	
			driver.switchTo().defaultContent();
			MyAssert.assert_True("消息发送失败",wait.wait(WebInfos.action成功提示));
			return;
		}
		
		else if(actionStr.contains("服务器") && actionStr.contains("分发") && !actionStr.contains("取消")){	
			driver.switchTo().defaultContent();
			MyAssert.assert_True("分发失败",wait.wait("成功")||driver.getPageSource().contains(WebInfos.distribute重复提示));
			return;
		}
		else if(actionStr.contains("服务器") && actionStr.contains("取消")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("服务器取消分发失败",wait.wait(WebInfos.distribute取消成功提示));
			return;
		}
		else if(actionStr.contains("服务器") && actionStr.contains("删除")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("服务器删除失败",wait.wait("成功"));
			return;
		}
		else if(actionStr.contains("服务器") && actionStr.contains("更改")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("服务器更改失败",wait.wait("成功"));
		}
		else if(actionStr.contains("服务器") && actionStr.contains("更新")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("服务器更新失败",wait.wait("成功"));
			return;
		}
		
		else if(actionStr.contains("服务器") && actionStr.contains("添加")){
			driver.switchTo().defaultContent();
			if(actionStr.contains("设备") && !actionStr.contains("分组")){
				driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[2]")).getAttribute("id"));
				MyAssert.assert_True("服务器添加失败",wait.wait("成功"));
				return;
			}
			
			if(actionStr.contains("用户")){
				MyAssert.assert_True("服务器添加失败",wait.wait("占用")||driver.getPageSource().contains("成功"));
				return;
			}
			if(actionStr.contains("策略")||actionStr.contains("设备分组")){
				MyAssert.assert_True("服务器添加失败",wait.wait("存在")||driver.getPageSource().contains("成功"));
				return;
			}
			MyAssert.assert_True("服务器添加失败",wait.wait("成功")||driver.getPageSource().contains("存在"));
			
			return;
		}
	
		else if(actionStr.contains("服务器用户分组注册设备")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("用户分组注册设备失败",wait.wait("成功"));
			return;
		}
		
		
		else if(actionStr.contains("服务器设备定位")){
			Thread.sleep(5000);
			System.out.println(driver.getCurrentUrl());
			MyAssert.assert_True("设备定位失败",driver.findElement(By.id("map"))!=null);
			return;
		}
		else if(actionStr.contains("服务器设备锁定")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("设备锁定失败",wait.wait(WebInfos.action成功提示));
			return;
		}
		else if(actionStr.contains("服务器对设备锁屏")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("锁屏失败",wait.wait(WebInfos.action成功提示));
			return;
		}
		else if(actionStr.contains("服务器设备解锁")){
			driver.switchTo().defaultContent();
			MyAssert.assert_True("设备解锁失败",wait.wait(WebInfos.action成功提示));
			return;
		}
		
		
	}
}
