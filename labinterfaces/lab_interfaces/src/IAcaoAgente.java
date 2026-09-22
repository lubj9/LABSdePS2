public interface IAcaoAgente {
    String executar(String comando) throws
            FalhaProcessamentoAgenteException,
            PromptInadequadoException;
}
