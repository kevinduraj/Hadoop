
package invertedindex;

import invertedindex.LineIndexer.LineIndexMapper;
import java.io.IOException;
import org.apache.hadoop.mapred.Reporter;


public class InvertedIndex {

    public static void main(String[] args) throws IOException {
        
        LineIndexMapper mapper = new LineIndexMapper();
        mapper.map(null, null, null, Reporter.NULL);
        
        LineIndexReducer reducer = new LineIndexReducer();
        reducer.reduce(null, null, null, Reporter.NULL);

    }
    
}
