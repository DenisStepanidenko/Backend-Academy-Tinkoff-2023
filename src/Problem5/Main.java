package Problem5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Main {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int[][] horses = new int[n][3];
        int[][][] dp = new int[n][100][100];

        for (int i = 0; i < n; i++) {
            String s = input.nextLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                horses[i][c - 'a']++;
            }
        }
        Arrays.sort(horses, (a, b) -> (a[0] + a[1] + a[2]) - (b[0] + b[1] + b[2]));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= horses[n - 1][0] + horses[n - 1][1] + horses[n - 1][2]; j++) {
                for (int k = 0; k <= horses[n - 1][0] + horses[n - 1][1] + horses[n - 1][2]; k++) {
                    if (i > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
                        if (j >= horses[i][0]) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - horses[i][0]][k] + horses[i][0] + horses[i][1]);
                        }
                        if (j >= horses[i][0] && k >= horses[i][1]) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - horses[i][0]][k - horses[i][1]] + horses[i][0] + horses[i][1] + horses[i][2]);
                        }
                    } else {
                        if (j >= horses[0][0]) {
                            dp[0][j][k] = Math.max(dp[0][j][k], horses[0][0] + horses[0][1]);
                        }
                        if (j >= horses[0][0] && k >= horses[0][1]) {
                            dp[0][j][k] = Math.max(dp[0][j][k], horses[0][0] + horses[0][1] + horses[0][2]);
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int j = 0; j <= horses[n - 1][0] + horses[n - 1][1] + horses[n - 1][2]; j++) {
            for (int k = 0; k <= j; k++) {
                ans = Math.max(ans, dp[n - 1][j][k]);
            }
        }
        System.out.println(ans);

    }


    static class Reader extends PrintWriter {

        private BufferedReader r;
        private StringTokenizer st;
        // standard input

        public Reader() {
            this(System.in, System.out);
        }

        public Reader(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input

        public Reader(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName));
        }

        // returns null if no more input
        String nextLine() {
            String str = "";
            try {
                str = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(r.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {

            return Long.parseLong(next());
        }
    }
}
