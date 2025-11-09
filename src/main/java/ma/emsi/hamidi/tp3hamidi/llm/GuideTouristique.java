package ma.emsi.hamidi.tp3hamidi.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface GuideTouristique {

    @SystemMessage("""
        Tu es un guide touristique. 
        Donne uniquement les informations touristiques sur la ville ou le pays demandé.
        Réponds au format JSON suivant, sans Markdown :
        {
          "ville_ou_pays": "<nom du lieu>",
          "endroits_a_visiter": ["<endroit 1>", "<endroit 2>", ...],
          "prix_moyen_repas": "<prix> <devise>"
        }
        N'inclus aucune autre explication.
    """)
    String infosLieu(@UserMessage String prompt);
}
