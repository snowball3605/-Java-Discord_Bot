package org.example.util;

import org.example.Main;

public class MoneyEnough {
    public static boolean Main(long GuildID, long MemberID, int Money) {
       int S = Integer.parseInt(JsonStructure.GetPropertyKey(port.Money_File, String.valueOf(GuildID), String.valueOf(MemberID)));

       if (Money > S) {
           return false;
       }
       return true;
    }
}
