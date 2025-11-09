package ma.emsi.hamidi.tp3hamidi.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ma.emsi.hamidi.tp3hamidi.llm.GuideTouristiqueClient;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    GuideTouristiqueClient guideClient;

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLieu(@PathParam("ville_ou_pays") String lieu) {
        String reponseJson = guideClient.getInfosTouristiques(lieu, 2);
        return Response.ok(reponseJson)
                .header("Access-Control-Allow-Origin", "*")
                .header("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0")
                .header("Pragma", "no-cache")
                .header("Expires", "0")
                .build();
    }

    @GET
    @Path("lieu/{ville_ou_pays}/{nb}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLieuAvecNb(@PathParam("ville_ou_pays") String lieu, @PathParam("nb") int nb) {
        String reponseJson = guideClient.getInfosTouristiques(lieu, nb);
        return Response.ok(reponseJson)
                .header("Access-Control-Allow-Origin", "*")
                .header("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0")
                .header("Pragma", "no-cache")
                .header("Expires", "0")
                .build();
    }
}
