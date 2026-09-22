public class Main {
    public static void main(String[] args) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        CrachaDAO crachaDAO = new CrachaDAO();

        long idLucas = funcionarioDAO.inserir(new Funcionario("Lucas Baracat", "Analista"));
        long idMaria = funcionarioDAO.inserir(new Funcionario("Maria Silva", "Desenvolvedora"));

        long idCrachaLucas = crachaDAO.inserir(new Cracha(idLucas, "CRACHA-" + idLucas));
        long idCrachaMaria = crachaDAO.inserir(new Cracha(idMaria, "CRACHA-" + idMaria));

        imprimir(funcionarioDAO, crachaDAO, "Após inserção:");

        System.out.println("Busca por id: " + funcionarioDAO.buscarPorId(idLucas));
        System.out.println("Busca por id: " + crachaDAO.buscarPorId(idCrachaLucas));

        funcionarioDAO.atualizar(new Funcionario(idLucas, "Lucas Z. Baracat", "Engenheiro de Software"));
        crachaDAO.atualizar(new Cracha(idCrachaLucas, idLucas, "CRACHA-999"));

        imprimir(funcionarioDAO, crachaDAO, "Após atualização:");

        crachaDAO.remover(idCrachaMaria);
        funcionarioDAO.remover(idMaria);

        imprimir(funcionarioDAO, crachaDAO, "Após remoção:");
    }

    private static void imprimir(FuncionarioDAO funcionarioDAO, CrachaDAO crachaDAO, String titulo) {
        System.out.println(titulo);
        System.out.println("Funcionários:");
        for (Funcionario f : funcionarioDAO.listar()) {
            System.out.println(f);
        }
        System.out.println("Crachás:");
        for (Cracha c : crachaDAO.listar()) {
            System.out.println(c);
        }
        System.out.println("-----------------------------------");
    }
}
