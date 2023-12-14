import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main{

	public static boolean[] infection;
	public static boolean[][] link;
	public static int count = 0, computer, linked;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = 0;
		int N = Integer.parseInt(br.readLine());

		if (N == 4 || N == 7) {
			answer = -1;
		} else if (N % 5 == 0) {
			answer = N / 5;
		} else if (N % 5 == 1 || N % 5 == 3) {
			answer = N / 5 + 1;
		} else if (N % 5 == 2 || N % 5 == 4) {
			answer = N / 5 + 2;
		}

		System.out.println(answer);
	}

}
