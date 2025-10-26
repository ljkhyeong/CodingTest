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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long S = Long.parseLong(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int length = Integer.MAX_VALUE, l = 0, r = 0, sum = 0;

		while (true) {
			if (sum >= S) {
				length = Math.min(length, r - l);
				sum -= arr[l++];
			}
			else {
				if (r ==N) break;
				sum += arr[r++];
			}
		}

		System.out.println(length == Integer.MAX_VALUE ? 0 : length);
	}



}

