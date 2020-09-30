package sistema;

import dominio.Produto;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cardapio {


    public static void adicionarProdutos() throws IOException {

        Scanner input = new Scanner(System.in);

        File file;
        FileWriter fileWriter;
        PrintWriter writer;

        System.out.println("O que você deseja adicionar: \n[1] Prato\n[2] Bebida\n[3] Vinho\n[0] Cancelar");
        int opcao;

        do {
            opcao = Integer.parseInt(input.nextLine());
            if (opcao < 0 || opcao > 3) {
                System.out.println("Opção inválida. Digite novamente");
            }
        } while (opcao < 0 || opcao > 3);

        System.out.print("Digite o nome do novo produto: ");
        String nome = input.nextLine();

        System.out.print("Digite o preço do produto: R$ ");
        String preco = input.nextLine().replace(",", ".");

        if (opcao > 0) {
            String s = preco + "\t" + nome;
            switch (opcao) {
                case 1:
                    file = new File("C:\\_ws\\eclipse-workspace\\Exercicio5\\files\\pratos.csv");
                    fileWriter = new FileWriter(file, true);
                    writer = new PrintWriter(fileWriter);

                    writer.println(nome + ";" + preco);
                    break;
                case 2:
                    file = new File("C:\\_ws\\eclipse-workspace\\Exercicio5\\files\\bebidas-tabuladas.txt");
                    fileWriter = new FileWriter(file, true);
                    writer = new PrintWriter(fileWriter);

                    writer.println(s);
                    break;
                default:
                    file = new File("C:\\_ws\\eclipse-workspace\\Exercicio5\\files\\vinhos-tabulados.txt");
                    fileWriter = new FileWriter(file, true);
                    writer = new PrintWriter(fileWriter);

                    writer.println(s);
                    break;
            }

            System.out.println("Prato adicionado com sucesso!");

            fileWriter.close();
            writer.close();

        } else {
            System.out.println("Cancelando...");
        }

    }


    public static void excluirProdutos() throws IOException {

        Scanner input = new Scanner(System.in);

        File file;
        FileWriter fileWriter;
        PrintWriter writer;

        List<Produto> items;
        String path;

        System.out.println("Informe a lista que deseja visualizar:\n[1] Pratos\n[2] Bebidas\n[3] Vinhos\n[0] Cancelar");
        int opcao;

        do {
            opcao = Integer.parseInt(input.nextLine());
            if (opcao < 0 || opcao > 3) {
                System.out.println("Opção inválida. Digite novamente");
            }
        } while (opcao < 0 || opcao > 3);

        if (opcao > 0) {
            switch (opcao) {
                case 1:
                    path = "C:\\_ws\\eclipse-workspace\\Exercicio5\\files\\pratos.csv";
                    break;
                case 2:
                    path = "C:\\_ws\\eclipse-workspace\\Exercicio5\\files\\bebidas-tabuladas.txt";
                    break;
                default:
                    path = "C:\\_ws\\eclipse-workspace\\Exercicio5\\files\\vinhos-tabulados.txt";
            }

            items = listarProdutos(path);

            System.out.println("Mostrando produtos:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + items.get(i).getNome() + " - R$ " + String.format("%1$.2f", items.get(i).getPreco()));
            }
            System.out.println("[0] Cancelar");

            int indexExcluir;

            do {
                System.out.print("Selecione um produto para excluir do cardápio: ");
                indexExcluir = Integer.parseInt(input.nextLine());
                if (indexExcluir < 0 || indexExcluir > items.size()) {
                    System.out.println("Opção inválida. Digite novamente");
                }
            } while (indexExcluir < 0 || indexExcluir > items.size());

            if (indexExcluir != 0) {
                indexExcluir --;
                items.remove(indexExcluir);

                file = new File(path);
                fileWriter = new FileWriter(file, false);
                writer = new PrintWriter(fileWriter);

                switch (opcao) {
                    case 1:
                        writer.println("PRATO;PRECO");
                        for (Produto item : items) {
                            writer.println(item.getNome() + ";" + item.getPreco());
                        }
                        break;
                    case 2:
                        writer.println("PRECO\tBEBIDA");
                        for (Produto item : items) {
                            writer.println(String.format("%1$,.2f", item.getPreco()) + "\t" + item.getNome());
                        }
                        break;
                    default:
                        writer.println("PRECO\tVINHO");
                        for (Produto item : items) {
                            writer.println(String.format("%1$,.2f", item.getPreco()) + "\t" + item.getNome());
                        }
                        break;
                }
                System.out.println("Prato excluído com sucesso!");
                fileWriter.close();
                writer.close();
            } else {
                System.out.println("Cancelando...");
            }
        } else {
            System.out.println("Cancelando...");
        }

    }


    public static List<Produto> listarProdutos(String path) throws FileNotFoundException {

        File arquivo = new File(path);
        Scanner scan = new Scanner(new FileInputStream(arquivo), StandardCharsets.UTF_8);
        scan.nextLine();

        String ext = getExtensao(path);
        List<Produto> items = new ArrayList<>();

        while (scan.hasNext()) {
            String[] dados;
            String nome;
            double preco;

            if (ext.equals("csv")) {
                dados = scan.nextLine().split(";");
                nome = dados[0];
                preco = Double.parseDouble(dados[1]);
            } else {
                dados = scan.nextLine().split("\t");
                nome = dados[1];
                preco = Double.parseDouble(dados[0].replace(",", "."));
            }

            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setPreco(preco);
            items.add(produto);
        }

        return items;

    }


    public static String getExtensao(String path) {

        String ext = "";
        int i = path.lastIndexOf(".");

        if (i > 0) {
            ext = path.substring(i + 1);
        }

        return ext;

    }


}
