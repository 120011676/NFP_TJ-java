# NFP_TJ-java

天津网络货运平台-SDK java版本

暂未发现有问题，在等等上传maven仓库

NFP_TJ-java-SD 普通SDK

springboot 使用方式
maven

```xml
<dependency>
    <groupId>com.github.qq120011676</groupId>
    <artifactId>NFP_TJ-java-SDK</artifactId>
    <version>V1.2.1-1.0.0</version>
    <scope>system</scope>
    <systemPath>${pom.basedir}/libs/NFP_TJ-java-SDK-V1.2.1-1.0.0.jar</systemPath>
</dependency>
<dependency>
    <groupId>com.github.qq120011676</groupId>
    <artifactId>NFP_TJ-java-SDK-spring-boot-autoconfigure</artifactId>
    <version>V1.2.1-1.0.0</version>
    <scope>system</scope>
    <systemPath>${pom.basedir}/libs/NFP_TJ-java-SDK-spring-boot-autoconfigure-V1.2.1-1.0.0.jar</systemPath>
</dependency>
<dependency>
    <groupId>com.github.qq120011676</groupId>
    <artifactId>NFP_TJ-java-SDK-spring-boot-starter</artifactId>
    <version>V1.2.1-1.0.0</version>
    <scope>system</scope>
    <systemPath>${pom.basedir}/libs/NFP_TJ-java-SDK-spring-boot-starter-V1.2.1-1.0.0.jar</systemPath>
</dependency>
<dependency>
    <groupId>cn.hutool</groupId>
    <artifactId>hutool-all</artifactId>
    <version>5.7.16</version>
</dependency>
<dependency>
    <groupId>org.bouncycastle</groupId>
    <artifactId>bcprov-jdk15to18</artifactId>
    <version>1.69</version>
</dependency>
```
application-xxx.yml
```yaml
nfp:
  tj:
    user-id: 物流交换代码 必须
    password: 密码 必须
    public-key: 公钥 必须
    base-url: 请求地址 默认生产地址（http://218.67.246.252:7999）
    timeout: 超时时间（连接+读取）（默认10秒）单位毫秒
    carrier: 网络货运经营者名称，(运单同步需要，配置后运单可不传自动设置)
    unified-social-credit-identifier: 统一社会信用代码，(运单同步需要，配置后运单可不传自动设置)
    permit-number: 道路运输经营许可证编号（网络货运经营者的道路运输经营许可证编号。）(运单同步需要，配置后运单可不传自动设置)
```