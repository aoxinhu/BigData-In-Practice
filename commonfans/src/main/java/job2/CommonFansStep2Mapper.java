package job2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @program: commonfans
 * @description:
 * @create: 2018-12-01 21:27
 **/
public class CommonFansStep2Mapper extends Mapper<LongWritable, Text, Text, Text> {
    // 上一个job所产生的数据是本次job读取的数据： B-C	A
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 将数据按制表符切分
        String[] split = value.toString().split("\t");
        // 将切出来的B-C用户对作为key，共同粉丝A作为value
        //===================================================================
        // ===== Mapper输出的是 K-V 对，K是可能重复的               ===========
        // ===== 后面 Reducer 拿到的是 K-list<V> 对， K是不重复的   ===========
        //===================================================================
        context.write(new Text(split[0]), new Text(split[1]));
    }
}
