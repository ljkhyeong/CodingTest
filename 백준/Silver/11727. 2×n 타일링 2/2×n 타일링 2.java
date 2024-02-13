import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static int[] dp = new int[1001];


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		dp[0] = dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007;
		}

		System.out.println(dp[n]);
	}


}
