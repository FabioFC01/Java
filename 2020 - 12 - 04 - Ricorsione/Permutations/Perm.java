public class Perm{
    public static int fattorialeIt (int n){
        if(n < 0){
            throw new IllegalArgumentException();
        }
        int ret = 1;
        for (int i = 1; i <= n; i++){
            ret *= i;
        }
        return ret;
    }

    public static String[] getPermutations(String word) {
        if (word == null) throw new IllegalArgumentException();
        if (word.length() < 2) return new String[]{word};
        int k = 0;
        //Numero di permutazioni di |s| = s!
        String[] permutations = new String[fattorialeIt(word.length())];
        for (int i = 0; i < word.length(); i++) {
            //il seguente comando toglie dalla parola una lettera per ciclo
			//RUM --> UM , RM , UM
                String shorterWord = word.substring(0, i) + word.substring(i + 1);

                String[] shorterWordPermutations = getPermutations(shorterWord);
                for (int j = 0; j < shorterWordPermutations.length; j++) {
                        permutations[k++] = word.charAt(i) + shorterWordPermutations[j];
                }
        }
        return permutations;
    }
    public static void main (String [] args){
        String [] perm = getPermutations("123");

        for(int i = 0; i < perm.length; i++){
            System.out.println(perm[i]);
        }

        boolean control;
        control = (perm.length == fattorialeIt(3));
        System.out.println(control);
    }
}