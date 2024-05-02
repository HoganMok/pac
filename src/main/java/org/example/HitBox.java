package org.example;

import java.awt.*;

public class HitBox {
    protected Rectangle hitbox;
    public HitBox(float x, float y, int width, int height){
        hitbox = new Rectangle((int)x, (int)y, width, height);
    }
    public void updateHixBox(float x, float y) {
        hitbox.x = (int)x;
        hitbox.y = (int)y;
    }
    public Rectangle getHitbox(){return hitbox;}
    public void drawHitBox(Graphics g){
        g.setColor(Color.CYAN);
        g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }
}
