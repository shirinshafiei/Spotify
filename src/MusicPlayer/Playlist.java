package MusicPlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Playlist {
    private String title;
    private ArrayList<Music> playlist = new ArrayList<>();
    private final User owner;

    public Playlist(String title, User owner){
        this.title = title;
        this.owner = owner;
    }

    public void editTitle(String newTitle, String password) throws InvalidOperationException {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("رمز عبور نامعتبر است");
        }
        this.title = newTitle;
    }

    public void addMusic(Music music, String password) throws InvalidOperationException {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("رمز عبور نامعتبر است");
        }
        if (playlist.contains(music)) {
            throw new InvalidOperationException("موزیک تکراری است");
        }
        playlist.add(music);
    }

    public void removeMusic(Music music, String password) throws InvalidOperationException {
        if (!owner.getPassword().equals(password)) {
            throw new InvalidOperationException("رمز عبور نامعتبر است");
        }
        if (!playlist.remove(music)) {
            throw new InvalidOperationException("موزیک در پلی‌لیست وجود ندارد");
        }
    }

    public ArrayList<Music> searchInPlaylist(String title) {
        ArrayList<Music> result = new ArrayList<>();
        for (Music music : playlist) {
            if (music.title.equals(title)) {
                result.add(music);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public Music searchInPlaylist(String title, User singer) {
        for (Music music : playlist) {
            if (music.title.equals(title) && music.singer.equals(singer)) {
                return music;
            }
        }
        return null;
    }

    public void playPlaylist() {
        for (Music music : playlist) {
            music.play();
        }
    }

    public void shufflePlaylist() {
        Collections.shuffle(playlist, new Random());
        playPlaylist();
    }

    public String getTitle() { return title; }
    public ArrayList<Music> getPlaylist() { return playlist; }
    public User getOwner() { return owner; }
}

