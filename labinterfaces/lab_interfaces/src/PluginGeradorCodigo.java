public class PluginGeradorCodigo implements IAcaoAgente {

    private static final int LIMITE_CARACTERES = 50;

    @Override
    public String executar(String comando) throws FalhaProcessamentoAgenteException {
        if (comando.length() > LIMITE_CARACTERES) {
            throw new FalhaProcessamentoAgenteException(
                "Limite de tokens de codigo excedido: comando com " + comando.length() +
                " caracteres excede o limite de " + LIMITE_CARACTERES + ".");
        }
        return "Snippet de codigo Java gerado para: " + comando;
    }
}
