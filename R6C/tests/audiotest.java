import sun.audio.*;
import java.io.*;

public class audiotest
{
  public static void main(String[] args)
  throws Exception
  {
        // open the sound file as a Java input stream
    String gongFile = "BgM.mp3";
    InputStream in = new FileInputStream(gongFile);

    // create an audiostream from the inputstream
    AudioStream oof = new AudioStream(in);

    // play the audio clip with the audioplayer class
    AudioPlayer.player.start(oof);
  }

  private void playSound()
{
  try
  {
    // get the sound file as a resource out of my jar file;
    // the sound file must be in the same directory as this class file.
    // the input stream portion of this recipe comes from a javaworld.com article.
    InputStream inputStream = getClass().getResourceAsStream("BgM.mp3");
    AudioStream audioStream = new AudioStream(inputStream);
    AudioPlayer.player.start(audioStream);
  }
  catch (Exception e)
  {
    // a special way i'm handling logging in this application
    if (debugFileWriter!=null) e.printStackTrace(debugFileWriter);
  }
}
}
