import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Sum_2 {
    public static void main(String[] args) {
        int[] a;
        int N = StdIn.readInt();
        int count=0;
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i]=StdIn.readInt();
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (a[i] + a[j] == 0) {
                    count++;
                }
            }
        }
        StdOut.println(count);
    }
}
