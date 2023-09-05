
## Spark SQL 样例

环境
- Java： 1.8
- maven
- spark： 3.1.3
- Scala： 2.12.10

### HiveContextApp.scala
学习 HiveContext 的使用，对 Hive 进行增查join
```
spark-submit --class com.whirly.HiveContextApp --master spark://master:7077 sparkSql-sample-1.0-SNAPSHOT.jar file:///G:/dev/data/spark-sql-sample/people.txt file:///G:/dev/data/spark-sql-sample/peopleScore.txt

spark-submit --class com.whirly.HiveContextApp sparkSql-sample-1.0-SNAPSHOT.jar file:///G:/dev/data/spark-sql-sample/people.txt file:///G:/dev/data/spark-sql-sample/peopleScore.txt
```

### HiveMySQLApp
使用外部数据源综合查询Hive和MySQL的表数据
```

```

### SQLContext 的使用
```$xslt
spark-submit --class "com.whirly.SQLContextApp" sparkSql-sample-1.0-SNAPSHOT.jar file:///G:/dev/data/spark-sql-sample/people.json
```

### SparkSession 使用
打 Jar 包后，cmd提交到spark命令：
> 以下命令sparkSql-sample-1.0-SNAPSHOT.jar 默认在 C:\Users\aoxinhu
```$xslt
spark-submit --class "com.whirly.SparkSessionApp" sparkSql-sample-1.0-SNAPSHOT.jar file:///G:/dev/data/spark-sql-sample/people.json
```
> 指定具体sparkSql-sample-1.0-SNAPSHOT.jar路径
```$xslt
spark-submit --class "com.whirly.SparkSessionApp" file:///D:/sparkSql-sample-1.0-SNAPSHOT.jar file:///G:/dev/data/spark-sql-sample/people.json
```

### JDBC 连接 ThriftServer 进行查询
```
```


### DataFrame API基本操作 (DataFrameApp.scala)
```
spark-submit --class "com.whirly.DataFrameApp" sparkSql-sample-1.0-SNAPSHOT.jar file:///G:/dev/data/spark-sql-sample/people.json
```

### DataFrame和RDD的互操作
```
spark-submit --class "com.whirly.DataFrameRDDApp" sparkSql-sample-1.0-SNAPSHOT.jar
```

### Dataset操作
```
spark-submit --class "com.whirly.DatasetApp" sparkSql-sample-1.0-SNAPSHOT.jar file:///G:/dev/data/spark-sql-sample/people.csv
```

### Parquet文件操作
```
spark-submit --class "com.whirly.ParquetApp" sparkSql-sample-1.0-SNAPSHOT.jar file:///G:/dev/data/spark-sql-sample/users.parquet file:///G:/dev/data/spark-sql-sample/jsonout
```




## 作业部署

文档：http://spark.apachecn.org/#/docs/15

## 在 Windows 上本地运行

需要下载Hadoop和Spark，然后解压到某个路径下，在环境变量中配置 HADOOP_HOME 和 SPARK_HOME，然后下载 [winutils.exe](https://github.com/srccodes/hadoop-common-2.2.0-bin/tree/master/bin) 放到 ${HADOOP_HOME}/bin 下 


HiveContext 因为元数据存在MySQL中，所以启动时需要把MySQL驱动加入classpath路径中


spark-shell  spark-sql hive 操作
