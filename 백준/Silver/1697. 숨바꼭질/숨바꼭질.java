import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static int[] check = new int[100001];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N == K) {
			System.out.println(0);
		} else {
			bfs(N, K);
		}

	}

	public static void bfs(int n, int dest) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		check[n] = 1;

		while (!queue.isEmpty()) {
			int temp = queue.poll();
			int nextN;
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					nextN = temp + 1;
				} else if (i == 1) {
					nextN = temp - 1;
				} else {
					nextN = temp * 2;
				}

				if (nextN == dest) {
					System.out.println(check[temp]);
					return;
				}

				if (nextN > 0 && nextN < check.length && check[nextN] == 0) {
					queue.offer(nextN);
					check[nextN] = check[temp] + 1;
				}
			}
		}
	}

}
