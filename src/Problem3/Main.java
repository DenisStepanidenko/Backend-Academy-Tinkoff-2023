package Problem3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int m = input.nextInt();
        int q = input.nextInt();
        int[][] arr = new int[n][m];
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = input.nextInt();
                arr[i][j] = x;
            }
        }
        System.out.println(Arrays.deepToString(arr));
        for (int i = 0; i < q; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            int k = input.nextInt();
            int answerCurrent = 0;
            for (int j = 0; j < m; j++) {
                if (Math.abs(arr[x-1][j] - arr[x-1][y-1]) <= k) {
                    //System.out.println(arr[x-1][j]);
                    answerCurrent++;
                }
            }
            for (int j = 0; j < n; j++) {
                if (Math.abs(arr[j][y-1] - arr[x-1][y-1]) <= k) {
                    //System.out.println(arr[j][y-1]);
                    answerCurrent++;
                }
            }
            answer.add(answerCurrent);
        }
        for(Integer x : answer){
            System.out.println(x);
        }
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
