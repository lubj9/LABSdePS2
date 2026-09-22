import java.util.Scanner;

public class Remocao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        CrachaDAO crachaDAO = new CrachaDAO();

        System.out.println("Funcionários:");
        for (Funcionario f : funcionarioDAO.listar()) {
            System.out.println(f);
        }

        System.out.print("Id do funcionário a remover: ");
        long id = Long.parseLong(sc.nextLine());

        crachaDAO.removerPorFuncionario(id);
        funcionarioDAO.remover(id);

        System.out.println("Após remoção:");
        for (Funcionario f : funcionarioDAO.listar()) {
            System.out.println(f);
        }

        sc.close();
    }
}
