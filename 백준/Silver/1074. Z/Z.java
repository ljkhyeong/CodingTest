import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int result = 0;

		System.out.println(z(N,x,y,result));
	}

	public static int z(int N, int x, int y, int result) {

		if (N == 0) {
			return result;
		}

		int half = (int)Math.pow(2, N - 1);
		int quadrant = 0;

		if (x >= half && y >= half) {
			quadrant=3;
			x -= half;
			y -= half;
		} else if(x < half && y >= half) {
			quadrant = 2;
			y -= half;
		} else if(x >= half && y < half) {
			quadrant = 1;
			x -= half;
		} else quadrant = 0;

		int initNum = (int) Math.pow(4, N-1);
		result += (initNum * quadrant);

		return z(--N, x, y, result);
	}


}
