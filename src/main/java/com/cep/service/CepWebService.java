package com.cep.service;

import java.net.URL;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class CepWebService {

    private String estado = "";
    private String cidade = "";
    private String bairro = "";
    private String tipoLogradouro = "";
    private String logradouro = "";

    private int resultado = 0;

    public CepWebService(String cep) throws Exception {
    	
            URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");

            Document document = getDocumento(url);

            Element root = document.getRootElement();
           
            Iterator<Element> i = root.elementIterator();
            
            i.forEachRemaining( element -> {	
            	
            	if (element.getQualifiedName().equals("uf")) {
                    setEstado(element.getText());
                }
                if (element.getQualifiedName().equals("cidade")) {
                    setCidade(element.getText());
                }
                if (element.getQualifiedName().equals("bairro")) {
                    setBairro(element.getText());
                }
                if (element.getQualifiedName().equals("tipo_logradouro")) {
                    setTipoLogradouro(element.getText());
                }
                if (element.getQualifiedName().equals("logradouro")) {
                    setLogradouro(element.getText());
                }
                if (element.getQualifiedName().equals("resultado")) {
                    setResultado(Integer.parseInt(element.getText()));
                }
            });
    
    }

    public Document getDocumento(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
