import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {

	static int P = 1000000007;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		long N = 1, S = 0;
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			S = N * s + S * n;
			N *= n;
			S %= P;
			N %= P;
		}

		if (S % N != 0) {
			System.out.println((f(N, P - 2) * S) % P);
		} else {
			System.out.println(S / N);
		}
	}

	static long f(long N, int index) {
		if (index == 1) return N;
		long temp = f(N, index / 2);
		if (index % 2 == 1)
			return temp * temp % P * N % P;
		else
			return temp * temp % P;
	}


}

