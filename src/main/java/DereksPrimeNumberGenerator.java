import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by derek on 3/1/17.
 */
public class DereksPrimeNumberGenerator implements PrimeNumberGenerator {
    @Override
    public List<Integer> generate(int startingValue, int endingValue) {
        if (startingValue > endingValue) {
            int tmp = startingValue;
            startingValue = endingValue;
            endingValue = tmp;
        }
        if (endingValue <= 0) {
            return Arrays.asList();
        }

        List<Integer> generatedPrimes;

        if (startingValue <= 2 && endingValue >= 2) {
            generatedPrimes = new ArrayList<>(Arrays.asList(2));
            startingValue = 3;
        } else {
            generatedPrimes = new ArrayList<>();
            if (startingValue % 2 == 0) {
                startingValue++;
            }
        }

        for (int i = startingValue; i <= endingValue; i += 2) {
            if (isPrime(i)) {
                generatedPrimes.add(i);
            }
        }

        return generatedPrimes;
    }

    @Override
    public boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        } else if (value <= 3) {
            return true;
        } else if (value % 2 == 0) {
            return false;
        }

        int maxDivisor = (int)Math.sqrt(value);

        for (int i = 3; i <= maxDivisor; i += 2) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
