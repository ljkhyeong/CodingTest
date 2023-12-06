import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine());

		int crossCount = 1, prevElementSum = 0;

		while (true) {
			if (X <= prevElementSum + crossCount) {
				if (crossCount % 2 == 1) {
					System.out.println((crossCount + 1) - (X - prevElementSum) + "/" + (X - prevElementSum));
					break;
				} else {
					System.out.println((X - prevElementSum) + "/" + ((crossCount + 1) - (X - prevElementSum)));
					break;
				}
			} else {
				prevElementSum += crossCount;
				crossCount++;
			}
		}
		
	}
}
