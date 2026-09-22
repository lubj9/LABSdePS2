public class DashboardAgente {
    public static void main(String[] args) {

        AgenteIA agente = new AgenteTexto("GPT-4");

        IAcaoAgente pesquisa = new PluginPesquisaWeb();
        IAcaoAgente gerador = new PluginGeradorCodigo();

        System.out.println("=== [TESTE DE INTEROPERABILIDADE] ===\n");

        String comando = "Como aprender Java";

        agente.usarHabilidade(pesquisa, comando);
        System.out.println("-----------------------------------");

        agente.usarHabilidade(gerador, comando);
        System.out.println("-----------------------------------");

        agente.usarHabilidade(pesquisa, "hackear");
        System.out.println("===================================");
    }
}
