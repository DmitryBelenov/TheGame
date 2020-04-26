package game.action.factory;


import game.object.LevelActionShape;
import game.statics.ScreenManager;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ItemStateRemoteAction implements Action {

    private LevelActionShape las;

    public ItemStateRemoteAction(LevelActionShape las){
        this.las = las;
    }

    public void invoke() throws SlickException {
        if (las.isRemoteActionDone()) {
            ScreenManager.setInscription("Remote action already done..");
        } else {
            LevelActionShape tiedShape = las.getTiedActionShape();
            if (tiedShape != null){
                tiedShape.setRemoteActionDone(true);
                Image img = tiedShape.getAlternateShapeImage();
                if (img != null){
                    tiedShape.setShapeImage(img);
                }

                ScreenManager.setInscription("Remote action '"+tiedShape.getName()+"' done");

                Image altImg = las.getAlternateShapeImage();

                if (altImg != null) {
                    las.setShapeImage(altImg);
                }
                las.setRemoteActionDone(true);
            } else {
                ScreenManager.setInscription("Nothing..");
            }
        }
    }
}
