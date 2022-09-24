import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @program: customizePartition
 * @description: 自定义分区，把各个部门的数据分发到各自的reduce task上
 * @create: 2018-12-02 16:50
 **/
public class JiduPartitioner<K, V> extends Partitioner<K, V> {

    /**
     * 自定义partition的数量需要和reduce task数量保持一致
     */
    @Override
    public int getPartition(K key, V value, int numPartitions) {
        String dname = key.toString().trim();
        int index = 4;
        switch (dname) {
            case "DevlopDepartment":
                index = 0;
                break;
            case "TestDepartment":
                index = 1;
                break;
            case "HardwareDepartment":
                index = 2;
                break;
            case "SaleDepartment":
                index = 3;
                break;
        }
        return index;
    }
}
