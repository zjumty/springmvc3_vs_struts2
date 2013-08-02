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

场景1： 返回10条记录的表格(JSP)
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

场景2： 返回10条记录的表格(FreeMarker)
Spring MVC3

    wrk -t8 -c500 -d30 http://192.168.2.101:8080/springmvcbm/index2?count=10
    
Results:
```
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    93.35ms   21.92ms 349.21ms   98.28%
    Req/Sec   672.92     55.69   757.00     95.71%
  161110 requests in 30.00s, 257.40MB read
  Socket errors: connect 0, read 81, write 28, timeout 0
Requests/sec:   5370.41
Transfer/sec:      8.58MB
```

Struts2

    wrk -t8 c500 -d30 http://192.168.2.101:8080/strutsbm/index2.action?count=10

Results:
```
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.29s   171.67ms   1.77s    77.01%
    Req/Sec    47.55     21.70   107.00     71.09%
  11442 requests in 30.01s, 17.96MB read
  Socket errors: connect 0, read 247, write 7, timeout 0
Requests/sec:    381.29
Transfer/sec:    612.74KB
```

场景3： 返回10条记录的JSON
Spring MVC3

    wrk -t8 -c500 -d30 http://192.168.2.101:8080/springmvcbm/index3?count=10
    
Results:
```
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    79.15ms   37.70ms 438.99ms   96.92%
    Req/Sec   790.81    127.60     1.35k    93.67%
  188993 requests in 30.00s, 107.29MB read
  Socket errors: connect 0, read 340, write 10, timeout 0
Requests/sec:   6299.78
Transfer/sec:      3.58MB
```

Struts2

    wrk -t8 c500 -d30 http://192.168.2.101:8080/strutsbm/index3.action?count=10

Results:
```
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.13s   172.86ms   1.58s    83.33%
    Req/Sec    50.98     10.09    92.00     78.09%
  12325 requests in 30.01s, 6.77MB read
  Socket errors: connect 0, read 458, write 24, timeout 58
Requests/sec:    410.67
Transfer/sec:    231.00KB
```

=====================
About wrk - Modern HTTP benchmarking tool : https://github.com/wg/wrk
