public class TesteInsercao {

    public static void main(String[] args) {

        FuncionarioDAO dao = new FuncionarioDAO();

        Funcionario f = new Funcionario("Lucas Baracat", "Desenvolvedor");

        dao.inserir(f);

    }

}