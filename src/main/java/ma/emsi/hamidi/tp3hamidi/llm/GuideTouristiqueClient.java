package ma.emsi.hamidi.tp3hamidi.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;

public class GuideTouristiqueClient {

    private final GuideTouristique guideTouristique;

    public GuideTouristiqueClient() {
        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("GEMINI_KEY"))
                .modelName("gemini-1.5-flash")
                .build();

        this.guideTouristique = AiServices.create(GuideTouristique.class, model);
    }

    public String getInfosTouristiques(String lieu, int nb) {
        String prompt = String.format(
                "Donne-moi %d principaux endroits à visiter à %s, et le prix moyen d'un repas dans la devise locale.",
                nb, lieu
        );
        return guideTouristique.infosLieu(prompt);
    }
}
