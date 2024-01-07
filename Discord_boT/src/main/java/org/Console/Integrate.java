package org.Console;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.Console.PID.side;

import java.util.Scanner;

public class Integrate extends ListenerAdapter {

    public static void integrate(JDA jda) {
        side.Main(jda);
    }
}
