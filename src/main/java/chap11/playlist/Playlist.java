package chap11.playlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {
    private List<Song> tracks = new ArrayList<>();
    private Map<String, String> singers = new HashMap<>();

    public void append(Song song) {
        tracks.add(song);
        singers.put(song.getSinger(), song.getTitle());
    }

    // public void remove(Song song) {
    //     tracks.remove(song);
    //     singers.remove(song.getSinger());
    // }


    public List<Song> getTracks() {
        return tracks;
    }

    public Map<String, String> getSingers() {
        return singers;
    }
}
