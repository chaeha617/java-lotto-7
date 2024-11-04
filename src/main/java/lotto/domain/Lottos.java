package lotto.domain;

import java.util.LinkedList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new LinkedList<>();


    public Lottos(){
    }

    public void addLotto(Lotto lotto){
        lottos.add(lotto);
    }

    public int size(){
        return lottos.size();
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Lotto lotto : lottos){
            stringBuilder.append(lotto.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
