package org.example.Event.OnReady;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.TimeUtil;
import org.example.AdminMember;
import org.example.Stats;
import org.example.util.JsonStructure;
import org.example.util.LangStructure;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import static org.example.Event.onMessageSend.Message.TextMID;

public class Ready extends ListenerAdapter {

    public static long TextID = 1126878182663000096L;
    public static long GuildID = 1126878181702508568L;
    @Override
    public void onReady(ReadyEvent event) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        int total = 0;

        List<Guild> guilds = event.getJDA().getGuilds();
        for (Guild guild : guilds) {
            int MemberCount = guild.getMemberCount();
            total += MemberCount;
        }
        Random random = new Random();

        EmbedBuilder messageEmbed = new EmbedBuilder()
                .setTitle("✅ " + event.getJDA().getSelfUser().getName() + " - 運行日誌 ✅")
                .setDescription("運行時間: " + dtf.format(now) + "\n")
                .appendDescription("運行狀態: 良好" + "\n")
                .appendDescription("伺服器在線數: " + event.getJDA().getGuilds().size() + "\n")
                .appendDescription("所在總人數: " + total + "\n")
                .appendDescription("網絡時延: " + event.getJDA().getGatewayPing() + "MS" + "\n")
                .appendDescription("邀請連結: https://join.mcsge.com")
                .setColor(new Color(random.nextInt(1, 256), random.nextInt(1, 256), random.nextInt(1, 256)));

        event.getJDA().getGuildById("1188491866698682398").getTextChannelById("1190262459206991882").sendMessageEmbeds(messageEmbed.build()).queue();


    }
    }