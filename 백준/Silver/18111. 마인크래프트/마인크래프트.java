import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{

	static int N, M, B;
	static int[][] arr;
	static int time = Integer.MAX_VALUE;
	static int height = 0;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		int max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}

		bruteForce(max);
		sb.append(time).append(' ').append(height);
		System.out.println(sb);
	}

	public static void bruteForce(int max) {

		for (int i = 0; i <=max; i++) {
			int[] result = leveling(i);

			if (result[0] < time) {
				time = result[0];
				height = result[1];
			} else if (result[0] == time && height < result[1]) {
				time = result[0];
				height = result[1];
			}
		}
	}

	public static int[] leveling(int height) {
		int block = B;
		int time = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int value = arr[i][j];

				if (value > height) {
					block += (value - height);
					time += 2 * (value - height);
				} else {
					block -= height - value;
					time += height - value;
				}
			}
		}

		if (block < 0) {
			return new int[] {99999999, height};
		}

		return new int[] {time, height};

	}


}
