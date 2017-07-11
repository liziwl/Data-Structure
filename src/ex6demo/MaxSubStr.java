package ex6demo;

public class MaxSubStr {

/*
 * Ѱ��str1��str2��Ӵ���
 * ��str1���� > str2���ȣ���len = str2.length(),����ȡstr2���г���
 * Ϊlen,len-1,len-2...�������Ӵ����ж��Ƿ������str1��,�״εõ��İ���
 * ��str1�е��Ӵ���Ϊ��Ӵ���
 *
 * ��str1���� <= str2���ȣ���len = str1.length(),����ȡstr1���г���
 * Ϊlen,len-1,len-2...�������Ӵ����ж��Ƿ������str2�У��״εõ��İ���
 * ��str2�е��Ӵ���Ϊ��Ӵ���
 */
	public static String  MaxSubStr(String str1, String str2){
		String str = "";
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		if (len1 > len2){
			for(int i = len2;  i > 0; i--)
				for(int j = 0; j <= len2-i; j++){
					str = str2.substring(j,j+i);
					KMP kmp = new KMP(str1, str);
					kmp.findNext();
					if(kmp.KMPStrMatch() >= 0){
						return str;
					}
				}
		}else{
			for(int i = len1;  i > 0; i--)
				for(int j = 0; j < len1-i; j++){
					str = str1.substring(j,j+i);
					KMP kmp = new KMP(str2, str);
					kmp.findNext();
					if(kmp.KMPStrMatch() >= 0)
						return str;
				}
		}
		
		return str;
	}
	
	public static void main(String[] args) {
		String s = MaxSubStr("errorcorrectingcodedistance","linearcodes");
		System.out.println(s);
	}

}
