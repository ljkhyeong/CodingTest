import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{

	static int[] dp = new int[11];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());


		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append('\n');
		}

		System.out.println(sb);
	}


}
