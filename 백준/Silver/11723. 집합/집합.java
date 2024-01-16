import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		int result = 0;

		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (str.equals("all")) {
				result = (1 << 21) - 1;
			} else if (str.equals("empty")) {
				result = 0;
			} else {
				int i = Integer.parseInt(st.nextToken());
				if (str.equals("add")) {
					result |= (1 << i);
				} else if (str.equals("remove")) {
					result &= ~(1 << i);
				} else if (str.equals("check")) {
					sb.append((result & (1 << i)) != 0 ? 1 : 0).append('\n');
				} else if (str.equals("toggle")) {
					result ^= (1 << i);
				}
			}
		}
		System.out.println(sb);
	}


}
