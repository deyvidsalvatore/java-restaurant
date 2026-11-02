package com.wylianedamaso.restaurant.cardapio.adicionais;

import com.wylianedamaso.restaurant.cardapio.ItemCardapio;
import com.wylianedamaso.restaurant.cardapio.LancheFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdicionaisTest {

    // O 'ItemCardapio' da para você reutilizar varias vezes
    private ItemCardapio lanche;

    // Before Each -> Antes de começar o teste você pode configurar algo antes de rodar cada teste
    // Nesse caso to limpando a variável antes de ser utilizada para não quebrar os testes
    // Não confunda com @BeforeAll que faz a configuração antes de rodar todos os testes de uma só vez
    // Before Each - para cada teste antes rode x, Before All - antes dessa suite de testes faça algo x
    @BeforeEach
    public void setUp() {
        lanche = null;
    }

    @Test
    void xBaconComCheddarCusta26(){
        lanche = new ComCheddar(LancheFactory.xBacon());
        assertEquals(26.00, lanche.getPreco(), 0.001);
    }

    @Test
    void deveAdicionarBaconExtraAoLanche(){
        lanche = new ComBaconExtra(LancheFactory.xBacon());
        assertEquals(28.00, lanche.getPreco(), 0.001);
    }

    @Test
    void deveSomarOsDoisAdicionaisAoLanche(){
        lanche = new ComBaconExtra(new ComCheddar(LancheFactory.xBacon()));
        assertEquals(32.00, lanche.getPreco(), 0.001);
        assertEquals("X-Bacon + cheddar + bacon extra", lanche.getDescricao());
    }

    @Test
    void deveManterOrdemDosAdicionaisNaDescricao() {
        ItemCardapio lanche = new ComCheddar(new ComBaconExtra(LancheFactory.xBacon()));
        assertEquals("X-Bacon + bacon extra + cheddar", lanche.getDescricao());
    }
}
