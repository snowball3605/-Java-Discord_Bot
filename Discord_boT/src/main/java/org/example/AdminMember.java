package org.example;

public class AdminMember {
    public static boolean Admin(long MemberID) {
        long[] Admin = {810822763601461318L, 705674606043856956L, 747071881169076264L};

        boolean found = false;
        for (long Member : Admin) {
            if (Member == MemberID) {
                found = true;
            }
        }
        return found;
    }
}
