import java.util.*;
public class fourOct {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt(); 
            String[] input = new String[n];
            for (int i = 0; i < n; i++) {
                input[i] = sc.next();
            }
            for (int i = n - 1; i >= 0; i--) {
                System.out.print(input[i] + " ");
            }
    }
    }
}
