package hw.zako.zakohealthindicator;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.labymod.api.LabyModAddon;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.labymod.api.LabyModAPI;

public class ZakoHealthIndicator extends LabyModAddon {

    public class ExampleMod extends LabyModAddon {

        @Override
        public void onInitializeClient() {

            if (isLabyModLoaded()) {
                System.out.println("LabyMod detected");
            }
        }

        private boolean isLabyModLoaded() {
            try {
                Class<?> clazz = Class.forName("net.labymod.main.LabyMod");
                System.out.println(clazz.getName());
                return true;
            } catch (Exception e) {
                return false;
            }
        }
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

