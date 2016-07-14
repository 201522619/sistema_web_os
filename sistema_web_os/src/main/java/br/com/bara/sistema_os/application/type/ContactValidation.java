package br.com.bara.sistema_os.application.type;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.bara.sistema_os.infraestrutura.ContatoValidator;

@Documented
@Constraint(validatedBy = ContatoValidator.class)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface ContactValidation {
	
	String message() default "Contato inválido!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
