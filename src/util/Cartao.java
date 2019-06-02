package util;

import java.util.Scanner;
import pojo.Carrinho;

public class Cartao implements FormaDePagamento {

    /*Se a seleção for cartão de crédito, um método na classe de cartão 
    solicitando os dados do cartão de crédito será necessário. A “Comunicação”(Fake) 
    com o Banco do cartão também, emitindo uma mensagem de sucesso e falha, 
    e por fim você deverá emitir a mensagem de pagamento realizado ou negado no 
    final do método da biblioteca. */
    public static Scanner scanner = new Scanner(System.in);
    public static Facade facade = new Facade();
    public static Carrinho carrinho = Carrinho.getInstance();

    @Override
    public void forma() {
        int cont = 0;
        String numeroCartao;
        double valorTotal = carrinho.getValorTotal();

        System.out.println("INSIRA O NÚMERO DE IDENTIFICAÇÃO DO CARTÃO DE 16 DIGITOS:");
        numeroCartao = scanner.next();

        if (numeroCartao.length() == 16) {
            System.out.println("Processando: ");
            for (int i = 0; i <= 50; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("TRANSAÇÃO AUTORIZADA!");
            facade.realizarPagamento(valorTotal, 3);
        } else {
            System.out.println("O NÚMERO DO CARTÃO ESTÁ INCORRETO");
        }
    }
}
