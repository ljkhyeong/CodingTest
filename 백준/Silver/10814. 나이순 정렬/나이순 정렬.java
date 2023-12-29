import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder[] sbs = new StringBuilder[201];

		for (int i = 0; i < sbs.length; i++) {
			sbs[i] = new StringBuilder();
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			sbs[age].append(age).append(' ').append(name).append('\n');
		}

		StringBuilder sb = new StringBuilder();
		for (StringBuilder s : sbs) {
			sb.append(s);
		}

		System.out.println(sb);
	}


}
