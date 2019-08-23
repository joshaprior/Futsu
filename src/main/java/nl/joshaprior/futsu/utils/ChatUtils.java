package nl.joshaprior.futsu.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import nl.joshaprior.futsu.check.Detection;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class ChatUtils {

    public static TextComponent Flag(Detection detection, Player player, String... info) {
        TextComponent text = new TextComponent();

        text.setColor(ChatColor.LIGHT_PURPLE);
        text.setBold(true);
        text.addExtra("[Futsu]");

        TextComponent append = new TextComponent(" failed ");
        append.setColor(ChatColor.RESET);
        text.addExtra(append);


        append = new TextComponent(detection.getParent().getName());
        append.setColor(ChatColor.DARK_PURPLE);
        text.addExtra(append);


        append = new TextComponent(" ");
        append.setColor(ChatColor.RESET);
        text.addExtra(" ");

        append = new TextComponent("(" + detection.getName() + ")");
        append.setColor(ChatColor.DARK_GRAY);
        text.addExtra(append);


        append = new TextComponent(" - ");
        append.setColor(ChatColor.RESET);
        text.addExtra(append);


        append = new TextComponent(detection.vl.getOrDefault(player, 0) + " > " + detection.getParent().getMax());
        append.setColor(ChatColor.GRAY);
        text.addExtra(append);

        ComponentBuilder hover = new ComponentBuilder("");

        if (info.length > 0) {
            Arrays.stream(info).forEach(i -> {
                hover.append(i);
                hover.append("\n");
            });
            text.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hover.create()));
        }
        return text;
    }
}
