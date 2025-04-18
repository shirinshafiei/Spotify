package MusicPlayer;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<User> followerList = new ArrayList<>();
    private ArrayList<User> followingList = new ArrayList<>();
    private UserBehavior behavior ;
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password) throws InvalidOperationException{
        for (User user : allUsers){
            if (user.username.equals(username)){
                throw new InvalidOperationException("نام کاربری نمی تواند تکراری باشد");
            }
        }
        if (password.length() < 8){
            throw new InvalidOperationException("رمز عبور نمی تواند کمتر از 8 کارکتر باشد");
        }
        this.username = username;
        this.password = password;
        this.behavior = new RegularBehavior();
        allUsers.add(this);
    }

    public void follow (User user){
        for (User users : followingList){
            if (users.username.equals(user.username)){
                throw new InvalidOperationException("این کاربر را قبلا قالو کرده اید");
            }
        }

        this.followingList.add(user);
        user.followerList.add(this);
    }

    public void createPlaylist (String Title){
        this.behavior.createPlaylist(Title, this);
    }

    public void playMusic (Music music){
        this.behavior.playMusic(music);
    }

    public void buyPremium(int month){
        this.behavior.buyPremium(this, month);
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public ArrayList<Playlist> getPlaylists() { return playlists; }
    public ArrayList<User> getFollowingList() {return followingList; }
    public ArrayList<User> getFollowerList() {return followerList; }
    public static ArrayList<User> getAllUsers() {return allUsers;}
    public void setBehavior(UserBehavior behavior) { this.behavior = behavior; }

}