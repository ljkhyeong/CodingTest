import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] wall = new int[W];
		int left = 0, right = W - 1;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			wall[i] = Integer.parseInt(st.nextToken());
		}

		int leftMax = wall[left], rightMax = wall[right];

		int totalWater = 0;
		while (left < right) {
			if (leftMax <= rightMax) {
				left++;

				if (wall[left] < leftMax) {
					totalWater += leftMax - wall[left];
				} else {
					leftMax = wall[left];
				}
			} else {
				right--;

				if (wall[right] < rightMax) {
					totalWater += rightMax - wall[right];
				} else {
					rightMax = wall[right];
				}
			}
		}

		System.out.println(totalWater);

	}

}

