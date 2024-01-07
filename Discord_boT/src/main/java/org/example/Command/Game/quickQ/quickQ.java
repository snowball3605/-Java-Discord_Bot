//package org.example.Command.Game.quickQ;
//
//import net.dv8tion.jda.api.EmbedBuilder;
//import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
//import net.dv8tion.jda.api.hooks.ListenerAdapter;
//import net.dv8tion.jda.api.interactions.components.buttons.Button;
//import org.example.AdminMember;
//import org.example.Stats;
//import org.example.util.CommandOptions;
//import org.example.util.LangStructure;
//
//import java.io.IOException;
//import java.util.*;
//
//public class quickQ extends ListenerAdapter {
//    static int Q_N;
//    public static int Q = 0;
//
//    @Override
//    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
//        if (!event.getName().equals("quickq")) return;
//        if (!Stats.QuickQ && !AdminMember.Admin(event.getMember().getIdLong())) {
//            String Text = LangStructure.Detection(event.getGuild().getIdLong(), "Command_OFF");
//            event.getInteraction().reply(Text).queue();
//            return;
//        }
//        Q = 0;
//        Q++;
//        Random random = new Random();
//        Q_N = random.nextInt(1, 5);
//        try {
//            ArrayList<int> Q = new ArrayList<int>();
//            while (Q.size() <= 3) {
//                int ran = new Random().nextInt(1, 5);
//                if (!Q.contains(ran)) {
//                    Q.add(ran);
//                }
//            }
//
//            EmbedBuilder embedBuilder = new EmbedBuilder()
//                    .setTitle(LangStructure.Detection(event.getGuild().getIdLong(), "Q") + ": " + Q)
//                    .setDescription(LangStructure.Q(event.getGuild().getIdLong(), String.valueOf(Q_N), "Q"));
//            event.getInteraction().replyEmbeds(embedBuilder.build()).setActionRow(Button.secondary("0", LangStructure.Q(event.getGuild().getIdLong(), String.valueOf(Q_N), "S" + Q.)))
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
