import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TestFileReader {
    BufferedReader reader;

    public TestFileReader() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader("src/test.txt"));
    }

    public List<Long> makeListReadingLineByLine() throws IOException {
        List<Long> res = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            res.add(Long.parseLong(line));
            line = reader.readLine();
        }
        reader.close();
        return res;
    }
}
