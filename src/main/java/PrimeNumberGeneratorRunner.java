import java.io.*;
import java.util.List;

/**
 * Created by derek on 3/1/17.
 */
public class PrimeNumberGeneratorRunner {
    private static final String INPUT_PROMPT = "Enter an integral range.\n";
    private static final String START_PROMPT = "Start: ";
    private static final String END_PROMPT = "End: ";
    private static final String CONTINUE_PROMPT = "Continue generating primes?[Y/n] ";
    private static final String DEFAULT_ANSWER = "Y";
    private static final String NEW_LINE = "\n";
    private static final String EMPTY_STRING = "";

    private PrimeNumberGenerator png;
    private int start, end;
    private BufferedReader reader;
    private OutputStream out;

    public PrimeNumberGeneratorRunner(PrimeNumberGenerator png) {
        this.png = png;
    }

    public void run(InputStream in, OutputStream out) throws IOException {
        reader = new BufferedReader(new InputStreamReader(in));
        this.out = out;
        do {
            getValues();
            execute();
        } while (ask());
        in.close();
        if (out != System.out) {
            out.close();
        }
    }

    private void getValues() throws IOException {
        out.write(INPUT_PROMPT.getBytes());
        getValue(START_PROMPT);
        getValue(END_PROMPT);
    }

    private void getValue(String which) throws IOException {
        out.write(which.getBytes());
        String ans = reader.readLine();
        int value = Integer.parseInt(ans);
        if (which.equals(START_PROMPT)) {
            start = value;
        } else {
            end = value;
        }
    }

    private void execute() throws IOException {
        List<Integer> result = png.generate(start, end);
        out.write(result.toString().getBytes());
        out.write(NEW_LINE.getBytes());
    }

    private boolean ask() throws IOException {
        out.write(CONTINUE_PROMPT.getBytes());
        String ans = reader.readLine();
        if (ans.equals(EMPTY_STRING) || ans.equalsIgnoreCase(DEFAULT_ANSWER)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PrimeNumberGeneratorRunner runner = new PrimeNumberGeneratorRunner(new DereksPrimeNumberGenerator());
        try {
            runner.run(System.in, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
