package AtividadeC3;

public abstract class Veiculo {

  private String placa;
  private String chassi;
  private String modelo;
  private int identificador = 0;
  private int anoVeiculo;
  private boolean locado;

  public Veiculo(String placa, String chassi, String modelo, int anoVeiculo) {
    super();
    this.placa = placa;
    this.chassi = chassi;
    this.modelo = modelo;
    this.anoVeiculo = anoVeiculo;
    this.identificador++;
    this.locado = false;
  }

  public abstract String exportar();
  
  public abstract String consultar();

  public abstract String veiculoAlugado(float diarias);
  
  public String getPlaca() {
    return placa;
  }

  private void setPlaca(String placa) {
    this.placa = placa;
  }

  public String getChassi() {
    return chassi;
  }

  private void setChassi(String chassi) {
    this.chassi = chassi;
  }

  public String getModelo() {
    return modelo;
  }

  public boolean isLocado() {
    return locado;
  }

  public void setLocado(boolean locado) {
    this.locado = locado;
  }

  private void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public int getIdentificador() {
    return identificador;
  }

  public int getAnoVeiculo() {
    return anoVeiculo;
  }

  private void setAnoVeiculo(int anoVeiculo) {
    this.anoVeiculo = anoVeiculo;
  }

  @Override
  public String toString() {
    return (
      "Veiculo [placa=" + placa +", chassi=" +chassi +", modelo=" +modelo +", identificador=" +identificador +", anoVeiculo=" +anoVeiculo + ", locado=" +locado +"]"
    );
  }
}
