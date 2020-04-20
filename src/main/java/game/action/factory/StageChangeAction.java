package game.action.factory;

import game.statics.StageInitializer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class StageChangeAction implements Action{
    private StateBasedGame sbg;
    private String stageCode;

    public StageChangeAction(StateBasedGame sbg, String stageCode){
        this.sbg = sbg;
        this.stageCode = stageCode;
    }

    public void invoke() throws SlickException {
        StageInitializer.stageInit(stageCode);
        sbg.enterState(0, new FadeOutTransition(), new FadeInTransition());
    }
}
