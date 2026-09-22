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

    public void usarHabilidade(IAcaoAgente ferramenta, String comando) {
        this.status = "PROCESSING";
        System.out.println("[" + nome + "] Usando habilidade: " + ferramenta.getClass().getSimpleName());
        try {
            String resultado = ferramenta.executar(comando);
            System.out.println("[" + nome + "] " + resultado);
        } catch (PromptInadequadoException e) {
            System.err.println("[LOG-AGENTE] [SEGURANCA] Erro: " + e.getMessage());
        } catch (FalhaProcessamentoAgenteException e) {
            System.err.println("[LOG-AGENTE] [DOMINIO] Erro: " + e.getMessage() + " | Timestamp: " + e.getTimestamp());
        } finally {
            this.status = "IDLE";
        }
    }

    public abstract void processarRequisicao(String input) throws
            FalhaProcessamentoAgenteException,
            PromptInadequadoException,
            ErroComunicacaoIAException;
}
