springmvc3_vs_struts2
=====================

Spring MVC 3 vs Struts2 Performance Benchmark

服务器配置：
Tomcat 7.0.42

NIO Connector

<Connector port="8080" protocol="org.apache.coyote.http11.Http11NioProtocol"
           connectionTimeout="20000" maxThreads="100"
           redirectPort="8443" />

Memory:
-Xms256m -Xmx1024m -XX:MaxPermSize=128m

CPU: intel i7 4 cores mbp

场景1： 返回10条记录的表格
Spring MVC3
  wrk -t8 -c500 -d30 http://192.168.2.101:8080/springmvcbm/index?count=10

Struts2
  wrk -t8 c500 -d30 http://192.168.2.101:8080/strutsbm/index.action?count=10
