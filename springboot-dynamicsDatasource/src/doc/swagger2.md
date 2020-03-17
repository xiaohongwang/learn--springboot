### 1、swagger2 ==  springfox-swagger == swagger和spring框架结合

#####  1、springBoot整合springfox-swagger
   
   - maven引入jar包
    
    ```
        <!--swagger2依赖 begin-->
        <dependency>
          <groupId>io.springfox</groupId>
          <artifactId>springfox-swagger2</artifactId>
          <version>2.2.2</version>
        </dependency>
        <dependency>
          <groupId>io.springfox</groupId>
          <artifactId>springfox-swagger-ui</artifactId>
          <version>2.2.2</version>
        </dependency>
       <!--swagger2依赖 end-->
    ```
   - 配置swagger2文件
   
    ```
    // spring加载
    @Configuration
    // 启用swagger2
    @EnableSwagger2
    public class Swagger2 {
        @Bean
        public Docket createRestApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()//ApiSelectorBuilder 控制那些接口暴露给swagger
                    .apis(RequestHandlerSelectors.basePackage("com.springboot.controller"))
                    .paths(PathSelectors.any())
                    .build();
        }
        /**
        * @Title:apiInfo
        * @Description: Api的基本信息
        * @author: wangxiaohong
        * @param: []
        * @return springfox.documentation.service.ApiInfo
        * @date: 10:17 2020-03-17
        * @version v1.0
        */
        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("Spring Boot中使用Swagger2构建RESTful APIs")
                    .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                    .termsOfServiceUrl("http://blog.didispace.com/")
                    .contact("程序猿DD")
                    .version("1.0")
                    .build();
        }
    }
    ```
#####  2、spring框架整合springfox-swagger
   - maven引入jar包
   
   ```
         <dependency>
   			<groupId>com.fasterxml.jackson.core</groupId>
   			<artifactId>jackson-core</artifactId>
   			<version>2.8.0</version>
   		</dependency>
   		<dependency>
   			<groupId>com.fasterxml.jackson.core</groupId>
   			<artifactId>jackson-databind</artifactId>
   			<version>2.6.3</version>
   		</dependency>
   		<dependency>
   			<groupId>com.fasterxml.jackson.core</groupId>
   			<artifactId>jackson-annotations</artifactId>
   			<version>2.6.3</version>
   		</dependency>
   
   		<!--Springfox-Swagger 依赖-->
   		<dependency>
   			<groupId>io.springfox</groupId>
   			<artifactId>springfox-swagger2</artifactId>
   			<version>2.6.1</version>
   		</dependency>
   		<dependency>
   			<groupId>io.springfox</groupId>
   			<artifactId>springfox-swagger-ui</artifactId>
   			<version>2.6.1</version>
   		</dependency>
   ```
   - 配置swagger2文件
   ```
   @Configuration
   @EnableSwagger2
   @EnableWebMvc
   @ComponentScan(basePackages = {"com.marknum.controller"})
   public class SwaggerConfig {
       @Bean
       public Docket customDocket() {
           return new Docket(DocumentationType.SWAGGER_2)
                   .apiInfo(apiInfo())
                   .select()
                   .apis(RequestHandlerSelectors.any())
                   .paths(PathSelectors.any())
                   .build();
       }
   
       private ApiInfo apiInfo() {
           Contact contact = new Contact("码牛产品研发中心", "", "");
           return new ApiInfoBuilder()
                   .title("项目实例演示")
                   .description("项目实例演示")
                   .contact(contact)
                   .version("1.1.0")
                   .build();
       }
   }

   ```
   - springmvc的xml文件配置
   ```
   	<!--swagger2 配置 begin-->
   	<bean class="com.marknum.config.SwaggerConfig"/>
   	<mvc:resources mapping="swagger-ui.html" location="classpath:/META-INF/resources/"/>
   	<mvc:resources mapping="/webjars/**" location="classpath:/META-INF/resources/webjars/"/>
   	<!--swagger2 配置 end-->
   ```
#####  3、spring ui访问地址 ip:port/项目context/swagger-ui.html

### 2、swagger2 注解使用@ApiOperation 接口说明
    
  |属性|解释|
  |:--------:|:------:|
  |value|接口描述|
  |notes|接口详细介绍|
  |httpMethod|接口请求方式|
  |produces|请求头 举例 application/json|
  
  ```
      @ApiOperation(value = "多数据源切换", notes = "测试多数元切换", httpMethod = "POST")

  ``` 
### 3、swagger2 注解使用@ApiImplicitParam 单个参数说明
  |属性|解释|
  |:--------:|:------:|
  |name|参数名|
  |value|用户详细实体user|
  |required|是否必要参数|
  |dataType|数据类型|
  
  ```
     @ApiOperation(value = "分页", notes = "测试分页插件", httpMethod = "POST")
     @ApiImplicitParam(name = "currentPage", value = "当前页码", required = true, dataType = "integer")
  ```
### 4、swagger2 注解使用@ApiImplicitParams 多个参数说明
    ```
    
    @ApiOperation(value = "分页", notes = "测试分页插件", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", required = true, dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "integer")

    }
    )
    ```
    
### 3、swagger2生产离线的接口文档  接口分组解决 TODO
