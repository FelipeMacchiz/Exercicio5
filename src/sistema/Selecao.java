package sistema;

import dominio.Pedido;
import dominio.Produto;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Selecao {


    public static Pedido fazerPedido() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        Pedido pedido = new Pedido();
        List<Produto> cardapio;
        Produto itemSelecionado;
        int selecaoCardapio;
        int fazerObservacao;
        int finalizar;
        String observacao;

        System.out.println("= PEDIDO =");

        do {
            System.out.println("Temos 3 opções de cardápio\n[1] Pratos\n[2] Bebidas\n[3] Vinhos");
            System.out.println("Qual deles você deseja selecionar? Você pode selecionar mais de um separando por vírgula");
            System.out.println("Digite 0 para sair");

            do {
                selecaoCardapio = Integer.parseInt(input.nextLine());
                if (selecaoCardapio < 0 || selecaoCardapio > 3) {
                    System.out.println("Opção inválida. Digite novamente");
                }
            } while (selecaoCardapio < 0 || selecaoCardapio > 3);

            if (selecaoCardapio == 0) {
                System.out.println("Saindo...");
                return pedido;
            } else {
                switch (selecaoCardapio) {
                    case 1:
                        cardapio = Cardapio.listarProdutos("C:\\_ws\\eclipse-workspace\\Exercicio5\\files\\pratos.csv");
                        System.out.println("= CARDÁPIO DE PRATOS =");
                        itemSelecionado = selecionarItem(cardapio);

                        pedido.getPratosSelecionados().add(itemSelecionado);
                        pedido.setPrecoTotal(pedido.getPrecoTotal() + itemSelecionado.getPreco());
                        break;
                    case 2:
                        cardapio = Cardapio.listarProdutos("C:\\_ws\\eclipse-workspace\\Exercicio5\\files\\bebidas-tabuladas.txt");
                        System.out.println("= CARDÁPIO DE BEBIDAS =");
                        itemSelecionado = selecionarItem(cardapio);

                        pedido.getBebidasSelecionadas().add(itemSelecionado);
                        pedido.setPrecoTotal(pedido.getPrecoTotal() + itemSelecionado.getPreco());
                        break;
                    default:
                        cardapio = Cardapio.listarProdutos("C:\\_ws\\eclipse-workspace\\Exercicio5\\files\\vinhos-tabulados.txt");
                        System.out.println("= CARDÁPIO DE VINHOS =");
                        itemSelecionado = selecionarItem(cardapio);

                        pedido.getVinhosSelecionados().add(itemSelecionado);
                        pedido.setPrecoTotal(pedido.getPrecoTotal() + itemSelecionado.getPreco());
                        break;
                }

                System.out.println("Deseja fazer alguma observação? [1] Sim [2] Não");
                do {
                    fazerObservacao = Integer.parseInt(input.nextLine());
                    if (fazerObservacao < 1 || fazerObservacao > 2) {
                        System.out.println("Opção inválida. Digite novamente");
                    }
                } while (fazerObservacao < 1 || fazerObservacao > 2);
                if (fazerObservacao == 1) {
                    System.out.print("Informe sua observação: ");
                    observacao = input.nextLine();
                    pedido.setObservacao(pedido.getObservacao() + "\n" + observacao);
                }

                System.out.println("Anotado! Você deseja finalizar o pedido?");
                System.out.println("[1] Sim\n[2] Não");
                do {
                    finalizar = Integer.parseInt(input.nextLine());
                    if (finalizar < 1 || finalizar > 2) {
                        System.out.println("Opção inválida. Digite novamente");
                    }
                } while (finalizar < 1 || finalizar > 2);
            }

        } while (finalizar != 1);

        return pedido;

    }


    public static Produto selecionarItem(List<Produto> cardapio) {

        Scanner input = new Scanner(System.in);
        Produto itemSelecionado;
        int indexItem;

        for (int i = 0; i < cardapio.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + cardapio.get(i).getNome() + " - R$ " + String.format("%1$,.2f", cardapio.get(i).getPreco()));
        }

        System.out.println("[0] Cancelar");

        do {
            System.out.print("Informe o item que deseja selecionar: ");
            indexItem = Integer.parseInt(input.nextLine());
            if (indexItem < 0 || indexItem > cardapio.size()) {
                System.out.println("Opção inválida. Digite novamente");
            }
        } while (indexItem < 0 || indexItem > cardapio.size());

        indexItem --;
        itemSelecionado = cardapio.get(indexItem);

        return itemSelecionado;

    }


}
