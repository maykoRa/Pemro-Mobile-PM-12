package com.example.tugas5;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<User> users = generateDummyUsers();

    private static ArrayList<User> generateDummyUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("OG Esports", "#DreamOG", "Against all odds, amidst the fierce battleground of The International 2018, we stood as warriors, fueled by determination and unity. With every keystroke and strategic maneuver, we etched our legacy into the annals of esports history. Thank you for standing by us, for believing in us, and for making this dream a reality. Together, we are unstoppable. Together, we are OG Esports, champions of The International 2018! \uD83C\uDFC6 #OGesports #TI8Champions", R.drawable.og, R.drawable.ogpost));
        users.add(new User("Team Spirit", "#SpiritWin", "To every fan who stood by us, every supporter who believed in us, and every adversary who pushed us to our limits, we extend our deepest gratitude. This victory is yours as much as it is ours. Together, we are Team Spirit, champions of The International 2021! \uD83C\uDFC6 #TeamSpirit #TI10Champions\"", R.drawable.spirit, R.drawable.spiritpost));
        users.add(new User("PSG.LGD", "#LGDForever", "Though the battle ended in defeat, our spirits remain unbroken. The journey to The International 2018 was a testament to our dedication, skill, and resilience. Despite falling short of the ultimate prize, we hold our heads high, for it is in defeat that we find the strength to rise again. To our fans who cheered tirelessly and believed unwaveringly, your support fuels our determination to return stronger. This may be a setback, but it is not the end of our story. We are PSG.LGD, and our legacy will endure. #LGDforever #TI8", R.drawable.lgd, R.drawable.lgdpost));
        users.add(new User("Team Liquid", "#LetsGoLiquid", "Bathed in the glow of victory, we stand as champions of The International 2017. Together, we've proven that with resilience, teamwork, and unwavering determination, anything is possible. This is our moment. This is our legacy. We are Team Liquid, champions of The International 2017! \uD83C\uDFC6 #LetsGoLiquid #TI7Champions", R.drawable.liquid, R.drawable.liquidpost));
        return users;
    }
}
