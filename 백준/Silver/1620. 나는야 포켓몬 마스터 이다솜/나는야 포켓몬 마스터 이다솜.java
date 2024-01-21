import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> nameMap = new HashMap<>();
		Map<Integer, String> numMap = new HashMap<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			String pocketMon = br.readLine();
			numMap.put(i, pocketMon);
			nameMap.put(pocketMon, i);
		}


		while (M-- > 0) {
			String input = br.readLine();
			try {
				int i = Integer.parseInt(input);
				sb.append(numMap.get(i)).append('\n');
			} catch (NumberFormatException e) {
				sb.append(nameMap.get(input)).append('\n');
			}
		}

		System.out.println(sb);


	}




}
