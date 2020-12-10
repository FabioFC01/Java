public class QueueMain {
    public static void main (String [] args){
        //dichiarazione
        QueueByStacks codaFinta = new QueueByStacks();

        //aggiunta
        codaFinta.enqueue("1");
        codaFinta.enqueue("2");
        codaFinta.enqueue("3");
        codaFinta.enqueue("4");
        codaFinta.enqueue("5");
        codaFinta.enqueue("6");
        codaFinta.enqueue("7");
        
        //1 2 3 4 5 6 7

        System.out.println(codaFinta.dequeue()); //1
        System.out.println(codaFinta.dequeue()); //2
        

    }
}