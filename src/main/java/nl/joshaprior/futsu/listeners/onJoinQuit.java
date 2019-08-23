package nl.joshaprior.futsu.listeners;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import nl.joshaprior.futsu.Futsu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import javax.swing.*;

public class onJoinQuit implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Futsu.getDataManager().add(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Futsu.getDataManager().remove(event.getPlayer());
    }
}
