import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i <= T; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            if (tokens.length < 6)
                continue;
            // System.out.println(Arrays.asList(tokens));
            int medalsC1 = Arrays.stream(Arrays.copyOfRange(tokens, 0, 3)).mapToInt(Integer::parseInt).sum();
            int medalsC2 = Arrays.stream(Arrays.copyOfRange(tokens, 3, 6)).mapToInt(Integer::parseInt).sum();
            System.out.println(medalsC1 > medalsC2 ? "1" : "2");
        }
        scanner.close();
    }
}
