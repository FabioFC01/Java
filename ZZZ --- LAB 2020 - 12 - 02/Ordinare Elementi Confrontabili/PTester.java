public class PTester
{
   public static void main(String[] args)
   {
      final int DIM = 10;
      
      P[] v = new P[DIM];     
      for(int i = 0; i < v.length; i++)
         v[i] = new P();
         
      System.out.println("***STAMPA ARRAY ORIGINARIO***");
      for (P e: v)
         System.out.print(e + " ");
      System.out.println();      
        
      // ordinamento dell'array v         
      Ordinamento.mergeSort(v);
      
      System.out.println("***STAMPA ARRAY ORDINATO***");
      for (P e: v)
         System.out.print(e + " ");
      System.out.println();      
   }
}