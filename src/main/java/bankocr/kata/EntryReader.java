package bankocr.kata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class EntryReader {

    private final BufferedReader bufferedReader;

    public EntryReader(Path filePath) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filePath.toFile());
        bufferedReader = new BufferedReader(fileReader);
    }

    public Entry newReadEntry() throws IOException {

        String line1, line2, line3;
        line1 = bufferedReader.readLine();
        line2 = bufferedReader.readLine();
        line3 = bufferedReader.readLine();

        if (line1 != null && line2 != null && line3 != null){

            Entry newEntry = new Entry(line1, line2,line3);
            bufferedReader.readLine();
            return newEntry;
        }

        return null;
    }

    public AccountNumberList readAllEntries() throws IOException{

        AccountNumberList clients = new AccountNumberList();
        Entry newEntry;
        while ((newEntry = newReadEntry()) != null)
            clients.add(newEntry);

        return clients;


    }

}
