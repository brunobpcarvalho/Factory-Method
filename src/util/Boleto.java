package util;

import pojo.Carrinho;

public class Boleto implements FormaDePagamento {

    public static Carrinho carrinho = Carrinho.getInstance();
    public static Facade facade = new Facade();
    double valorTotal = carrinho.getValorTotal();

    @Override
    public void forma() {
        System.out.println("BOLETO GERADO NO VALOR DE R$" + valorTotal);
        facade.realizarPagamento(valorTotal, 1);
    }
}
