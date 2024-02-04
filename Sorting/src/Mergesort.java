import java.util.*;

public class Mergesort {
    public static void main(String[] args) {
        Scanner ab = new Scanner(System.in);
        int n = ab.nextInt();
        int b[] = new int[n];
        for (int i = 0; i < n; i++)
            b[i] = ab.nextInt();
        mergesort(b, 0, n - 1);
        ab.close();
    }

    public static void mergesort(int b[], int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            mergesort(b, i, mid);
            mergesort(b, mid + 1, j);
            merge(b, i, mid, j);
        }
    }

    public static void merge(int b[], int lb, int mid, int ub) {
        int n1 = mid - lb + 1;
        int n2 = ub - mid;
        int l[] = new int[n1];
        int r[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            l[i] = b[lb + i];
        }
        for (int j = 0; j < n2; j++) {
            r[j] = b[mid + j + 1];
        }
        int i = 0, j = 0, k = lb;
        while (i < n1 && j < n2) {
            if (l[i] <= r[j]) {
                b[k] = l[i];
                i++;
            } else {
                b[k] = r[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            b[k] = l[i];
            i++;
            k++;
        }
        while (j < n2) {
            b[k] = r[j];
            k++;
            j++;
        }
    }
}
