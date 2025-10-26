import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int x = Integer.parseInt(br.readLine());

		int l = 0, r = N-1, cnt = 0;
		while (l < r) {
			int sum = arr[l] + arr[r];
			if (sum == x) {
				cnt++;
				l++; r--;
			}
			if (sum > x) {
				r--;
			}
			if (sum < x) {
				l++;
			}
		}

		System.out.println(cnt);
	}



}

