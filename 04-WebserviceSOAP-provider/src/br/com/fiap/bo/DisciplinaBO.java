package br.com.fiap.bo;

public class DisciplinaBO {

	public float calcularMedia(float am, float ps, float nac){
		return am*0.3f + nac*0.2f + ps*0.5f;
	}
	
	public float calcularPs(float am, float nac){
		return (6 - (am*0.3f + nac*0.2f))/0.5f;
	}
	
	public float calcularPsAnual(float am, 
						float nac, float mediaSemestre){
		return (12 - (mediaSemestre +am*0.3f + nac*0.2f))/0.5f;
	}
	
}