JDK 1.6.0_43&nbsp; <br>SDK http://googleappengine.googlecode.com/files/appengine-java-sdk-1.8.2.zip&nbsp; <br>&nbsp; <br>以下写法为书号1890269，GAE ID：qidiancheck为例。&nbsp;&nbsp; <br>用法：&nbsp; <br>1、修改文件 QidianCheck\war\WEB-INF\cron.xml 每个&lt;cron&gt;&lt;/cron&gt;为一个定时任务，几个任务就几组&lt;cron&gt;&lt;/cron&gt;。&nbsp; <br>bookID为起点书号。&nbsp; <br>
![image](https://github.com/potato2010/QidianCheck/raw/master/screenshots/01.png)
<br>2、修改 appengine-web.xml ，&lt;application&gt;qidiancheck&lt;/application&gt;之间填入申请到的GAE的ID。<br>
![image](https://github.com/potato2010/QidianCheck/raw/master/screenshots/02.png)
<br>3、index.html 根据需要修改，觉得没必要就删了。&nbsp; <br>4、上传&nbsp; <br>初次完整上传&nbsp; <br>appengine-java-sdk/bin/appcfg.cmd update QidianCheck/war&nbsp; <br>第二次只上传任务即可&nbsp; <br>appengine-java-sdk/bin/appcfg.cmd update_cron QidianCheck/war&nbsp; <br>更多命令行参考&nbsp; <br>https://developers.google.com/appengine/docs/java/tools/uploadinganapp?hl=zh-cn&nbsp; <br>5、上传后访问&nbsp; <br>https://qidiancheck.appspot.com/CheckBook?bookID=1890269&nbsp; <br>&nbsp; <br>6、编辑管理员邮箱&nbsp; <br>点击GAE后台的Datastore Viewer&nbsp; <br>By kind选择adminInfo&nbsp; <br>点击链接name=adminInfo&nbsp; <br>将管理员gmail输入value中，点击按钮Save Entity保存&nbsp; <br>7、编辑提醒邮箱&nbsp; <br>点击GAE后台的Datastore Viewer&nbsp; <br>By kind选择1890269&nbsp; <br>点击链接name=1890269&nbsp; <br>
![image](https://github.com/potato2010/QidianCheck/raw/master/screenshots/03.png)
<br>目标邮箱输入mail下方的value中，点击按钮Save Entity保存&nbsp; <br>
![image](https://github.com/potato2010/QidianCheck/raw/master/screenshots/04.png)
<br>如果有多个邮箱，用英文逗号分隔&nbsp; <br>8、（非必要）测试&nbsp; <br>点击链接name=1890269&nbsp; <br>time中的值改一个小于当前数字的数，比如0，点击按钮Save Entity保存&nbsp; <br>访问&nbsp; <br>https://qidiancheck.appspot.com/CheckBook?bookID=1890269&nbsp; <br>访问后邮件会被发送，name=1890269中的time值会被更新，后台Quota Details中的Recipients Emailed数会加1。&nbsp; <br>&nbsp; <br>&nbsp; <br>&nbsp; <br>&nbsp; <br>&nbsp; <br>&nbsp; <br><br>

