import java.util.Objects;

public class IngressoEvento implements VendaDeTurismoIF {
	private int qtdeDeIngressosInteira;
	private int qtdeDeIngressosMeia;
	private String tipoEvento;
	private double valorEntradaInteira;

	public IngressoEvento(int qtdeDeIngressosTotal, int qtdeMeiaEntrada, String tipo, double valorEntradaInteira)
			throws Exception {
		super();
		testaEntrada(qtdeDeIngressosTotal, qtdeMeiaEntrada, tipo, valorEntradaInteira);
		this.qtdeDeIngressosInteira = qtdeDeIngressosTotal - qtdeMeiaEntrada;
		this.qtdeDeIngressosMeia = qtdeMeiaEntrada;
		this.tipoEvento = tipo;
		this.valorEntradaInteira = valorEntradaInteira;
	}

	private void testaEntrada(int qtdeDeIngressosTotal, int qtdeMeiaEntrada, String tipo, double valorEntradaInteira)
			throws Exception {
		if (qtdeDeIngressosTotal < 1 || qtdeMeiaEntrada < 1)
			throw new Exception(
					"Quantidade total de ingressos e quantidade de ingressos de meia entrada deve ser maior que 1");
		if (qtdeDeIngressosTotal < qtdeMeiaEntrada)
			throw new Exception("Quantidade de meia entrada deve ser menor que quantidade total de ingressos");
		if (tipo == null || tipo.equals(""))
			throw new Exception("Tipo não pode ser nulo ou vazio");
		if (valorEntradaInteira <= 0)
			throw new Exception("Valor da entrada inteira deve ser maior que zero");

	}

	public int getQtdeDeIngressosInteira() {
		return qtdeDeIngressosInteira;
	}

	public void setQtdeDeIngressosInteira(int qtdeDeIngressosInteira) {
		this.qtdeDeIngressosInteira = qtdeDeIngressosInteira;
	}

	public int getQtdeMeiaEntrada() {
		return qtdeDeIngressosMeia;
	}

	public void setQtdeMeiaEntrada(int qtdeMeiaEntrada) {
		this.qtdeDeIngressosMeia = qtdeMeiaEntrada;
	}

	public String getTipo() {
		return tipoEvento;
	}

	public void setTipo(String tipo) {
		this.tipoEvento = tipo;
	}

	public double getValorEntradaInteira() {
		return valorEntradaInteira;
	}

	public void setValorEntradaInteira(double valorEntradaInteira) {
		this.valorEntradaInteira = valorEntradaInteira;
	}

	@Override
	public int hashCode() {
		return Objects.hash(qtdeDeIngressosInteira, qtdeDeIngressosMeia, tipoEvento, valorEntradaInteira);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof IngressoEvento))
			return false;
		IngressoEvento other = (IngressoEvento) obj;
		return qtdeDeIngressosInteira == other.qtdeDeIngressosInteira && qtdeDeIngressosMeia == other.qtdeDeIngressosMeia
				&& Objects.equals(tipoEvento, other.tipoEvento)
				&& Double.doubleToLongBits(valorEntradaInteira) == Double.doubleToLongBits(other.valorEntradaInteira);
	}

	@Override
	public String toString() {
		return "Ingresso [qtdeDeIngressos=" + qtdeDeIngressosInteira + ", qtdeMeiaEntrada=" + qtdeDeIngressosMeia
				+ ", tipo=" + tipoEvento + ", valorEntradaInteira=" + valorEntradaInteira + ", preço= R$" + getPreco() + "]";
	}

	@Override
	public double getPreco() {
		return ((double) qtdeDeIngressosInteira) * valorEntradaInteira
				+ ((double) qtdeDeIngressosMeia) * valorEntradaInteira / 2.0;
	}

	@Override
	public String getDescricao() {
		return getQtdeDeIngressosInteira() + " ingressos tarifa inteira e " + getQtdeMeiaEntrada()
				+ " ingressos meia entrada para o evento " + getTipo() + ".";
	}

}
