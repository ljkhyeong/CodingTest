import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{

	static long[] dp = new long[101];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int N;
		StringBuilder sb = new StringBuilder();

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i < 101; i++) {
			dp[i] = -1;
		}

		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			sb.append(padovan(N)).append('\n');
		}

		System.out.println(sb);
	}

	static long padovan(int N) {
		if (dp[N] == -1) {
			dp[N] = padovan(N - 2) + padovan(N - 3);
		}
		return dp[N];
	}
}
