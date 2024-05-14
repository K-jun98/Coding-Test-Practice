import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ16493 {
    static public void main(String[] args) {
        FastReader rd = new FastReader();

        int N = rd.nextInt(), M = rd.nextInt();
        int []days = new int[M + 1];
        int []pages = new int[M + 1];
        for(int i = 1; i <= M; ++i) {
            days[i] = rd.nextInt();
            pages[i] = rd.nextInt();
        }

        int []DP = new int[N + 1];
        int ans = 0;
        for(int k = 1; k <= M; ++k) {
            for(int i = N; i >= days[k]; --i) {
                DP[i] = Math.max(DP[i], DP[i - days[k]] + pages[k]);
                ans = Math.max(ans, DP[i]);
            }
        }
        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
