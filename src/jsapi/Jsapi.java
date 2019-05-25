/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsapi;

import javax.speech.*;
import javax.speech.recognition.*;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.Voice;
import java.io.FileReader;
import java.util.Locale;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import t2s.son.LecteurTexte;

/**
 *
 * @author Andry
 */
public class Jsapi extends ResultAdapter {

    static Recognizer recognizer = null;
    static Voice voice = null;
    static Synthesizer synth = null;
    static Chat chatSession = null;

    public static void textToSpeech(String reponse) {
            LecteurTexte lt = new LecteurTexte(reponse);
            lt.playAll();
    }
    
    public static void initBot(){
        Bot bot = new Bot(Config.BOT_NAME, Config.BOT_PATH);
        chatSession = new Chat(bot);
    }
    // Permet de jouer une string en synthèse vocale

    // Call à la détection d'un nouvel ordre
    public void resultCreated(ResultEvent e) {
        System.out.println("Result Created...");
    }

    // Call à la detection d'un nouveau mot ou syllabe?
    public void resultUpdated(ResultEvent e) {
        Result r = (Result) (e.getSource());
        System.out.println("Result Updated... " + r);
    }

    // Call si rien n'est trouvé (bruit ambiant...)
    public void resultRejected(ResultEvent e) {
        System.out.println("Result Rejected... ");
    }

    // Call si match avec un élément de la grammaire
    public void resultAccepted(ResultEvent re) {
        try {
            Result res = (Result) (re.getSource());
            // On récupère le meilleur token
            ResultToken tokens[] = res.getBestTokens();

            String phrase = "";
            String gst = "";

            for (int i = 0; i < tokens.length; i++) {
                gst = tokens[i].getSpokenText();
                phrase += gst + " ";
            }
            
            System.out.println();
            phrase = phrase.trim();
            
            System.out.println("============== RESULTATS RECONNAISSANCE VOCALE ==============");
            System.out.println("Speech to text: " + phrase);
            String response = chatSession.multisentenceRespond(phrase);
            System.out.println("Text to speech: " + response);
            textToSpeech(response);

        } catch (Exception ex) {
            System.out.println("Erreur: " + ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initBot();
        try {
            // On initialise le moteur de reco
            recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
            recognizer.allocate();

            // On lui indique le fichier de grammaire
            FileReader grammar = new FileReader(Config.PATH_GRAMMAR);
            RuleGrammar rg = recognizer.loadJSGF(grammar);
            rg.setEnabled(true);

            // On lui indique que le mode dictation est activé en plus de la grammaire
            DictationGrammar dictation;
            dictation = recognizer.getDictationGrammar("dictation");
            dictation.setEnabled(true);

            SpeakerManager speakerManager = recognizer.getSpeakerManager();

            // On applique le profil de reco Windows
            SpeakerProfile profile = new SpeakerProfile();
            SpeakerProfile[] profs = speakerManager.listKnownSpeakers();
            for (int i = 0; i < profs.length; i++) {
                System.out.println("Found Profile " + i + " = " + profs[i].getName());
                profile = profs[i];
            }

            speakerManager.setCurrentSpeaker(profile);
            System.out.println("Current Profile set to " + speakerManager.getCurrentSpeaker().getName());

            // On ajoute un listener
            recognizer.addResultListener(new Jsapi());

            recognizer.commitChanges();
            recognizer.requestFocus();
            recognizer.resume();

        } catch (Exception e) {

            System.out.println("Exception: " + e.toString());
            e.printStackTrace();
            System.exit(0);
        }
    }

}
