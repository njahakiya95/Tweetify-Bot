/**
 * Created by IntelliJ IDEA.
 * User: Nirmal Patel
 * Date: 1/2/2022
 */

/**
 * TwitterBot.java takes a predefined list of quotes from a file called tweets.txt
 * in the resources directory and tweets each quote to the user's Twitter timeline.
 * Before running the code, be sure to change String quotesFile to the correct directory
 * location on your machine. A valid Twitter Developer's account is necessary to run this code.
 */

//Import relevant classes from twitter4j
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

//Import java.io class
import java.io.*;

//TwitterBot() calls and runs quoteTweeter()
public class TwitterBot {
    public static void main(String[] args) {
        quoteTweeter();
    }

    //quoteTweeter() reads file pointed to by String quotesFile and tweets each line
    //every 10 minutes to the user's Twitter timeline
    private static void quoteTweeter() {
        String quote;   //string quote holds each line in tweets.txt
        String quotesFile = "/home/nirmal/git/twitter-bot/src/main/resources/tweets.txt";   //assign file location to String quotesFile

        try {
            //read quotesFile and assign to quoteReader
            BufferedReader quoteReader = new BufferedReader(new FileReader(quotesFile));
            while ((quote = quoteReader.readLine()) != null) {
                //while you haven't reached the end of the quotesFile
                sendTweet(quote);   //sendTweet function handles quote
                System.out.println("Tweeting quote: " + quote + "..."); //print message to confirm the tweet was sent

                try {
                    //print message to wait for 10 minutes before tweeting next quote
                    System.out.println("Sleep for 10 minutes...");
                    Thread.sleep(600000);   //sleep for 10 minutes (10 minutes = 600000 milliseconds)
                } catch (InterruptedException e) {
                    //print InterruptedException message
                    e.printStackTrace();
                }
            } quoteReader.close();  //close BufferedReader
            } catch (IOException ex) {
            System.err.println(ex); //print IOException message
        }
    }

    //sendTweet takes quote as input and tweets the quote to the user's Twitter timeline
    private static void sendTweet(String line) {
        Twitter twitter = TwitterFactory.getSingleton();    //create twitter object that posts quote
        Status status;  //create status object
        try {
            status = twitter.updateStatus(line); //tweets the quote and updates the status message
            System.out.println(status); //prints the status message
        } catch (TwitterException e) {;
            e.printStackTrace();    //prints TwitterException message 
        }
    }
}
