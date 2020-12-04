public class Reverse {
    public static String rev (String s){
        System.out.println(s);
        if (s == null) return null;
        if (s.length() < 2) return s;
        return rev(s.substring(1)) + s.charAt(0);
    }
    public static void main (String [] args){
        String nome = "ROMA";
        //System.out.println(nome.substring(1, 3)); //OM
        System.out.println(rev(nome));
    }
}
/*
ROMA
OMA
MA
A
AMOR
*/