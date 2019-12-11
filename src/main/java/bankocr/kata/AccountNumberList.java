package bankocr.kata;

import java.io.*;
import java.util.ArrayList;

public class AccountNumberList extends ArrayList<Entry> {
    public void toFile(String outputFile, Boolean append) throws IOException {
        File file = new File(outputFile);
        FileWriter writer = new FileWriter(file, append);
        BufferedWriter buffer = new BufferedWriter(writer);

        for (Entry e : this) {
            buffer.write(e.toString()+"\n");
        }
        buffer.close();
        writer.close();
    }
}
