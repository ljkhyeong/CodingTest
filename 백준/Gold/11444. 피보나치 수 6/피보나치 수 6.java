import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	final static int MOD = 1000000007;
	static long[][] origin = {{1, 1}, {1, 0}};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());

		long[][] answer = pow(origin, N-1);

		System.out.println(answer[0][0]);


	}

	static long[][] pow(long[][] A, long exp) {

		if (exp == 1L || exp == 0L) {
			return A;
		}

		long[][] ret = pow(A, exp / 2);

		ret = multiply(ret, ret);

		if (exp % 2 == 1L) {
			ret = multiply(ret, origin);
		}

		return ret;

	}

	static long[][] multiply(long[][] o1, long[][] o2) {

		long[][] result = new long[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					result[i][j] += o1[i][k] * o2[k][j];
					result[i][j] %= MOD;
				}
			}
		}

		return result;
	}



}
