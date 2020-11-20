public class MaxSottostringa {
    private String par1;
    private String par2;
    private int contatore;

    public MaxSottostringa (String unaPar1, String unaPar2){
        par1 = unaPar1;
        par2 = unaPar2;
        contatore = 0;
    }

    public String Calcolo () {
        //declaration
        String parola = "";
        String lunga = "";
        String corta = "";
        int lunghezza = 0;

        //assegnazione
        if(par1.length() >= par2.length()){
            lunga = par1;
            corta = par2;
        }
        else{
            lunga = par2;
            corta = par1;
        }

        //Ciclo
        for (int i = 0; i < lunga.length() -1; i++){
            //scorre con i la stringa lunga
            contatore++;
            for(int j = 0; j < corta.length() -1; j++){
                //scorre con j la stringa corta
                contatore++;
                if (lunga.substring(i, i+1).equals(corta.substring(j, j+1))){
                    //si entra qui se abbiamo trovato una stringa di due lettere uguale
                    for (int k = 1; k <= corta.length(); k++){
                        //con k guarda le stringhe più lunghe di 2
                        contatore++;
                        if(((i+k) <= lunga.length())  && ((j+k) <= corta.length()) ){
                            if (lunga.substring(i, i+k).equals(corta.substring(j, j+k))){
                                //corrispondenza di 2 o più lettere
                                if(lunga.substring(i, i+k).length() > lunghezza){
                                    //se la corrispondenza è più lunga
                                    //assegnazione alla stringa
                                    parola = lunga.substring(i, i+k);
                                    lunghezza = lunga.substring(i, i+k).length();
                                }
                                else if(lunga.substring(i, i+k).length() == lunghezza) {
                                    //se la corrispondenza è lunga uguale
                                    parola = parola + "\n" +  lunga.substring(i, i+k) ;
                                }
                            }
                        }    
                    }
                }
            }  
        }
        return parola;
    }

    public int getContatore () {
        return contatore;
    }
}