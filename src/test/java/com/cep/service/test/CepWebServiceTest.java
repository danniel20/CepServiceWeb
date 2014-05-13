package com.cep.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cep.service.CepWebService;

public class CepWebServiceTest {

    @Test
    public void verificaCepValido() {
        String cep = "60.714.903";

        CepWebService cws = new CepWebService(cep);

        assertEquals(1, cws.getResultado());
        assertEquals("CE", cws.getEstado());
        assertEquals("Fortaleza", cws.getCidade());
        assertEquals("Itaperi", cws.getBairro());
        assertEquals("Fundação", cws.getTipoLogradouro());
        assertEquals("Universidade Estadual do Ceará - UE", cws.getLogradouro());

    }
}
