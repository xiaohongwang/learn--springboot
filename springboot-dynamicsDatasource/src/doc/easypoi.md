[EasyPoi教程](http://easypoi.mydoc.io/#text_186900)

### 1. 提供功能
 + 1、基于注解导出、导入文件
 + 2、基于Map灵活定义表头信息，导出、导入文件
 + 3、支持模版导出
### 2. 注解
    注解方式采用实体和Excel的对应,每个实例model -- row（行数据）, 实体属性filed -- col（列信息）
   + @Excel 作用到filed上面,是对Excel一列的一个描述  属性注解
   + @ExcelCollection 表示一个集合,主要针对一对多的导出,比如一个老师对应多个科目,科目就可以用集合表示
   + @ExcelEntity 表示一个继续深入导出的实体,但他没有太多的实际意义,只是告诉系统这个对象里面同样有导出的字段
   + @ExcelIgnore 和名字一样表示这个字段被忽略跳过这个导导出
   + @ExcelTarget 这个是作用于最外层的对象,描述这个对象的id,以便支持一个对象可以针对不同导出做出不同处理  类注解
   
    @Excel

   |属性|类型|默认值|功能|
   |:--------:|:------:|:------:|:----:|
   |name|String|null|列名,支持name_id|
   |needMerge|boolean|fasle|是否需要纵向合并单元格(合并一对多时单个列的合并的)|
   |orderNum|String|"0"|列的排序|
   |replace|String[]|{}|值得替 ，可用于翻译中文    replace = {"男_1", "女_2"} 导出时，属性值为1，excel中输出男；|
   |isStatistics|boolean|fasle|自动统计数据,在追加一行统计,把所有数据都和输出|
   |format|String|""|时间格式 Date类型属性|
   |suffix|String|""|文字后缀|
   |mergeVertical|boolean|false|纵向合并内容相同的单元格|
   |isImportField|String|"false"|校验字段,看看这个字段是不是导入的Excel中有,如果没有说明是错误的Excel,读取失败|
   |type|int|1|导出类型 1 是文本; 2 是图片; 3 是函数; 10 是数字 默认是文本|
   |imageType|int|1|导出类型 1 从file读取 属性类型为String, 相对路径也可以用绝对路径; 2 是从数据库中读取  属性类型为byte[]  默认是文件 同样导入也是一样的||
   |savePath|String|"upload"|导入文件保存路径,如果是图片可以填写,默认是/excel/upload/img|
    
    
    @ExcelTarget
   
   |属性|类型|默认值|功能|
   |:--------:|:------:|:------:|:----:|
   |value|String|null|定义ID|
   
   ```
   //实体ID为major  name ,@Excel name支持name_中id,此时number对应列名为主讲教师编号
   @ExcelTarget(value = "major")
   public class Teacher {
       @Excel(name = "主讲教师编号_major,代课教师编号_absent", needMerge = true, orderNum = "1")
       private String number;
   ```
   
    ImportParams 参数
    
   ```
        /**
        * 表格标题行数,默认0
        */
       private int                 titleRows        = 0;
       /**
        * 表头行数,默认1
        */
       private int                 headRows         = 1;
       /**
        * 字段真正值和列标题之间的距离 默认0
        */
       private int                 startRows        = 0;
   
       /**
        * 主键设置,如何这个cell没有值,就跳过 或者认为这个是list的下面的值
        * 大家不理解，去掉这个
        */
   
       private Integer             keyIndex         = null;
       /**
        * 开始读取的sheet位置,默认为0
        */
       private int                 startSheetIndex  = 0;
       /**
        * 上传表格需要读取的sheet 数量,默认为1
        */
       private int                 sheetNum         = 1;
       /**
        * 是否需要保存上传的Excel,默认为false
        */
       private boolean             needSave         = false;
       /**
        * 校验组
        */
       private Class[]             verifyGroup = null;
       /**
        * 是否需要校验上传的Excel,默认为false
        */
       private boolean             needVerify = false;
       /**
        * 校验处理接口
        */
       private IExcelVerifyHandler verifyHandler;
       /**
        * 保存上传的Excel目录,默认是 如 TestEntity这个类保存路径就是
        * upload/excelUpload/Test/yyyyMMddHHmss_***** 保存名称上传时间_五位随机数
        */
       private String              saveUrl          = SAVE_URL;
       /**
        * 最后的无效行数
        */
       private int                 lastOfInvalidRow = 0;
       /**
        * 手动控制读取的行数
        */
       private int                 readRows = 0;
       /**
        * 导入时校验数据模板,是不是正确的Excel
        */
       private String[]            importFields;
       /**
        * 导入时校验excel的标题列顺序。依赖于importFields的配置顺序
       */
       private boolean             needCheckOrder = false;
       /**
        * Key-Value 读取标记,以这个为Key,后面一个Cell 为Value,多个改为ArrayList
        */
       private String              keyMark = ":";
       /**
        * 按照Key-Value 规则读取全局扫描Excel,但是跳过List读取范围提升性能
        * 仅仅支持titleRows + headRows + startRows 以及 lastOfInvalidRow
        */
       private boolean             readSingleCell = false;

  ```
### 3、ExcelExportEntity  等同于 @Excel

    @Excel注解的导出,规定必须把model写好,并且注解写好,每次导出的Excel都是固定的,无法动态控制导出的列
    ExcelExportEntity 支持更自由的导出,ExcelExportEntity是注解经过处理翻译成的实体类,两者几乎是一对的
    
```
    List<ExcelExportEntity> entity = new ArrayList<ExcelExportEntity>();
    ExcelExportEntity exportEntity = new ExcelExportEntity("组别", "group");
    exportEntity.setNeedMerge(true);
    entity.add(exportEntity);
    boolean isNeed = true;
    //  根据导出标志, 解决不同的excel需求
    if (isNeed){
        exportEntity = new ExcelExportEntity("组别名", "group_alias");
        entity.add(exportEntity);
    }

```

### 4、IExcelDataHandler 导入导出 自定义数据处理接口
```
//导入数据  CustomDataHandler 标题转换为对应的标识
ImportParams params = new ImportParams();
        params.setDataHandler(new CustomDataHandler());
```

### 5、导入excel校验

```实体属性注解```

   |属性|功能|
   |:--------:|:------:|
   |@Pattern(regexp = "", message = "")|正则表达式|
   |@Min(value = )|最小|
   |@Max(value = )|最大|
   |@NotNull|非空|