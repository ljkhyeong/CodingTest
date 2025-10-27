import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {
	static int N, C;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int l = 0, r = arr[N - 1], ans = 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (can(mid)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		System.out.println(ans);
	}

	static boolean can(int d) {
		int cnt = 1;
		int last = arr[0];
		for (int i = 1; i < N; i++) {
			if (arr[i] - last >= d) {
				cnt++;
				last = arr[i];
			}
		}
		return cnt >= C;
	}



}

