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

		String s = br.readLine().toUpperCase();
		int[] arr = new int[26];

		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 65]++;
		}

		int max = -1;
		char ch = '?';

		for (int i = 0; i < 26; i++) {
			if (arr[i] > max) {
				max = arr[i];
				ch = (char)(i + 65);
			} else if (arr[i] == max) {
				ch = '?';
			}
		}
		System.out.println(ch);

	}

}
