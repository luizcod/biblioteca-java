import java.util.ArrayList;

public class Biblioteca {
    public static void main(String[] args) {

       ArrayList<Livro> livros = new ArrayList<>();

        Servico servico = new Servico();
        boolean parar = false;
        do{
            int opcao = servico.opcao();
            switch (opcao) {
                case 1:
                    break;
                case 6:
                    parar = true;
                    System.out.println("Encerrando . . .");
                    break;
            }

        }while(!parar);

    }
}