package test.bankocr.parse;

import bankocr.kata.AccountNumberList;
import bankocr.kata.EntryReader;
import org.junit.jupiter.api.Test;
import test.bankocr.BankOcrAcceptanceTest;

import java.net.URL;
import java.nio.file.Path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class FuzzyMatchTest {
    @Test
    void distanceZeroFunctionTest() throws Exception {

        URL inputFileContent= BankOcrAcceptanceTest.class.getClassLoader().getResource("multipleEntries");//ButOneIsDucked");
        EntryReader reader = new EntryReader(Path.of(inputFileContent.toURI()));
        AccountNumberList clients = reader.readAllEntries();
        assertThat(clients.get(0).distance(), is(equalTo(0)));

    }

    @Test
    void distanceFunctionTest() throws Exception {

        URL inputFileContent= BankOcrAcceptanceTest.class.getClassLoader().getResource("multipleEntriesButOneIsDucked");//ButOneIsDucked");
        EntryReader reader = new EntryReader(Path.of(inputFileContent.toURI()));
        AccountNumberList clients = reader.readAllEntries();
        assertThat(clients.get(0).distance(), is(equalTo(1)));
        assertThat(clients.get(1).distance(), is(equalTo(1)));
    }
}
