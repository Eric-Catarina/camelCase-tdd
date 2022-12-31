import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CamelCaseTest {
    static List<String> placeholder = new ArrayList<String>();
    static List<String> resultadoEsperado = new ArrayList<String>();
    @Test
    void converterCamelCase_nome(){
        List<String> resultado = CamelCase.converterCamelCase("nome");
        assertEquals("nome", resultado.get(0));
        assertEquals(1, resultado.size());
    }
    @Test
    void converterCamelCase_Nome(){
        List<String> resultado = CamelCase.converterCamelCase("Nome");
        assertEquals("nome", resultado.get(0));
        assertEquals(1, resultado.size());
    }
    @Test
    void converterCamelCase_nomeComposto(){
        resultadoEsperado.add("nome");
        resultadoEsperado.add("composto");
        List<String> resultado = CamelCase.converterCamelCase("nomeComposto");
        System.out.println(resultado);
        assertTrue(resultadoEsperado.equals(resultado));
        assertEquals(2, resultado.size());
    }
}