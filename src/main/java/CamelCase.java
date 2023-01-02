import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

//converterCamelCase = breakCamelCase
public class CamelCase {


    static List<String> listaGruposPalavras = new ArrayList<String>();

    static String palavraAtual = "";
    static StringBuilder sb = new StringBuilder();
    static char caracterAtual;
    static char proximoCaracter;
    static int indexCaracterAtual;


    public static List<String> converterCamelCase(String original) {
        divideEmGruposDePalavras(original);
        return listaGruposPalavras;
    }
    public static boolean checaSeEhPalavra(){
        if(Character.isUpperCase(caracterAtual)){
            if(Character.isUpperCase(proximoCaracter)){
                return false;
            }
        }
        if (chechaSeEhNumero()){
            return false;
        }
        return  true;
    }
    public static boolean chechaSeEhNumero(){
        if(Character.isDigit(caracterAtual)){
            return true;
        }
        return false;
    }

    public static void divideEmGruposDePalavras(String frase) {
        boolean ehPalavra = true;
        for (indexCaracterAtual = 0; indexCaracterAtual < frase.length(); indexCaracterAtual++) {
            caracterAtual = frase.charAt(indexCaracterAtual);
            if (ehUltimaLetraDaFrase(frase, indexCaracterAtual));
            else {
                proximoCaracter = frase.charAt(indexCaracterAtual + 1);
            }
            ehPalavra = checaSeEhPalavra();
            if (ehPalavra){
                adicionaLetraAtual();
            } else if (chechaSeEhNumero()) {
                adicionaNumeroAtual(frase);

            } else {
                adicionaSiglaAtual(frase, indexCaracterAtual);
                indexCaracterAtual+=2;
            }
            if(ehPalavra && Character.isUpperCase(proximoCaracter)){
                fechaPalavraAtual();
            }
        }
    }
    public  static void adicionaLetraAtual(){
        palavraAtual += Character.toLowerCase(caracterAtual);
    }
    public  static  void fechaPalavraAtual(){
        listaGruposPalavras.add(palavraAtual);
        palavraAtual = "";
    }

    public static boolean ehUltimaLetraDaFrase(String frase, int i){
        if(i == frase.length() - 1){
            proximoCaracter = caracterAtual;
            if(checaSeEhPalavra()){
                adicionaLetraAtual();
            }
            fechaPalavraAtual();
            return true;
        }
        else return  false;
    }
    public static void adicionaSiglaAtual(String frase, int i){
        palavraAtual += frase.charAt(i);
        palavraAtual += frase.charAt(i + 1);
        palavraAtual += frase.charAt(i + 2);
        fechaPalavraAtual();
    }
    public static  void adicionaNumeroAtual(String frase){
        fechaPalavraAtual();
        for (;Character.isDigit(caracterAtual); indexCaracterAtual++){
            caracterAtual = frase.charAt(indexCaracterAtual);
            if(Character.isLetter(caracterAtual)) continue;
            adicionaLetraAtual();
        }
        fechaPalavraAtual();
        indexCaracterAtual-=2;
    }
    private void resetaVariaveisClasse (){

    }
}
