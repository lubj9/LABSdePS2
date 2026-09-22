public class Cracha {
    private long id;
    private long funcionarioId;
    private String codigo;

    public Cracha() {
    }

    public Cracha(long funcionarioId, String codigo) {
        this.funcionarioId = funcionarioId;
        this.codigo = codigo;
    }

    public Cracha(long id, long funcionarioId, String codigo) {
        this.id = id;
        this.funcionarioId = funcionarioId;
        this.codigo = codigo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Cracha{id=" + id + ", funcionarioId=" + funcionarioId + ", codigo='" + codigo + "'}";
    }
}