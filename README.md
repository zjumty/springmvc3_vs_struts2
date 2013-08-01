springmvc3_vs_struts2
=====================

Spring MVC 3 vs Struts2 Performance Benchmark

Server Configuration：

    Tomcat 7.0.42

NIO Connector

    <Connector port="8080" protocol="org.apache.coyote.http11.Http11NioProtocol"
           connectionTimeout="20000" maxThreads="100"
           redirectPort="8443" />

Memory:

    -Xms256m -Xmx1024m -XX:MaxPermSize=128m

CPU: 
    
    intel i7 4 cores mbp

场景1： 返回10条记录的表格
Spring MVC3

    wrk -t8 -c500 -d30 http://192.168.2.101:8080/springmvcbm/index?count=10
    
Results:
```
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   108.97ms  151.39ms 985.59ms   97.01%
    Req/Sec   713.31    129.44     0.95k    93.48%
  170587 requests in 30.00s, 266.99MB read
  Socket errors: connect 0, read 256, write 10, timeout 11
Requests/sec:   5685.56
Transfer/sec:      8.90MB
```

Struts2

    wrk -t8 c500 -d30 http://192.168.2.101:8080/strutsbm/index.action?count=10

Results:
```
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.34s   156.82ms   2.04s    81.50%
    Req/Sec    44.49     12.18    83.00     67.47%
  10668 requests in 30.01s, 16.41MB read
  Socket errors: connect 0, read 255, write 24, timeout 2
Requests/sec:    355.45
Transfer/sec:    559.90KB
```
