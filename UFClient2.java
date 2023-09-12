import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.QuickUnionUF;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class UFClient2 {
    static boolean check(QuickUnionUF uf,int N) {
        int root=uf.find(0);
        for (int i=0;i<N;i++) {
            if(uf.find(i)!=root) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int N = StdIn.readInt();
        int i=1;
        ArrayList<Integer> list = new ArrayList<>();
        QuickUnionUF uf = new QuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }
            if (check(uf,N)) {
                StdOut.println(i);
                return;
            }
            i++;
        }
        StdOut.println("False");
    }
}
