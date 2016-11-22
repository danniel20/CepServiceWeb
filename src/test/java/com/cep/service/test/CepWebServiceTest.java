package com.cep.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cep.service.CepWebService;

public class CepWebServiceTest {
	
	private CepWebService cws;
	private String cep;
	
	@Before
	public void inicializar() throws Exception{
	     cep = "60.714.903";
	     cws = new CepWebService(cep);
	}

    @Test
    public void verificaCepValido() throws Exception {
        assertEquals(1, cws.getResultado());
        assertEquals("CE", cws.getEstado());
        assertEquals("Fortaleza", cws.getCidade());
        assertEquals("Itaperi", cws.getBairro());
        assertEquals("Fundação", cws.getTipoLogradouro());
        assertEquals("Universidade Estadual do Ceará - UE", cws.getLogradouro());

    }
}
