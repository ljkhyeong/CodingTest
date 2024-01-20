import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{

	static int minNode = 1;
	static int INF = 100;
	static int[][] dp;
	static int[] numbers;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i!=j) dp[i][j] = INF;
			}
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());

			dp[start][dest] = 1;
			dp[dest][start] = 1;
		}

		floyd(N);

		numbers = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				numbers[i] += dp[i][j];
			}

			if (numbers[i] < numbers[minNode]) {
				minNode = i;
			}
		}

		System.out.println(minNode);
	}

	public static void floyd(int N) {
		for (int j = 1; j <= N; j++) {
			for (int i = 1; i <= N; i++) {
				for (int k = 1; k <= N; k++) {
					if (dp[i][k] > dp[i][j] + dp[j][k]) {
						dp[i][k] = dp[i][j] + dp[j][k];
					}
				}
			}
		}
	}



}
