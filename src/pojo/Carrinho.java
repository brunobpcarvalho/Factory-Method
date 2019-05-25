package pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Carrinho extends Observable {

    private static Carrinho instance;

    private List<String> produto = new ArrayList<>();
    private double valorTotal;
    
    public static Carrinho getInstance() {
        if (Carrinho.instance == null) {
            Carrinho.instance = new Carrinho();
        }
        return instance;
    }

    public List<String> getProduto() {
        return produto;
    }

    public void setProduto(List<String> produto) {
        this.produto = produto;
        setChanged();
        notifyObservers();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
