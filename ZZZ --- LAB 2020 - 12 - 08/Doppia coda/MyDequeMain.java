public class MyDequeMain {
    public static void main (String [] args){
        //creazione
        MyDeque doppiaCoda = new MyDeque();
        doppiaCoda.addFirst("1");
        doppiaCoda.addLast("2"); //1 2
        doppiaCoda.addLast("3"); // 1 2 3
        doppiaCoda.addFirst("0"); // 0 1 2 3
        doppiaCoda.addFirst("-1"); //-1  0 1 2 3
        doppiaCoda.removeFirst(); // 0 1 2 3
        doppiaCoda.removeLast(); // 0 1 2
        doppiaCoda.removeLast(); // 0 1
        doppiaCoda.removeFirst(); //1
        doppiaCoda.addLast("2"); //1 2
        doppiaCoda.removeLast(); // 1
        

        //System.out.println();

        
        System.out.println(doppiaCoda.getFirst()); //1
        System.out.println(doppiaCoda.getLast()); //1
        System.out.println(doppiaCoda.size()); //1
        System.out.println(doppiaCoda.first); //4
        System.out.println(doppiaCoda.last);//5
        
    }
}