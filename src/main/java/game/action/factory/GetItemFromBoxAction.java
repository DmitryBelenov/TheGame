package game.action.factory;

import game.object.LevelActionShape;
import game.object.QuestItem;
import game.statics.ScreenManager;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GetItemFromBoxAction implements Action {
    private LevelActionShape levelActionShape;

    public GetItemFromBoxAction(LevelActionShape levelActionShape){
        this.levelActionShape = levelActionShape;
    }

    public void invoke() throws SlickException {
        Image image = levelActionShape.getAlternateShapeImage();
        if (image != null){
            levelActionShape.setShapeImage(image);
        }

        QuestItem item = levelActionShape.getTiedItem();

        if (item != null) {
            if (!ScreenManager.iItems.contains(item)) {
                ScreenManager.setInscription(item.getDescription() + ": " + item.getContent());

                if (ScreenManager.iItems.size() == 10) {
                    ScreenManager.iItems.remove(0);
                }
                ScreenManager.iItems.add(item);

                Animation animation = levelActionShape.getTiedAnimation();
                if (animation != null){
                    ScreenManager.animateLevelAction(levelActionShape.getTiedAnimation(),
                            levelActionShape.getActionShape().getX(),
                            levelActionShape.getActionShape().getY());
                }
            } else {
                ScreenManager.setInscription("This item already used here..");
            }
        }
    }
}
