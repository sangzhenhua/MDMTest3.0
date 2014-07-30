package com.pekall.test.mdm.support.util;

public class UiTestInfos {
	public static final String MDMTestProjectDir = "e:\\workspace\\MDMTest3.0";
	public static final String UITestProjectDir = "e:\\workspace\\MDMMobileTest3.0";
	
	public static final String Setup模块 = "SetUp";
	public static final String Setup模块_初始化方法 = "uninstallPekall";
	public static final String Setup模块_登陆pekall方法 = "loginPekall";
	public static final String Setup模块_返回home界面方法 = "goHome";
	public static final String Setup模块_启动监视器方法 = "runWatcher";
	
	public static final String Msg模块 = "Message";
	public static final String Msg模块_检查用户消息接收方法 = "checkUserMsgReceived";
	public static final String Msg模块_检查用户消息删除方法 = "checkUserMsgDelete";

	public static final String Msg模块_检查用户分组消息接收方法 = "checkUserGroupMsgReceived";
	public static final String Msg模块_检查用户分组消息复制方法 = "checkUserGroupMsgCopy";
	
	public static final String Msg模块_检查设备消息通知栏接收并查看详情方法 = "checkDeviceMsgNotificationReceivedAndSeeDetail";
	public static final String Msg模块_检查设备分组消息接收方法 = "checkDeviceGroupMsgReceived";
	public static final String Msg模块_检查消息接收方法 = "checkMsgReceived";
	public static final String Device模块 = "Device";
	public static final String Device模块_设备锁定方法 = "lock";
	public static final String Device模块_检查注册设备方法 = "checkRegisterDevice";
	
	
	public static final String Device模块_检查设备锁屏方法 = "checkLockedScreen";
	public static final String Device模块_检查设备锁定方法 = "checkLocked";
	public static final String Device模块_检查设备解锁方法 = "checkUnlocked";
	public static final String Device模块_检查企业数据部分擦除方法 = "checkCompanyDataCleared";
	
	public static final String PloyAndConfig模块 = "PloyAndConfig";
	public static final String PloyAndConfig模块_检查用户策略更改方法 = "checkUserPloyChanged";
	public static final String PloyAndConfig模块_检查用户分组策略更改方法 = "checkUserGroupPloyChanged";
	public static final String PloyAndConfig模块_检查设备策略更改方法 = "checkDevicePloyChanged";
	public static final String PloyAndConfig模块_检查设备分组策略更改方法 = "checkDeviceGroupPloyChanged";
	
	public static final String PloyAndConfig模块_检查Android邮箱策略接收并登陆邮箱方法  = "checkAndroidEmailPloyReceivedAndLogin";
	public static final String PloyAndConfig模块_检查Android密码策略更新方法  = "checkAndroidPWDPloyUpdated";
	public static final String PloyAndConfig模块_检查Android限制策略接收方法  = "checkAndroidRestrictPloyReceived";
	public static final String PloyAndConfig模块_检查Android限制策略删除方法  = "checkAndroidRestrictPloyDeleted";
	public static final String PloyAndConfig模块_检查wifi配置接收方法  = "checkWIFIConfigReceived";
	public static final String PloyAndConfig模块_检查wifi配置更新方法  = "checkWIFIConfigUpdated";
	public static final String PloyAndConfig模块_检查wifi配置删除方法  = "checkWIFIConfigDeleted";
	
	public static final String Doc模块  = "Document";
	public static final String Doc模块_检查用户文档接收并下载打开本地文档查看方法  = "checkUserDocReceivedAndDownloadAndOpenAndCheckInLocalDoc";
	public static final String Doc模块_检查用户分组文档通知栏接收并下载打开本地文档查看方法  = "checkUserGroupDocNotificationReceivedAndDownloadAndOpenAndCheckInLocalDoc";
	public static final String Doc模块_检查设备文档接收并下载删除方法  = "checkDeviceDocReceivedAndDownloadAndDelete";
	public static final String Doc模块_检查设备分组文档接收并搜索方法  = "checkDeviceGroupDocReceivedAndSearch";
	public static final String Doc模块_检查文档1接收方法  = "checkDoc1Received";
	public static final String Doc模块_检查文档2接收方法  = "checkDoc2Received";
	public static final String Doc模块_检查用户文档取消方法  = "checkUserDocCancelled";
	public static final String Doc模块_检查用户分组文档取消方法  = "checkUserGroupDocCancelled";
	public static final String Doc模块_检查设备文档取消方法  = "checkDeviceDocCancelled";
	public static final String Doc模块_检查设备分组文档取消方法  = "checkDeviceGroupDocCancelled";
	public static final String Doc模块_检查文档1取消方法  = "checkDoc1Cancelled";
	public static final String Doc模块_检查文档2删除方法  = "checkDoc2Deleted";
	
