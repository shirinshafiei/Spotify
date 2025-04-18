package MusicPlayer;

public class RegularBehavior implements UserBehavior{
    public int playingLimit = 5;
    @Override
    public void createPlaylist(String Title, User Owner) throws InvalidOperationException {
        throw new InvalidOperationException("کاربر عادی نمی تواند پلی لیست بسازد");
    }

    @Override
    public void playMusic(Music music) throws InvalidOperationException {
        if (playingLimit <= 0) {
            throw new InvalidOperationException("محدودیت پلی کردن موزیک برای کاربران عادی به پایان رسیده است");
        }
        music.play();
        playingLimit--;
    }

    @Override
    public void buyPremium(User owner, int month) {
        if (month < 0){
            throw new InvalidOperationException("ماه نمی تواند منفی باشد");
        }
        owner.setBehavior(new PremiumBehavior(month));
    }
}
