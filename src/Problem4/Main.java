package Problem4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static Reader input = new Reader();

    public static void main(String[] args) {
        List<Integer> answer = new ArrayList<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            int answerCurrent = 1;
            boolean flag = false;
            for (int j = x; j <= y; j++) {
                int ostatok = j % 9;
                if (ostatok == 0) {
                    answerCurrent = 9;
                    flag = true;
                    break;

                } else {
                    answerCurrent *= ostatok;
                    if (answerCurrent % 9 == 0) {
                        answerCurrent = 9;
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                answer.add(9);
            } else {
                answer.add(answerCurrent % 9);
            }
        }
        for (Integer x : answer) {
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
