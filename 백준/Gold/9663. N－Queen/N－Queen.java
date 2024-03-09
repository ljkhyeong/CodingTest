import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static int[] arr;
	static int N, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		nQueen(0);
		System.out.println(count);
	}

	static void nQueen(int depth) {
		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			if (possible(depth)) {
				nQueen(depth+1);
			}
		}
	}

	static boolean possible(int row) {

		for (int i = 0; i < row; i++) {
			if (arr[i] == arr[row]) {
				return false;
			} else if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
				return false;
			}
		}
		return true;
	}



}
