package game.action.factory;

import org.newdawn.slick.state.StateBasedGame;

public class StageChangeActionFactory implements ActionFactory {
    private StateBasedGame sbg;
    private String stageCode;

    public StageChangeActionFactory(StateBasedGame sbg, String stageCode){
        this.sbg = sbg;
        this.stageCode = stageCode;
    }

    public Action getAction() {
        return new StageChangeAction(sbg, stageCode);
    }
}
