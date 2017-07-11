package hw2;

public class ployTest {
	public static void main(String[] args) {
		int Afac[] = { 4, -2, 5, 8, 9, 1 };
		int Apow[] = { 8, 6, 5, 2, 1, 0 };
		int Bfac[] = { -3, 7, 4, -9, 6 };
		int Bpow[] = { 7, 6, 3, 1, 0 };
		int Cfac[] = { 0, 0, 5, 0, 0, 0};
		int Cpow[] = { 8, 6, 5, 2, 1, 0 };

		polynomial A = new polynomial(new Term(3, 9));
		polynomial B = new polynomial(new Term(-2, 8));
		polynomial C = new polynomial();
		for (int i = 0; i < Afac.length; i++) {
			Term temp = new Term(Afac[i], Apow[i]);
			A.AddTerm(temp);
		}
		for (int i = 0; i < Bfac.length; i++) {
			Term temp = new Term(Bfac[i], Bpow[i]);
			B.AddTerm(temp);
		}
		for (int i = 0; i < Cfac.length; i++) {
			Term temp = new Term(Cfac[i], Cpow[i]);
			C.AddTerm(temp);
		}
		
		A.printLink();
		A.addPoly(B).printLink();
		A.mulPoly(B).printLink();
		A.mulPoly(B).format().printLink();
		A.diffPoly().printLink();
		System.out.println(A.maxPow());
		
		C.printLink();
		C.removefac(0);
		C.printLink();
	}
}
