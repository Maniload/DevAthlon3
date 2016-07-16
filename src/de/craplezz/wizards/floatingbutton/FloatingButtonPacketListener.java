package de.craplezz.wizards.floatingbutton;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedWatchableObject;
import de.craplezz.wizards.Wizards;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Schuckmann on 28.05.2016.
 */
public class FloatingButtonPacketListener extends PacketAdapter {

    public FloatingButtonPacketListener() {
        super(Wizards.getInstance(), PacketType.Play.Server.SPAWN_ENTITY, PacketType.Play.Server.ENTITY_METADATA, PacketType.Play.Server.ENTITY_EQUIPMENT);
    }

    @Override
    public void onPacketSending(PacketEvent event) {
        Player player = event.getPlayer();
        PacketContainer packet = event.getPacket();
        if (FloatingText.isFloatingText(packet.getIntegers().read(0))) {
            FloatingText floatingText = FloatingText.getFloatingText(packet.getIntegers().read(0));
            if (packet.getType() == PacketType.Play.Server.ENTITY_METADATA) {
                List<WrappedWatchableObject> watchableObjects = packet.getWatchableCollectionModifier().read(0);
                for (int i = 0; i < watchableObjects.size(); i++) {
                    WrappedWatchableObject watchableObject = watchableObjects.get(i);
                    if (watchableObject.getIndex() == 2) {
                        watchableObject.setValue(floatingText.getDisplayName(player));
                        watchableObjects.set(i, watchableObject);
                        break;
                    }
                }
                packet.getWatchableCollectionModifier().write(0, watchableObjects);
            }
            else if (packet.getType() == PacketType.Play.Server.ENTITY_EQUIPMENT && floatingText instanceof FloatingButton) {
                if (packet.getIntegers().read(1) == 4) {
                    packet.getItemModifier().write(0, ((FloatingButton) floatingText).getHelmet(player));
                }
            }
            event.setPacket(packet);
        }
    }

}
