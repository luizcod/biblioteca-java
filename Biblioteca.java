import java.util.ArrayList;

public class Biblioteca {
    public static void main(String[] args) {
        ArrayList<Livro> livros = new ArrayList<>();
        Servico servico = new Servico();
        boolean parar = false;
        int idLivro = 1;

        do {
            int opcao = servico.opcao();

            switch (opcao) {
                case 1 -> {
                    livros.add(servico.adicionaLivro(idLivro));
                    idLivro++;
                }
                case 2 -> servico.listarLivros(livros);
                case 3 -> {
                    System.out.println("Digite o ID do livro que deseja emprestar:");
                    int id = servico.lerInt();
                    servico.emprestimoLivro(livros, id);
                }
                case 4 -> {
                    System.out.println("Digite o ID do livro que deseja devolver:");
                    int id = servico.lerInt();
                    servico.devolverLivro(livros, id);
                }
                case 5 -> {
                    System.out.println("Digite o ID do livro que deseja excluir:");
                    int id = servico.lerInt();
                    servico.excluirLivro(livros, id);
                }
                case 6 -> {
                    parar = true;
                    System.out.println("Encerrando . . .");
                }
                default -> System.out.println("Opção inválida. Digite um número entre 1 e 6.");
            }

        } while (!parar);
    }
}
