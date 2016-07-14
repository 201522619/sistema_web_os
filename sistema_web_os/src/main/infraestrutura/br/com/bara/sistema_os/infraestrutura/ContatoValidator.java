package br.com.bara.sistema_os.infraestrutura;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.bara.sistema_os.application.business.ContatoBusiness;
import br.com.bara.sistema_os.application.domain.Contato;
import br.com.bara.sistema_os.application.type.ContactValidation;

public class ContatoValidator implements ConstraintValidator<ContactValidation, Contato>{

	private ContatoBusiness contatoBusiness;
	
	public ContatoValidator() {
		this.contatoBusiness = new ContatoBusiness();
	}
	
	@Override
	public void initialize(ContactValidation arg0) {}

	@Override
	public boolean isValid(Contato contato, ConstraintValidatorContext context) {
		//Implementar lógica
		return false;
	}

}
