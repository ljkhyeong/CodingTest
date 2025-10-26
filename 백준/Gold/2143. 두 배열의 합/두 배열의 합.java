import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {

	static int[] A;
	static int[] B;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long T = Long.parseLong(br.readLine());
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		B = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		Map<Long, Integer> freq = new HashMap<>();

		for (int i = 0; i < N; i++) {
			long sum = 0;
			for (int j = i; j < N; j++) {
				sum += A[j];
				freq.merge(sum, 1, Integer::sum);
			}
		}

		long ans = 0;
		for (int i = 0; i < M; i++) {
			long sum = 0;
			for (int j = i; j < M; j++) {
				sum += B[j];
				long need = T - sum;
				Integer saved = freq.get(need);
				if (saved != null) {
					ans += saved;
				}
			}
		}

		System.out.println(ans);
	}



}

