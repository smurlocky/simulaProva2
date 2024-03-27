import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        PasseioDeLancha lancha = new PasseioDeLancha(2, 4);
        PasseioDeLancha lancha2 = new PasseioDeLancha(2, 3);
        List<VendaDeTurismoIF> vendas = new ArrayList<>();

        vendas.add(lancha);
        vendas.add(lancha2);

        VendasDaAgenciaDeTurismo agencia = new VendasDaAgenciaDeTurismo(vendas);

        System.out.println(vendas.get(0).getPreco());
        System.out.println(vendas.get(0).getDescricao());
        System.out.println(vendas.get(1).getPreco());
        System.out.println(vendas.get(1).getDescricao());
        System.out.println(agencia.getQuantidadeVendas());
    }
}
