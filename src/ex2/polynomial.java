package ex2;

import ex1.arList;

public class polynomial {
	private Term head = null;
	private Term tail = null;
	private Term pointer = null;

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
			System.out.print("(" + pointer.getfac() + "," + pointer.getpow() + ")" + "+");
			pointer = pointer.next();
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
			}
			temp = temp.next();
			pointer = pointer.next();
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
			}
			temp = temp.next();
			pointer = pointer.next();
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

	// 在链查找除指定fac
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

	// 加法
	public void addPoly(polynomial b) {
		int leng = b.getLength();
		Term key = b.head.next();
		for (int i = 0; i < leng; i++) {
			Term loc = this.lookPow(key.getpow());
			if (loc == null)
				this.AddTerm(new Term(key.getfac(), key.getpow()));
			else {
				loc.setfac(loc.getfac() + key.getfac());
			}
			key = key.next();
		}
		this.removefac(0);
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