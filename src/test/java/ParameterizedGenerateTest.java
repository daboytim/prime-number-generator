import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by derek on 3/1/17.
 */
@RunWith(Parameterized.class)
public class ParameterizedGenerateTest {
    private PrimeNumberGenerator underTest;

    @Before
    public void setup() {
        underTest = new DereksPrimeNumberGenerator();
    }

    @Parameterized.Parameter(value = 0)
    public int startingValue;
    @Parameterized.Parameter(value = 1)
    public int endingValue;
    @Parameterized.Parameter(value = 2)
    public int[] validPrimes;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {7900, 7920, new int[]{7901, 7907, 7919}},
                {0, 10, new int[]{1, 2, 3, 5, 7}},
                {1, 1, new int[]{1}},
                {4, 4, new int[]{}},
                {-5, -1, new int[]{}},
                {-5, 5, new int[]{1, 2, 3, 5}}
        });
    }

    @Test
    public void shouldReturnListOfPrimesByParameters() throws Exception {
        assertThat(underTest.generate(startingValue, endingValue).toArray(), equalTo(validPrimes));
    }
}
