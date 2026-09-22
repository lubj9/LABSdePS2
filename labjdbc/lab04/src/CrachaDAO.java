import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrachaDAO {

    public void inserir(Cracha cracha) {
        String sql = "insert into cracha (funcionario_id, codigo) values (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, cracha.getFuncionarioId());
            stmt.setString(2, cracha.getCodigo());
            stmt.executeUpdate();

            System.out.println("Crachá inserido com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir crachá: " + e.getMessage());
        }
    }

    public void atualizar(Cracha cracha) {
        String sql = "update cracha set funcionario_id = ?, codigo = ? where id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, cracha.getFuncionarioId());
            stmt.setString(2, cracha.getCodigo());
            stmt.setLong(3, cracha.getId());

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Crachá atualizado com sucesso.");
            } else {
                System.out.println("Crachá não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar crachá: " + e.getMessage());
        }
    }

    public List<Cracha> listar() {
        List<Cracha> lista = new ArrayList<>();
        String sql = "select * from cracha order by id";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cracha c = new Cracha(
                        rs.getLong("id"),
                        rs.getLong("funcionario_id"),
                        rs.getString("codigo")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar crachás: " + e.getMessage());
        }

        return lista;
    }

    public void remover(long id) {
        String sql = "delete from cracha where id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Crachá removido com sucesso.");
            } else {
                System.out.println("Crachá não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover crachá: " + e.getMessage());
        }
    }

    public void removerPorFuncionario(long funcionarioId) {
        String sql = "delete from cracha where funcionario_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, funcionarioId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao remover crachás do funcionário: " + e.getMessage());
        }
    }
}
