package job1;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @program: commonfans
 * @description:
 * @create: 2018-12-01 20:55
 **/
public class CommonFansStep1Mapper extends Mapper<LongWritable, Text, Text, Text> {
    // 输入数据形式如：A:B,C,D,F,E,O
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 将所传入的一行数据按照冒号切分
        String[] splits = value.toString().split(":");
        // 得到数据中的用户
        String user = splits[0];
        // 得到粉丝
        String[] fans = splits[1].split(",");

        // === 将粉丝作为 key，用户作为value，得到  == 单个粉丝：粉丝关注的一个用户 ==
        // === 输出的一系列的 key-value , key是可能重复的 =====
        // === 后面会把 key 去重, 把同一个key的value合在一起 ======
        for (String fan : fans) {
            context.write(new Text(fan), new Text(user));
        }
    }
}
