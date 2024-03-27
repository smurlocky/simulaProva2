public class CartaoDeMetro implements VendaDeTurismoIF {
  private int qtdeViagens;
  static final double VALOR_DE_UMA_VIAGEM = 7;

  public CartaoDeMetro(int qtdeViagens) throws Exception {
    if (qtdeViagens <= 0) {
      throw new Exception("Quantidade de viagens deve ser maior que zero");
    }
    this.qtdeViagens = qtdeViagens;
  }

  public int getQtdeViagens() {
    return qtdeViagens;
  }

  public void setQtdeViagens(int qtdeViagens) {
    if (qtdeViagens > 0) {
      this.qtdeViagens = qtdeViagens;
    }
  }

  public double getPreco() {
    if (qtdeViagens >= 20) {
      return qtdeViagens * VALOR_DE_UMA_VIAGEM * 0.8; // Aplicar desconto de 20%
    } else {
      return qtdeViagens * VALOR_DE_UMA_VIAGEM;
    }
  }

  public String getDescricao() {
    return qtdeViagens + " viagens de metro.";
  }

  public String toString() {
    return "CartaoDeMetro [qtdeViagens=" + qtdeViagens +
        "]";
  }
}
