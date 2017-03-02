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
public class ParameterizedIsPrimeTest {
    private PrimeNumberGenerator underTest;

    @Before
    public void setup() {
        underTest = new DereksPrimeNumberGenerator();
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
                {1, false},
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
