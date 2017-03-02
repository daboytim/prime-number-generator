import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by derek on 3/1/17.
 */
@RunWith(value = Parameterized.class)
public class DereksPrimeNumberGeneratorTest {
    private static int startingValue = 7900;
    private static int endingValue = 7920;
    private static int[] validPrimes = {7901, 7907, 7919};

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
        assertThat(underTest.isPrime(7901), equalTo(true));
    }

    @Test
    public void shouldReturnFalseWhenValueIsNotPrime() throws Exception {
        assertThat(underTest.isPrime(7900), equalTo(false));
    }

    @Parameterized.Parameter(value = 0)
    public int value;
    @Parameterized.Parameter(value = 1)
    public boolean result;
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {-1, false},
                {0, false},
                {1, true},
                {2, true},
                {3, true},
                {4, false},
                {5, true},
                {9, false}
        });
    }

    @Test
    public void shouldReturnBooleanByParameters() throws Exception {
        assertThat(underTest.isPrime(value), equalTo(result));
    }
}
