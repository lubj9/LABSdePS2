public class AgenteImagem extends AgenteIA {

    private static final String[] TERMOS_SENSIVEIS = {"hackear", "roubar", "biometrico"};

    public AgenteImagem(String nome) {
        super(nome);
    }

    @Override
    public void processarRequisicao(String input) throws
            FalhaProcessamentoAgenteException,
            PromptInadequadoException,
            ErroComunicacaoIAException {

        this.status = "PROCESSING";

        conectarServidor();

        String p = input.toLowerCase();
        for (String termo : TERMOS_SENSIVEIS) {
            if (p.contains(termo)) {
                this.status = "IDLE";
                throw new PromptInadequadoException(
                    "Conteudo inadequado detectado pelo Safety Guard (termo: '" + termo + "').");
            }
        }

        System.out.println("Agente de Imagem [" + nome + "] sintetizando pixels para: " + input);
        this.status = "IDLE";
    }
}
