package statistics.matcher;

import java.util.LinkedList;
import statistics.Player;

public class Query {

    private LinkedList<Player> alkiot;

    public Query() {
        alkiot = new LinkedList<>();
    }

    public void push(Player alkio){
        alkiot.addFirst(alkio);
    }

    public Player pop(){
        return alkiot.remove();
    }

    public boolean empty(){
        return alkiot.isEmpty();
    }
}
