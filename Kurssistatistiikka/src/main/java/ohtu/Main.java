package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "011120775";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println( bodyText );
        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

//        System.out.println("Oliot:");
//        for (Submission submission : subs) {
//            System.out.println(submission);
//        }
        System.out.println("opiskelijanumero: " + studentNr);
        System.out.println("");
        int yhtTeht = 0;
        int yhtTunnit = 0;
        for (Submission submission : subs) {
            yhtTeht += submission.getExercises().size();
            yhtTunnit += submission.getHours();
            System.out.println(submission);
        }
        System.out.println("yhteensä: " + yhtTeht + " tehtävää " + yhtTunnit + " tuntia");

    }
}
