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

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int repeat = 0;

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			repeat = Integer.parseInt(st.nextToken());
			String s = st.nextToken();

			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < repeat; j++) {
					sb.append(s.charAt(i));
				}
			}
			sb.append('\n');
		}

		System.out.println(sb);

	}

}
