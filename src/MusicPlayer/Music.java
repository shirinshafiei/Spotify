package MusicPlayer;

import java.util.ArrayList;

public class Music {
    public String title;
    public User singer;
    public static ArrayList<Music> allMusics = new ArrayList<>();
    int numberOfStream = 0;

    public Music(String title, User singer) {
        boolean found = false;
        for (User user : User.getAllUsers()){
            if (user.equals(singer)){
                found = true;
            }
        }
        if (!found){
            throw new InvalidOperationException("خواننده وجود ندارد");
        }

        this.title = title;
        this.singer = singer;

        allMusics.add(this);
    }

    public void play() {
        System.out.println("در حال پخش موزیک '" + title + "' از " + singer.getUsername());
        numberOfStream++;
    }

    public static ArrayList<Music> search(String title) {
        ArrayList<Music> result = new ArrayList<>();

        for (Music music : allMusics) {
            if (music.title.equals(title)) {
                result.add(music);
            }
        }
        if (result.isEmpty()){
            return null;

        }else {
            return result;
        }
    }

    public static Music search(String title, User singer) {
        for (Music music : allMusics) {
            if (music.title.equals(title) && music.singer.equals(singer)) {
                return music;
            }
        }
        return null;
    }

}