# language: zh-CN

功能: 策略配置
	Android密码策略的添加，下发，更新，删除
	Android限制策略的添加，下发
	WIFI、email配置的添加，下发，更新，删除


	场景大纲: 添加Android邮箱策略
 		 假如登陆MDM服务器
 	 	当添加Android邮箱策略：策略名称<策略名称>策略描述<策略描述>配置类型<配置类型>接收邮件服务器主机名<接收邮件服务器主机名>接收邮件服务器端口<接收邮件服务器端口>发送邮件服务器主机名<发送邮件服务器主机名>发送邮件服务器端口<发送邮件服务器端口>
 		那么服务器Android邮箱策略添加成功
 	
		例子:
			|策略名称                                         |策略描述     |配置类型|接收邮件服务器主机名|接收邮件服务器端口|发送邮件服务器主机名|发送邮件服务器端口|
			|自动化测试Android邮箱策略|自动化测试|POP3  |mail.pekall.com|110       |mail.pekall.com|25         |
		


	场景: Android邮箱策略下发并客户端登陆邮箱
 		假如登陆MDM服务器
		当选择Android密码策略
			|策略名称|
 			|自动化测试Android邮箱策略|
 		而且Android密码策略下发到用户
 			|账号|
  		|zhenhua.sang@pekall.com|
 		那么服务器Android邮箱策略分发成功
 		而且客户端Android邮箱策略接收并登陆邮箱成功

