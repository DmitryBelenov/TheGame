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

                Rectangle itemCallArea = new Rectangle(item.getX() - 30, item.getY() - 30, 60, 60);
                Rectangle playerCollBlock = new Rectangle(player.getX() - 15, player.getY() - 40, 32, 80);


                g.fill(itemCallArea);
                g.fill(playerCollBlock);

                // action on approach to item
                if (playerCollBlock.intersects(itemCallArea)){
                    g.setColor(Color.white);
                    g.drawString(item.getDescription(), item.getX(), item.getY() - 16);
                    g.setColor(Color.transparent);

                    if (gc.getInput().isKeyDown(Input.KEY_E)){
                        item.setShow(false);
                        ScreenManager.setInscription(item.getDescription()+": "+item.getContent());

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
