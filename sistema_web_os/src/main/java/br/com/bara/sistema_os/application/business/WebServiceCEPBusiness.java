package br.com.bara.sistema_os.application.business;

import java.util.HashMap;
import java.util.Map;

import br.com.webservice_cep.WebServiceCep;

public class WebServiceCEPBusiness {
	
	public Map<Object, Object> procurarCEP(String cep){
		Map<Object, Object> mapCep = new HashMap<Object, Object>();
		try {
			WebServiceCep serviceCep = WebServiceCep.searchCep(cep);
			if(serviceCep.isCepNotFound()){
				throw new RuntimeException("CEP inválido ou não foi possível "
						+ "obter conexão com a base de dados dos Correios! Tente novamente.");
			}else if (serviceCep.wasSuccessful()){
				mapCep.put(1, serviceCep.getLogradouro());
				mapCep.put(2, serviceCep.getCidade());
				mapCep.put(3, serviceCep.getUf());
				mapCep.put(4, serviceCep.getBairro());
			}else{
				throw new RuntimeException("Servidor dos correios não está respondendo! Tente novamente mais tarde");
			}
			return mapCep;
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
