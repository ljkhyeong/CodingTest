import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[10001];

		while (N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			count[num]++;
		}

		for (int i = 1; i < count.length; i++) {
			while (count[i] > 0) {
				sb.append(i).append('\n');
				count[i]--;
			}
		}

		System.out.println(sb);
	}


}
