package min;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @create: 2018-11-26 12:42
 **/
public class MinTemperatureReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int maxValue = Integer.MAX_VALUE;
        for (IntWritable value : values) {
            // 最小值
            maxValue = Math.min(maxValue, value.get());
        }
        context.write(key, new IntWritable(maxValue));

    }
}
