package module.kaplanbot;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.util.DiscordException;

import java.io.File;
import java.util.Scanner;

public class Kaplan {

    private static final String TOKEN = readTokenFromFile();
    public static IDiscordClient client;

    public static void main(String[] args) {
        System.out.println("Logging bot in...");
        client = createClient(TOKEN, false); // building the client
        client = createClient(TOKEN, true); // logging into the client

        EventDispatcher dispatcher = client.getDispatcher();
        dispatcher.registerListener(new MessageListener());
    }

    private static String readTokenFromFile() {
        File file = new File("C:/Users/Trevor/Documents/JeffKaplanBot/src/main/java/module/kaplanbot/token.conf");
        Scanner reader;

        try {
            reader = new Scanner(file);
        } catch (Exception e) {
            System.out.println("We couldn't read the file. Error: " + e.getMessage());
            System.exit(1);
            return "";
        }

        return (reader.nextLine()); // return the token key from the file.
    }

    public static IDiscordClient createClient(String token, boolean login) { // Returns a new instance of the Discord client
        ClientBuilder clientBuilder = new ClientBuilder(); // Creates the ClientBuilder instance
        clientBuilder.withToken(token); // Adds the login info to the builder
        try {
            if (login) {
                return clientBuilder.login();  // Creates the client instance and logs the client in.
            } else {
                return clientBuilder.build(); // Creates the client instance, but it doesn't log the client in yet, login with client.login().
            }
        } catch (DiscordException e) { // This is thrown if there was a problem building the client.
            e.printStackTrace();
            return null;
        }
    }

}
