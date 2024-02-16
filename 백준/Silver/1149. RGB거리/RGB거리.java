import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][3];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dp[i][0] = Integer.parseInt(st.nextToken());
			dp[i][1] = Integer.parseInt(st.nextToken());
			dp[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i++) {
			dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]);
		}

		System.out.println(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));
	}



}
