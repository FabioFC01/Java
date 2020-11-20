public class IsPalindrome {
    public static void main (String [] args){
        //declaration
        //non palindrome
        String a = "nonno";
        String b = "ABCA";
        String c = "ABBC";
        String d = "abbc";
        String e = "Ab";
        String f = "aBc";

        //palindrome
        String g = "AnnA";
        String h = "AbCbA";
        String i = "a";
        String l = "aa";

        //Null
        String m = null;

        System.out.println(a + "    " + IsPalindromeTest(a));
        System.out.println(b + "     " + IsPalindromeTest(b));
        System.out.println(c + "     " + IsPalindromeTest(c));
        System.out.println(d + "     " + IsPalindromeTest(d));
        System.out.println(e + "       " + IsPalindromeTest(e));
        System.out.println(f + "      " + IsPalindromeTest(f));
        System.out.println(g + "     " + IsPalindromeTest(g));
        System.out.println(h + "    " + IsPalindromeTest(h));
        System.out.println(i + "        " + IsPalindromeTest(i));
        System.out.println(l + "       " + IsPalindromeTest(l));
        System.out.println(m + "       " /*+ IsPalindromeTest(m)*/);

    }

    public static boolean IsPalindromeTest (String s) {        
        //eccezione
        if (s == null)
            throw new IllegalArgumentException();
        //ciclo
        for (int i = 0; i < (s.length()/2)+1; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}