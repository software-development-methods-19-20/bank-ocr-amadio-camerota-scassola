package test.bankocr.parse;

import bankocr.kata.ClientPool;
import bankocr.kata.Entry;
import bankocr.kata.EntryReader;
import org.junit.jupiter.api.Test;
import test.bankocr.BankOcrAcceptanceTest;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class FileWriteTest {
    @Test
    public void testWrite() throws URISyntaxException, IOException {
        //parse entry file
        URL allNumbersTest = BankOcrAcceptanceTest.class.getClassLoader().getResource("multipleEntries");

        EntryReader reader = new EntryReader(Path.of(allNumbersTest.toURI()));

        ClientPool clients = reader.readAllEntries();
        clients.toFile("outputFile", false);

        // verification of output file correctness
        File outputFile = new File ("outputFile");
        try {
            FileReader fileReader = new FileReader(outputFile);
            BufferedReader outputFileContent = new BufferedReader(fileReader);
            for (Entry e : clients) {
                assertThat(e.toString(), is(outputFileContent.readLine()));
            }
        } catch (NullPointerException e) {
            System.out.println("File non trovato");
        }

    }
}