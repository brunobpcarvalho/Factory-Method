package util;

public class Facade {
    Calcular calcular = new Calcular();
    
    public void mostrarTotal(double valor) {
        this.calcular.mostrarTotal(valor);
    }
    
    public void realizarPagamento(double valorPago, int formaPagamento){
        this.calcular.realizarPagamento(valorPago, formaPagamento);
    }
}