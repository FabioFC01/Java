public class Sub{
    public static void printSubstring (String s){
        if (s == null) throw new IllegalArgumentException();
        if (s.length() == 0) System.out.println(s);
        else{
            for (int i = 1; i <= s.length() ; i++){
                System.out.println(s.substring(0,i));		
            }
            System.out.println();
            printSubstring(s.substring(1));  //senza la prima lettera
            }
    }
    /*
    ---RUM---
    R
    UM
    RUM
    U
    UM
    M
    
    */
    public static void main (String [] args){
        String nome = "12345";
        printSubstring(nome);
    }
}
/*
1
12   
123  
1234 
12345
     
2    
23   
234  
2345 
     
3    
34   
345  
     
4    
45   

5
*/