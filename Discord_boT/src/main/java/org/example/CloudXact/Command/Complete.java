package org.example.CloudXact.Command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.example.util.JsonStructure;

import java.util.UUID;

import static org.example.util.CommandOptions.*;

public class Complete extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("cx_complete")) return;

        Member member = event.getOption(CX_MEMBER).getAsMember();
        String Reason = event.getOption(CX_Fraction).getAsString();
        String TimeStamp = event.getOption(CX_TIMESTAMP).getAsString();
        String Click_M = event.getOption(CX_CM).getAsString();

        String Discord_Name = member.getNickname();

        long M_ID = member.getIdLong();

        UUID uuid = UUID.randomUUID();
        MessageEmbed messageEmbed = new EmbedBuilder()
                .setTitle("Complete Interview")
                .setDescription("Name: " + member.getUser().getAsMention() + "\nDiscord ID: " + M_ID + "\nReviewer: " + Click_M + "\nFraction: " + Reason + "\nInterview Time: " + TimeStamp + "\nID: " + uuid)
                .build();

        event.getJDA().getGuildById("883760822143320065").getTextChannelById("1161985325447524392").sendMessageEmbeds(messageEmbed).queue();
        Role role = event.getJDA().getRoleById("1023870332756570182");
        event.getJDA().getGuildById("883760822143320065").getTextChannelById("1161985325447524392").sendMessage(role.getAsMention()).queue();
    }
}
