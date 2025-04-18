package MusicPlayer;

public class PremiumBehavior implements UserBehavior{
    public int month;

    public PremiumBehavior(int month){
        if (month < 0){
            throw new InvalidOperationException("ماه نمی تواند منفی باشد");
        }
        this.month = month;
    }

    @Override
    public void createPlaylist(String Title, User Owner) {
        Playlist playlist = new Playlist(Title , Owner);
        Owner.getPlaylists().add(playlist);
    }

    @Override
    public void playMusic(Music music) {
        music.play();
    }

    @Override
    public void buyPremium(User Owner, int month) {
        this.month =+ month;
    }
}
