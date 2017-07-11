package hw2;

public class polynomial {
	private Term head = null;
	private Term tail = null;
	private Term pointer = null;

	public polynomial() {
		this.head = new Term();
		tail = head;
	}

	public polynomial(Term head) {
		this.head = new Term();
		this.head.LinkNext(head);
		tail = head;
	}

	// 在链表末尾添加节点
	public void AddTerm(Term node) {
		tail.LinkNext(node);
		tail = tail.next();
	}

	// 返回链表长度
	public int getLength() {
		pointer = head.next();
		int length = 0;
		while (pointer != null) {
			length += 1;
			pointer = pointer.next();
		}
		return length;
	}

	// 打印链表所有的元素
	public void printLink() {
		pointer = head.next();
		System.out.print("[");
		while (pointer != null) {
			System.out.print(pointer.getfac() + "*X^" + pointer.getpow());
			pointer = pointer.next();
			if (pointer != null)
				System.out.print(" + ");
		}
		System.out.println("]");
	}

	// 在链表指定位置插入节点
	public void insertAt(int index, Term node) {
		pointer = head;
		int key = 0;
		while (key != index - 1) {
			key += 1;
			pointer = pointer.next();
		}
		node.LinkNext(pointer.next());
		pointer.LinkNext(node);
	}

	// 在链表指定位置删除节点
	public void removeAt(int index) {
		pointer = head;
		int key = 0;
		while (key != index - 1) {
			key += 1;
			pointer = pointer.next();
		}
		pointer.LinkNext(pointer.next().next());
	}

	// 在链表删除指定pow
	public void removepPow(int num) {
		pointer = head.next();
		Term temp = head;
		while (pointer != null) {
			if (pointer.getpow() == num) {
				temp.LinkNext(temp.next().next());
				pointer = temp.next();
			} else {
				temp = temp.next();
				pointer = pointer.next();
			}
		}
	}

	// 在链表删除指定fac
	public void removefac(int num) {
		pointer = head.next();
		Term temp = head;
		while (pointer != null) {
			if (pointer.getfac() == num) {
				temp.LinkNext(temp.next().next());
				pointer = temp.next();
			} else {
				temp = temp.next();
				pointer = pointer.next();
			}
		}
	}

	// 在链表查找指定pow
	public Term lookPow(int num) {
		pointer = head.next();
		while (pointer != null) {
			if (pointer.getpow() == num) {
				break;
			}
			pointer = pointer.next();
		}
		return pointer;
	}

	// 在链查找出指定fac
	public Term lookfac(int num) {
		pointer = head.next();
		while (pointer != null) {
			if (pointer.getfac() == num) {
				break;
			}
			pointer = pointer.next();
		}
		return pointer;
	}

	// 在链表找到最大pow
	public int maxPow() {
		pointer = head.next();
		int max = pointer.getpow();
		while (pointer != null) {
			if (pointer.getpow() > max) {
				max = pointer.getpow();
			}
			pointer = pointer.next();
		}
		return max;
	}

	// 在链表找到最小pow
	public int minPow() {
		pointer = head.next();
		int min = pointer.getpow();
		while (pointer != null) {
			if (pointer.getpow() < min) {
				min = pointer.getpow();
			}
			pointer = pointer.next();
		}
		return min;
	}

	// 加法
	public polynomial addPoly(polynomial b) {
		polynomial temp = new polynomial();
		int leng = b.getLength();
		Term key = b.head.next();
		for (int i = 0; i < leng; i++) {
			Term loc = this.lookPow(key.getpow());
			if (loc == null)
				temp.AddTerm(new Term(key.getfac(), key.getpow()));
			else {
				int fac = loc.getfac() + key.getfac();
				temp.AddTerm(new Term(fac, loc.getpow()));
			}
			key = key.next();
		}
		temp.removefac(0);
		return temp;
	}

	// 减法
	public polynomial subPoly(polynomial b) {
		polynomial temp = new polynomial();
		int leng = b.getLength();
		Term key = b.head.next();
		for (int i = 0; i < leng; i++) {
			Term loc = this.lookPow(key.getpow());
			if (loc == null)
				temp.AddTerm(new Term(key.getfac(), key.getpow()));
			else {
				int fac = loc.getfac() - key.getfac();
				temp.AddTerm(new Term(fac, loc.getpow()));
			}
			key = key.next();
		}
		temp.removefac(0);
		return temp;
	}

	// 乘法
	public polynomial mulPoly(polynomial b) {
		polynomial temp = new polynomial();
		int aleng = this.getLength();
		int bleng = b.getLength();
		Term key = b.head.next();
		Term loc = this.head.next();
		for (int i = 0; i < bleng; i++) {
			loc = this.head.next();
			for (int j = 0; j < aleng; j++) {
				int fac = loc.getfac() * key.getfac();
				int pow = loc.getpow() + key.getpow();
				temp.AddTerm(new Term(fac, pow));
				loc = loc.next();
			}
			key = key.next();
		}
		temp.removefac(0);
		return temp;
	}

	// 微分
	public polynomial diffPoly() {
		polynomial temp = new polynomial();
		int leng = this.getLength();
		Term loc = this.head.next();
		for (int i = 0; i < leng; i++) {
			int fac = loc.getfac() * loc.getpow();
			int pow = loc.getpow() - 1;
			temp.AddTerm(new Term(fac, pow));
			loc = loc.next();
		}
		temp.removefac(0);
		return temp;
	}

	// 排序化简（MergeSort）
	public polynomial format() {
		int len = this.getLength();
		polynomial temp = new polynomial();
		Term loc = this.head.next();
		int max = this.maxPow();
		int min = this.minPow();
		int tFac = 0;
		int tPow = max;
		for (int i = 0; i < max - min + 1; i++) {
			tFac = 0;
			loc = this.head.next();
			for (int j = 0; j < len; j++) {
				if (loc.getpow() == tPow) {
					tFac += loc.getfac();
				}
				loc = loc.next();
			}
			temp.AddTerm(new Term(tFac, tPow));
			tPow -= 1;
		}
		temp.removefac(0);
		return temp;
	}

}

class Term {
	private int factor;
	private int power;
	private Term next;

	public Term() {
	}

	public Term(int fac, int pow) {
		factor = fac;
		power = pow;
	}

	public Term next() {
		return this.next;
	}

	public void LinkNext(Term next) {
		this.next = next;
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