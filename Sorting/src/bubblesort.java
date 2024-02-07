import java.util.*;

public class bubblesort {
    public static void main(String[] args) {
        Scanner ab = new Scanner(System.in);
        int n = ab.nextInt();
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = ab.nextInt();
        }
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (b[j] > b[j + 1]) {
                    temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
            }

        }
      System.out.println(Arrays.toString(b));
        ab.close();
    }
}