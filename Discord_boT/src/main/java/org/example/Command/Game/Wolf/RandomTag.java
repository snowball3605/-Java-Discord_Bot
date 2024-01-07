package org.example.Command.Game.Wolf;

import java.util.Random;

import static org.example.Command.Game.Wolf.Start.MemberCount;

public class RandomTag {
    static int[] ID;
    static int WolfCount = 0; // 狼人
    static int WitchCount = 0; // 女巫
    static int Linguist = 0; // 語言家
    static int Hunter = 0; // 獵人
    static int Guard = 0; // 守衛
    static int RandomCount = 0;
    static int L;
    static int LR;
    public static int[] TagRandom(int Count) {
        L = 0;
        WolfCount = 0; WitchCount = 0; Linguist = 0; Hunter = 0; Guard = 0;
        ID = new int[Count];
        for (int i = 0; i < ID.length; i++) {
            ID[i] = 0;
        }
        if (Count == 6) {WolfCount = 2; WitchCount = 1; Linguist = 1; Hunter = 1; Guard = 0;}
        if (Count == 7) {WolfCount = 2; WitchCount = 1; Linguist = 1; Hunter = 1; Guard = 0;}
        if (Count == 8) {WolfCount = 3; WitchCount = 1; Linguist = 1; Hunter = 1; Guard = 0;}
        if (Count == 9) {WolfCount = 3; WitchCount = 1; Linguist = 1; Hunter = 1; Guard = 1;}
        if (Count == 10) {WolfCount = 4; WitchCount = 1; Linguist = 1; Hunter = 1; Guard = 1;}

        RandomCount = 0;
        while (true) { // Random Wolf
            if (RandomCount >= WolfCount) break;
            Random random = new Random();
            LR = random.nextInt(Count);
            if (LR != L && ID[LR] == 0) {
                RandomCount++;
                ID[LR] = 1;
                L = LR;
            }
        }
        RandomCount = 0;
        while (true) { // Random Witch
            if (RandomCount >= WitchCount) break;
            Random random = new Random();
            LR = random.nextInt(Count);
            if (LR != L && ID[LR] == 0) {
                RandomCount++;
                ID[LR] = 2;
                L = LR;
            }
        }
        RandomCount = 0;
        while (true) { // Random Hunter
            if (RandomCount >= Hunter) break;
            Random random = new Random();
            LR = random.nextInt(Count);
            if (LR != L && ID[LR] == 0) {
                RandomCount++;
                ID[LR] = 4;
                L = LR;
            }
        }
        RandomCount = 0;
        while (true) { // Random Linguist
            if (RandomCount >= Linguist) break;
            Random random = new Random();
            LR = random.nextInt(Count);
            if (LR != L && ID[LR] == 0) {
                RandomCount++;
                ID[LR] = 3;
                L = LR;
            }
        }
        RandomCount = 0;
        while (true) { // Random Guard
            if (RandomCount >= Guard) break;
            Random random = new Random();
            LR = random.nextInt(Count);
            if (LR != L && ID[LR] == 0) {
                RandomCount++;
                ID[LR] = 6;
                L = LR;
            }
        }
        return ID;
    }

    public static String main() {
        int[] re = TagRandom(MemberCount);
        for (int sum : re) {
            return decoder(sum);
        }
        return null;
    }

    public static String decoder(int i) {
        if (i == 0) return "平民";
        if (i == 1) return "狼人";
        if (i == 2) return "女巫";
        if (i == 3) return "語言家";
        if (i == 4) return "獵人";
        return "守衛";
    }
}
