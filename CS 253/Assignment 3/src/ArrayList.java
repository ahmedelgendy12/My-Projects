
public class ArrayList <E> {
	private static final int CAPACITY = 16;
	private E[] data;
	private int size = 0;
	
	//Constructor
	public ArrayList() {
		this(CAPACITY);
	}
	public ArrayList(int capacity) {
		data =  (E[]) new Object[capacity];
	}
	//returns the size 
	public int size() {
		return size;
	}
	//checks if the arraylist is empty
	public boolean isEmpty() {
		return size() == 0;
	}
	// returns whats the value in i position
	public E get(int i) throws IndexOutOfBoundsException{
		checkIndex(i,size);
		return data[i];
	}
	// sets data in i position
	public E set(int i, E e) throws IndexOutOfBoundsException{
		checkIndex(i,size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}
	// adds data at i position and moves everything down the array
	public void add(int i, E e) throws IndexOutOfBoundsException{
		checkIndex(i,size+1);
		for (int k = size - 1; k >= i; k--) {
			data[k + 1] = data[k];
			data[i] = e; 
			size++;
		}
	}
	//Check if index is less than zero and or bigger than the size and throws an exception
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
		if (i < 0 || i >= n) {
			throw new IndexOutOfBoundsException("Illegal Entry At: " + i);
		}
		
	}
}
	
