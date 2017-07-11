package hw2;

import java.util.Calendar;
import java.util.Iterator;

public class polynomial3<poly> implements Iterable<poly>{

	private static final int DEFAULT_CAPACITY=10;
	
	private int theSize;
	private poly [] theItems;
	
	public  polynomial3() {
		clear();
	}
	public void clear() {
		theSize=0;
		ensureCapcity(DEFAULT_CAPACITY);
	}
	public int size() {
		return theSize;
	}
	public boolean isEmpty(){
		return theSize==0;
	}
	public void trimToSize (){
		ensureCapcity(size());
	}
	public poly get(int idx) {
		if(idx<0||idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		return theItems[idx];
	}
	
	public poly set(int idx , poly newVal) {
		if(idx<0||idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		poly old = theItems[idx];
		theItems[idx]=newVal;
		return old;
	}
	//Î´Íê³É
	public void ensureCapcity(int newCapacity) {
		if (newCapacity<theSize ) 
			return;
		poly [] old =theItems;
		
	}
	@Override
	public Iterator<poly> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
