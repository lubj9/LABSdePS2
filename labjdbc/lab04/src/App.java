import java.util.List;

public class App {
    public static void main(String[] args) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        CrachaDAO crachaDAO = new CrachaDAO();

        List<Funcionario> funcionarios = funcionarioDAO.listar();
        System.out.println("Funcionários:");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }

        List<Cracha> crachas = crachaDAO.listar();
        System.out.println("Crachás:");
        for (Cracha c : crachas) {
            System.out.println(c);
        }
    }
}
