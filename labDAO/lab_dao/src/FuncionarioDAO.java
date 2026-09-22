import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements DAO<Funcionario> {

    @Override
    public long inserir(Funcionario funcionario) {
        String sql = "insert into funcionario (nome, cargo) values (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    funcionario.setId(rs.getLong(1));
                }
            }

            System.out.println("Funcionário inserido com sucesso. Id: " + funcionario.getId());

        } catch (SQLException e) {
            System.out.println("Erro ao inserir funcionário: " + e.getMessage());
        }

        return funcionario.getId();
    }

    @Override
    public Funcionario buscarPorId(long id) {
        String sql = "select * from funcionario where id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Funcionario(
                            rs.getLong("id"),
                            rs.getString("nome"),
                            rs.getString("cargo")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar funcionário: " + e.getMessage());
        }

        return null;
    }

    @Override
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

    @Override
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

    @Override
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
