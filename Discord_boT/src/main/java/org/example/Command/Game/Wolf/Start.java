package org.example.Command.Game.Wolf;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.example.AdminMember;
import org.example.Stats;
import org.example.util.JsonStructure;
import org.example.util.LangStructure;

import javax.swing.plaf.PanelUI;
import java.nio.file.Path;
import java.security.PublicKey;
import java.sql.Time;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.util.CommandOptions.VOICECHANNEL;
import static org.example.util.port.Lang_File;

public class Start extends ListenerAdapter {
    public static StringBuilder memberNames = new StringBuilder();
    public static long VoiceChannelID;
    public static String TextChannelID;
    public static long GuildID;
    public static long BotID;
    public static long StartID;
    public static VoiceChannel voiceChannel;
    public static int MemberCount = 0;
    public static long[] MemberID;
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("wolf")) return;
        if (!Stats.Wolf && !AdminMember.Admin(event.getMember().getIdLong())) {
            String Text = LangStructure.Detection(event.getGuild().getIdLong(), "Command_OFF");
            event.getInteraction().reply(Text).queue();
            return;
        }
        MemberCount = 0;

        voiceChannel = event.getOption(VOICECHANNEL).getAsChannel().asVoiceChannel();
        List<Member> memberList = voiceChannel.getMembers();
        for (Member member : memberList) {
            if (!member.getUser().isBot()) {
                MemberCount++;
                String memberName = member.getAsMention();
                memberNames.append(memberName).append("");
            }
        }
        int time = 0;
        MemberID = new long[MemberCount + 1];
        for (Member member : memberList) {
            if (!member.getUser().isBot()) {
                MemberID[time] = member.getIdLong();
                time++;
            }
        }

        MessageEmbed embedBuilder = new EmbedBuilder()
                .setTitle("狼人殺 6-10人房")
                .setDescription("玩家:" + memberNames)
                .setTimestamp(Instant.now())
                .build();

        event.getInteraction().replyEmbeds(embedBuilder).addActionRow(Button.success("start", "start").asEnabled()).queue();
        GuildID = event.getGuild().getIdLong();
        VoiceChannelID = voiceChannel.getIdLong();
        TextChannelID = event.getChannel().getId();
        BotID = event.getJDA().getSelfUser().getIdLong();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.getChannel().getId().equals(TextChannelID)) return;
        if (event.getMember().equals(BotID)) return;

        StartID = event.getChannel().getLatestMessageIdLong();
    }
}
