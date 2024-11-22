import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMENU:");
            System.out.println("1 - Adicionar caractere");
            System.out.println("2 - Buscar código Morse");
            System.out.println("3 - Exibir a árvore");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o código Morse: ");
                    String codigo = input.nextLine();
                    System.out.print("Digite o caractere correspondente: ");
                    char simbolo = input.nextLine().charAt(0);
                    arvore.adicionar(codigo, simbolo);
                    System.out.println("Caractere adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o caractere para buscar: ");
                    char busca = input.nextLine().charAt(0);
                    String resultado = arvore.buscar(busca);
                    if (resultado != null) {
                        System.out.println("Código Morse: " + resultado);
                    } else {
                        System.out.println("Caractere não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Estrutura da árvore:");
                    arvore.exibir();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        input.close();
    }
}
