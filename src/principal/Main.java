package principal;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Carrinho;
import pojo.Produto;
import util.Facade;

public class Main implements Observer {

    public static Carrinho carrinho = Carrinho.getInstance();
    public static Produto produto = new Produto();
    public static List<String> produtoCarrinho = new ArrayList();
    public static Facade facade = new Facade();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        carrinho.addObserver(main);

        XStream xs = new XStream(new DomDriver());
        xs.alias("Produto", Produto.class);

        converterXml();

        int opcaoMenu;
        int opcaoMenu2;
        int resposta;
        int idProduto;
        int posicaoProduto = 0;
        double valorCarrinho = 0;
        double valorPago;

        do {
            System.out.println("MENU:");
            System.out.println("1 - CARRINHO");
            System.out.println("2 - PAGAMENTO");
            System.out.println("0 - SAIR");
            opcaoMenu = scanner.nextInt();
            limparConsole();
            switch (opcaoMenu) {
                case 1:
                    do {
                        System.out.println("MENU:");
                        System.out.println("1 - ADICIONAR PRODUTO");
                        System.out.println("2 - VER PRODUTOS ADICIONADOS AO CARRINHO");
                        System.out.println("0 - SAIR");
                        opcaoMenu2 = scanner.nextInt();
                        limparConsole();

                        switch (opcaoMenu2) {
                            case 1:
                                do {
                                    listarProdutos();
                                    System.out.println("SELECIONE OS PRODUTOS PELO ID:");
                                    idProduto = scanner.nextInt();
                                    limparConsole();

                                    for (int i = 0; i < produto.getId().length; i++) {
                                        if (idProduto == produto.getId()[i]) {
                                            posicaoProduto = i;
                                        }
                                    }
                                    valorCarrinho = valorCarrinho + produto.getPreco()[posicaoProduto];
                                    addProdutoCarrinho(posicaoProduto, produto);
                                    carrinho.setProduto(produtoCarrinho);

                                    System.out.println("DESEJA ADICIONAR OUTRO PRODUTO?");
                                    System.out.println("1 = SIM OU 2 = NÃO");
                                    resposta = scanner.nextInt();
                                    limparConsole();
                                } while (resposta == 1);
                                carrinho.setValorTotal(valorCarrinho);
                                break;
                            case 2:
                                listarCarrinho();
                                break;
                        }
                    } while (opcaoMenu2 != 0);

                    break;
                case 2:
                    System.out.println("PAGAMENTO");

                    facade.mostrarTotal(carrinho.getValorTotal());

                    System.out.println("DIGITE O VALOR DADO");
                    valorPago = scanner.nextDouble();
                    facade.calcularTroco(valorPago);
                    break;
            }
                    
        } while (opcaoMenu != 0);
    }

    public static void converterXml() {
        try {
            FileReader fr = new FileReader("C:\\Users\\bruno\\Documents\\NetBeansProjects\\Observer\\src\\xml\\produto.xml");
            XStream xs = new XStream(new DomDriver());
            xs.alias("Produto", Produto.class);

            produto = (Produto) xs.fromXML(fr);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void listarProdutos() {
        int i;
        System.out.println("PRODUTOS");
        for (i = 0; i <= 9; i++) {
            System.out.println("ID:" + produto.getId()[i]
                    + " - " + produto.getNome()[i]
                    + " - R$:" + produto.getPreco()[i]);
        }
    }

    public static void listarCarrinho() {
        System.out.printf("ITENS DO CARRINHO\n");
        int n = carrinho.getProduto().size();
        for (int i = 0; i < n; i++) {
            System.out.printf("PRODUTO: " + carrinho.getProduto().get(i) + "\n");
        }
        System.out.println("VALOR TOTAL: R$" + carrinho.getValorTotal());
    }

    public static void addProdutoCarrinho(int posicao, Produto produto) {
        produtoCarrinho.add(produto.getNome()[posicao]);
    }

    public final static void limparConsole() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
        }
    }

    @Override
    public void update(Observable observable, Object arg) {
        carrinho = (Carrinho) observable;
        System.out.println("Produto Adicionado ao Carrinho!");
    }
}
