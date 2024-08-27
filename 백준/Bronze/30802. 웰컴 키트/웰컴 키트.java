import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] tShirt = new int[6];
		for (int i = 0; i < 6; i++) {
			tShirt[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int answer1 = 0;

		for (int i = 0; i < 6; i++) {
			answer1 += (tShirt[i]+T-1) / T;
		}
		int answer2= n/P;
		int answer3= n%P;

		sb.append(answer1).append('\n');
		sb.append(answer2).append(' ').append(answer3);
		System.out.println(sb);


	}



}

