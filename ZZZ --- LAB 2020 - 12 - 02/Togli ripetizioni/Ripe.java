import java.util.Scanner;

public class Ripe{
    public static void main (String [] args){
        Scanner in = new Scanner (System.in);
        int [] v = new int [1];
        int vSize = 0;
        
        while (in.hasNext()){
            /*Scanner tok = new Scanner (in.nextLine());

            while (tok.hasNext()){
                    if(vSize >= v.length){
                        int [] newV = new int [2 * v.length];
                        System.arraycopy(v, 0, newV, 0, v.length);
                        v = newV;
                    }
                    //aggiunta
                    v[vSize++] = tok.nextInt();
            }
            tok.close();*/
            if(vSize >= v.length){
                int [] newV = new int [2 * v.length];
                System.arraycopy(v, 0, newV, 0, v.length);
                v = newV;
            }
            v[vSize++] = in.nextInt();
        }
        in.close();

        //compattamento array
        int [] newV = new int [vSize];
        System.arraycopy(v, 0, newV, 0, vSize);
        v = newV;

        System.out.println("ARRAY CON RIPETIZIONI DISORDINATO");
        for (int i = 0; i < v.length; i++){
            System.out.print(v[i] + "  ");
        }



        //Mergesort
        Mergesort(v);

        //Stampa
        //Array ordinato con ripetizioni
        System.out.println("ARRAY CON RIPETIZIONI ORDINATO");
        for (int i = 0; i < v.length; i++){
            System.out.print(v[i] + "  ");
        }

        //togli ripetizioni
      int i = 1;
      int j = 1;
      int cur = v[0];
      while(i < v.length) // O(n)
      {
         if (cur != v[i])
         {
            v[j] = v[i]; 
            cur = v[i];
            j++;
         }   
            
         i++;   
      }

	vSize = j;


        System.out.println("ARRAY SENZA RIPETIZIONI");
        for (i = 0; i < vSize; i++){
            System.out.print(v[i] + "  ");
        }
        


    }

    public static void Mergesort (int [] a){
        if (a.length < 2){
            return;
        }
        //tagliamo a metà
        int mid = a.length / 2;

        int [] l = new int[mid];
        int [] r = new int[a.length - mid];

        //copiatura
        System.arraycopy(a, 0, l, 0, mid);
        System.arraycopy(a, mid, r, 0, a.length - mid);
        //mid non mid+1 ricorda

        //ricorsione
        Mergesort(l);
        Mergesort(r);

        Merge(a, l, r);
    }

    public static void Merge (int [] a, int [] b, int [] c) {
        int ia = 0;
        int ib = 0;
        int ic = 0;

        while(ib < b.length && ic < c.length){
            if (b[ib] < c[ic]){
                a[ia++] = b[ib++];
            }
            else{
                a[ia++] = c[ic++];
            }
        }
        //un array ha finito
        while(ib < b.length){
            a[ia++] = b[ib++];
        }
        while(ic < c.length){
            a[ia++] = c[ic++];
        }
    }
}
