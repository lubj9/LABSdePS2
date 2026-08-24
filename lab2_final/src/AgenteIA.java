public abstract class AgenteIA {

    protected String nome;
    protected String status;

    public AgenteIA(String nome) {
        this.nome = nome;
        this.status = "IDLE";
    }

    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return status;
    }

    public void conectarServidor() throws ErroComunicacaoIAException {
        ModuloConexao.validarLink();
        System.out.println("[" + nome + "] Conexao com o servidor estabelecida.");
    }

    public abstract void processarRequisicao(String input) throws
            FalhaProcessamentoAgenteException,
            PromptInadequadoException,
            ErroComunicacaoIAException;
}
