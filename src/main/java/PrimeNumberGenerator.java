import java.util.List;

/**
 * Created by derek on 3/1/17.
 */
public interface PrimeNumberGenerator {
    List<Integer> generate(int startingValue, int endingValue);
    boolean isPrime(int value);
}
