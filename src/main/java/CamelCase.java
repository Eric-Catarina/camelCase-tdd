import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

//converterCamelCase = breakCamelCase
public class CamelCase {
    //String[] vetorPalavraSplitada = original.split("(?!^)");

    static List<String> resultadoFinal = new ArrayList<>();
    static List<String> listaGruposPalavras = new ArrayList<String>();
    static List<Character> listaLetras = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static char caracterAtual;
    static char proximoCaracter;


    public static List<String> converterCamelCase(String original) {
        divideEmGruposDePalavras(original);
        return listaGruposPalavras;
    }
    public static boolean checaSeEhPalavra(){
        if(Character.isLowerCase(caracterAtual)){
            return true;
        }
        if(Character.isUpperCase(caracterAtual)){
            if(Character.isUpperCase(proximoCaracter)){
                return false;
            }
        }
        return  true;
    }

    public static void divideEmGruposDePalavras(String frase) {

        boolean ehPalavra = true;

        for (int i = 0; i < frase.length(); i++) {
            caracterAtual = frase.charAt(i);
            if(i == frase.length() - 1){
                proximoCaracter = caracterAtual;
                for(Character ch : listaLetras){
                    sb.append(ch);

                }
                sb.append(proximoCaracter);
                listaGruposPalavras.add(sb.toString());
            }
            else proximoCaracter = frase.charAt(i + 1);
            ehPalavra = checaSeEhPalavra();
            if (ehPalavra){
                listaLetras.add(Character.toLowerCase(caracterAtual));
            }
            if(ehPalavra && Character.isUpperCase(proximoCaracter)){
                for(Character ch : listaLetras){
                    sb.append(ch);
                }
                listaGruposPalavras.add(sb.toString());
            }
        }
    }
}
