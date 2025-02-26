package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutImperial() throws Exception {
        assertThat(queryProcessor.process("Imperial"),
                containsString("university"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutMe() throws Exception {
        assertThat(queryProcessor.process("Zekun"), containsString("Yang"));
    }

    @Test
    public void knowsTeam() throws Exception {
        assertThat(queryProcessor.process("name"), containsString("Alpha"));
    }

    @Test
    public void knowsLargest() throws Exception {
        //1234 1236 2048
        assertThat(queryProcessor.process("which of the following numbers is the largest: 1234 2048 1235"), containsString("2048"));
    }

    @Test
    public void knowsWhatIs() throws Exception {
        assertThat(queryProcessor.process("what is 20 plus 15"), containsString("35"));
    }

    @Test
    public void knowsWhatIs2() throws Exception {
        assertThat(queryProcessor.process("what is 20 minus 15"), containsString("5"));
    }

    @Test
    public void knowsPrime() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers are primes: 2 6 9"), containsString("2"));
    }


}
