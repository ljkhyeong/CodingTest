import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int[] counting = new int[10];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			counting[str.charAt(i)-'0']++;
		}

		for (int i = 9; i >= 0; i--) {
			while (counting[i]-- > 0) {
				sb.append(i);
			}
		}

		System.out.println(sb);
	}


}
