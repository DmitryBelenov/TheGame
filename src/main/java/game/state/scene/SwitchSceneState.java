package game.state.scene;

import game.SetupGame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class SwitchSceneState extends BasicGameState {
    public static int stageNumber;
    public static String stageName;

    public int getID() {
        return 0;
    }

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
    }

    public void render(GameContainer gameContainer, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.drawString("Scene "+stageNumber+". "+stageName, 430, 360);
        g.drawString("Press ENTER", SetupGame.WIDTH - 150, SetupGame.HEIGHT - 50);
        g.setColor(Color.transparent);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
            sbg.enterState(stageNumber, new FadeOutTransition(), new FadeInTransition());
        }
    }
}
