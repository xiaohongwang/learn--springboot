## 注解
    注解的本质：注解本质就是继承了Annotation接口的接口
    一个注解准确意义上来说，只不过是一种特殊的注释而已，如果没有解析它的代码，它可能连注释都不如
```
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}

//实质
public interface Override extends Annotation{}
```

1. 注解定义 关键字 @interface
2. 元注解：修饰注解的注解 一般用于指定某个注解生命周期以及作用目标等信息

|元注解|说明|
|:---:|:---:|
|@Target|注解的作用目标|
|@Retention|注解的生命周期|
|@Documented|注解是否应当被包含在 JavaDoc 文档中|
|@Inherited|是否允许子类继承该注解|
   - @Target 指明注解的作用目标 修饰类 修饰方法 修饰字段属性 @Target(value = {ElementType.})
  
  |值|说明|
  |:---:|:---:|
  |ElementType.TYPE|允许被修饰的注解作用在类、接口和枚举上|
  |ElementType.FIELD|允许作用在属性字段上|
  |ElementType.METHOD|允许作用在方法上|
  |ElementType.PARAMETER|允许作用在方法参数上|
  |ElementType.CONSTRUCTOR|允许作用在构造器上|
  |ElementType.LOCAL_VARIABLE|允许作用在本地局部变量上|
  |ElementType.ANNOTATION_TYPE|允许作用在注解上|
  |ElementType.PACKAGE|允许作用在包上|
  
   -  @Retention 用于指明当前注解的生命周期
   
   |值|说明|例子|
   |:---:|:---:|:---:|
   |RetentionPolicy.SOURCE|当前注解编译期可见，不会写入 class 文件|@Override|
   |RetentionPolicy.CLASS|类加载阶段丢弃，会写入class文件||
   |RetentionPolicy.RUNTIME|永久保存，可以反射获取|@Controller|