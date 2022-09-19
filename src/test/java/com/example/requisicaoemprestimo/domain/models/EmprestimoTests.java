package com.example.requisicaoemprestimo.domain.models;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

public class EmprestimoTests {


    @Test
    public void testParcelas(){
        var emprestimo = EmprestimoTestsFixture.emprestimoAprovado(100, 12);
        var parcelas = emprestimo.getParcelas();

        assertTrue(parcelas.isPresent());
        assertEquals( Double.valueOf(106.50), emprestimo.getValorTotalEmprestimo());
        assertEquals(12, parcelas.get().length);
    }

}
