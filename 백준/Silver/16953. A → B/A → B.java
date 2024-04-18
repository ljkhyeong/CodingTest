import java.io.*;
import java.util.*;

class Main {
    static class Pair {
        long value;
        int count;

        public Pair(long value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println(bfs(a, b));
    }

    static int bfs(long start, long end) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, 1));  // 처음 시작할 때 연산 횟수를 1로 설정

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            long curValue = current.value;
            int curCount = current.count;

            if (curValue == end) {
                return curCount;
            }

            // 2를 곱하는 연산
            long nextValue = curValue * 2;
            if (nextValue <= end) {
                queue.offer(new Pair(nextValue, curCount + 1));
            }

            // 1을 오른쪽에 추가하는 연산
            nextValue = curValue * 10 + 1;
            if (nextValue <= end) {
                queue.offer(new Pair(nextValue, curCount + 1));
            }
        }

        return -1;  // B로 만들 수 없는 경우
    }
}