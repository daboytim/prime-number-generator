import java.util.ArrayList;
import java.util.List;

/**
 * Created by derek on 3/1/17.
 */
public class DereksPrimeNumberGenerator implements PrimeNumberGenerator {
    @Override
    public List<Integer> generate(int startingValue, int endingValue) {
        List<Integer> generatedPrimes = new ArrayList<>();

        if (startingValue % 2 == 0) {
            startingValue++;
        }
        if (endingValue % 2 == 0) {
            endingValue--;
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
        return false;
    }
}