	public static final String Email模块  = "Email";
	public static final String Email模块_Email配置接收方法  = "checkEmailConfigReceived";
	public static final String Email模块_Email发送接收查看方法 = "checkEmailSendAndReceiveAndView";
	public static final String Email模块_Email附件保存查看方法 = "checkEmailAttachmentSaveAndView";
	public static final String Email模块_删除邮件并进入已删除邮件文件夹查看方法 = "checkEmailDeleteAndViewInDeletedFolder";
	public static final String Email模块_Email配置更新方法  = "checkEmailConfigUpdated";
	public static final String Email模块_Email配置删除方法  = "checkEmailConfigDeleted";
	public static final String Contacts模块 = "Contacts";
	public static final String Contacts模块_检查用户通讯录接收并进入详情添加和取消重要联系人方法 = "checkUserContactsReceivedAndInDetailAddAndCancelFavoriteContact";
	public static final String Contacts模块_检查用户分组通讯录通知栏接收并详情拨打电话查看通话记录方法 = "checkUserGroupContactsNotificationReceivedAndInDetailCallPhoneAndCheckCallHistory";
	public static final String Contacts模块_检查设备通讯录接收并详情拨打手机查看通话记录方法 = "checkDeviceContactsReceivedAndInDetailCallMobileAndCheckCallHistory";
	public static final String Contacts模块_检查设备分组通讯录接收方法 = "checkDeviceGroupContactsReceived";
	public static final String Contacts模块_检查通讯录1接收方法 = "checkContacts1Received";
	public static final String Contacts模块_检查通讯录2接收方法 = "checkContacts2Received";
	public static final String Contacts模块_检查用户通讯录取消方法 = "checkUserContactsCancelled";
	public static final String Contacts模块_检查用户分组通讯录取消方法 = "checkUserGroupContactsCancelled";
	public static final String Contacts模块_检查设备通讯录取消方法 = "checkDeviceContactsCancelled";
	public static final String Contacts模块_检查设备分组通讯录取消方法 = "checkDeviceGroupContactsCancelled";
	public static final String Contacts模块_检查通讯录1取消方法 = "checkContacts1Cancelled";
	public static final String Contacts模块_检查通讯录2更新方法 = "checkContacts2Updated";
	public static final String Contacts模块_检查通讯录2删除方法 = "checkContacts2Deleted";
	
	public static final String App模块  = "App";
	public static final String App模块_检查用户应用接收方法 = "checkUserAppReceived";
	public static final String App模块_检查用户应用下载安装方法 = "checkUserAppDownloadAndInstall";
	public static final String App模块_检查用户分组应用接收方法 = "checkUserGroupAppReceived";
	public static final String App模块_检查用户分组应用下载安装方法 = "checkUserGroupAppDownloadAndInstallInDetail";
	public static final String App模块_检查用户分组应用更新方法 = "checkUserGroupAppUpdate";
	
	public static final String App模块_检查设备应用接收方法 = "checkDeviceAppReceived";
	public static final String App模块_检查设备应用下载安装方法 = "checkDeviceAppDownloadAndInstall";
	
	public static final String App模块_检查设备分组应用接收方法 = "checkDeviceGroupAppReceived";
	public static final String App模块_检查应用1接收方法 = "checkApp1Received";
	public static final String App模块_检查应用2接收方法 = "checkApp2Received";
	public static final String App模块_检查用户应用取消并卸载方法 = "checkUserAppCancelledAndUninstall";
	public static final String App模块_检查用户分组应用取消并卸载方法 = "checkUserGroupAppCancelledAndUninstall";
	public static final String App模块_检查设备应用取消并卸载方法 = "checkDeviceAppCancelledAndUninstall";
	public static final String App模块_检查设备分组应用取消方法 = "checkDeviceGroupAppCancelled";
	public static final String App模块_检查应用1取消方法 = "checkApp1Cancelled";
	public static final String App模块_检查应用2删除方法 = "checkApp2Deleted";
	
	
}