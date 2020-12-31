//package mappaArray;

public class MyMap /*implements Map*/{
	
	public MyMap() {
		makeEmpty();
	}

	class Entry{
		private Object key;
		private Object value;
		
		public Entry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
		
		public Object getKey() {
			return key;
		}
		public void setKey(Object key) {
			this.key = key;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}		
	}
	
	private Entry[] a;
	private final static int INITIAL = 10;
	private int pSize;

	//@Override
	public boolean isEmpty() {
		return pSize == 0;
	}

	//@Override
	public void makeEmpty() {
		a = new Entry[INITIAL];
		pSize = 0;
	}

	//@Override
	public int size() {
		return pSize;
	}

	//@Override
	public Object get(Object key) {
		if (key == null) throw new IllegalStateException();
		for (int i = 0;i < pSize; i++) {
			if(a[i].getKey().equals(key)) {
				return a[i].getValue();
			}
		}
		return null;
	}

	//@Override
	public Object put(Object key, Object value) {
		if (key == null || value == null) throw new IllegalArgumentException();
		Object old = remove(key);
		if (pSize >= a.length) {
			Entry newA[] = new Entry[a.length * 2];
			System.arraycopy(a, 0, newA, 0, pSize);
			a = newA;
		}
		
		a[pSize++] = new Entry(key,value);
		return old;
	}

	//@Override
	public Object remove(Object key) {
		if (key == null) throw new IllegalArgumentException();
		for(int i = 0; i < pSize; i++){
			if (a[i].getKey().equals(key)){
				Object ob = a[i].getValue();
				a[i] = a[pSize-1];
				a[pSize-1] = null;
				pSize--;
				return ob;
			}
		}
		return null;
	}

	//@Override
	public Object[] keys() {
		Object[] tmp = new Object[pSize];
		for(int i = 0;i < pSize; i++) {
			tmp[i] = a[i].getKey();
		}
		return tmp;
	}

}
