import jdk.vm.ci.common.InitTimer;

public class MyVectorGenerics <E> implements Container  {
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
}