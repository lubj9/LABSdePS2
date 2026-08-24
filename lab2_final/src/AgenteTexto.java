public class AgenteTexto extends AgenteIA {

    public AgenteTexto(String nome) {
        super(nome);
    }

    @Override
    public void processarRequisicao(String input) throws
            FalhaProcessamentoAgenteException,
            PromptInadequadoException,
            ErroComunicacaoIAException {

        this.status = "PROCESSING";

        conectarServidor();

        if (input.length() > 500) {
            this.status = "IDLE";
            throw new FalhaProcessamentoAgenteException(
                "Estouro de contexto: prompt com " + input.length() +
                " caracteres excede o limite de 500.");
        }

        System.out.println("Agente de Texto [" + nome + "] gerando resposta para: " + input);
        this.status = "IDLE";
    }
}
