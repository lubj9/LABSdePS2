import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrachaDAO implements DAO<Cracha> {

    @Override
    public long inserir(Cracha cracha) {
        String sql = "insert into cracha (funcionario_id, codigo) values (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, cracha.getFuncionarioId());
            stmt.setString(2, cracha.getCodigo());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    cracha.setId(rs.getLong(1));
                }
            }

            System.out.println("Crachá inserido com sucesso. Id: " + cracha.getId());

        } catch (SQLException e) {
            System.out.println("Erro ao inserir crachá: " + e.getMessage());
        }

        return cracha.getId();
    }

    @Override
    public Cracha buscarPorId(long id) {
        String sql = "select * from cracha where id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cracha(
                            rs.getLong("id"),
                            rs.getLong("funcionario_id"),
                            rs.getString("codigo")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar crachá: " + e.getMessage());
        }

        return null;
    }

    @Override
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

    @Override
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

    @Override
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
