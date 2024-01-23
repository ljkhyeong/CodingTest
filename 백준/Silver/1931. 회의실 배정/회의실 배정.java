import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] reservation = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			reservation[i][0] = Integer.parseInt(st.nextToken());
			reservation[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(reservation, (a1, a2) -> {
			if (a1[1] == a2[1]) {
				return a1[0] - a2[0];
			}
			return a1[1] - a2[1];
		});

		int count = 0;
		int prev_time = 0;

		for (int i = 0; i < N; i++) {
			if (prev_time <= reservation[i][0]) {
				prev_time = reservation[i][1];
				count++;
			}
		}

		System.out.println(count);

	}


}
