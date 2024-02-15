import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			if (N > 32) {
				sb.append(0).append('\n');
				continue;
			}

			String[] MBTI = new String[N];

			for (int i = 0; i < N; i++) {
				MBTI[i] = st.nextToken();
			}

			int min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					for (int k = j + 1; k < N; k++) {
						if (min == 0) break;
						int count = 0;
						for (int l = 0; l < 4; l++) {
							count += MBTI[i].charAt(l) != MBTI[j].charAt(l) ? 1 : 0;
							count += MBTI[j].charAt(l) != MBTI[k].charAt(l) ? 1 : 0;
							count += MBTI[i].charAt(l) != MBTI[k].charAt(l) ? 1 : 0;
						}
						min = Math.min(min, count);
					}
				}
			}
			sb.append(min).append('\n');
		}

		System.out.println(sb);

	}



}
