package com.example.tugas4;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<User> users = generateDummyUsers();

    private static ArrayList<User> generateDummyUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Azusa Nakano", "Azu-nyan", "Moments like these are the symphony of our friendship, each click of the camera capturing the harmonious blend of melodies and laughter. Here's to endless rehearsals, spontaneous jam sessions, and unforgettable adventures. \uD83D\uDCF8\uD83C\uDFB6 #BandBonding #KOnAdventures #MusicalMemories", R.drawable.azusa, R.drawable.azusapost));
        users.add(new User("Delsin Rowe", "MagnateConduit", "Taking the fight to the streets, every surge of power fuels the fire within. Battling DUPs to reclaim freedom's melody from their oppressive grasp. Let the neon glow illuminate the path to justice! \uD83D\uDCA5 #NeonHero #InfamousSecondSon #ConduitPower", R.drawable.delsin, R.drawable.delsinpost));
        users.add(new User("Rudeus Greyrat", "Quagmire", "Within the halls of Orsted Corp, amidst the hum of corporate intrigue, a different battle brews. Crafting strategies to challenge Hitogami's shadowy influence, my determination serves as my sword and knowledge as my shield. Ready to confront destiny itself, I stand firm for the sake of all realms. The clash is inevitable. ⚔\uFE0F\uD83D\uDCBC #CorporateCrusade #RudeusStrategies #MushokuTensei", R.drawable.rudeus, R.drawable.rudeuspost));
        users.add(new User("Aiden Pearce", "TheVigilante", "In the heart of the city's shadows, vengeance and redemption intertwine like threads in a tapestry of justice. Every hack, every takedown, a step closer to the truth. For my family, for justice, the city will know my name. \uD83D\uDD0D\uD83D\uDCBB #DigitalVigilante #AidenUnleashed #WatchDogs", R.drawable.aiden, R.drawable.aidenpost));
        users.add(new User("Ryou Yamada", "poorBassist", "Under the starry sky, our melodies ignite like constellations in the night. We'll paint the heavens with the colors of our music, forging connections that transcend time and space. Let the universe be our audience as we rock beneath the stars! \uD83C\uDF1F\uD83C\uDFB8 #StarryPerformance #KessokuBeats #BocchiTheRock", R.drawable.ryou, R.drawable.ryoupost));
        users.add(new User("Corvo Attano", "TheAssasin", "Amidst the shadows of betrayal, redemption beckons. Every step forward is a step closer to truth, every blade drawn a testament to my resolve. The city may whisper my name in fear, but justice will sing it in triumph. ⚔\uFE0F\uD83C\uDF11 #SeekingRedemption #BladeofHonor #DishonoredJourney", R.drawable.corvo, R.drawable.corvopost));
        return users;
    }
}
