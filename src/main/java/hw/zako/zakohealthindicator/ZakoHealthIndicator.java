package hw.zako.zakohealthindicator;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.SettingsElement;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.labymod.api.LabyModAPI;

import java.util.List;

public class ZakoHealthIndicator extends LabyModAddon {

    public void onEnable() {
        System.out.println("Addon loaded");
    }

    @Override
    public void loadConfig() {

    }

    @Override
    protected void fillSettings(List<SettingsElement> list) {

    }


    @Override
    public void onInitialize() {
        Config config = Config.getInstance();
        ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("crosshairhealth")
                .executes(c -> {
                    config.setCrosshair(!config.isCrosshair());
                    c.getSource().sendFeedback(new LiteralText("Ok: "+ config.isCrosshair()).formatted(Formatting.AQUA));
                    return 1;
                })
        );
    }
}

