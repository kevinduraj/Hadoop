package invertedindex;

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class LineIndexer {

  public static class LineIndexMapper extends MapReduceBase
                            implements Mapper<LongWritable, Text, Text, Text> {

    private final static Text word = new Text();
    private final static Text location = new Text();

    /*--------------------------------------------------------------------------------------------*/
    public void map(LongWritable key, Text val,
                        OutputCollector<Text, Text> output
                        , Reporter reporter)  throws IOException {

      FileSplit fileSplit = (FileSplit)reporter.getInputSplit();
      String fileName = fileSplit.getPath().getName();
      location.set(fileName);

      String line = val.toString();
      StringTokenizer itr = new StringTokenizer(line.toLowerCase());
      
      while (itr.hasMoreTokens()) {
        word.set(itr.nextToken());
        output.collect(word, location);
      }
      
    }
    /*--------------------------------------------------------------------------------------------*/
    
  }
}
