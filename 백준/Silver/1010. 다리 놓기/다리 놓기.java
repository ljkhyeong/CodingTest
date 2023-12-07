import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{

	static int[][] dp = new int[30][30];


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int N, M;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			sb.append(combination(M, N)).append('\n');
		}

		System.out.println(sb);
	}

	static int combination(int n, int r) {

		if (dp[n][r] > 0) {
			return dp[n][r];
		}

		if (n == r || r == 0) {
			return dp[n][r] = 1;
		}

		return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
	}
}
