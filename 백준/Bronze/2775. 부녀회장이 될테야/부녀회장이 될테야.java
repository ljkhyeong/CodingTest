import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int[][] apt = new int[15][15];

		makeApt(apt);

		while (T-- > 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(apt[k][n]).append('\n');
		}

		System.out.println(sb);
	}

	private static void makeApt(int[][] apt) {

		for (int i = 1; i < apt.length; i++) {
			apt[i][1] = 1;
			apt[0][i] = i;
		}

		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				apt[i][j] = apt[i-1][j] + apt[i][j-1];
			}
		}
	}

}
