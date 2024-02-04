import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int k = Integer.parseInt(br.readLine());
			while (k-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char cal = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());

				if (cal=='I') {
					map.put(n, map.getOrDefault(n, 0) + 1);
				} else {
					if (map.size() == 0) {
						continue;
					}

					int key;
					if (n == 1) {
						key = map.lastKey();
					} else {
						key = map.firstKey();
					}

					int count = map.get(key);
					if (count == 1) {
						map.remove(key);
					} else {
						map.put(key, count - 1);
					}
				}

			}

			if (map.size() == 0) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
			}
		}

		System.out.println(sb);

	}

}
