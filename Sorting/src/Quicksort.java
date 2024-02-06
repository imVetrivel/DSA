import java.util.*;

public class Quicksort {
    public static void main(String[] args) {
        Scanner ab = new Scanner(System.in);
        int n = ab.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = ab.nextInt();
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        ab.close();
    }

    public static void sort(int a[], int l, int r) {
        if (l < r) {
            int pivotpos = quick(a, l, r);
            sort(a, l, pivotpos - 1);
            sort(a, pivotpos + 1, r);
        }
    }

    public static int quick(int a[], int l, int r) {
        int start = l, end = r, pivot = a[l];
        while (start < end) {
            while ((start <= end) && (a[start] <= pivot)) {
                start++;
            }
            while ((start <= end) && (a[end] > pivot)) {
                end--;
            }
            if (start < end) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }
        int temp = a[end];
        a[end] = a[l];
        a[l] = temp;
        return end;
    }
}