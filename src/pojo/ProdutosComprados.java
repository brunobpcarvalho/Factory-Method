package pojo;

import java.util.ArrayList;
import java.util.List;

/*Continuando a permuta, ao finalizar o processo de compra, o software deverá 
salvar a transação em um arquivo XML, informando quais produtos foram comprados 
(somente código), preço total e a forma de pagamento. */
public class ProdutosComprados {
    private List<Integer> id = new ArrayList();
    private String formaPag;
    private double preco;

    public List<Integer> getId() {
        return id;
    }

    public void setId(List<Integer> id) {
        this.id = id;
    }
    
    public String getFormaPag() {
        return formaPag;
    }

    public void setFormaPag(String formaPag) {
        this.formaPag = formaPag;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
