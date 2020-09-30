package sistema;

import dominio.Pedido;

import java.io.IOException;
import java.util.Scanner;

public class Programa {


    public static void main(String[] args) throws IOException {

        int modo = selecaoModo();
        if (modo == 1) {
            modoCliente();
        } else {
            modoGerente();
        }

    }


    public static int selecaoModo() {

        Scanner input = new Scanner(System.in);
        int modo;

        System.out.println("Selecione o modo de utilização do programa:\n[1] Cliente\n[2] Gerente");
        do {
            modo = Integer.parseInt(input.nextLine());
            if (modo < 1 || modo > 2) {
                System.out.println("Opção inválida. Digite novamente");
            }
        } while (modo < 1 || modo > 2);

        return modo;

    }


    public static void modoCliente() throws IOException {

        Scanner input = new Scanner(System.in);
        int outroPedido;

        do {

            Pedido pedido = Selecao.fazerPedido();
            Relatorio.imprimirNota(pedido);
            Relatorio.salvarNota(pedido);

            System.out.println("Deseja fazer outro pedido? [1] Sim [2] Não");
            do {
                outroPedido = Integer.parseInt(input.nextLine());
                if (outroPedido < 1 || outroPedido > 2) {
                    System.out.println("Opção inválida. Digite novamente");
                }
            } while (outroPedido < 1 || outroPedido > 2);

        } while (outroPedido != 2);

    }


    public static void modoGerente() throws IOException {

        Scanner input = new Scanner(System.in);
        int tarefa;

        do {
            System.out.println("Qual tarefa deseja realizar?\n[1] Adicionar produtos\n[2] Remover produtos\n[0] Sair");
            do {
                tarefa = Integer.parseInt(input.nextLine());
                if (tarefa < 0 || tarefa > 2) {
                    System.out.println("Opção inválida. Digite novamente");
                }
            } while (tarefa < 0 || tarefa > 2);

            switch (tarefa) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    Cardapio.adicionarProdutos();
                    break;
                case 2:
                    System.out.println("1");
                    Cardapio.excluirProdutos();
                    break;
                default:
                    break;
            }

        } while (tarefa != 0);

    }

}
