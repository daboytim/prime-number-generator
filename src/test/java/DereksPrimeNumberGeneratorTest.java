import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by derek on 3/1/17.
 */
public class DereksPrimeNumberGeneratorTest {
    private static int startingValue = 7900;
    private static int endingValue = 7920;
    private static int[] validPrimes = {7901, 7907, 7919};
    private static int[] firstTwentySixPrimes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    private PrimeNumberGenerator underTest;

    @Before
    public void setup() {
        underTest = new DereksPrimeNumberGenerator();
    }

    @Test
    public void shouldGenerateFirstTwentySixPrimes() throws Exception {
        List<Integer> result = underTest.generate(2, 101);
        assertThat(result.toArray(), equalTo(firstTwentySixPrimes));
    }

    @Test
    public void shouldGenerateListOfPrimes() throws Exception {
        List<Integer> result = underTest.generate(startingValue, endingValue);
        assertThat(result.toArray(), equalTo(validPrimes));
    }

    @Test
    public void shouldReturnTrueWhenValueIsPrime() throws Exception {
        for (int i : validPrimes) {
            assertThat(underTest.isPrime(i), equalTo(true));
        }
    }

    @Test
    public void shouldReturnFalseWhenValueIsNotPrime() throws Exception {
        assertThat(underTest.isPrime(7900), equalTo(false));
    }
}
