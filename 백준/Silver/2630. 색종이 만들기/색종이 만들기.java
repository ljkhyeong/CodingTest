import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static int[] color = new int[2];
	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		partition(0, 0, N);

		sb.append(color[0]).append('\n').append(color[1]);
		System.out.println(sb);
	}

	public static void partition(int row, int col, int size) {

		if (colorCheck(row, col, size)) {
			return;
		}

		size /= 2;

		partition(row, col, size);
		partition(row, col+size, size);
		partition(row+size, col, size);
		partition(row+size, col+size, size);

	}

	public static boolean colorCheck(int row, int col, int size) {
		int temp = arr[row][col];
		for (int i = row; i < row+size; i++) {
			for (int j = col; j < col+size; j++) {
				if (temp != arr[i][j])
					return false;
			}
		}
		color[temp]++;
		return true;
	}

}
