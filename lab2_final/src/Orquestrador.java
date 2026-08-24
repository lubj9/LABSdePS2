import java.util.List;

public class Orquestrador {

    public static void processarFila(List<AgenteIA> lista, String comando) {
        System.out.println("=== [ORQUESTRADOR] Processando fila | Comando: \"" + comando + "\" ===\n");

        for (AgenteIA agente : lista) {
            System.out.println(">> Encaminhando para: " + agente.getNome());
            try {
                agente.processarRequisicao(comando);

            } catch (PromptInadequadoException e) {
                imprimirLog("SEGURANCA", e.getMessage());
            } catch (FalhaProcessamentoAgenteException e) {
                imprimirLog("DOMINIO", e.getMessage() + " | Timestamp: " + e.getTimestamp());
            } catch (ErroComunicacaoIAException e) {
                imprimirLog("INFRA", e.getMessage());
            }
            System.out.println("-----------------------------------");
        }
    }

    private static void imprimirLog(String nivel, String mensagem) {
        String hora = java.time.LocalTime.now().toString().substring(0, 8);
        System.err.println("[LOG-AGENTE] [" + hora + "] [" + nivel + "] Erro: " + mensagem);
    }
}
