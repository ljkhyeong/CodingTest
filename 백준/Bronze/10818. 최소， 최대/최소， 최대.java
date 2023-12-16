import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		while (N-- > 0) {
			int i = Integer.parseInt(st.nextToken());
			min = Math.min(min, i);
			max = Math.max(max, i);
		}

		sb.append(min).append(' ').append(max);
		System.out.println(sb);

	}

}
