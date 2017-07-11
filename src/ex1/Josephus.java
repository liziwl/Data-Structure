package ex1;

import java.util.Arrays;
import java.util.Scanner;

public class Josephus {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n;//������
		int m;//ÿ�ֳ��е��˵ı���
		int index=0;//ÿ�ֳ���������ţ����������±꣩
		System.out.print("��������������");
		n=input.nextInt();
		System.out.print("������ÿ�ֳ��е��˵ı���:");
		m=input.nextInt();
		
		int person[]=new int[n]; //ԭʼ��������
		int newPerson[]=new int[n];//�����˵�����
		for(int i=0;i<n;i++){
			person[i]=i+1;
		}
		System.out.println(Arrays.toString(person));
		
		//i Ϊʣ�������
		for(int i=n;i>1;i--){
			index+=m;//�ӵ�ǰλ�������m����
	
			if(i<index){//�����ǰ����������<������õ�����
				index=index%i;//����
				if(index==0){//������ñ�������˵�����Ƴ����������������һλ��
					index=i;
				}
			}
			newPerson[n-i]=person[index-1];//�����Ƴ����˷�������˵�����
			removeAt(person,index,i);//ִ���Ƴ�����
			index--;//�Ƴ��󣬵�ǰ���Ӧ��1
		}
		newPerson[n-1]=person[0];
		System.out.println(Arrays.toString(newPerson));
		input.close();
	}
	
	//����index�����Ƴ���index��������ǰ��
	public static void removeAt(int array[],int index,int curSize){
		for(int i=index;i<curSize;i++){
			array[i-1]=array[i];
			array[i]=0;
		}
		
	}
}
