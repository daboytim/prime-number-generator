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
    private static int[] invalidPrimes = {-2, 4, 10, 9, 15, 21};

    private PrimeNumberGenerator underTest;

    @Before
    public void setup() {
        underTest = new DereksPrimeNumberGenerator();
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
        for (int i : invalidPrimes) {
            assertThat(underTest.isPrime(i), equalTo(false));
        }
    }
}
