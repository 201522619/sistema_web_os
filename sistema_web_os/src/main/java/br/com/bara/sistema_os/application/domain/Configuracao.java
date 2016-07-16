package br.com.bara.sistema_os.application.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_configuracao")
public class Configuracao extends GenericEntity implements Serializable{

	private static final long serialVersionUID = -7279860918565645240L;
	
}
