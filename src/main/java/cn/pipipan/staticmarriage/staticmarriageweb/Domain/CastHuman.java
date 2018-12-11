package cn.pipipan.staticmarriage.staticmarriageweb.Domain;

import com.pipipan.staticmarriage.Human;

import java.io.Serializable;

public class CastHuman implements Serializable {
    int id;
    int[] peer;
    int lover_id;
    public CastHuman(Human human){
        id = human.getId();
        peer = human.getPeer();
        lover_id = human.getLover() == null ? -1 : human.getLover().getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getPeer() {
        return peer;
    }

    public void setPeer(int[] peer) {
        this.peer = peer;
    }

    public int getLover_id() {
        return lover_id;
    }

    public void setLover_id(int lover_id) {
        this.lover_id = lover_id;
    }
}
