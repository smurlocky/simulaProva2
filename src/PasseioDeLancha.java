public class PasseioDeLancha implements VendaDeTurismoIF {
  private int numeroDePessoas;
  private int qtdeDeHoras;
  private final double PRECO_POR_PESSOA = 60;

  public PasseioDeLancha(int numeroDePessoas, int qtdeDeHoras) {
    this.numeroDePessoas = numeroDePessoas;
    this.qtdeDeHoras = qtdeDeHoras;
  }

  @Override
  public String toString() {
    return "PasseioDeLancha []";
  }

  public int getNumeroDePessoas() {
    return numeroDePessoas;
  }

  public void setNumeroDePessoas(int numeroDePessoas) {
    this.numeroDePessoas = numeroDePessoas;
  }

  public int getQtdeDeHoras() {
    return qtdeDeHoras;
  }

  public void setQtdeDeHoras(int qtdeDeHoras) {
    this.qtdeDeHoras = qtdeDeHoras;
  }

  public double getPrecoPorPessoa() {
    return PRECO_POR_PESSOA;
  }

  public double getPreco() {
    return this.numeroDePessoas * this.qtdeDeHoras * this.PRECO_POR_PESSOA;
  }

  public String getDescricao() {
    return "Passeio de Lancha";
  }

}
