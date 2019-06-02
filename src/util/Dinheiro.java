package util;

import java.util.Scanner;

public class Dinheiro implements FormaDePagamento{
    
    public static Scanner scanner = new Scanner(System.in);
    public static Facade facade = new Facade();
    
    @Override
    public void forma() {
        double valorPago;
        System.out.println("DIGITE O VALOR DADO:");
        valorPago = scanner.nextDouble();
        facade.realizarPagamento(valorPago, 2);
    }
}
