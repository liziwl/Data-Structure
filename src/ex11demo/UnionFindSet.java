package ex11demo;

import java.util.Scanner;

/*
 * ���鼯������˳������洢��ÿ�����洢������Ӧ�±�
 * �����ֵΪ��ֵ���������еȼ۽��ĸ���
 */
public class UnionFindSet {

	private int[] s = null;

	//��ʼ����ÿ�����ĸ��ڵ�ָ������Ϊ-1
	public UnionFindSet(int num) {
		s = new int[num+1];
		for (int i = 0; i < num; i++)
			s[i] = -1;
	}

	//���ϲ�
	public void union(int nodei, int nodej) {
		int rooti = find(nodei);
		int rootj = find(nodej);
		if (s[rooti] > s[rootj]){
			s[rootj] += s[rooti];
			s[rooti] = rootj;
		}
		else {
			s[rooti] += s[rootj];
			s[rootj] = rooti;
		}
	}

	//���ҵ�x�����ĸ����
	public int find(int x) {
		if (s[x] < 0)
			return x;
		else
			return find(s[x]);
	}
	
	
	public void printUF(){
		int n = 0;
		for(int i = 1; i < s.length; i++){
			if(s[i] < 0)
				n++;
			System.out.print(s[i]+" ");
		}
		System.out.println();
		System.out.println(n);
		for(int i = 1; i < s.length; i++){
			if(s[i] < 0){
				for(int j = 1; j < s.length; j++){
					if(find(j) == i)
						System.out.print(j + " ");
				}
				System.out.println();
			}
		}
	}
	
	/*  �������ݣ�
	 *  8						  	 
 		6							 
 		1 2 2 3 4 5 5 8 3 7 4 6
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); //������
		int friendNum = sc.nextInt();  //���Ѷ���
		
		UnionFindSet UF = new UnionFindSet(num);
		
		int friend1,friend2;
		for(int i = 0; i < friendNum; i++){
			friend1 = sc.nextInt();
			friend2 = sc.nextInt();
			System.out.println(friend1 + " " + friend2);
			UF.union(friend1, friend2);
		}
		UF.printUF();
	}
}
