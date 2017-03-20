import java.util.ArrayList;
import java.util.Collections;
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
        if (endingValue < 2) { //If the entire range is < the lowest prime number, return an empty list.
            return Collections.emptyList();
        }

        List<Integer> generatedPrimes = new ArrayList<>();

        for (int i = startingValue; i <= endingValue; i ++) {
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

        //We now know value is an odd number > 3 so we'll check for congruence with odd values between the lowest odd prime number (3) and sqrt(value).
        //It would be an optimization to only check congruence with prime numbers; we'll implement that later.
        for (int i = 3; i <= maxDivisor; i += 2) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
