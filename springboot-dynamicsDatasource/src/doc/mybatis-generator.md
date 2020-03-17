### 1、mybatis通用mapper插件
 - maven依赖
    ```
        <!--mybatis通用mapper插件-->
          <plugin>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-maven-plugin</artifactId>
            <version>1.3.2</version>
            <configuration>
                <verbose>true</verbose>
                <overwrite>true</overwrite>
                <configurationFile>src/main/resources/generatorConfig.xml</configurationFile>
            </configuration>
        </plugin>
    ```
    
  - 在指定位置添加配置文件 generatorConfig.xml
      ```
        根据文档注释修改配置即可
      ```
  - 执行生成对应文件
    idea自带maven管理工具执行plugins