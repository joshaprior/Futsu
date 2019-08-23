package nl.joshaprior.futsu.check;

import com.comphenix.protocol.events.PacketAdapter;
import nl.joshaprior.futsu.Futsu;
import nl.joshaprior.futsu.utils.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.LinkedHashMap;

public class Detection implements Listener {

    private String name;
    private Check parent;

    public LinkedHashMap<Player, Integer> vl = new LinkedHashMap<>();

    public Detection(String name, Check parent) {
        this.name = name;
        this.parent = parent;
        Futsu.getPlugin().getServer().getPluginManager().registerEvents(this, Futsu.getPlugin());
    }

    public String getName() {
        return name;
    }

    public Check getParent() {
        return parent;
    }

    public void flag(Player player, String... info) {
        int violations = this.vl.getOrDefault(player, 0) + 1;

        player.spigot().sendMessage(ChatUtils.Flag(this, player, info));

        if (violations > parent.getMax()) {
            player.sendMessage("You would have been kicked!");
            violations = 0;
        }
        this.vl.put(player, violations);
    }
}
