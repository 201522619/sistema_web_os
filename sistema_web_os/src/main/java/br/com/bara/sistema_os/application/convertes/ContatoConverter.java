package br.com.bara.sistema_os.application.convertes;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.bara.sistema_os.application.domain.TipoContato;

@FacesConverter(value = "contatoConverter")
public class ContatoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		try {
			if (value == null || value.length() == 0) {
				return null;
			}
			return value;
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		try {
			if (value == null) {
				return "";
			}
			return String.valueOf(((TipoContato) value).getDescricao());
		} catch (RuntimeException e) {
			throw e;
		}
	}

}
