public class MyVectorGenerics <E>  implements Container  {
    private static final int INITIAL_SIZE = 1;
    private Object dati [];
    private int aSize;

    MyVectorGenerics (){
        makeEmpty();
    }

    public void makeEmpty() {
        dati = new Object [INITIAL_SIZE];
        aSize = 0;
    }

    public boolean isEmpty () {
        return aSize == 0;
    }

    public int size () {
        return aSize;
    }

   public int capacity () {
       return dati.length;
   }

   public boolean contains (E e){
       //precondizioni
       if(e == null){
           return false;
       }
        for (int i = 0; i < aSize; i++){
            if (dati[i].equals(e)){
                return true;
            }
        }
        return false;
   }

   public E elementAt (int index) {
        //precondizioni
        if (index < 0 || index >= aSize){
            return null;
        }
        return (E)dati[index];
   }

   public int indexOf(E e) {
       if (e == null){
           return -1;
       }
       for (int i = 0; i < aSize; i++){
           if (((E)dati[i]).equals(e)){
               return i;
           }
       }
       return -1;
   }

   public E remove(int index) {
       //precondizioni
       if (index < 0 || index >= aSize){
        return null;
        }
        E temp = (E)dati[index];
        for (int i = index; i < aSize-1 ; i++){
            dati[i] = dati[i+1];
        }
        aSize--;
        return temp;
   }

   public E set(int index, E e) {
       //precondizioni
       if(index < 0 || index >= aSize){
           return null;
       }
       dati[index] = e;
       return (E)dati[index];
   }

   public Object[] toArray () {
       Object [] temp = new Object [aSize];
       for(int i = 0; i < aSize; i++){
           temp[i] = dati[i];
       }
       return temp;
   }

   public String toString () {
       String temp = "";
       for(int i = 0; i < aSize; i++){
            temp += (i+1) + "  :  " + dati[i] + "\n";
        }
        return temp;
   }

   public void add(int index, E e) {
       if (index < 0 || index > aSize ||e == null){
           return;
       }
       if (aSize >= dati.length){
           this.ridimensiona();
       }
       //spostamento
       for (int i = aSize; i > index; i--){
           dati[i] = dati[i-1];
       }
       dati[index] = (E)e;
       aSize++;
   }

   public void add (E e){
       add(aSize, e);
   }

   public void ridimensiona () {
       Object [] temp = new Object[2 *dati.length];
       for(int i = 0; i < aSize; i++){
        temp[i] = dati[i];
        }
        dati = temp;
   }


}
