package ex1;

public class arList_Test {

	public static void main(String[] args) {
		arList a = new arList();
		a.insertElement("a");
		a.insertElement("b");
		a.insertElement("c");
		a.insertElement("d");
		a.insertElement("e");

		long starTime1 = System.currentTimeMillis();
		for (int i = 0; i < 9000000; i++) {
			a.moveRight2(3);
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println(endTime1 - starTime1);

		a.printList();

		arList b = new arList();
		b.insertElement("a");
		b.insertElement("b");
		b.insertElement("c");
		b.insertElement("d");
		b.insertElement("e");

		long starTime2 = System.currentTimeMillis();
		for (int i = 0; i < 9000000; i++) {
			b.moveRight1(3);
		}
		long endTime2 = System.currentTimeMillis();
		System.out.println(endTime2 - starTime2);

		b.printList();
	}

}
