import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

	static int[] parent;
	static ArrayList<Integer>[] party;



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int[] truth_man = new int[k];

		for (int i = 0; i < k; i++) {
			truth_man[i] = Integer.parseInt(st.nextToken());
		}

		parent = new int[N + 1];
		party = new ArrayList[M];


		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int party_size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < party_size; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}

		}

		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			int first_man = party[i].get(0);
			for (int j = 1; j < party[i].size(); j++) {
				union(first_man, party[i].get(j));
			}
		}

		int count = 0;
		for (int i = 0; i < M; i++) {
			int leader = party[i].get(0);
			boolean flag = true;
			for (int j = 0; j < k; j++) {
				if (isSameGroup(leader, truth_man[j])) {
					flag = false;
					break;
				}
			}
			if (flag) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[b] = a;
		}
	}
	public static int find(int a) {
		if (parent[a] == a) {
			return a;
		} else {
			return parent[a] = find(parent[a]);
		}
	}

	public static boolean isSameGroup(int a, int b) {
		if (find(a) == find(b)) {
			return true;
		} else {
			return false;
		}
	}


}
