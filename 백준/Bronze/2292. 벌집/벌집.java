import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int count = 1;
		int min = 2;

		if (N == 1) {
			System.out.println(count);
		} else {
			while (N >= min) {
				min += 6 * count;
				count++;
			}
			System.out.println(count);
		}
	}



}
