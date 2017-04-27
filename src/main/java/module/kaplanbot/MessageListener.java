package module.kaplanbot;

import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MessageBuilder;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class MessageListener implements IListener<MessageReceivedEvent> {
    @Override
    public void handle(MessageReceivedEvent event) {
        IMessage message = event.getMessage();
        if (message.getContent().startsWith("::boo")) {
            try {
                // Builds (sends) and new message in the channel that the original message was sent with the content of the original message.
                sendMessage("Testing message.", event);
            } catch (RateLimitException e) { // RateLimitException thrown. The bot is sending messages too quickly!
                System.err.print("Sending messages too quickly!");
                e.printStackTrace();
            } catch (DiscordException e) { // DiscordException thrown. Many possibilities. Use getErrorMessage() to see what went wrong.
                System.err.print(e.getErrorMessage()); // Print the error message sent by Discord
                e.printStackTrace();
            } catch (MissingPermissionsException e) { // MissingPermissionsException thrown. The bot doesn't have permission to send the message!
                System.err.print("Missing permissions for channel!");
                e.printStackTrace();
            }
        }
    }

    private void sendMessage(String message, MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        new MessageBuilder(Kaplan.client).appendContent(message).withChannel(event.getMessage().getChannel()).build();
    }
}
