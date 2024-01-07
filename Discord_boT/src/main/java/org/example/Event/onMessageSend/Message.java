package org.example.Event.onMessageSend;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.w3c.dom.Text;

import java.util.Random;

import static org.example.Event.OnReady.Ready.GuildID;
import static org.example.Event.OnReady.Ready.TextID;

public class Message extends ListenerAdapter {
    public static long TextMID;
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getChannel().getIdLong() != TextID) return;
        if (event.getMessage().getMember().getUser().isBot()) {
            System.out.println("`");
            TextMID = event.getChannel().getLatestMessageIdLong();
        }
    }
}
