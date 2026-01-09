import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] liquid = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			liquid[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(liquid);

		int left = 0;
		int right = N - 1;
		long minDiff = Long.MAX_VALUE;
		long ans1 = 0, ans2 = 0;

		while (left < right) {
			long sum = liquid[left] + liquid[right];

			if (Math.abs(sum) < minDiff) {
				minDiff = Math.abs(sum);
				ans1 = liquid[left];
				ans2 = liquid[right];
			}

			if (sum < 0) {
				left++;
			} else if (sum > 0) {
				right--;
			} else {
				break;
			}
		}

		System.out.println(ans1 + " " + ans2);
	}

}

