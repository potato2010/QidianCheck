JDK 1.6.0_43  
SDK http://googleappengine.googlecode.com/files/appengine-java-sdk-1.8.2.zip  
  
以下写法为书号1890269，GAE ID：qidiancheck为例。   
用法：  
1、修改文件 QidianCheck\war\WEB-INF\cron.xml 每个<cron></cron>为一个定时任务，几个任务就几组<cron></cron>。  
bookID为起点书号。  
2、修改 appengine-web.xml ，<application>qidiancheck</application>之间填入申请到的GAE的ID。  
3、index.html 根据需要修改，觉得没必要就删了。  
4、上传  
初次完整上传  
appengine-java-sdk/bin/appcfg.cmd update QidianCheck/war  
第二次只上传任务即可  
appengine-java-sdk/bin/appcfg.cmd update_cron QidianCheck/war  
更多命令行参考  
https://developers.google.com/appengine/docs/java/tools/uploadinganapp?hl=zh-cn  
5、上传后访问  
https://qidiancheck.appspot.com/guestbook?bookID=1890269  
  
6、编辑管理员邮箱  
点击GAE后台的Datastore Viewer  
By kind选择adminInfo  
点击链接name=adminInfo  
将管理员gmail输入value中，点击按钮Save Entity保存  
7、编辑提醒邮箱  
点击GAE后台的Datastore Viewer  
By kind选择1890269  
点击链接name=1890269  
目标邮箱输入mail下方的value中，点击按钮Save Entity保存  
如果有多个邮箱，用英文逗号分隔  
8、（非必要）测试  
点击链接name=1890269  
time中的值改一个小于当前数字的数，比如0，点击按钮Save Entity保存  
访问  
https://qidiancheck.appspot.com/guestbook?bookID=1890269  
访问后邮件会被发送，name=1890269中的time值会被更新，后台Quota Details中的Recipients Emailed数会加1。  
  
  
  
  
  
  
