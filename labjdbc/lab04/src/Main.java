import java.util.List;

public class Main {
    public static void main(String[] args) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        CrachaDAO crachaDAO = new CrachaDAO();

        funcionarioDAO.inserir(new Funcionario("Lucas Baracat", "Analista"));
        funcionarioDAO.inserir(new Funcionario("Maria Silva", "Desenvolvedora"));

        List<Funcionario> funcionarios = funcionarioDAO.listar();
        System.out.println("Funcionários:");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }

        crachaDAO.inserir(new Cracha(1, "CRACHA-001"));
        crachaDAO.inserir(new Cracha(2, "CRACHA-002"));

        List<Cracha> crachas = crachaDAO.listar();
        System.out.println("Crachás:");
        for (Cracha c : crachas) {
            System.out.println(c);
        }

        funcionarioDAO.atualizar(new Funcionario(1, "Lucas Z. Baracat", "Engenheiro de Software"));
        crachaDAO.atualizar(new Cracha(1, 1, "CRACHA-999"));

        System.out.println("Após atualização:");
        for (Funcionario f : funcionarioDAO.listar()) {
            System.out.println(f);
        }
        for (Cracha c : crachaDAO.listar()) {
            System.out.println(c);
        }

        crachaDAO.remover(2);
        funcionarioDAO.remover(2);

        System.out.println("Após remoção:");
        for (Funcionario f : funcionarioDAO.listar()) {
            System.out.println(f);
        }
        for (Cracha c : crachaDAO.listar()) {
            System.out.println(c);
        }
    }
}