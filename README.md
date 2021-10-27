# Getting Started
### 修改代码
修改jsonweb/src/main/resources/static/index.html文件.将var url = 'http://{your_ip}:8080'的地址修改为自己的服务器地址
### 打包代码
mvn clean package
### 执行代码
java -jar app.jar --server.port=8080
### 访问界面
http://{your_ip}:8080


