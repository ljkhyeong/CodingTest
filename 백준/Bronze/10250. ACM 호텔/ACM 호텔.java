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

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int room;

			if (N % H == 0) {
				room = (100 * H) + ((N - 1) / H + 1);
			} else {
				room = (100 * (N % H)) + ((N - 1) / H + 1);
			}

			sb.append(room).append('\n');
		}
		System.out.println(sb);

	}

}
