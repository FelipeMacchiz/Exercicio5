package sistema;

import dominio.Pedido;
import dominio.Produto;

import java.io.*;

public class Relatorio {

    public static void imprimirNota(Pedido pedido) {

        System.out.println("-=-=-=- CONTA -=-=-=-");
        if (pedido.getPratosSelecionados().size() > 0) {
            System.out.println("- PRATOS");
            for (Produto prato : pedido.getPratosSelecionados()) {
                System.out.println(String.format("%-6s %-24s", String.format("R$ %1$,.2f", prato.getPreco()), prato.getNome()));
            }
        }
        if (pedido.getBebidasSelecionadas().size() > 0) {
            System.out.println("- BEBIDAS");
            for (Produto bebida : pedido.getBebidasSelecionadas()) {
                System.out.println(String.format("%-6s %-24s", String.format("R$ %1$,.2f", bebida.getPreco()), bebida.getNome()));
            }
        }
        if (pedido.getVinhosSelecionados().size() > 0) {
            System.out.println("- VINHOS");
            for (Produto vinho : pedido.getVinhosSelecionados()) {
                System.out.println(String.format("%-6s %-24s", String.format("R$ %1$,.2f", vinho.getPreco()), vinho.getNome()));
            }
        }
        if (!pedido.getObservacao().isEmpty()) {
            System.out.println("- OBSERVAÇÃO\n" + pedido.getObservacao());
        }
        System.out.println("- TOTAL\n" + String.format("R$ %1$,.2f", pedido.getPrecoTotal()));

    }


    public static void salvarNota(Pedido pedido) throws IOException {

        File file = new File("C:\\_ws\\eclipse-workspace\\Exercicio5\\files\\relatorio.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter writer = new PrintWriter(fileWriter);

        writer.println("-=x=-=x=-=x=-");
        if (pedido.getPratosSelecionados().size() > 0) {
            writer.println("- PRATOS");
            for (Produto prato : pedido.getPratosSelecionados()) {
                writer.println(String.format("%-6s %s", String.format("R$ %1$,.2f", prato.getPreco()), prato.getNome()));
            }
        }
        if (pedido.getBebidasSelecionadas().size() > 0) {
            writer.println("- BEBIDAS");
            for (Produto bebida : pedido.getBebidasSelecionadas()) {
                writer.println(String.format("%-6s %s", String.format("R$ %1$,.2f", bebida.getPreco()), bebida.getNome()));
            }
        }
        if (pedido.getVinhosSelecionados().size() > 0) {
            writer.println("- VINHOS");
            for (Produto vinho : pedido.getVinhosSelecionados()) {
                writer.println(String.format("%-6s %s", String.format("R$ %1$,.2f", vinho.getPreco()), vinho.getNome()));
            }
        }
        if (!pedido.getObservacao().isEmpty()) {
            writer.println("- OBSERVAÇÃO\n" + pedido.getObservacao());
        }
        writer.println("TOTAL: " + String.format("R$ %1$,.2f\n", pedido.getPrecoTotal()));

        fileWriter.close();
        writer.close();

    }

}
