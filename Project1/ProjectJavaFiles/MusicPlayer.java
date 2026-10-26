import java.util.HashMap;
import java.util.Map;

public class MusicPlayer{
    //Static Class
    public static class Music {
        private String title, author;
        private int playcount;
        public Music(String title, String author) {
            this.title = title;
            this.author = author;
            this.playcount = 0;
        }
        public boolean equals(Music otherMusic) {
            return this.title == otherMusic.title && this.author == otherMusic.author;
        }
        public String toString() {
            return this.title;
        }
    }
    //----------------------------------------------------------------
    //Instance Variables
    private Map<Integer, Music> library = new HashMap<>();
    private DoublelyLinkedList<Music> playlist = new DoublelyLinkedList<>();
    private DoublelyLinkedList<Music> upNext = new DoublelyLinkedList<>();
    private Stack<Music> history = new Stack<>();
    private Music playingNow;
    //----------------------------------------------------------------
    //Methods 
    public boolean addSong(int id, String title, String artist) {
        
        Music selectedMusic = new Music(title, artist);
        //Check to see if song id exists and return proper bool val
        if (library.containsKey(id)) 
            return false;
        else {
            //Add music to end of playlist 
            playlist.append(selectedMusic);
            library.put(id, selectedMusic);
        }
        return true;

    }
    public Music findSong(int id) {
            return library.get(id);
    }
    public String showPlaylist() {
        return playlist.toString();
    }
    public Music play(int id) {
        Music selectedMusic = library.get(id);
        if(selectedMusic == null) return null;
        if(playingNow != null) history.push(playingNow);
        playHelper(selectedMusic);
        return playingNow;
    }
        private void playHelper(Music selectedMusic) {
        playingNow = selectedMusic;
        playingNow.playcount++;
        }
    public Music nowPlaying() {
        return playingNow;
    }
    public int playCount(int id) {
        Music selectedMusic = library.get(id);
        try {
            return selectedMusic.playcount;
        } catch (NullPointerException e) {
            return 0;
        }
    }
    public boolean queueLater(int id) {
        Music selectedMusic = library.get(id);
        if (selectedMusic != null)
            return upNext.append(selectedMusic);
        return false;
    } 
    public boolean queueNext(int id) {
        Music selectedMusic = library.get(id);
        if (selectedMusic != null)
            return upNext.prepend(selectedMusic);
        return false;
    }
    public String showUpNext() {
        String returnString = "[";
        if(upNext.getSize() == 0)
            return "";
        for(int i = 0; i < upNext.getSize(); i++) {
            if(playlist.conatins(upNext.get(i))) {
                returnString += String.format("%s", upNext.get(i));
                if (i != upNext.getSize()-1) returnString += ", "; 
            }
            if(i == upNext.getSize()-1) returnString +="]";
        }
        return returnString;
    }
    public Music next() {
        Music selectedMusic = null;
        if (upNext.getHead() != null) {
            selectedMusic = upNext.getHeadElement();
            //Cycle and skip removed elements
            while(!playlist.conatins(selectedMusic) && selectedMusic != null && upNext.getHead() != null) {
                selectedMusic = upNext.getHeadElement();
                upNext.removeHead();
            }
        }
        if (selectedMusic == null) {
            selectedMusic = playingNow;
            int currentSongPlaylistIndex = playlist.indexOf(selectedMusic);
            if(currentSongPlaylistIndex != -1)
                selectedMusic = playlist.get(currentSongPlaylistIndex+1);
            if (selectedMusic == null) 
                return null;
        }
        if (playingNow != null) 
                history.push(playingNow);
        playHelper(selectedMusic);
        upNext.removeHead();
        return playingNow;
    }
    public Music back() {
        Music selectedMusic = null;
        if(history.peek() != null)
        selectedMusic = history.peek().getElement();
        //Cycle and skip removed elements 
        while (!playlist.conatins(selectedMusic) && selectedMusic != null) {
            history.pop();
            selectedMusic = history.peek().getElement();
        } 
        if (selectedMusic == null) 
            return null; //if history is NO null, playingNow must have a non null value
        upNext.prepend(playingNow);
        playHelper(selectedMusic);
        history.pop();
        return playingNow;
    }
    public String showHistory() {
        String returnString = "[";
        if(history.getSize() == 0)
            return "";
        for(int i = 0; i < history.getSize(); i++) {
            if(playlist.conatins(history.peekAt(i))) {
                returnString += String.format("%s", history.peekAt(i));
                if (i != history.getSize()-1) returnString += ", ";
            }
            if(i == history.getSize()-1) returnString +="]";
        }
        return returnString;
    }
    public boolean removeSong(int id) {
        Music selectedMusic = library.get(id);
        if (selectedMusic == null || selectedMusic == playingNow) return false;
        playlist.removeAt(playlist.indexOf(selectedMusic));
        library.remove(id);
        return true;
    }
    //----------------------------------------------------------------
    //Extra
    public void clearUpNextQueue() {
        upNext.clear();
    }
    public void shuffle() {
        int size = playlist.getSize();
        boolean[] refArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            int chooseIndex = (int)((size - i) * Math.random());
            for (int j = 0; j < chooseIndex+1; j++) {
                if(refArr[j]) chooseIndex++;
            }
            upNext.append(playlist.get(chooseIndex));
            refArr[chooseIndex] = true;
        }
    }
    //----------------------------------------------------------------
} 