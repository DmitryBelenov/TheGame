package game.action.factory;

import game.object.LevelActionShape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class DangerousBarrierActionFactory implements ActionFactory{

    private LevelActionShape levelActionShape;
    private StateBasedGame sbg;

    public DangerousBarrierActionFactory(LevelActionShape levelActionShape, StateBasedGame sbg){
        this.levelActionShape = levelActionShape;
        this.sbg = sbg;
    }

    public Action getAction() {
        return new DangerousBarrierAction(levelActionShape, sbg);
    }
}
