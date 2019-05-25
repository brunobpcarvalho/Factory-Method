package util;

public class Calcular {

    private static double total = 0;

    public void mostrarTotal(double total) {
        Calcular.total = total;
        System.out.println("VALOR TOTAL DO CARRINHO: R$" + total);
    }

    public void calcularTroco(double valorPago) {
        if (Calcular.total == 0) {
            System.out.println("");
        } else if (Calcular.total <= valorPago) {
            System.out.println("TROCO: R$" + (valorPago - Calcular.total));
        } else {
            System.out.println("O VALOR PAGO ESTÁ INCORRETO. O VALOR TOTAL É R$:" + Calcular.total
                    + " E O VALOR PAGO É DE R$:" + valorPago);
        }
    }
}