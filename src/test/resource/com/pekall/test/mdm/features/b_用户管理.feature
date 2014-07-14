# language: zh-CN

功能: 用户管理
	添加删除用户和给用户发送消息


	场景大纲: 单个添加用户
		 假如登陆MDM服务器
		当添加单个用户:账户名<账户名>姓名<姓名>电话<电话>
		那么用户单个添加成功

	 	 例子:
  		|账户名|姓名|电话|
  		|zhenhua.sang@pekall.com|1qaz2wsx|18612425230|
 


	场景大纲: 批量添加用户
		 假如登陆MDM服务器
 		当导入文件<文件路径>批量添加用户
 		那么用户批量添加成功
 
		例子:
			|文件路径|
  		|d:\\autoTestFile\\batch_user_template.xls|


	 场景: 注册设备
		 假如登陆MDM服务器
 		当选择用户
  		|账号|
  		|zhenhua.sang@pekall.com|
		而且注册设备
		那么服务器注册设备成功
 #	那么客户端注册设备成功


 	场景: 用户发送消息
 		假如登陆MDM服务器
 		当选择用户
  		|账号|
  		|zhenhua.sang@pekall.com|
 		而且给用户发送消息
			|主题|消息|
  		|UserPushMessage|This is a push message!|
 		那么服务器用户消息发送成功
 		而且客户端用户消息接收成功
 	

 	场景: 用户更改策略
 		假如登陆MDM服务器
 		当选择用户
  		|账号|
  		|zhenhua.sang@pekall.com|
 		而且给用户更改策略
			|策略名称|
  		|自动化测试Android密码策略1|
 		那么服务器用户策略更改成功
 		那么客户端用户策略更改成功
  

	场景: 用户分发应用并在应用列表下载暂停安装
 		假如登陆MDM服务器
 		当选择用户
  		|账号|
  		|zhenhua.sang@pekall.com|
 		而且给用户分发应用
			|应用名称|
  		|2048|
 		那么服务器分发应用成功
 		而且客户端用户应用接收成功
 		而且客户端用户应用应用列表界面下载暂停安装成功
	
	
	场景: 用户分发文档
 		假如登陆MDM服务器
 		当选择用户
  		|账号|
  		|zhenhua.sang@pekall.com|
 		而且给用户分发文档
			|文档名称|
  		|自动化测试txt|
 		那么服务器分发文档成功
 		那么客户端用户文档接收成功
 	

	场景: 用户分发通讯录
 		假如登陆MDM服务器
 		当选择用户
  		|账号|
  		|zhenhua.sang@pekall.com|
 		而且给用户分发通讯录
			|通讯录名称|
  		|自动化测试通讯录1|
 		那么服务器用户通讯录成功
 		那么客户端用户通讯录接收成功


	场景: 取消用户应用分发并卸载应用
 		假如登陆MDM服务器
 		当选择用户
  		|账号|
  		|zhenhua.sang@pekall.com|
 		而且取消给用户分发的应用
			|应用名称|
  		|2048|
 		那么服务器取消分发应用成功
 		那么客户端用户应用取消并卸载成功
 	

	场景: 取消用户文档分发
 		假如登陆MDM服务器
 		当选择用户
  		|账号|
  		|zhenhua.sang@pekall.com|
 		而且取消给用户分发的文档
			|文档名称|
  		|自动化测试txt|
 		那么服务器用户文档取消分发成功
 		那么客户端用户文档取消分发成功
 	
 	
 	场景: 取消用户通讯录分发
 		假如登陆MDM服务器
 		当选择用户
  		|账号|
  		|zhenhua.sang@pekall.com|
 		而且取消给用户分发的通讯录
			|通讯录名称|
  		|自动化测试通讯录1|
 		那么服务器用户通讯录取消分发成功
 		那么客户端用户通讯录取消分发成功
 	
 	
 	场景: 添加用户分组
		假如登陆MDM服务器
		当添加分组
			|分组名称|分组成员|描述 |
			|自动化测试用户分组|zhenhua.sang@pekall.com|自动化测试分组|
		那么服务器添加用户分组成功
		
		
 	场景: 用户分组更改策略
 		假如登陆MDM服务器
 		当选择用户分组
  		|分组名称|
  		|自动化测试用户分组|
 		而且给用户分组更改策略
			|策略名称|
  		|自动化测试Android密码策略2|
 		那么服务器用户分组策略更改成功
 		那么客户端用户分组策略更改成功
  
	
	场景: 用户分组发送消息
 		假如登陆MDM服务器
 		当选择用户分组
  		|分组名称|
  		|自动化测试用户分组|
 		而且给用户分组发送消息
			|主题|消息|
  		|UserGroupPushMessage|This is a push message!|
 		那么服务器用户分组消息发送成功
 		那么客户端用户分组消息接收成功	
 	

	场景: 用户分组注册设备
 		假如登陆MDM服务器
 		当选择用户分组
  		|分组名称|
  		|自动化测试用户分组|
 		而且给用户分组注册设备
 		那么服务器用户分组注册设备成功
 	
 	
 	场景: 用户分组分发应用并通知栏进入应用详情下载安装更新
 		假如登陆MDM服务器
 		当选择用户分组
  		|分组名称|
  		|自动化测试用户分组|
 		而且给用户分组分发应用
			|应用名称|
  		|墨迹天气|
 		那么服务器用户分组应用分发成功
 	      而且客户端用户分组应用接收成功
 	      而且客户端用户分组应用应用详情界面下载安装成功
 	      而且客户端用户分组应用更新成功
 	
 	
 	场景: 用户分组分发文档
 		假如登陆MDM服务器
 		当选择用户分组
  		|分组名称|
  		|自动化测试用户分组|
 		而且给用户分组分发文档
			|文档名称|
  		|自动化测试jpg|
 		那么服务器用户分组文档分发成功
 		那么客户端用户分组文档接收成功
 	

 	场景: 用户分组分发通讯录
 		假如登陆MDM服务器
 		当选择用户分组
  		|分组名称|
  		|自动化测试用户分组|
 		而且给用户分组分发通讯录
			|通讯录名称|
  		|自动化测试通讯录2|
 		那么服务器用户分组通讯录分发成功
 		那么客户端用户分组通讯录接收成功
 	
 
 	场景: 取消用户分组应用分发
 		假如登陆MDM服务器
 		当选择用户分组
  		|分组名称|
  		|自动化测试用户分组|
 		而且取消给用户分组分发的应用
			|应用名称|
  		|墨迹天气|
 		那么服务器用户分组应用取消分发成功
 		而且客户端用户分组应用取消并卸载成功
 	
  
 	场景: 取消用户分组文档分发
 		假如登陆MDM服务器
 		当选择用户分组
  		|分组名称|
  		|自动化测试用户分组|
 		而且取消给用户分组分发的文档
			|文档名称|
  		|自动化测试jpg|
 		那么服务器用户分组文档取消分发成功
 		那么客户端用户分组文档取消分发成功
 	
 
 	场景: 取消用户分组通讯录分发
 		假如登陆MDM服务器
 		当选择用户分组
  		|分组名称|
  		|自动化测试用户分组|
 		而且取消给用户分组分发的通讯录
			|通讯录名称|
  		|自动化测试通讯录2|
 		那么服务器用户分组通讯录取消分发成功
 		那么客户端用户分组通讯录取消成功