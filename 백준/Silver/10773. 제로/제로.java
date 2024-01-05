import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stack = new int[N];
		int size = 0;

		while (N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
				stack[size] = num;
				size++;
			} else {
				size--;
			}
		}

		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += stack[i];
		}

		System.out.println(sum);

	}


}
