package game.action;

import game.action.factory.*;
import game.object.ActionType;
import game.object.LevelActionShape;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ActionManager {

    private StateBasedGame sbg;
    private LevelActionShape levelActionShape;

    public ActionManager(StateBasedGame sbg, LevelActionShape levelActionShape){
        this.sbg = sbg;
        this.levelActionShape = levelActionShape;
    }

    public void invokeAction() throws SlickException {
        ActionFactory actionFactory = getFactory(levelActionShape.getType());

        if (actionFactory != null) {
            Action action = actionFactory.getAction();
            action.invoke();
        } else {
            System.out.println("Can't initialize action factory for remote action shape: "+levelActionShape.getName());
        }
    }

    private ActionFactory getFactory(ActionType actionType){
        switch (actionType){
            case stage:
                return new StageChangeActionFactory(sbg, levelActionShape.getGoToStageCode());
            case itemBox:
                return new GetItemFromBoxActionFactory(levelActionShape);
            case remote_action:
                return new ItemStateRemoteActionFactory(levelActionShape);
            case dangerous_barrier:
                return new DangerousBarrierActionFactory(levelActionShape, sbg);
            default:
                    return null;
        }
    }
}
