package wordcount;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

    /*--------------------------------------------------------------------------------------------*/
    public class Reducer 
        extends org.apache.hadoop.mapreduce.Reducer<Text, IntWritable, Text, IntWritable> {

        public void reduce(Text key, Iterator<IntWritable> values
                , org.apache.hadoop.mapreduce.Reducer.Context context) 
                throws IOException, InterruptedException {
            
            int sum = 0;
            
            while (values.hasNext()) {
                sum += values.next().get();
            }
            context.write(key, new IntWritable(sum));
        }
    }
    /*--------------------------------------------------------------------------------------------*/
