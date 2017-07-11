package hw1;

import java.util.Arrays;

public class time {
	/**
	 * Cubic maximum contiguous subsequence sum algorithm.
	 */
	public static int maxSubSum3(int[] a) {
		int maxSum = 0;

		for (int i = 0; i < a.length; i++)
			for (int j = i; j < a.length; j++) {
				int thisSum = 0;

				for (int k = i; k <= j; k++)
					thisSum += a[k];

				if (thisSum > maxSum)
					maxSum = thisSum;
			}

		return maxSum;
	}

	/**
	 * Quadratic maximum contiguous subsequence sum algorithm.
	 */
	public static int maxSubSum2(int[] a) {
		int maxSum = 0;

		for (int i = 0; i < a.length; i++) {
			int thisSum = 0;
			for (int j = i; j < a.length; j++) {
				thisSum += a[j];

				if (thisSum > maxSum)
					maxSum = thisSum;
			}
		}

		return maxSum;
	}

	/**
	 * Linear-time maximum contiguous subsequence sum algorithm.
	 */
	public static int maxSubSum1(int[] a) {
		int maxSum = 0, thisSum = 0;

		for (int j = 0; j < a.length; j++) {
			thisSum += a[j];

			if (thisSum > maxSum)
				maxSum = thisSum;
			else if (thisSum < 0)
				thisSum = 0;
		}

		return maxSum;
	}

	/**
	 * Recursive maximum contiguous subsequence sum algorithm. Finds maximum sum
	 * in subarray spanning a[left..right]. Does not attempt to maintain actual
	 * best sequence.
	 */
	private static int maxSumRec(int[] a, int left, int right) {
		if (left == right) // Base case
			if (a[left] > 0)
				return a[left];
			else
				return 0;

		int center = (left + right) / 2;
		int maxLeftSum = maxSumRec(a, left, center);
		int maxRightSum = maxSumRec(a, center + 1, right);

		int maxLeftBorderSum = 0, leftBorderSum = 0;
		for (int i = center; i >= left; i--) {
			leftBorderSum += a[i];
			if (leftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum = leftBorderSum;
		}

		int maxRightBorderSum = 0, rightBorderSum = 0;
		for (int i = center + 1; i <= right; i++) {
			rightBorderSum += a[i];
			if (rightBorderSum > maxRightBorderSum)
				maxRightBorderSum = rightBorderSum;
		}

		return Math.max(maxLeftSum, Math.max(maxRightSum, maxLeftBorderSum + maxRightBorderSum));
	}

	/**
	 * Driver for divide-and-conquer maximum contiguous subsequence sum
	 * algorithm.
	 */
	public static int maxSubSumN(int[] a) {
		return maxSumRec(a, 0, a.length - 1);
	}

	public static void timeTest(int times) {
		int test1[] = new int[times];
		for (int i = 0; i < times; i++) {
			test1[i] = (int) (Math.random() * 31) - 15;
		}
		//System.out.println(Arrays.toString(test1));
		int max3 = 0;
		int max2 = 0;
		int maxN = 0;
		int max1 = 0;
		//N^3时间复杂度
		long t31 = System.nanoTime();
		for (int i = 0; i < times; i++) {
			if(times>=10000)
				break;
			max3 = maxSubSum3(test1);
		}
		long t32 = System.nanoTime();
		long t3 = t32 - t31;
		//N^2时间复杂度
		long t21 = System.nanoTime();
		for (int i = 0; i < times; i++) {
			if(times>=10000)
				break;
			max2 = maxSubSum2(test1);
		}
		long t22 = System.nanoTime();
		long t2 = t22 - t21;
		//NlgN时间复杂度
		long tN1 = System.nanoTime();
		for (int i = 0; i < times; i++) {
			maxN = maxSubSumN(test1);
		}
		long tN2 = System.nanoTime();
		long tN = tN2 - tN1;
		//N时间复杂度
		long t11 = System.nanoTime();
		for (int i = 0; i < times; i++) {
			max1 = maxSubSum1(test1);
		}
		long t12 = System.nanoTime();
		long t1 = t12 - t11;

		System.out.printf("时间复杂度\t%s\t%s\t\n", "秒", "结果");
		System.out.printf("N^3\t%.4E\t%s\t\n", t3 * Math.pow(10, -9), max3);
		System.out.printf("N^2\t%.4E\t%s\t\n", t2 * Math.pow(10, -9), max2);
		System.out.printf("NlgN\t%.4E\t%s\t\n", tN * Math.pow(10, -9), maxN);
		System.out.printf("N^1\t%.4E\t%s\t\n", t1 * Math.pow(10, -9), max1);

	}

	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) {
			System.out.println("\n数组大小："+(int) Math.pow(10, i));
			timeTest((int) Math.pow(10, i));
		}
	}
}
