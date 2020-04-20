package game.state;

import game.SetupGame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverState extends BasicGameState {
    public int getID() {
        return 1001;
    }

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.drawString("Game over", 470, 360);
        g.drawString("Press ENTER to EXIT", SetupGame.WIDTH - 250, SetupGame.HEIGHT - 50);
        g.setColor(Color.transparent);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
            System.exit(0);
        }
    }
}
