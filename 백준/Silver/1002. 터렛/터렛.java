import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			System.out.println(searchMarine(x1, y1, r1, x2, y2, r2));
		}

	}

	static int searchMarine(int x1, int y1, int r1, int x2, int y2, int r2) {
		int distanceTwoFocus = (int)Math.pow(x2 - x1, 2) + (int)Math.pow(y2 - y1, 2);

		if (x1 == x2 && y1 == y2 && r1 == r2) {
			return -1;
		} else if (distanceTwoFocus > (int)Math.pow(r1 + r2, 2)) {
			return 0;
		} else if (distanceTwoFocus < (int)Math.pow(r2 - r1, 2)) {
			return 0;
		} else if (distanceTwoFocus == (int)Math.pow(r2 - r1, 2)) {
			return 1;
		} else if (distanceTwoFocus == (int)Math.pow(r1 + r2, 2)) {
			return 1;
		} else {
			return 2;
		}
	}

    }
