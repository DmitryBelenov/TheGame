package game;

import game.state.GameOverState;
import game.state.scene.Scene1State;
import game.state.scene.Scene2State;
import game.state.scene.SwitchSceneState;
import game.statics.StageInitializer;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class SetupGame extends StateBasedGame {

//    public static int WIDTH = 1024;
//    public static int HEIGHT = 768;

    public static int WIDTH = 800;
    public static int HEIGHT = 600;

    private static int TARGET_FPS = 60;

    private SetupGame(String title) {
        super(title);
    }

    public void initStatesList(GameContainer container) throws SlickException {
        // for change stages (START - code of first scene)
        StageInitializer.stageInit("START");

        this.addState(new SwitchSceneState());
        this.addState(new Scene1State());
        this.addState(new Scene2State());
        this.addState(new GameOverState());
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new SetupGame("Game"));
        app.setDisplayMode(SetupGame.WIDTH, SetupGame.HEIGHT, false);
        app.setTargetFrameRate(SetupGame.TARGET_FPS);
        app.setVSync(true);
        app.start();
    }
}
