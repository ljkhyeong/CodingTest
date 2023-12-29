import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0 && c == 0) {
				break;
			}

			int max = Math.max(a, Math.max(b, c));

			if (max == a && max != b && max != c) {
				check(a, b, c, sb);
			} else if (max == b && max != a && max != c) {
				check(b, a, c, sb);
			} else if (max == c && max != a && max != b) {
				check(c, a, b, sb);
			}
		}

		System.out.println(sb);
	}

	static void check(int a, int b, int c, StringBuilder sb) {
		if (a * a == (b * b) + (c * c)) {
			sb.append("right").append('\n');
		} else {
			sb.append("wrong").append('\n');
		}
	}

}
