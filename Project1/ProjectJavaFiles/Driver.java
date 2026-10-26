public class Driver {

    public static void main(String[] args) {
        //Instantiate objects and variables  
        MusicPlayer demo = new MusicPlayer();
        MusicPlayer emptyPlayer = new MusicPlayer();

        //Beginning Test Script 
        //Part 1
        System.out.println("--- 1. Build the playlist ---");
        System.out.println(demo.addSong(1, "Night Drive", "Steven Hulse"));
        System.out.println(demo.addSong(2, "Slow Tide", "Steven Hulse"));
        System.out.println(demo.addSong(3, "Copper Sky", "Steven Hulse"));
        System.out.println(demo.addSong(4, "Static Boom", "Steven Hulse"));
        System.out.println(demo.addSong(5, "Low Orbit", "Steven Hulse"));
        System.out.println(demo.addSong(6, "Glass Rivers", "Steven Hulse"));
        System.out.printf("duplicate s3: %b\n", demo.addSong(3, "Copper Sky", "Steven Hulse"));
        System.out.printf("playlist: %s\n",demo.showPlaylist());
        //Part 2
        System.out.println("--- 2. Look up songs ---");
        System.out.printf("find s4 (song id:4): %s\n", demo.findSong(4));
        System.out.printf("find s9 (song id:9): %s\n", demo.findSong(9));
        //Part 3
        System.out.println("--- 3. Play and move forward ---");
        System.out.printf("play s1 (song id:1): %s\n", demo.play(1));
        System.out.printf("play s9 (song id:9): %s\n", demo.play(9));
        System.out.printf("next: %s\n", demo.next());
        System.out.printf("next: %s\n", demo.next());
        System.out.printf("history: %s", demo.showHistory());
        //Part 4
        System.out.println("--- 4. Up next ---");
        System.out.println(demo.queueLater(1));
        System.out.println(demo.queueLater(5));
        System.out.println(demo.queueLater(6));
        System.out.printf("queue s9 (song id:9): %s\n", demo.queueLater(9));
        System.out.printf("up next: %s\n", demo.showUpNext());
        System.out.printf("next: %s\n", demo.next());
        System.out.printf("now playing: %s\n", demo.nowPlaying());
        System.out.printf("history: %s\n", demo.showHistory());
        //Part 5
        System.out.println("--- 5. Back button ---");
        System.out.printf("back: %s\n", demo.back());
        System.out.printf("up next: %s\n", demo.showUpNext());
        System.out.printf("history: %s\n", demo.showHistory());
        //Part 6
        System.out.println("--- 6. Remove songs ---");
        System.out.printf("remove s5 (song id:5): %s\n", demo.removeSong(5));
        System.out.printf("remove current (s3): %s\n", demo.removeSong(3));
        System.out.printf("remove s9 (song id:9): %s\n", demo.removeSong(9));
        System.out.printf("playlist: %s\n",demo.showPlaylist());
        System.out.printf("up next: %s\n", demo.showUpNext());
        //Part 7
        System.out.println("--- 7. Removed songs are skipped ---");
        System.out.printf("next: %s\n", demo.next());
        System.out.printf("next: %s\n", demo.next());
        System.out.printf("next at end: %s\n", demo.next());
        System.out.printf("now playing: %s\n", demo.nowPlaying());
        //Part 8 
        System.out.println("--- 8. Removed songs are skipped ---");
        System.out.printf("s1: %d\n", demo.playCount(1));
        System.out.printf("s3: %d\n", demo.playCount(3));
        System.out.printf("s6: %d\n", demo.playCount(6));
        System.out.printf("s5 (removed): %d\n", demo.playCount(5 ));
        //Part 9 
        System.out.println("--- 9. Empty player ---");
        System.out.printf("next: %s\n", emptyPlayer.next());
        System.out.printf("back: %s\n", emptyPlayer.back());
        System.out.printf("now playing: %s\n", emptyPlayer.nowPlaying());
        System.out.printf("playlist: %s\n", emptyPlayer.showPlaylist());
        //----------------------------------------------------------------
        //Part Extra credit
        MusicPlayer extraDemo = new MusicPlayer();
        extraDemo.addSong(1, "Night Drive", "Steven Hulse");
        extraDemo.addSong(2, "Slow Tide", "Steven Hulse");
        extraDemo.addSong(3, "Copper Sky", "Steven Hulse");
        extraDemo.addSong(4, "Static Boom", "Steven Hulse");
        extraDemo.addSong(5, "Low Orbit", "Steven Hulse");
        extraDemo.addSong(6, "Glass Rivers", "Steven Hulse");
        System.out.println("\n\n\n");
        System.out.println("--- Extra credit: Shuffle ---");
        System.out.printf("Example playlist: %s\n", extraDemo.showPlaylist());
        extraDemo.shuffle();
        System.out.printf("Shuffled up next 1: %s\n", extraDemo.showUpNext());
        extraDemo.clearUpNextQueue();
        extraDemo.shuffle();
        System.out.printf("Shuffled up next 2: %s\n", extraDemo.showUpNext());
        extraDemo.clearUpNextQueue();
        extraDemo.shuffle();
        System.out.printf("Shuffled up next 3: %s\n", extraDemo.showUpNext());
    }

}