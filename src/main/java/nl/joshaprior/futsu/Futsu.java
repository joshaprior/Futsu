package nl.joshaprior.futsu;

import com.comphenix.protocol.*;
import nl.joshaprior.futsu.check.CheckManager;
import nl.joshaprior.futsu.data.DataManager;
import nl.joshaprior.futsu.listeners.MovementListeners;
import nl.joshaprior.futsu.listeners.onJoinQuit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Futsu extends JavaPlugin implements Listener {

    private static Futsu plugin;
    private static ProtocolManager protocolManager;
    private MovementListeners movementListeners;

    private static DataManager dataManager;
    private static CheckManager checkManager;

    private int currentTick;
    public double tps = -1;

    @Override
    public void onEnable() {
        plugin = this;
        protocolManager = ProtocolLibrary.getProtocolManager();
        movementListeners = new MovementListeners();

        dataManager = new DataManager();
        checkManager = new CheckManager();

        plugin.getServer().getPluginManager().registerEvents(new onJoinQuit(), this);

        runTasks();
    }

    @Override
    public void onDisable() {

    }

    private void runTasks() {
        //TPS check
        new BukkitRunnable() {
            long sec;
            long currentSec;
            int ticks;

            public void run() {
                sec = (System.currentTimeMillis() / 1000L);
                if (currentSec == sec) {
                    ticks += 1;
                } else {
                    currentSec = sec;
                    tps = (tps == 0.0D ? ticks : (tps + ticks) / 2.0D);
                    ticks = 1;
                }
                currentTick++;
            }
        }.runTaskTimer(this, 0L, 1L);
    }

    public static Futsu getPlugin() {
        return plugin;
    }

    public static ProtocolManager getProtocolManager() {
        return protocolManager;
    }

    public static DataManager getDataManager() {
        return dataManager;
    }

    public static CheckManager getCheckManager() {
        return checkManager;
    }

    public MovementListeners getMovementListeners() {
        return movementListeners;
    }

    public int getCurrentTick() {
        return currentTick;
    }
}
