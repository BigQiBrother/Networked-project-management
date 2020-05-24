网络化项目管理大作业，仅供学习使用（agiltest文件夹为项目源代码）


项目名：火车订票系统

技术使用：后端Springboot + Mybatis + Maven包管理 
	  前端：原生html + js + css + jquery

JKD版本：1.8

mysql版本：8

配置文件为 ：application.yml  
	
	其中里面的数据库配置 为  用户名：root   密码 ：123456   数据库名：ticket
	访问端口号：8080

开发工具： idea


项目启动前，新建一个名字为 ticket 数据库，运行ticket.sql，确保配置文件没有问题后即可访问打开


访问前需要修改网页请求的base_url，保证请求畅通




base_url 在项目文件的相对位置：agiletest\src\main\resources\static\static\js    下，自行定制修改
 

在静态资源文件custom.js以及loginJS.js的头部修改  var base_url = "http://localhost:8080";（这里为默认的请求基地址）

该项目部分静态资源需要联网获取，打开浏览器访问前，请保证网络畅通，否则可能出现一些页面样式丢失等问题

确保上述正确后，即可打开项目(以agiletest文件夹为根目录)，使用maven导包运行


访问地址：
http://localhost:8080/static/fontpage/login.html

大家觉得好用的话，给颗星星呗~~~~~










	  
