package util;

public class FormaFactory {

    public FormaDePagamento gerarForma(String forma) {
        if(forma.toUpperCase().equals("BOLETO")){
            return new Boleto();
        }else if(forma.toUpperCase().equals("DINHEIRO")){
            return new Dinheiro();
        }else if(forma.toUpperCase().equals("CARTAO")){
            return new Cartao();
        }
        return null;
    }
}
