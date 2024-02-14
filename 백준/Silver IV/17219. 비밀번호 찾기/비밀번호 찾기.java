import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, String> map = new HashMap<>();

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			String str = br.readLine();
			sb.append(map.get(str)).append('\n');
		}

		System.out.println(sb);
	}


}
