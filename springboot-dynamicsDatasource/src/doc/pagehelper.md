## pagehelper
#### 1、引入jar包
```
    <!--mybatis分页插件-->
    <dependency>
      <groupId>com.github.pagehelper</groupId>
      <artifactId>pagehelper-spring-boot-starter</artifactId>
      <version>0.1.0</version>
    </dependency>
```
#### 2、配置pagehelper
```
@Configuration
public class PageHelperConfig {

    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");//多余的数据是否作为新的页
        properties.setProperty("rowBoundsWithCount","true");//读取总数
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}

or
application.yml中配置:
pagehelper:
  helperDialect: mysql
  reasonable: true
  supportMethodsArguments: true
  pageSizeZero: true
  params: count=countSql
```
#### 3、代码
```
@Override
    @DynamicSwitchDataSource(dataSource = "datasource1")
    public Object findUserList(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<SysUser> sysUsers =  sysUserMapper.selectAll();
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);
```