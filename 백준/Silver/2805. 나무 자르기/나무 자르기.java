import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {


	static int[] arr;
	static int N, M;

	static int low, hi;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			hi = Math.max(hi, arr[i]);
		}
		
		upperbound();
	}

	static void upperbound() {


		while (low < hi) {
			int mid = low + ((hi - low) / 2);
			long sum = 0;

			for (int n : arr) {
				if (n - mid > 0) {
					sum += (n - mid);
				}
			}

			if (sum < M) {
				hi = mid;
			} else {
				low = mid + 1;
			}
		}
		System.out.println(low - 1);
	}






}
