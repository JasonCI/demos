package xierwana.ft;

import java.util.Random;

public class Randomizer {

	private static Random random = new Random();

	/**
	 * 
	 * @param p
	 *            卷数
	 * @param m
	 *            单卷题数
	 * @param n
	 *            题库题目数
	 * @return  第一维度是试卷，第二维度是卷内试题编号
	 */
	public static int[][] randomize(int p, int m, int n) {
		// 前提, p <= n, m <= n.
		if (p > n) {
			throw new RuntimeException("Paper count should not be larger than items in the repository");
		}

		if (m > n) {
			throw new RuntimeException("Items in paper should not be larger than items in the repository");
		}

		int[][] a = new int[p][m];
		int total = p * m;

		int lcm = leastCommonMultiple(p, n);
		int[] permutation = toPermutation(n);

		for (int i = 0; i < total; i++) {
			int index = (i + i / lcm) % n;
			a[i % p][i / p] = permutation[index];
		}

		return a;

	}

	private static int leastCommonMultiple(int x, int y) {
		int m = x * y;
		for (int i = x > y ? x : y; i <= m; i++) {
			if (i % x == 0 && i % y == 0) {
				return i;
			}
		}
		return m;
	}

	private static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]);
				System.out.print(",");
			}
			System.out.println("");
		}
	}

	private static int[] toPermutation(int n) {

		int[] permutation = new int[n];
		for (int i = 0; i < n; i++) {
			permutation[i] = i;
		}

		for (int i = 0; i < n; i++) {
			permute(n, permutation);
		}

		return permutation;

	}

	private static void permute(int n, int[] permutation) {
		int a = Math.abs(random.nextInt()) % n;
		int b = Math.abs(random.nextInt()) % n;
		if (a != b) {
			int temp = permutation[a];
			permutation[a] = permutation[b];
			permutation[b] = temp;
		}
	}

	public static void main(String[] args) {
		// 3份卷子，每卷6题目，题库大小6
		int[][] s = randomize(3, 6, 6);
		print(s);
		System.out.println();

		// 5份卷子，每卷5题目，题库大小5
		s = randomize(5, 5, 5);
		print(s);
		System.out.println();

		// 3份卷子，每卷4题目，题库大小5
		s = randomize(3, 4, 5);
		print(s);
		System.out.println();

		// 10份卷子，每卷10题目，题库大小100
		s = randomize(10, 10, 100);
		print(s);
		System.out.println();

	}

}
