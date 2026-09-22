import java.util.Scanner;

public class Alteracao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FuncionarioDAO dao = new FuncionarioDAO();

        System.out.println("Funcionários:");
        for (Funcionario f : dao.listar()) {
            System.out.println(f);
        }

        System.out.print("Id do funcionário a alterar: ");
        long id = Long.parseLong(sc.nextLine());
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        System.out.print("Novo cargo: ");
        String cargo = sc.nextLine();

        dao.atualizar(new Funcionario(id, nome, cargo));

        System.out.println("Após alteração:");
        for (Funcionario f : dao.listar()) {
            System.out.println(f);
        }

        sc.close();
    }
}
