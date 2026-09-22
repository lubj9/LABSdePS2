import java.util.List;

public interface DAO<T> {
    long inserir(T obj);
    T buscarPorId(long id);
    List<T> listar();
    void atualizar(T obj);
    void remover(long id);
}
