package hw2;

public class ployTest2 {
	public static void main(String[] args) {
		int Afac[] = { 4, -2, 5, 8, 9, 1 };
		int Apow[] = { 8, 6, 5, 2, 1, 0 };
		int Bfac[] = { -3, 7, 4, -9, 6 };
		int Bpow[] = { 7, 6, 3, 1, 0 };
		int Cfac[] = { 0, 0, 5, 0, 0, 0};
		int Cpow[] = { 8, 6, 5, 2, 1, 0 };

		polynomial2 A = new polynomial2(new Term2(3, 9));
		polynomial2 B = new polynomial2(new Term2(-2, 8));
		polynomial2 C = new polynomial2();
		for (int i = 0; i < Afac.length; i++) {
			Term2 temp = new Term2(Afac[i], Apow[i]);
			A.Add(temp);
		}
		for (int i = 0; i < Bfac.length; i++) {
			Term2 temp = new Term2(Bfac[i], Bpow[i]);
			B.Add(temp);
		}
		for (int i = 0; i < Cfac.length; i++) {
			Term2 temp = new Term2(Cfac[i], Cpow[i]);
			C.Add(temp);
		}
		
		A.printList();
		A.addPoly(A).printList();
		A.mulPoly(A).printList();
		A.mulPoly(A).format().printList();
		A.diffPoly().printList();
		System.out.println(A.MaxDegree());
		
		C.printList();
		C.removefac(0);
		C.printList();
	}
}
