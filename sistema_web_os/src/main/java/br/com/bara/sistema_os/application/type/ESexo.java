package br.com.bara.sistema_os.application.type;

public enum ESexo {
	
	MASC("Masculino"), FEMI("Feminino");
	
	private String sexo;
	
	private ESexo(String sexo){
		this.sexo = sexo;
	}
	
	public String toString(){
		return this.sexo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	

}
