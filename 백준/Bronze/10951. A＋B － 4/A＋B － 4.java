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
		String str;
		while ((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			int ab = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			sb.append(ab).append('\n');
		}
		System.out.println(sb);

	}

}
