# student_ssm
### 使用maven管理，集成SSH框架和shiro的学生管理系统
1. resources/templates下的页面文件是freemarker的，目前该项目已经注释掉了配置，该文件夹的内容无用。
2. 由于mysql的jdbc版本的问题，如果不幸报错，就只能在jdbc的链接上或版本进行修改。
3. 附赠该项目的数据文件https://blog.madongyu.ml/download/student.sql
,可以试着导入自己本地的数据库。（表的设计不是很好，莫笑）
4. 页面很丑。
5. 可使用Maven运行此项目，直接使用Maven的clean package命令即可
6. 使用Ehcache缓存Shiro的session
7. 该项目中的数据库备份恢复的功能并没有考虑通用的情况，需要配置mysqldump的路径，并且文件输出路径也是固定的，具体实现可以到Backup.jsp和Restore.jsp文件查看
8. 访问的页面链接为http://localhost:8080/student_ssm/
