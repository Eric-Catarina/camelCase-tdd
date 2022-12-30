import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CamelCaseTest {
    static List<String> placeholder = new ArrayList<String>();
    @Test
    void converterCamelCase_nome(){
        List<String> resultado = CamelCase.converterCamelCase("nome");
        assertEquals("nome", resultado.get(0));
        assertEquals(1, resultado.size());
    }
    @Test
    void converterCamelCase_Nome(){
        List<String> resultado = CamelCase.converterCamelCase("Nome");
        assertEquals("Nome", resultado.get(0));
        assertEquals(1, resultado.size());
    }
    @Test
    void converterCamelCase_nomeComposto(){
        List<String> resultado = CamelCase.converterCamelCase("nomeComposto");
        List<String> resultadoFinalEsperado = new ArrayList<>();
        
        resultadoFinalEsperado.add("nome");
        resultadoFinalEsperado.add("composto");

        System.out.println(resultado);
        assertTrue(resultadoFinalEsperado.equals(resultado));
        assertEquals(2, placeholder.size());
    }
}