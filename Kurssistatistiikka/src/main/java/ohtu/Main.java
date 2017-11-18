package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "011120775";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";

        String courseInfoUrl = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";

        String palautuksetUrl = "https://studies.cs.helsinki.fi/ohtustats/stats";

        String palautusBodyText = Request.Get(palautuksetUrl).execute().returnContent().asString();

        JsonParser parser = new JsonParser();
        JsonObject parsittuData = parser.parse(palautusBodyText).getAsJsonObject();

        int yhtTehtavia = 0;
        int yhtPalautuksia = 0;

        for (String current : parsittuData.keySet()) {
            JsonObject currentObject = parsittuData.getAsJsonObject(current);
            yhtPalautuksia += currentObject.get("students").getAsInt();
            yhtTehtavia += currentObject.get("exercise_total").getAsInt();
        }

        String bodyText = Request.Get(url).execute().returnContent().asString();

        String infoBodyText = Request.Get(courseInfoUrl).execute().returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        CourseInformation info = mapper.fromJson(infoBodyText, CourseInformation.class);

        System.out.println("Kurssi: " + info.getName() + ", " + info.getTerm());
        System.out.println("");

        System.out.println("opiskelijanumero: " + studentNr);
        System.out.println("");

        int yhtTeht = 0;
        int yhtTunnit = 0;
        for (Submission submission : subs) {
            yhtTeht += submission.getExercises().size();
            yhtTunnit += submission.getHours();
            System.out.println("viikko " + submission.getWeek() + ":");
            System.out.println("  tehtyjä tehtäviä yhteensä: " + submission.getExercises().size()
                    + " (maksimi " + info.getExercises().get(submission.getWeek() - 1) + ")"
                    + ", aikaa kului " + submission.getHours() + " tuntia, tehdyt tehtävät: " + submission.printableExercises());
        }
        System.out.println("yhteensä: " + yhtTeht + " tehtävää " + yhtTunnit + " tuntia");

        System.out.println("");
        System.out.println("kurssilla yhteensä " + yhtPalautuksia + " palautusta, palautettuja tehtäviä "
            + yhtTehtavia + " kpl");

    }
}
