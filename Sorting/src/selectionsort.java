import java.util.*;

public class selectionsort {
    public static void main(String[] args) {
        Scanner ab = new Scanner(System.in);
        int n = ab.nextInt();
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = ab.nextInt();
        }
        int minpos = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            minpos = i;
            for (int j = i + 1; j < n; j++) {
                if (b[minpos] > b[j]) {
                    minpos = j;
                }
            }
            temp = b[minpos];
            b[minpos] = b[i];
            b[i] = temp;
        }
        System.out.println(Arrays.toString(b));
        ab.close();
    }
}
