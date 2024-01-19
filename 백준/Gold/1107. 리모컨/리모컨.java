import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		boolean[] broken = new boolean[10];

		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (M-- > 0) {
				int i = Integer.parseInt(st.nextToken());
				broken[i] = true;
			}
		}

		int result = Math.abs(100 - N);

		for (int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);
			int length = str.length();

			boolean isBreak = false;

			for (int j = 0; j < length; j++) {
				if (broken[str.charAt(j) - '0']) {
					isBreak=true;
					break;
				}
			}
			if (!isBreak) {
				int result2 = length + Math.abs(i - N);
				result = Math.min(result, result2);
			}
		}

		System.out.println(result);
	}



}
