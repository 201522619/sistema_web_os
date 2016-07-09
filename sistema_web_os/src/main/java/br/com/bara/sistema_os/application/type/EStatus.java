package br.com.bara.sistema_os.application.type;

public enum EStatus {
	
	ATIVO("Ativo"), INATIVO("Inativo");
	
	private String status;
	
	private EStatus(String status){
		this.status = status;
	}
	
	public String toString(){
		return status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
