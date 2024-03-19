import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {





	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N + 1][K + 1];
		int[] wArr = new int[N + 1];
		int[] vArr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			wArr[i] = Integer.parseInt(st.nextToken());
			vArr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j - wArr[i] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wArr[i]] + vArr[i]);
				}
			}
		}

		System.out.println(dp[N][K]);
	}




}
