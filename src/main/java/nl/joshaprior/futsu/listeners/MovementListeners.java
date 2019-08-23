package nl.joshaprior.futsu.listeners;

import nl.joshaprior.futsu.Futsu;
import nl.joshaprior.futsu.data.DataPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementListeners implements Listener {

    public MovementListeners() {
        Futsu.getPlugin().getServer().getPluginManager().registerEvents(this, Futsu.getPlugin());



    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        DataPlayer data = Futsu.getDataManager().getDataPlayer(player);

        data.location = player.getLocation();
        data.onGround = player.isOnGround();

    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        DataPlayer data = Futsu.getDataManager().getDataPlayer(player);
        data.lastBlockPlace.reset();
    }
}
