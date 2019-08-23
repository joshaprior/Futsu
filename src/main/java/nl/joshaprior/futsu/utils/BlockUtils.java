package nl.joshaprior.futsu.utils;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.type.Slab;
import org.bukkit.block.data.type.Stairs;

public class BlockUtils {

    public static boolean isSlab(Block block) {
        return block.getType().data.equals(Slab.class);
    }

    public static boolean isStair(Block block) {
        return block.getType().data.equals(Stairs.class);
    }

    public static boolean isLiquid(Block block) {
        return block.getType().data.equals(Levelled.class);
    }

    public static boolean isSolid(Location location) {
        return location.getBlock().getType().isSolid();
    }

    public static boolean isSolid(double x, double y, double z) {
        return false;
    }
}
