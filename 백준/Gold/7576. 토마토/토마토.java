import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static int[][] arr;
	static int[] dm = {0, 0, 1, -1};
	static int[] dn = {-1, 1, 0, 0};
	static int result = 0;
	static int N,M;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < M; k++) {
				arr[j][k] = Integer.parseInt(st.nextToken());
				if (arr[j][k] == 1) {
					queue.add(new int[] {j, k});
				}
			}
		}


		bfs();


		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				if (arr[j][k] == 0) {
					System.out.println(-1);
					return;
				}
				result = Math.max(result, arr[j][k]);
			}
		}

		if (result == 1) {
			System.out.println(0);
		} else {
			System.out.println(result - 1);
		}

	}
	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextN = current[0] + dn[i];
				int nextM = current[1] + dm[i];

				if (nextN >= 0 && nextN < N && nextM >= 0 && nextM < M && arr[nextN][nextM]==0) {
					queue.add(new int[] { nextN, nextM});
					arr[nextN][nextM] = arr[current[0]][current[1]] + 1;
				}
			}
		}

	}
}
