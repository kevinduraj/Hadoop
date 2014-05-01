package invertedindex;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class LineIndexReducer extends MapReduceBase
                    implements Reducer<Text, Text, Text, Text> {

    public void reduce(Text key, Iterator<Text> values,
                        OutputCollector<Text, Text> output, Reporter reporter)
                        throws IOException {

        boolean first = true;
        StringBuilder toReturn = new StringBuilder();
        
        while (values.hasNext()) {
            if (!first) {
                toReturn.append(", ");
            }
            first = false;
            toReturn.append(values.next().toString());
        }

        output.collect(key, new Text(toReturn.toString()));
    }
}
