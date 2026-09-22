public class PluginPesquisaWeb implements IAcaoAgente {

    private static final String[] TERMOS_PROIBIDOS = {"hackear", "roubar"};

    @Override
    public String executar(String comando) throws PromptInadequadoException {
        String c = comando.toLowerCase();
        for (String termo : TERMOS_PROIBIDOS) {
            if (c.contains(termo)) {
                throw new PromptInadequadoException(
                    "Pesquisa bloqueada pelo Safety Guard (termo: '" + termo + "').");
            }
        }
        return "Resultado da pesquisa no Google sobre: " + comando;
    }
}
