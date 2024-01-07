package org.example.util;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;
import org.Console.Integrate;
import org.Console.PID.side;

import java.util.List;

public class BotStructure{
    public static JDA jda;
    public static void Main(String TOKEN, Object EventListeners, CommandDataImpl[] CommandDataImpl) throws Exception{

        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN)
                .setLargeThreshold(250)
                .enableCache(CacheFlag.ONLINE_STATUS, CacheFlag.ACTIVITY)
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_PRESENCES)
                .setBulkDeleteSplittingEnabled(false)
                .setActivity(Activity.listening("HHH"))
                .setStatus(OnlineStatus.ONLINE)
                .addEventListeners(EventListeners);

        jda = jdaBuilder.build().awaitReady();

        Thread thread = new Thread(() -> {
        Integrate.integrate(jda);
        });
        thread.start();
        
        jda.updateCommands().addCommands(CommandDataImpl).queue();

        System.out.println("Bot is Start at " + TOKEN);
    }
}
