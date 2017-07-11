package ex6;

public class KMP {
	
	//返回一个p一样长度的索引
	public static int[] index(String p) {
		int m = p.length();
		int[] out = new int[m];
		for (int i = 0; i < m; i++) {
			out[i] = i;
		}
		return out;

	}
	
	//构建Next数组
	public static int[] findNext(String p) {
		char[] pattern = p.toCharArray();
		int j, k;
		int m = p.length();

		assert (m > 0);

		int[] next = new int[m];
		next[0] = -1;
		j = 0;
		k = -1;
		while (j < m - 1) {
			// 例如：
			// 1, 5 match; 检查2, 6是否match; 接着检查3, 7
			while (k >= 0 && pattern[k] != pattern[j]) {
				k = next[k];
			}
			j++;
			k++;
			next[j] = k;
		}
		return next;
	}
	
	//匹配成功时，返回是模式串P在目标串T中的起始下标
	public static int Match(String T, String P, int[] next) {
		char[] t = T.toCharArray();
		int tLen = T.length();
		char[] p = P.toCharArray();
		int pLen = P.length();
		
		int j = 0;//p下标
		int i = 0;//t下标
		if (tLen < pLen)
			return -1;
		while (j < pLen && i < tLen) {
			if (j == -1 || t[i] == p[j]) {
				i++;
				j++;
			} else
				j = next[j];
		}
		if (j >= pLen)
			return (i - pLen);
		else
			return -1;

	}

	public static void FormatPrint(int[] obj) {
		for (int i = 0; i < obj.length; i++) {
			System.out.printf("%3s", obj[i]);
			if (i != obj.length - 1) {
				System.out.print(", ");
			} else
				System.out.println();
		}
	}

	public static void FormatPrint(char[] obj) {
		for (int i = 0; i < obj.length; i++) {
			System.out.printf("%3s", obj[i]);
			if (i != obj.length - 1) {
				System.out.print(", ");
			} else
				System.out.println();
		}
	}

	public static void main(String[] args) {
		String a = "PARTICPARIPATEINPARACHUTE";
		FormatPrint(index(a));
		FormatPrint(a.toCharArray());
		FormatPrint(findNext(a));
		String p="RIPATE";
		System.out.println(Match(a, p, findNext(p)));

	}
}
