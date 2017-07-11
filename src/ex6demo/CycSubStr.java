package ex6demo;

public class CycSubStr {

	//×Ö·û´®ÓÒÒÆiÎ»
	public static String CycShift(String str, int i){
		return str.substring(str.length()-i,str.length())+ str.substring(0,str.length()-i);
	}

	//ÅĞ¶Ïstr1Ñ­»·ÓÒÒÆºóÊÇ·ñ°üº¬str2
	public static boolean SubStr(String str1, String str2){
		String tStr;
		for(int i = 0; i < str1.length()-1; i++){
			tStr = CycShift(str1, i);
			KMP kmp = new KMP(tStr, str2);
			kmp.findNext();
			if(kmp.KMPStrMatch() >= 0){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		boolean flag = SubStr("AABCD","CDAA");
//		boolean flag = SubStr("ABCD","ACBD");
		System.out.println(flag);
	}

}
