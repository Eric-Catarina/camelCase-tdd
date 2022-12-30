import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
//converterCamelCase = breakCamelCase
public class CamelCase {
    //String[] vetorPalavraSplitada = original.split("(?!^)");

    static List<String> resultadoFinal = new ArrayList<>();
    static List<Character> vetorPedacosPalavras = new ArrayList<>();
    static List<String> vetorGruposPalavras = new ArrayList<>();
    static Stack<Integer> indexesMaiusculas = new Stack<>();
    public static List<String> converterCamelCase(String original){
        if (!temMaiuscula(original)){
            resultadoFinal.add(original);
            return resultadoFinal;
        } else if (temMaiuscula(original)) {
            indexesDasMaiusculas(original);
            juntaPedacosPalavrasEmGrupos(original);
        }
        return resultadoFinal;
    }
    public static List<String> juntaPedacosPalavrasEmGrupos(String frase){
        for (int i = 0; i < frase.length(); i++) {
           if (indexesMaiusculas.size() == 0 || i != indexesMaiusculas.get(0)){
               vetorPedacosPalavras.add(frase.charAt(i));
           } else  {
               indexesMaiusculas.pop();
               vetorGruposPalavras.add(vetorPedacosPalavras.stream().map(String::valueOf).collect(Collectors.joining()));
               vetorPedacosPalavras.clear();
               System.out.println(vetorGruposPalavras);
               resultadoFinal.add(vetorPedacosPalavras.stream().map(String::valueOf).collect(Collectors.joining()));
           }
        }
        return vetorGruposPalavras;
    }
    public static Stack<Integer> indexesDasMaiusculas(String frase){
        for (int i = 0; i < frase.length(); i++) {
            if (Character.isUpperCase(frase.charAt(i))){
                indexesMaiusculas.push(i);
            }
        }
        return indexesMaiusculas;

    }
    public static  boolean temMaiuscula(String palavra){
        for (int i = 0; i < palavra.length(); i++) {
            if (Character.isUpperCase(palavra.charAt(i))){
                return true;
            }
        }
        return false;
    }
}
