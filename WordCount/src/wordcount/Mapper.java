package wordcount;

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;


    public class Mapper extends org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, Text, IntWritable> {

        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        /*----------------------------------------------------------------------------------------*/
        public void map(LongWritable key, Text value, org.apache.hadoop.mapreduce.Reducer.Context context) 
                    throws IOException, InterruptedException {
            
            String line = value.toString();
            StringTokenizer tokenizer = new StringTokenizer(line);
            
            while (tokenizer.hasMoreTokens()) {
                word.set(tokenizer.nextToken());
                context.write(word, one);
            }
        }
        /*----------------------------------------------------------------------------------------*/
    }