import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int count = 0, sol = 0;

		for (int i = 1; i < M - 1; i++) {
			if (str.charAt(i) == 'O' && str.charAt(i+1) == 'I') {
				count++;
				if (count == N) {
					if (str.charAt(i - (2 * count) + 1) == 'I') {
						sol++;
					}
					count--;
				}
				i++;
			} else {
				count = 0;
			}
		}

		System.out.println(sol);
	}	

}
