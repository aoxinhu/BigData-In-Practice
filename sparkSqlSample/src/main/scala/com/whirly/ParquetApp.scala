package com.whirly

import org.apache.spark.sql.SparkSession

/**
  * Parquet文件操作
  */
object ParquetApp {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("SparkSessionApp")
      .master("local[2]").getOrCreate()

    val path = args(0)
    
    // spark.read.format("parquet").load 这是标准写法
    val userDF = spark.read.format("parquet").load(path)

    userDF.printSchema()
    userDF.show()

    userDF.select("name","favorite_color").show

    userDF.select("name","favorite_color").write.format("json").save(args(1))

    spark.read.load(path).show
    
    //下面会报错，因为sparksql默认处理的format就是parquet
    //spark.read.load("file:///E:/bigdata-workstation/sparkSqlSample/data/people.json").show

    spark.read.format("parquet").option("path",path).load().show

    spark.stop()
  }
}
