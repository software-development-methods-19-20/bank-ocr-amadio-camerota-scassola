package test.bankocr.parse;

import bankocr.kata.ClientPool;
import bankocr.kata.Entry;
import bankocr.kata.EntryReader;
import org.junit.jupiter.api.Test;
import test.bankocr.BankOcrAcceptanceTest;

import java.net.URL;
import java.nio.file.Path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ReadEntryTest {

    @Test
    void allZerosEntry() throws Exception {
        URL allZerosSingleEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("allZerosEntry");
        EntryReader reader = new EntryReader(Path.of(allZerosSingleEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.toString(), is(equalTo("000000000")));
    }

    @Test
    void allOnesEntry() throws Exception {
        URL allOnesSingleEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("allOnesEntry");
        EntryReader reader = new EntryReader(Path.of(allOnesSingleEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.toString(), is(equalTo("111111111")));
    }

    @Test
    void allNumbersTest() throws Exception {
        URL allNumbersTest = BankOcrAcceptanceTest.class.getClassLoader().getResource("allOneToNineDigitEntry");
        EntryReader reader = new EntryReader(Path.of(allNumbersTest.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.toString(), is(equalTo("123456789")));
    }

    @Test
    void multipleEntriesTest() throws Exception {

        URL allNumbersTest = BankOcrAcceptanceTest.class.getClassLoader().getResource("multipleEntries");
        EntryReader reader = new EntryReader(Path.of(allNumbersTest.toURI()));
        ClientPool clients = reader.readAllEntries();
        assertThat(clients.get(0).toString(), is(equalTo("200800000")));
        assertThat(clients.get(1).toString(), is(equalTo("999999999")));
    }


}
