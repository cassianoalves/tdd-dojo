package cassianoalves.tdddojo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteSoma {

	/**
	 * Realiza soma de mesma moeda
	 */
	@Test
	public void somaMesmaMoeda() {
		Moeda valor1 = new Moeda(10, "USD");
		Moeda valor2 = new Moeda(5, "USD");
		
		double resultado;
		double esperado = 15;
		
		Somatoria somatoria = new Somatoria();
		resultado = somatoria.soma(valor1.valor, valor2.valor);
		
		assertEquals(esperado, resultado, 0);
	}
	
	@Test
	public void somaMoedasDiferentes() {
		
	}
	

}
