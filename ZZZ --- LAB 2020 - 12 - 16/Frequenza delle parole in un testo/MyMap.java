public class MyMap implements Map {

    //classe privata
    private class Entry {
        private Object element;
        private Object key;

        public Entry (Object e, Object k){
            element = e;
            key = k;
        }

        public Entry () {
            this(null, null);
        }

        public Object getElement () {return element; }
        public Object getKey () {return key;}

        public void setElement (Object e) { element = e;}
        public void setkey (Object k) { key = k;}
    }
    // --- FINE CLASSE PRIVATA ENTRY ---

    //variabili di esemplare
    private Entry [] v;
    private int vSize;
    private static final int INITIAL_SIZE = 10;


    //costruttore
    public MyMap () {
        makeEmpty();
    }

    public void makeEmpty () {
        v = new Entry [INITIAL_SIZE];
        vSize = 0;
    }

    public int size () {
        return vSize;
    }

    public boolean isEmpty () { return vSize <= 0; }

    public Object get (Object key) {
        if (key == null) throw new IllegalArgumentException();
        for (int i = 0; i < vSize; i++) {       //cerca nell'array
            if (v[i].getKey().equals(key)){
                return v[i].getElement();
            }
        }
        return null;
    }

    public Object remove (Object key){
        if (key == null) throw new IllegalArgumentException();

        for (int i = 0; i < vSize; i++){
            if (v[i].getKey().equals(key)){
                Object ritorno = v[i].getElement();
                v[i] = v[vSize-1];  //prende il valore dell'ultimo
                v[vSize-1] = null;
                vSize--;
                return ritorno;
            }
        }

        return null;
    }

    public Object put (Object key, Object value) {
        if (key == null || value == null) throw new IllegalArgumentException();

        Object old = remove(key);
        if (vSize >= v.length){
            //ridimensionamento dinamico
            Entry [] newV  = new Entry [2 * v.length];
            System.arraycopy(v, 0, newV, 0, vSize);
            v = newV;
        }

        v[vSize++] = new Entry(value, key);

        return old;
    }

    public Object [] keys () {
        Object [] temp = new Object [vSize];
        for (int i = 0; i < vSize; i++){
            temp[i] = v[i].getKey();
        }
        return temp;
    }
}