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
		computer = Integer.parseInt(br.readLine());
		linked = Integer.parseInt(br.readLine());

		infection = new boolean[computer+1];
		link = new boolean[computer + 1][computer + 1];


		for (int i = 0; i < linked; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			link[a][b] = link[b][a] = true;
		}

		dfs(1);

		System.out.println(count-1);
	}

	public static void dfs(int start) {
		infection[start] = true;
		count++;

		for (int i = 1; i <= computer; i++) {
			if (link[start][i] && !infection[i]) {
				dfs(i);
			}
		}
	}

}
