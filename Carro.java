package AtividadeC3;

public class Carro extends Veiculo {

  private boolean luxo;
  private float diaria;

  public Carro(String placa, String chassi, String modelo, int anoVeiculo, boolean luxo) {
    super(placa, chassi, modelo, anoVeiculo);
    this.luxo = luxo;
    diaria = 0;
  }

  public boolean isLuxo() {
    return luxo;
  }

  public void setLuxo(boolean luxo) {
    this.luxo = luxo;
  }

  public float getDiaria() {
    return diaria;
  }

  public void setDiaria(float diaria) {
    this.diaria = diaria;
  }

  private float CalculoDiaria(float diaria, boolean luxo) {
    if (luxo == true) {
      return diaria * 100;
    } 
    
    else return diaria * 50;
  }

@Override
public String exportar() {
	return  "Carro: " + ", Placa: " + this.getPlaca() + ", Chassi: " + this.getChassi()  + ", Modelo: " + this.getModelo() + ", Ano do veiculo: " + this.getAnoVeiculo() + ", Veiculo de Luxo: "  + verificarVeiculoLuxo(this.luxo) +"\n";		  
 }	

	
@Override
 public String consultar() {
	return 
		"\nTipo do veiculo: Carro" +	
	    "\nModelo: " + this.getModelo() +
	    "\nPlaca: " + this.getPlaca() +
	    "\nAno do veiculo: " + this.getAnoVeiculo() +
	    "\nVeiculo de luxo: " + verificarVeiculoLuxo(this.luxo) +
	    "\n";
	}

  @Override
  public String veiculoAlugado(float dias){
    return "\nCarro: " +
    "\nTipo do veiculo: Carro" +	
    "\nModelo: " + this.getModelo() +
    "\nPlaca: " + this.getPlaca() +
    "\nAno do veiculo: " + this.getAnoVeiculo() +
    "\nVeiculo de luxo: " + verificarVeiculoLuxo(this.luxo) +
    "\nAlugado por: " + dias + " dias" +
    "\nValor total: " + this.CalculoDiaria(dias, this.luxo) +
    "\n";
  }

 private String verificarVeiculoLuxo(boolean luxo){
	 if(this.luxo == true) return "Sim";
	 else return "Não";
 }
}
