import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Sum_3 {
    static int slowCount(int[] a,int N) {
        int count=0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[k] + a[j] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static boolean binarySearch(int[] a, int N,int value) {
        int mid = 0;
        int left = 0, right = N - 1;
        while (left < right) {
            mid = (int) ((right + left) / 2);
            if (a[mid] == value) {
                return true;
            } else if (a[mid] > value) {
                right = mid-1;
            } else {
                left=mid+1;
            }
        }
        return false;
    }
    static int fastCount(int[] a,int N) {
        Arrays.sort(a);
        int count=0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (binarySearch(a, N, -a[i] - a[j])) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] a;
        int N = StdIn.readInt();
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i]=StdIn.readInt();
        }
        //O(n^3)
        StdOut.println(slowCount(a,N));
        //O(n^2log(n))
        StdOut.println(fastCount(a,N));
    }
}
