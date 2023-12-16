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

		String str = br.readLine();

		for (int i = 0; i < 26; i++) {
			sb.append(str.indexOf(i + 97)).append(' ');
		}

		System.out.println(sb);

	}

}
