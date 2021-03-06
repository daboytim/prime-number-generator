import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by derek on 3/1/17.
 */
public class PrimeNumberGeneratorRunnerTest {
    private PrimeNumberGeneratorRunner underTest;
    private ClassLoader classLoader = ClassLoader.getSystemClassLoader();

    @Before
    public void setup() throws IOException {
        underTest = new PrimeNumberGeneratorRunner(new DereksPrimeNumberGenerator());
    }

    @Test
    public void shouldAcceptTwoIntegersAsInput() throws Exception {
        underTest.run(classLoader.getResourceAsStream("twoIntegerInput"), System.out);
    }

    @Test
    public void shouldPrintGeneratedPrimeNumbers() throws Exception {
        PipedInputStream outputReader = new PipedInputStream();
        underTest.run(classLoader.getResourceAsStream("twoIntegerInput"), new PipedOutputStream(outputReader));
        BufferedReader reader = new BufferedReader(new InputStreamReader(outputReader));
        StringBuffer result = new StringBuffer();
        while(reader.ready()) {
            result.append(reader.readLine());
        }
        assertThat(result.toString(), containsString("[7901, 7907, 7919]"));
    }

    @Test
    public void shouldAllowMultipleExecutions() throws Exception {
        underTest.run(classLoader.getResourceAsStream("multipleExecutionInput"), System.out);
    }

    @Test
    public void shouldHandleNonIntegerInput() throws Exception {
        PipedInputStream outputReader = new PipedInputStream();
        underTest.run(classLoader.getResourceAsStream("nonIntegerInput"), new PipedOutputStream(outputReader));
        BufferedReader reader = new BufferedReader(new InputStreamReader(outputReader));
        StringBuffer result = new StringBuffer();
        while(reader.ready()) {
            result.append(reader.readLine());
        }
        assertThat(result.toString(), containsString("is not a valid integer. Please try again."));
    }
}
