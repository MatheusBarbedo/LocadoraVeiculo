package AtividadeC3;

public class Caminhao extends Veiculo {

  private int carga;
  private float diaria;

  public Caminhao(String placa, String chassi, String modelo, int anoVeiculo, int carga) {
    super(placa, chassi, modelo, anoVeiculo);
    this.carga = carga;
    diaria = 0;
  }

  public int getCarga() {
    return carga;
  }

  public void setCarga(int carga) {
    this.carga = carga;
  }

  public  float getDiaria() {
    return diaria;
  }

  public void setDiaria(float diaria) {
    this.diaria = diaria;
  }

  public float CalculoDiaria(float diaria, int carga) {
    if (carga >= 250) {
      return diaria * 200;
    } 
    
    else return diaria * 100;
  }

  @Override
  public String toString() {
    return "Caminhao [carga=" + carga + "]";
  }

  @Override
  public String exportar() {
    return verificarTipoCaminhao(this.carga) + ": " + ", Placa: "+ this.getPlaca() + ", Chassi: " + this.getChassi()  + ", Modelo: " + this.getModelo() + ", Ano do veiculo: " + this.getAnoVeiculo() + ", Carga do veiculo: " + this.carga + "\n";
  }

  @Override
  public String consultar() {
	return 
    "\nTipo do veiculo: " + verificarTipoCaminhao(this.getCarga()) +
    "\nModelo: " + this.getModelo() +
    "\nPlaca: " + this.getPlaca() +
    "\nAno do veiculo: " + this.getAnoVeiculo() +
    "\nCarga do veiculo: " + this.getCarga() +
    "\n";
  }

  @Override
  public String veiculoAlugado(float dias){
    return
    "\nTipo do veiculo: " + verificarTipoCaminhao(this.carga) +	
    "\nModelo: " + this.getModelo() +
    "\nPlaca: " + this.getPlaca() +
    "\nAno do veiculo: " + this.getAnoVeiculo() +
    "\nAlugado por: " + dias + " dias" +
    "\nValor total: " + this.CalculoDiaria(dias, this.getCarga()) +
    "\n";
  }

  private String verificarTipoCaminhao(int carga){
    if(carga >= 250) return "Caminhao";
    else return "Carreta";
  }
}
