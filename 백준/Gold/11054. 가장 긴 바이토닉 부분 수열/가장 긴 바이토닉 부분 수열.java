import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;


class Main {

	static Integer[] i_dp;
	static Integer[] d_dp;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		i_dp = new Integer[n];
		d_dp = new Integer[n];
		seq = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			LIS(i);
			LDS(i);
		}

		int max = -1;
		for (int i = 0; i < n; i++) {
			max = Math.max(i_dp[i] + d_dp[i] - 1, max);
		}

		System.out.println(max);
	}

	static int LIS(int n) {
		if (i_dp[n] == null) {
			i_dp[n] = 1;

			for (int i = n - 1; i >= 0; i--) {
				if (seq[i] < seq[n]) {
					i_dp[n] = Math.max(i_dp[n], LIS(i)+1);
				}
			}
		}
		return i_dp[n];
	}

	static int LDS(int n) {
		if (d_dp[n] == null) {
			d_dp[n] = 1;

			for (int i = n + 1; i < d_dp.length; i++) {
				if (seq[i] < seq[n]) {
					d_dp[n] = Math.max(d_dp[n], LDS(i) + 1);
				}
			}
		}
		return d_dp[n];
	}



}
