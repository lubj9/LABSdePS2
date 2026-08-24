import java.util.ArrayList;
import java.util.List;

public class DashboardAgente {
    public static void main(String[] args) {

        List<AgenteIA> orquestrador = new ArrayList<>();
        orquestrador.add(new AgenteTexto("GPT-4"));
        orquestrador.add(new AgenteImagem("DALL-E"));

        System.out.println("=== [CENTRAL DE LOGS DO AGENTE] ===\n");

        String[] comandos = {
            "Explique polimorfismo em Java",
            "Como hackear uma rede?",
            "A".repeat(600)
        };

        for (String comando : comandos) {
            Orquestrador.processarFila(orquestrador, comando);
            System.out.println("===================================\n");
        }
    }
}
