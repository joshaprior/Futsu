package nl.joshaprior.futsu.data;

import nl.joshaprior.futsu.check.Detection;
import nl.joshaprior.futsu.utils.TimerUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.LinkedHashMap;

public class DataPlayer {

    private Player player;

    public Location location;
    public boolean onGround;

    public TimerUtils lastBlockPlace = new TimerUtils(this);

    public DataPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}