# HouDuan

--- 

### 人人帮项目的后端。

注: 关于“人人帮”这个名字，名字是自己瞎起的，没有任何商业性活动，仅用作自己学习使用，如有冲突请联系删除。

<a target="_blank" href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=D3ZuYGdqYWhQY2ZPfn4hbGBi" style="text-decoration:none;"><img src="http://rescdn.qqmail.com/zh_CN/htmledition/images/function/qm_open/ico_mailme_02.png"/></a>

---
##### 项目说明

  +  maven管理项目
  +  tomcat9
  +  jdk8
  +  mysql5 //连接的远程数据库服务器。
  +  springmvc+spring+mybatis
  +  实现了基本的业务需求，在接单通知功能模块用户体验度太差，需要重新设计。用户接单后没有在app内对发单用户进行通知，目前简单的实现了短信通知。

---

##### 存在的问题

 + 接口设计不合理
 + 接口不安全，对请求没有进行验证
 + 权限设计分配不合理
 + 没有任何的加密措施，数据不安全
 + 业务逻辑不完善
