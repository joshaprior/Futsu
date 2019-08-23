package nl.joshaprior.futsu.check.checks.movement.nofall.type;

import com.comphenix.packetwrapper.WrapperPlayClientFlying;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.*;
import nl.joshaprior.futsu.Futsu;
import nl.joshaprior.futsu.check.Check;
import nl.joshaprior.futsu.check.Detection;
import nl.joshaprior.futsu.data.DataPlayer;
import nl.joshaprior.futsu.utils.ChatUtils;
import org.bukkit.entity.Player;

public class TypeA extends Detection {

    public TypeA(String name, Check parent) {
        super(name, parent);

        Futsu.getProtocolManager().addPacketListener(new PacketAdapter(Futsu.getPlugin(), ListenerPriority.NORMAL,
                PacketType.Play.Client.FLYING) {

            @Override
            public void onPacketReceiving(PacketEvent event) {
                PacketContainer packet = event.getPacket();
                Player player = event.getPlayer();
                DataPlayer data = Futsu.getDataManager().getDataPlayer(player);
                if (event.getPacketType() == PacketType.Play.Client.FLYING) {
                    WrapperPlayClientFlying wrapper = new WrapperPlayClientFlying(packet);
                    if (wrapper.getOnGround() != data.onGround && data.lastBlockPlace.hasPassed(10)) {
                        wrapper.setOnGround(false);
                        flag(player,
                                "Data",
                                "OnGround: " + data.onGround,
                                "Packet",
                                "OnGround: " + wrapper.getOnGround()
                        );
                    }
                }
            }
        });
    }
}
