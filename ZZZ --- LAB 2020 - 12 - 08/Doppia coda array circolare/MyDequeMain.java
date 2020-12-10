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
        

        //System.out.println();

        
        System.out.println(doppiaCoda.getFirst()); //0
        System.out.println(doppiaCoda.getLast()); //2
        System.out.println(doppiaCoda.removeFirst()); //0
        System.out.println(doppiaCoda.getFirst()); //1
        System.out.println(doppiaCoda.size()); //2
        //1 2

        
        
        System.out.println();
        System.out.println("-------------");
        System.out.println();
        


        doppiaCoda.addLast("3");
        doppiaCoda.addLast("4");
        doppiaCoda.addLast("5");
        doppiaCoda.addLast("6");
        doppiaCoda.addLast("7");
        doppiaCoda.addLast("8");
        doppiaCoda.addLast("9");
        doppiaCoda.addLast("10");
        doppiaCoda.addLast("11");
        doppiaCoda.addLast("12");
        doppiaCoda.addLast("13"); //1 2 3 ... 12 13

        System.out.println(doppiaCoda.getFirst()); //1
        System.out.println(doppiaCoda.getLast()); //13
        System.out.println(doppiaCoda.removeFirst()); //1
        System.out.println(doppiaCoda.getFirst()); //2
        System.out.println(doppiaCoda.size()); //12
        //2 3 4 ... 12 13

        doppiaCoda.removeFirst(); //2
        doppiaCoda.removeFirst();
        doppiaCoda.removeFirst();
        doppiaCoda.removeFirst();
        doppiaCoda.removeFirst();
        doppiaCoda.removeFirst();
        doppiaCoda.removeFirst();
        doppiaCoda.removeFirst();
        doppiaCoda.removeFirst(); //10
        doppiaCoda.removeFirst();
        doppiaCoda.removeFirst(); //12
        
        System.out.println();
        System.out.println("-------------");
        System.out.println();
        //13
        System.out.println(doppiaCoda.getFirst()); //3
        System.out.println(doppiaCoda.getLast()); //13
        System.out.println(doppiaCoda.size()); //1

        System.out.println();
        System.out.println("-------------");
        System.out.println();

        doppiaCoda.removeFirst(); //13
        System.out.println(doppiaCoda.size()); //0

        doppiaCoda.addLast("1");
        System.out.println(doppiaCoda.getFirst()); //1
        System.out.println(doppiaCoda.getLast()); //1
        System.out.println(doppiaCoda.size()); //1

        //FUNZIONAAAAAA
        
    }
}