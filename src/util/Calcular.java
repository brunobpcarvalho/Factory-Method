package util;

import java.util.Random;

public class Calcular {

    private static double total = 0;
    private static Calcular instance;

    public static Calcular getInstanceCalcular() {
        if (Calcular.instance == null) {
            Calcular.instance = new Calcular();
        }
        return instance;
    }

    public void mostrarTotal(double total) {
        Calcular.total = total;
        System.out.println("VALOR TOTAL DO CARRINHO: R$" + total);
    }

    public void realizarPagamento(double valorPago, int formaPagamento) {
        switch (formaPagamento) {
            case 1://BOLETO
                Random gerador = new Random();
                System.out.print("CÓDIGO DE BARRAS DO BOLETO: ");
                for (int i = 0; i < 5; i++) {
                    System.out.print(gerador.nextInt(999999999) + ".");
                }
                System.out.println("");
                System.out.println("OS PRODUTOS SOMENTE SERÃO LIBERADOS APÓS O PAGAMENTO DO BOLETO");
                System.out.println("APÓS 3 DIAS ÚTEIS A COMPRA SERÁ CANCELADA");
                break;
            case 2://DINHEIRO

                if (Calcular.total == 0) {
                    System.out.println("");
                } else if (Calcular.total <= valorPago) {
                    System.out.println("TROCO: R$" + (valorPago - Calcular.total));
                } else {
                    System.out.println("O VALOR PAGO ESTÁ INCORRETO. O VALOR TOTAL É R$:" + Calcular.total
                            + " E O VALOR PAGO É DE R$:" + valorPago);
                }
                break;
            case 3://CARTAO
                System.out.println("PAGAMENTO NO VALOR DE R$" + total + " REALIZADO COM SUCESSO");
                break;
        }
    }
}
