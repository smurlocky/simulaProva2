import java.util.ArrayList;
import java.util.List;

public class VendasDaAgenciaDeTurismo {

  List<VendaDeTurismoIF> vendas;

  public VendasDaAgenciaDeTurismo(List<VendaDeTurismoIF> vendas) {
    this.vendas = new ArrayList<>(vendas);
  }

  public void adicionarVenda(VendaDeTurismoIF venda) {
    vendas.add(venda);
  }

  public double getValorTotal() {
    double total = 0;
    for (VendaDeTurismoIF venda : vendas) {
      total += venda.getPreco();
    }
    return total;
  }

  public int getQuantidadeVendas() {
    return vendas.size();
  }

  public String toString() {
    return "VendasDaAgenciaDeTurismo []";
  }

  public List<VendaDeTurismoIF> getVendas() {
    return vendas;
  }

}
