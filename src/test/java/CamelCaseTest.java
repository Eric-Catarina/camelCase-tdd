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
    @Test
    void converterCamelCase_NomeComposto(){
        resultadoEsperado.add("nome");
        resultadoEsperado.add("composto");
        List<String> resultado = CamelCase.converterCamelCase("NomeComposto");
        System.out.println(resultado);
        assertTrue(resultadoEsperado.equals(resultado));
        assertEquals(2, resultado.size());
    }
    @Test
    void converterCamelCase_CPF(){
        resultadoEsperado.add("CPF");

        List<String> resultado = CamelCase.converterCamelCase("CPF");
        System.out.println(resultado);
        assertTrue(resultadoEsperado.equals(resultado));
        assertEquals(1, resultado.size());
    }
    @Test
    void converterCamelCase_numeroCPF(){
        resultadoEsperado.add("numero");
        resultadoEsperado.add("CPF");
        List<String> resultado = CamelCase.converterCamelCase("numeroCPF");
        System.out.println(resultado);
        assertTrue(resultadoEsperado.equals(resultado));
        assertEquals(2, resultado.size());
    }
    @Test
    void converterCamelCase_numeroCPFContribuinte(){
        resultadoEsperado.add("numero");
        resultadoEsperado.add("CPF");
        resultadoEsperado.add("contribuinte");

        List<String> resultado = CamelCase.converterCamelCase("numeroCPFContribuinte");
        System.out.println(resultado);
        assertTrue(resultadoEsperado.equals(resultado));
        assertEquals(3, resultado.size());
    }
    @Test
    void converterCamelCase_recupera10Primeiros(){
        resultadoEsperado.add("recupera");
        resultadoEsperado.add("10");
        resultadoEsperado.add("primeiros");

        List<String> resultado = CamelCase.converterCamelCase("recupera10Primeiros");
        System.out.println(resultado);
        assertTrue(resultadoEsperado.equals(resultado));
        assertEquals(3, resultado.size());
    }



}