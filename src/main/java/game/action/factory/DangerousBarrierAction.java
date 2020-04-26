package game.action.factory;

import game.object.LevelActionShape;
import game.statics.ScreenManager;
import game.statics.StageInitializer;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class DangerousBarrierAction implements Action {

    private LevelActionShape levelActionShape;
    private StateBasedGame sbg;

    public DangerousBarrierAction(LevelActionShape levelActionShape, StateBasedGame sbg){
        this.levelActionShape = levelActionShape;
        this.sbg = sbg;
    }

    public void invoke() throws SlickException {
        if (!levelActionShape.isRemoteActionDone()){
            Animation animation = levelActionShape.getTiedAnimation();
            if (animation != null){
                ScreenManager.animateLevelAction(levelActionShape.getTiedAnimation(),
                        levelActionShape.getActionShape().getX(),
                        levelActionShape.getActionShape().getY());
            }

            StageInitializer.setGameOver();
        } else {
            ScreenManager.setInscription("Oh nice, no barrier now!");
        }
    }
}
