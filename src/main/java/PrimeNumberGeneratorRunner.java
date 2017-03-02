import java.io.*;
import java.util.List;

/**
 * Created by derek on 3/1/17.
 */
public class PrimeNumberGeneratorRunner {
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
        out.close();
    }

    private void getValues() throws IOException {
        out.write("Enter an integral range.\n".getBytes());
        getValue("Start: ");
        getValue("End: ");
    }

    private void getValue(String which) throws IOException {
        out.write(which.getBytes());
        String ans = reader.readLine();
        int value = Integer.parseInt(ans);
        if (which.equals("Start: ")) {
            start = value;
        } else {
            end = value;
        }
    }

    private void execute() throws IOException {
        List<Integer> result = png.generate(start, end);
        out.write(result.toString().getBytes());
        out.write("\n".getBytes());
    }

    private boolean ask() throws IOException {
        out.write("Continue generating primes?[Y/n] ".getBytes());
        String ans = reader.readLine();
        if (ans.equals("") || ans.equalsIgnoreCase("y")) {
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
