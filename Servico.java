import java.util.ArrayList;
import java.util.Scanner;

public class Servico {
    Scanner scanner = new Scanner(System.in);

    public int opcao() {
        System.out.println("Escolha uma opção:");
        System.out.println("[1] Adicionar livro");
        System.out.println("[2] Listar livros");
        System.out.println("[3] Empréstimo de livro");
        System.out.println("[4] Devolver livro");
        System.out.println("[5] Excluir livro");
        System.out.println("[6] Encerrar programa");
        return scanner.nextInt();
    }

    public int lerInt() {
        return scanner.nextInt();
    }

    public Livro adicionaLivro(int id) {
        scanner.nextLine(); // consome o newline após nextInt()
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o autor do livro:");
        String autor = scanner.nextLine();
        System.out.println("Digite o ano de lançamento do livro:");
        int ano = scanner.nextInt();
        Livro livro = new Livro(id, titulo, autor, ano);
        System.out.println();
        System.out.println("Livro adicionado com sucesso!");
        System.out.println();
        return livro;
    }

    public void listarLivros(ArrayList<Livro> livros) {
        if (livros.isEmpty()) {
            System.out.println();
            System.out.println("Não há livros cadastrados.");
            System.out.println();
            return;
        }
        System.out.println();
        System.out.println("Lista de livros:");
        for (Livro livro : livros) {
            System.out.println(livro.toString());
        }
        System.out.println();
    }

    public void emprestimoLivro(ArrayList<Livro> livros, int id) {
        Livro livro = findLivroPorId(livros, id);
        if (livro == null) {
            System.out.println();
            System.out.println("Livro com ID " + id + " não encontrado!");
            System.out.println();
            return;
        }
        if (livro.getDisponibilidade()) {
            livro.setDisponibilidade(false);
            System.out.println();
            System.out.println("Empréstimo realizado com sucesso: " + livro.getTitulo());
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Livro indisponível para empréstimo: " + livro.getTitulo());
            System.out.println();
        }
    }

    public void devolverLivro(ArrayList<Livro> livros, int id) {
        Livro livro = findLivroPorId(livros, id);
        if (livro == null) {
            System.out.println();
            System.out.println("Livro com ID " + id + " não encontrado!");
            System.out.println();
            return;
        }
        if (!livro.getDisponibilidade()) {
            livro.setDisponibilidade(true);
            System.out.println();
            System.out.println("Livro devolvido com sucesso: " + livro.getTitulo());
            System.out.println();
        } else {
            System.out.println();
            System.out.println("O livro já está disponível: " + livro.getTitulo());
            System.out.println();
        }
    }

    public void excluirLivro(ArrayList<Livro> livros, int id) {
        Livro livro = findLivroPorId(livros, id);
        if (livro == null) {
            System.out.println();
            System.out.println("Livro com ID " + id + " não encontrado!");
            System.out.println();
            return;
        }
        livros.remove(livro);
        System.out.println();
        System.out.println("Livro excluído com sucesso: " + livro.getTitulo());
        System.out.println();
    }

    private Livro findLivroPorId(ArrayList<Livro> livros, int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }
}
