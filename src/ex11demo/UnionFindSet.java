package ex11demo;

import java.util.Scanner;

/*
 * 并查集，采用顺序数组存储，每个结点存储父结点对应下标
 * 根结点值为负值，代表树中等价结点的个数
 */
public class UnionFindSet {

	private int[] s = null;

	//初始化，每个结点的父节点指针设置为-1
	public UnionFindSet(int num) {
		s = new int[num+1];
		for (int i = 0; i < num; i++)
			s[i] = -1;
	}

	//结点合并
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

	//查找第x个结点的父结点
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
	
	/*  测试数据：
	 *  8						  	 
 		6							 
 		1 2 2 3 4 5 5 8 3 7 4 6
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); //总人数
		int friendNum = sc.nextInt();  //朋友对数
		
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
