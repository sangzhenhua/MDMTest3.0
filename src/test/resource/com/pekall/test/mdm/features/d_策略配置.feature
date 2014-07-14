# language: zh-CN

功能: 策略配置
	Android密码策略的添加，下发，更新，删除
	Android限制策略的添加，下发
	WIFI、email配置的添加，下发，更新，删除


	场景: Android密码策略下发分组
 		假如登陆MDM服务器
		当选择Android密码策略
			|策略名称|
 			|自动化测试Android密码策略5|
 		而且Android密码策略下发到用户
 			|账号|
  		|zhenhua.sang@pekall.com|
 		那么服务器Android密码策略分发成功
 		而且客户端Android密码策略接收成功

