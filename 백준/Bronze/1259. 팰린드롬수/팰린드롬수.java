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
		while (true) {
			String str = br.readLine();
			if (str.equals("0")) {
				break;
			}

			String check = "yes";

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
					check = "no";
				}
			}

			sb.append(check).append('\n');
		}

		System.out.println(sb);
	}

}
