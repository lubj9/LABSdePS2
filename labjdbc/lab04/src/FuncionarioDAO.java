import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void inserir(Funcionario funcionario) {
        String sql = "insert into funcionario (nome, cargo) values (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.executeUpdate();

            System.out.println("Funcionário inserido com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir funcionário: " + e.getMessage());
        }
    }

    public void atualizar(Funcionario funcionario) {
        String sql = "update funcionario set nome = ?, cargo = ? where id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setLong(3, funcionario.getId());

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Funcionário atualizado com sucesso.");
            } else {
                System.out.println("Funcionário não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar funcionário: " + e.getMessage());
        }
    }

    public List<Funcionario> listar() {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "select * from funcionario order by id";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario f = new Funcionario(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("cargo")
                );
                lista.add(f);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar funcionários: " + e.getMessage());
        }

        return lista;
    }

    public void remover(long id) {
        String sql = "delete from funcionario where id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Funcionário removido com sucesso.");
            } else {
                System.out.println("Funcionário não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover funcionário: " + e.getMessage());
        }
    }
}