package br.com.bara.sistema_os.application.type;

public enum ETipoPessoa {

	FISICA("Física"), JURIDICA("Jurídica");
	
	private String tipoPessoa;
	
	private ETipoPessoa(String tipoPessoa){
		this.tipoPessoa = tipoPessoa;
	}
	
	public String toString(){
		return this.tipoPessoa;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	
}
