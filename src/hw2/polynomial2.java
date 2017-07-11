package hw2;

import java.util.ArrayList;

public class polynomial2 {
	private ArrayList<Term2> poly;

	public polynomial2() {
		poly = new ArrayList<Term2>();
	}

	public polynomial2(Term2 head) {
		poly = new ArrayList<Term2>();
		poly.add(head);
	}
	
	public void Add(Term2 a) {
		poly.add(a);
	}
	
	public int size(){
		return poly.size();
	}
	
	// 打印数组所有的元素
		public void printList() {
			System.out.print("[");
			int len = poly.size();
			for(int i=0;i<len;i++){
				int pow = poly.get(i).getpow();
				int fac = poly.get(i).getfac();
				System.out.print(fac + "*X^" + pow);
				if(i<len-1)
					System.out.print(" + ");
			}		
			System.out.println("]");
		}
		
	// 在数组找到最大pow
	public int MaxDegree() {
		int len = poly.size();
		int max = poly.get(0).getpow();
		for (int i = 1; i < len; i++) {
			int temp = poly.get(i).getpow();
			if (temp > max)
				max = temp;
		}
		return max;
	}
	
	// 在数组找到最小pow
		public int MinDegree() {
			int len = poly.size();
			int min = poly.get(0).getpow();
			for (int i = 1; i < len; i++) {
				int temp = poly.get(i).getpow();
				if (temp < min)
					min = temp;
			}
			return min;
		}

	// 在数组删除指定fac
	public void removefac(int num) {
		ArrayList<Term2> temp = new ArrayList<Term2>();
		int len = this.poly.size();
		for (int i = 0; i < len; i++) {
			Term2 loc = this.poly.get(i);
			if (loc.getfac() != num) {
				temp.add(loc);
			}
		}
		this.poly = temp;
	}

	// 在数组找到指定pow
	public Term2 lookPow(int pow) {
		int len = this.poly.size();
		Term2 temp = null;
		for (int i = 0; i < len; i++) {
			if (poly.get(i).getpow() == pow) {
				temp = poly.get(i);
				break;
			}
		}
		return temp;
	}

	// 加法
	public polynomial2 addPoly(polynomial2 b) {
		polynomial2 temp = new polynomial2();
		int Blen = b.size();
		for (int i = 0; i < Blen; i++) {
			Term2 loc = this.lookPow(b.poly.get(i).getpow());
			if (loc == null)
				temp.Add(b.poly.get(i));
			else {
				int fac1 = loc.getfac() + b.poly.get(i).getfac();
				temp.Add(new Term2(fac1, loc.getpow()));
			}
		}
		return temp;
	}

	// 减法
	public polynomial2 subPoly(polynomial2 b) {
		polynomial2 temp = new polynomial2();
		int Blen = b.size();
		for (int i = 0; i < Blen; i++) {
			Term2 loc = this.lookPow(b.poly.get(i).getpow());
			if (loc == null)
				temp.Add(b.poly.get(i));
			else {
				int fac1 = loc.getfac() - b.poly.get(i).getfac();
				temp.Add(new Term2(fac1, loc.getpow()));
			}
		}
		return temp;
	}

	// 乘法
	public polynomial2 mulPoly(polynomial2 b) {
		polynomial2 temp = new polynomial2();
		int Alen = this.size();
		int Blen = b.size();
		for (int i = 0; i < Blen; i++) {
			Term2 loc = b.poly.get(i);
			for (int j = 0; j < Alen; j++) {
				int fac = loc.getfac() * this.poly.get(j).getfac();
				int pow = loc.getpow() + this.poly.get(j).getpow();
				temp.Add(new Term2(fac, pow));
			}
		}
		return temp;
	}

	// 微分
	public polynomial2 diffPoly() {
		polynomial2 temp = new polynomial2();
		int len = this.size();
		for (int i = 0; i < len; i++) {
			Term2 loc = this.poly.get(i);
			int fac = loc.getfac() * loc.getpow();
			int pow = loc.getpow() - 1;
			temp.Add(new Term2(fac, pow));
		}
		temp.removefac(0);
		return temp;
	}
	
	// 排序化简
		public polynomial2 format() {
			int len = this.size();
			polynomial2 temp = new polynomial2();
			Term2 loc;
			int max = this.MaxDegree();
			int min = this.MinDegree();
			int tFac = 0;
			int tPow = max;
			int index;
			for (int i = 0; i < max - min + 1; i++) {
				tFac = 0;
				index=0;
				loc = this.poly.get(index);
				for (int j = 0; j < len; j++) {
					if (loc.getpow() == tPow) {
						tFac += loc.getfac();
					}
					if(j<len-1)
					index++;
					loc = this.poly.get(index);
				}
				temp.Add(new Term2(tFac, tPow));
				tPow -= 1;
			}
			temp.removefac(0);
			return temp;
		}
}

class Term2 {
	private int factor;
	private int power;

	public Term2() {
	}

	public Term2(int fac, int pow) {
		factor = fac;
		power = pow;
	}

	public void setpow(int num) {
		power = num;
	}

	public void setfac(int num) {
		factor = num;
	}

	public int getpow() {
		return power;
	}

	public int getfac() {
		return factor;
	}

}