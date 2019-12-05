package test.bankocr.parse;

import bankocr.kata.ClientPool;
import bankocr.kata.EntryReader;
import org.junit.jupiter.api.Test;
import test.bankocr.BankOcrAcceptanceTest;

import java.io.FileNotFoundException;
import java.io.IOException;
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

        // read file
        // assert line
    }
}
