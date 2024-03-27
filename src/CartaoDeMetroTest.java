
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartaoDeMetroTest {
	CartaoDeMetro cartao;

	@BeforeEach
	void setUp() throws Exception {
		cartao = new CartaoDeMetro(10);
	}

	@Test
	void testCartaoDeMetro() {
		assertEquals(10, cartao.getQtdeViagens());
		assertEquals(7, CartaoDeMetro.VALOR_DE_UMA_VIAGEM);
	}

	@Test
	void testCartaoDeMetroExcecoes() {
		try {
			cartao = new CartaoDeMetro(-10);
			fail("Uma excecao deveria ter sido lancada");
		} catch (Exception e) {
			assertEquals("Quantidade de viagens deve ser maior que zero", e.getMessage());
		}

		try {
			cartao = new CartaoDeMetro(0);
			fail("Uma excecao deveria ter sido lancada");
		} catch (Exception e) {
			assertEquals("Quantidade de viagens deve ser maior que zero", e.getMessage());
		}
	}

	@Test
	void testToString() {
		assertEquals("CartaoDeMetro [qtdeViagens=10]", cartao.toString());
	}

	@Test
	void testGetSetQuantidade() throws Exception {
		assertEquals(10, cartao.getQtdeViagens());

		cartao.setQtdeViagens(3);
		assertEquals(3, cartao.getQtdeViagens());

		cartao.setQtdeViagens(0);
		assertEquals(3, cartao.getQtdeViagens());

		cartao.setQtdeViagens(-1);
		assertEquals(3, cartao.getQtdeViagens());
	}

	@Test
	void testGetPreco() throws Exception {
		assertEquals(10 * 7, cartao.getPreco());

		cartao.setQtdeViagens(19);
		assertEquals(19 * 7, cartao.getPreco());

		// a partir de 20 viagens o cliente tem 20% de desconto
		// (então só paga 80% do valor total da compra)
		cartao.setQtdeViagens(20);
		assertEquals(20 * 7 * 0.8, cartao.getPreco());
	}

	@Test
	void testGetDescricao() {
		assertEquals("10 viagens de metro.", cartao.getDescricao());
	}

}
