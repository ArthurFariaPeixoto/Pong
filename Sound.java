import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {

    private AudioClip clip;

    public static final Sound win = new Sound("/win.wav");
    public static final Sound lose = new Sound("/lose.wav");
    public static final Sound bounce = new Sound("/bounce.wav");
    public static final Sound music = new Sound("/music.wav");

    private Sound(String name) {
        try {
            clip = Applet.newAudioClip(Sound.class.getResource(name));
        }catch(Throwable e) {}
    }

    public void play() {
        try {
            new Thread(() -> clip.play()).start();
        }catch(Throwable e) {}
    }

    public void loop() {
        try {
            new Thread(() -> clip.loop()).start();
        }catch(Throwable e) {}
    }

    public void stop(){
        clip.stop();
    }
}
