package util;

public class Facade {
    Calcular calcular = new Calcular();
    
    public void mostrarTotal(double valor) {
        this.calcular.mostrarTotal(valor);
    }
    
    public void calcularTroco(double valorPago){
        this.calcular.calcularTroco(valorPago);
    }
}