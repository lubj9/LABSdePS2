import java.util.Scanner;

public class Criacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FuncionarioDAO dao = new FuncionarioDAO();

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Cargo: ");
        String cargo = sc.nextLine();

        dao.inserir(new Funcionario(nome, cargo));

        System.out.println("Funcionários:");
        for (Funcionario f : dao.listar()) {
            System.out.println(f);
        }

        sc.close();
    }
}
