package org.example;

import java.util.List;

public class CollisionDetection {
    public boolean isCollided(List<HitBox> hitBoxList1, HitBox hitBox2){
        for (HitBox hitBox1: hitBoxList1) {
            if (hitBox1.getHitbox().intersects(hitBox2.getHitbox())) {return true;}
        }
        return  false;
    }
}
