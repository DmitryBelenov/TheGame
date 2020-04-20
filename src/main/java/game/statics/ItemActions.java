package game.statics;

import game.object.Character;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import game.object.QuestItem;

import java.util.List;

public class ItemActions {

    public static void itemApproachAction(List<QuestItem> questItems, Graphics g, GameContainer gc, Character player){
        for (QuestItem item : questItems){
            if (item.isShow()){
                Image i = item.getImage();
                i.draw(item.getX(), item.getY());

                Rectangle itemCallArea = new Rectangle(item.getX() - 36, item.getY() - 36, 96, 96);
                Rectangle playerCollBlock = new Rectangle(player.getX() - 36, player.getY() - 36, 96, 96);


                g.fill(itemCallArea);
                g.fill(playerCollBlock);

                // action on approach to item
                if (playerCollBlock.intersects(itemCallArea)){
                    g.setColor(Color.white);
                    g.drawString(item.getDescription(), item.getX(), item.getY() - 16);
                    g.setColor(Color.transparent);

                    if (gc.getInput().isKeyDown(Input.KEY_E)){
                        item.setShow(false);
                        ScreenManager.setInscription("Got "+item.getDescription()+": "+item.getContent());

                        if (ScreenManager.iItems.size() == 10){
                            ScreenManager.iItems.remove(0);
                        }
                        ScreenManager.iItems.add(item);
                    }
                }
            }
        }
    }
}
