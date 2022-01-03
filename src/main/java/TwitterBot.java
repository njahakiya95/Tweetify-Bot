import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.nio.charset.Charset;

public class TwitterBot {
    public static void main(String[] args) {
        quoteTweeter();
    }

    private static void quoteTweeter() {
        String quote;
        String quotesFile = "/home/nirmal/git/twitter-bot/src/main/resources/tweets.txt";

        try {
            BufferedReader quoteReader = new BufferedReader(new FileReader(quotesFile));
            while ((quote = quoteReader.readLine()) != null) {
                sendTweet(quote);
                System.out.println("Tweeting quote: " + quote + "...");

                try {
                    System.out.println("Sleep for 10 minutes...");
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } quoteReader.close();
            } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static void sendTweet(String line) {
        Twitter twitter = TwitterFactory.getSingleton();
        Status status;
        try {
            status = twitter.updateStatus(line);
            System.out.println(status);
        } catch (TwitterException e) {;
            e.printStackTrace();
        }
    }
}
