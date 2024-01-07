package org.example.Command.Game.Wolf;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.w3c.dom.Text;

import java.time.Instant;
import java.util.List;

import static org.example.Command.Game.Wolf.Start.*;
import static org.example.util.CommandOptions.VOICECHANNEL;

public class ChannelEvent extends ListenerAdapter {
    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {
        MemberCount = 0;
        memberNames.delete(0, 100);
        AudioChannelUnion JoinChannel = event.getChannelJoined();
        AudioChannelUnion LeaveChannel = event.getChannelLeft();

        if (JoinChannel != null) { // Join
           if (event.getChannelJoined().getIdLong() != VoiceChannelID) return;
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

            event.getGuild().getTextChannelById(TextChannelID).editMessageEmbedsById(StartID).setEmbeds(embedBuilder).queue();
        } else if (LeaveChannel != null) { // Leave
            MemberCount = 0;
            if (event.getChannelLeft().getIdLong() != VoiceChannelID) return;
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

            event.getGuild().getTextChannelById(TextChannelID).editMessageEmbedsById(StartID).setEmbeds(embedBuilder).queue();
        }
    }
}
