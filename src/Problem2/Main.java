package Problem2;

import java.io.*;
import java.util.*;

public class Main {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int m = input.nextInt();
        Queue<Integer> current = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = input.nextInt();
            if (x == 1) {
                int y = input.nextInt();
                current.offer(y);
            } else if (x == 2) {
                Queue<Integer> currentNew = new LinkedList<>();
                int k = current.size();
                for (int j = 0; j < k; j++) {
                    int p = current.poll();
                    currentNew.offer(p);
                    currentNew.offer(p);
                }
                current = currentNew;
            } else {
                answer.add(current.remove());
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
