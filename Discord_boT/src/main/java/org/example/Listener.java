package org.example;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.example.CloudXact.Command.Complete;
import org.example.CloudXact.Command.Waiting_List;
import org.example.Command.Eng_L.Eng;
import org.example.Command.Game.Lion.Lion;
import org.example.Command.Game.Poker.onSlashCommand;
import org.example.Command.Game.Wolf.Button;
import org.example.Command.Game.Wolf.ChannelEvent;
import org.example.Command.Game.Wolf.Start;
import org.example.Command.Lang.Lang;
import org.example.Command.Lang.Work;
import org.example.Command.Rule.rule;
import org.example.Event.EarthQuake.EQ;
import org.example.Event.OnReady.Ready;
import org.example.Event.PlayerJoin.PlayerJoin;
import org.example.Event.onMessageSend.Message;
import org.example.MoneySystem.Command;
import org.example.MoneySystem.Show;

import java.io.IOException;

public class Listener extends ListenerAdapter {

    Start start = new Start();
    ChannelEvent ChannelEvent = new ChannelEvent();
    Button button = new Button();
    onSlashCommand poker = new onSlashCommand();
    Lang lang = new Lang();
    Ready ready = new Ready();
    Command command = new Command();
    onSlashCommand slashCommand = new onSlashCommand();
    Show show = new Show();

    Lion lion = new Lion();
    Work work = new Work();
    Message message = new Message();
    Eng eng = new Eng();
    Waiting_List waiting_list = new Waiting_List();
    Complete complete = new Complete();
    PlayerJoin playerJoin = new PlayerJoin();
    rule rule = new rule();
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        start.onSlashCommandInteraction(event);
        poker.onSlashCommandEvent(event);
        lang.onSlashCommand(event);
        command.SetMoney(event);
        show.onSlashCommand(event);
        lion.onSlashCommand1(event);
        work.onSlashCommand(event);
        ready.onSlashCommandInteraction(event);
        eng.onSlashCommandInteraction(event);
        waiting_list.onSlashCommandInteraction(event);
        complete.onSlashCommandInteraction(event);
        rule.onSlashCommandInteraction(event);

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        start.onMessageReceived(event);
        message.onMessageReceived(event);
    }

    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {
        ChannelEvent.onGuildVoiceUpdate(event);
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        button.ButtonClick(event);
        slashCommand.onButtonInteraction(event);
        eng.onButtonInteraction(event);
        rule.onButtonInteraction(event);
    }

    @Override
    public void onReady(ReadyEvent event) {
        ready.onReady(event);
    }
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        playerJoin.onGuildMemberJoin(event);
    }

}
