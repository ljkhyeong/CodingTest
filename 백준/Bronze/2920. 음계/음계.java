import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int first = Integer.parseInt(st.nextToken());
		String answer;

		if (first == 1) {
			answer = "ascending";
			for (int i = 2; i < 9; i++) {
				int next = Integer.parseInt(st.nextToken());
				if (next != i) {
					answer = "mixed";
					break;
				}
			}
		} else if (first == 8) {
			answer = "descending";
			for (int i = 7; i > 0; i--) {
				int next = Integer.parseInt(st.nextToken());
				if (next != i) {
					answer = "mixed";
					break;
				}
			}
		} else {
			answer = "mixed";
		}

		System.out.println(answer);
	}

}
