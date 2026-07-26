import java.util.Scanner;

public class Servico {
    Scanner scanner = new Scanner(System.in);

    public int opcao(){
        System.out.println("Escolha uma opção:");
        System.out.println("[1] Adicionar livro");
        System.out.println("[2] Listar livros");
        System.out.println("[3] Empréstimo de livro");
        System.out.println("[4] Devolver livro");
        System.out.println("[5] Excluir livro");
        System.out.println("[6] Encerrar programa");
        int opcao = scanner.nextInt();
        return opcao;
    }
}