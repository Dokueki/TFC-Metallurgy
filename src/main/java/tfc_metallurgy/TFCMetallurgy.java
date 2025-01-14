package tfc_metallurgy;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;
import tfc_metallurgy.common.ClientEvents;
import tfc_metallurgy.common.MetallurgyItemGroup;
import tfc_metallurgy.common.block_entities.MetallurgyBlockEntities;
import tfc_metallurgy.common.blocks.MetallurgyBlocks;
import tfc_metallurgy.common.fluids.MetallurgyFluids;
import tfc_metallurgy.common.items.MetallurgyItems;

@Mod(TFCMetallurgy.mod_id)
public class TFCMetallurgy {

	public static final String mod_id = "tfc_metallurgy";

	public static final Logger LOGGER = LogUtils.getLogger();

	public TFCMetallurgy() {
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		MetallurgyItems.ITEMS.register(bus);
		MetallurgyBlocks.BLOCKS.register(bus);
		MetallurgyFluids.FLUID_TYPES.register(bus);
		MetallurgyFluids.FLUIDS.register(bus);
		MetallurgyBlockEntities.BLOCK_ENTITIES.register(bus);
		MetallurgyItemGroup.CREATIVE_TABS.register(bus);
		if (FMLEnvironment.dist == Dist.CLIENT) {
			ClientEvents.init();
		}
	}
}
