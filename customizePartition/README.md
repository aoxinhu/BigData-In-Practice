## 自定义分区

> 实验来源：[hadoop MapReduce自定义分区partition的作用和用法](https://blog.csdn.net/wo198711203217/article/details/80621738)

把各个部门的数据分发到各自的reduce task上

```
hadoop fs -rm -r -skipTrash /hadoop/cus-partition/input 

hdfs dfs -mkdir -p /hadoop/cus-partition/input;
hdfs dfs -put C:/PROJECTS/BigData-In-Practice/customizePartition/data/input/jidu1.txt /hadoop/cus-partition/input;
hdfs dfs -put C:/PROJECTS/BigData-In-Practice/customizePartition/data/input/jidu2.txt /hadoop/cus-partition/input;
hdfs dfs -put C:/PROJECTS/BigData-In-Practice/customizePartition/data/input/jidu3.txt /hadoop/cus-partition/input;
hdfs dfs -put C:/PROJECTS/BigData-In-Practice/customizePartition/data/input/jidu4.txt /hadoop/cus-partition/input

# 运行
hadoop fs -rm -r -skipTrash /hadoop/cus-partition/output

hadoop jar customize-Partition-1.0-SNAPSHOT.jar JiduRunner /hadoop/cus-partition/input /hadoop/cus-partition/output

# 查看结果文件
hadoop dfs -ls /hadoop/cus-partition/output

hdfs dfs -cat /hadoop/cus-partition/output/part-r-00004
```


#### 测试数据

```$xslt
# cat jidu1.txt 
DevlopDepartment        100
TestDepartment        90
HardwareDepartment        92
SaleDepartment        200

# cat jidu2.txt 
DevlopDepartment        200
TestDepartment        93
HardwareDepartment        95
SaleDepartment        230

# cat jidu3.txt 
DevlopDepartment        202
TestDepartment        92
HardwareDepartment        94
SaleDepartment        231

# cat jidu4.txt 
DevlopDepartment        209
TestDepartment        98
HardwareDepartment        99
SaleDepartment        251
```

#### 结果汇总

```$xslt
DevlopDepartment	711
TestDepartment	373
HardwareDepartment	380
SaleDepartment	912
```

#### Hadoop 安全模式
```
hdfs dfsadmin -safemode get //查看状态
hdfs dfsadmin -safemode enter //进入安全模式
hdfs dfsadmin -safemode get //查看状态
hdfs dfsadmin -safemode leave //退出安全模式
hdfs dfsadmin -safemode get //查看安全模式
```