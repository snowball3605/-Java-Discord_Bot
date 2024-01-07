package org.example.Event.EarthQuake;

public class Method {
    public static String EQ_LEVEL(String intensity) {
        switch (intensity){
            case "0": case "1":
                return "⚪";
            case "2":
                return "\uD83D\uDFE1";
            case "3": case "4":
                return "\uD83D\uDFE2";
            case "5":
                return "\uD83D\uDD34";
            case "6": case "7":
                return "\uD83D\uDFE4";
            case "8": case "9":
                return "\uD83D\uDFE3";
            case "10":
                return "⚫";
            default:
                return "❌";

        }
    }

    public static String EQ_Text(String intensity) {
        switch (intensity){
            case "0": case "1":
                return "無感";
            case "2":
                return "微震";
            case "3": case "4":
                return "弱震";
            case "5":
                return "強震";
            case "6": case "7":
                return "烈震";
            case "8": case "9": case "10":
                return "劇震";
            default:
                return "❌";

        }
    }
}
