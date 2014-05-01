package wordcount;

import java.io.IOException;
import java.util.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;

/**
 * Big Data Analytics
 * Hadoop word count without deprecated API
 */
public class WordCount {

    /*--------------------------------------------------------------------------------------------*/
    public static void main(String[] args) throws Exception {
        
        Configuration conf = new Configuration();
        
        Job job = new Job(conf);
        job.setJarByClass(WordCount.class);
        job.setJobName("WordCountJob");
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
        job.setMapperClass(Mapper.class);
        
        job.setCombinerClass(Reducer.class);
        job.setReducerClass(Reducer.class);
        
        org.apache.hadoop.mapreduce.lib.input.FileInputFormat.addInputPath(job, new Path(args[0]));
        org.apache.hadoop.mapreduce.lib.output.FileOutputFormat.setOutputPath(job, new Path(args[1]));
        
        job.waitForCompletion(true);
        
    }
    /*--------------------------------------------------------------------------------------------*/

}
