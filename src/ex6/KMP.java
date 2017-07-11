package ex6;

public class KMP {
	
	//����һ��pһ�����ȵ�����
	public static int[] index(String p) {
		int m = p.length();
		int[] out = new int[m];
		for (int i = 0; i < m; i++) {
			out[i] = i;
		}
		return out;

	}
	
	//����Next����
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
			// ���磺
			// 1, 5 match; ���2, 6�Ƿ�match; ���ż��3, 7
			while (k >= 0 && pattern[k] != pattern[j]) {
				k = next[k];
			}
			j++;
			k++;
			next[j] = k;
		}
		return next;
	}
	
	//ƥ��ɹ�ʱ��������ģʽ��P��Ŀ�괮T�е���ʼ�±�
	public static int Match(String T, String P, int[] next) {
		char[] t = T.toCharArray();
		int tLen = T.length();
		char[] p = P.toCharArray();
		int pLen = P.length();
		
		int j = 0;//p�±�
		int i = 0;//t�±�
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
