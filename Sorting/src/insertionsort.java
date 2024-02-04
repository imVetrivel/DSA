import java.util.*;

public class insertionsort {
    public static void main(String[] args) {
        Scanner ab = new Scanner(System.in);
        int n = ab.nextInt();
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = ab.nextInt();
        }
        int temp = 0;
        for (int i = 1; i < n; i++) {
            temp = b[i];
            int j = i - 1;
            while (j >= 0 && temp < b[j]) {
                b[j + 1] = b[j];
                j--;
            }
            b[j + 1] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(b[i]);
        }
        ab.close();
    }
}
