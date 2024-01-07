package org.example.CloudXact.Command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.example.util.JsonStructure;

import java.util.UUID;

import static org.example.util.CommandOptions.*;

public class Waiting_List extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("cx_complete_form")) return;

        Member member = event.getOption(CX_MEMBER).getAsMember();
        String Reason = event.getOption(CX_REASON).getAsString();
        String TimeStamp = event.getOption(CX_TIMESTAMP).getAsString();
        String Click_M = event.getOption(CX_CM).getAsString();

        String Position = event.getOption(CX_POSITION).getAsString();

        String Discord_Name = member.getNickname();

        long M_ID = member.getIdLong();

        UUID uuid = UUID.randomUUID();

        MessageEmbed messageEmbed = new EmbedBuilder()
                .setTitle("Member Interview List")
                .setDescription("Name: " + member.getUser().getAsMention() + "\nDiscord ID: " + M_ID + "\nReviewer: " + Click_M + "\nReason: " + Reason + "\nPosition: " + Position + "\nInterview Time: " + TimeStamp + "\nID: " + uuid)
                .build();

        event.getJDA().getGuildById("883760822143320065").getTextChannelById("1161985325447524392").sendMessageEmbeds(messageEmbed).queue();
    }
}
