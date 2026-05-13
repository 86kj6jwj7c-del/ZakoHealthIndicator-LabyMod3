package hw.zako.zakohealthindicator;


import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.labymod.api.LabyModAPI;

public class ZakoHealthIndicator implements ModInitializer {

    public static void init() {
        System.out.println(LabyModAPI.getName());
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

