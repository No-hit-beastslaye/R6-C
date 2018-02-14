import javafx.application.*;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;

import javafx.stage.*;
import javafx.event.*;
import javafx.scene.image.*;

import javafx.scene.text.*;
import javafx.scene.Group;

import javafx.scene.media.*;
import javax.sound.sampled.*;
import java.io.File;

public class Main extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  public Char Player = new Char();

  @Override    //Boot up.
  public void start(final Stage first)
  {
    //Image en viewport voor het start scherm
    Pane background1 = new Pane();
    Image Child = new Image("images/intro-screen.jpg");
    ImageView Rainbow = new ImageView();

    //Image wordt aangeroepen.
    Rainbow = new ImageView(Child);
    background1.getChildren().add(Rainbow);

    String geluid = "BackgroundMusic";

    //Groups
    Group oofer = new Group();
    Group root2 = new Group();

    //Scenes
    final Scene game = new Scene(oofer, 1250, 750);
    final Scene fight = new Scene(root2, 1250, 750);

    //Text voor het start scherm.
    Text intro = new Text();
    intro.setText("Welcome to Rainbow 6: Cancer.");
    intro.setFont(Font.font("sans-serif", FontWeight.BOLD, FontPosture.REGULAR, 40));
    intro.setFill(Color.WHITE);
    intro.setStrokeWidth(2);
    intro.setStroke(Color.BLACK);
    intro.setX(320);
    intro.setY(175);

    //Audio this was big GAY to make it run good........
    String path = "audio/BgM.mp3";
    Media BackgroundMusic = new Media(new File(path).toURI().toString());
    MediaPlayer audio = new MediaPlayer(BackgroundMusic);
    audio.setAutoPlay(true);
    MediaView mediaview = new MediaView(audio);

    //Button functies
    Button play = new Button();
    play.setLayoutX(550);
    play.setLayoutY(400);
    play.setText("Play the game already.");
    play.setOnAction(new EventHandler<ActionEvent>()
    {
      public void handle(ActionEvent event)
      {
        first.setScene(fight);
      }
    });
    oofer.getChildren().addAll(background1, play, intro);

    first.setScene(game);
    first.setTitle("Rainbow 6: Cancer");
    first.show();

    Text hud = new Text();
    hud.setText("Move!");
    hud.setLayoutX(600);
    hud.setLayoutY(50);
    hud.setFont(Font.font("sans-serif", FontWeight.BOLD, FontPosture.REGULAR, 20));

    //Image model = new Image();

    root2.getChildren().addAll(hud);
  }

}
