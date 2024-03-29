import java.util.ArrayList;
import java.util.List;

public class PlayerBase {

    private List<Player> playerList = new ArrayList<>();

    public PlayerBase(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
