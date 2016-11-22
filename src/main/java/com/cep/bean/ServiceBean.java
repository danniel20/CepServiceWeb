package com.cep.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.cep.service.CepWebService;

@ManagedBean
@RequestScoped
public class ServiceBean {

    private String cep = null;

    private String tipoLogradouro;
    private String logradouro;
    private String estado;
    private String cidade;
    private String bairro;

    public void encontraCep() {
        
		try {
			CepWebService cws = new CepWebService(getCep());
			
			 if (cws.getResultado() == 1) {
		            setTipoLogradouro(cws.getTipoLogradouro());
		            setLogradouro(cws.getLogradouro());
		            setEstado(cws.getEstado());
		            setCidade(cws.getCidade());
		            setBairro(cws.getBairro());
		        } else {
		            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cep não encontrado!", "Cep não encontrado!"));
		        }
			 
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Servidor não está respondendo!", "Servidor não está respondendo"));
		}
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
}
