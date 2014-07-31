# language: zh-CN

功能: 测试准备
	添加策略，文档，应用，通讯录


	场景: 删除所有已添加的自动化测试文档
 		 假如登陆MDM服务器
 	 	当删除所有自动化测试文档
 		那么服务器所有自动化测试文档删除成功
 

 	场景: 删除所有已添加的自动化测试通讯录
 		 假如登陆MDM服务器
 	 	当删除所有自动化测试通讯录
 		那么服务器所有自动化测试通讯录删除成功
 	

 	场景: 删除所有已添加的自动化测试应用
 		 假如登陆MDM服务器
 	 	当删除所有自动化测试应用
 		那么服务器所有自动化测试应用删除成功

	场景大纲: 添加Android密码策略
 		 假如登陆MDM服务器
 	 	当添加Android密码策略：策略名称<策略名称>策略描述<策略描述>密码等级<密码等级>
 		那么服务器Android密码策略添加成功
 	
		例子:
			|策略名称|策略描述|密码等级|
			|自动化测试Android密码策略1|自动化测试|数字|
			|自动化测试Android密码策略2|自动化测试|数字|
			|自动化测试Android密码策略3|自动化测试|数字|
			|自动化测试Android密码策略4|自动化测试|数字|
		

	场景大纲: 新建文档
 		假如登陆MDM服务器
		当添加文档:文档名称<文档名称>文档标签<文档标签>文档路径<文档路径>
  	那么服务器文档添加成功
		
		例子:
			|文档名称|文档标签|文档路径  |
  		|自动化测试txt|自动化测试文档|D:\\autoTestFile\\txt.txt|
  		|自动化测试jpg|自动化测试文档|D:\\autoTestFile\\jpg.jpg|
  		|自动化测试png|自动化测试文档|D:\\autoTestFile\\png.png|
  		|自动化测试ppt|自动化测试文档|D:\\autoTestFile\\ppt.ppt|
  		|自动化测试docx|自动化测试文档|D:\\autoTestFile\\docx.docx|
  		|自动化测试xlsx|自动化测试文档|D:\\autoTestFile\\xlsx.xlsx|

	场景大纲: 新建企业通讯录
		假如登陆MDM服务器
		当添加企业通讯录:通讯录名称<通讯录名称>通讯录路径<通讯录路径>
  	那么服务器通讯录添加成功
  		例子:
  			|通讯录名称|通讯录路径  |
  			|自动化测试通讯录1|D:\\autoTestFile\\enterprise_contacts1.xls|
  			|自动化测试通讯录2|D:\\autoTestFile\\enterprise_contacts2.xls|
  			|自动化测试通讯录3|D:\\autoTestFile\\enterprise_contacts3.xls|
  			|自动化测试通讯录4|D:\\autoTestFile\\enterprise_contacts4.xls|
  			|自动化测试通讯录5|D:\\autoTestFile\\enterprise_contacts5.xls|
  			|自动化测试通讯录6|D:\\autoTestFile\\enterprise_contacts6.xls|
	

	场景大纲: 新建企业android应用
 		 假如登陆MDM服务器
 		 当添加应用:应用路径<应用路径>应用截图路径<应用截图路径>应用类别<应用类别>应用描述<应用描述>
  	 那么服务器应用添加成功
			例子:
				|应用路径|应用截图路径|应用类别 |应用描述|
  			|d:\\autoTestFile\\2048.apk|d:\\autoTestFile\\2048.jpg|办公|2048正式版|
  			|d:\\autoTestFile\\墨迹天气.apk|d:\\autoTestFile\\墨迹天气.jpg|办公|墨迹天气正式版|
  			|d:\\autoTestFile\\新华字典.apk|d:\\autoTestFile\\新华字典.jpg|办公|新华字典正式版|
  			|d:\\autoTestFile\\万年历.apk|d:\\autoTestFile\\万年历.jpg|办公|万年历正式版|
  		  |d:\\autoTestFile\\我查查.apk|d:\\autoTestFile\\我查查.jpg|办公|我查查正式版|
	

	场景大纲: 新建百度android应用
 		 假如登陆MDM服务器
 		 当添加百度应用:应用名称<应用名称>安全策略<安全策略>分发类别<分发类别>分发到<分发到>
  	 那么服务器应用添加成功
			例子:
				|应用名称|安全策略|分发类别|分发到|
  			|note||||
  			
	