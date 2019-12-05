package test.bankocr.parse;

import bankocr.kata.Entry;
import bankocr.kata.EntryReader;
import org.junit.jupiter.api.Test;
import test.bankocr.BankOcrAcceptanceTest;

import java.net.URL;
import java.nio.file.Path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WriteToFileTest {
    @Test
    public void checkOutputFile() throws Exception {
        URL allZerosSingleEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("allZerosEntry");
        EntryReader reader = new EntryReader(Path.of(allZerosSingleEntry.toURI()));
        ClientPool entryList = reader.fileParser();
        //write entryList to file
        assertThat(entry.toString(), is(equalTo("000000000")));

    }
}
