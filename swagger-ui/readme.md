### Swagger-UI

Swagger3.0 官方 starter 诞生了，其它的都可以扔了~： https://jishuin.proginn.com/p/763bfbd31813

- pom.xml引入依赖
```$xslt
<!-- 引入Swagger3依赖 -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```

```$xslt
@Api：用在controller类，描述API接口
@ApiOperation：描述接口方法
@ApiModel：描述对象
@ApiModelProperty：描述对象属性
@ApiImplicitParams：描述接口参数
@ApiResponses：描述接口响应
@ApiIgnore：忽略接口方法
```
   