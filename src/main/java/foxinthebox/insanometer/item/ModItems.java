package foxinthebox.insanometer.item;

import foxinthebox.insanometer.Insanometer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Insanometer.MOD_ID);

    public static final RegistryObject<Item> NIGHTMARE_FUEL = ITEMS.register("nightmare_fuel", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SHADOW_STEEL_INGOT = ITEMS.register("shadow_steel_ingot", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static void addCreativeTab(CreativeModeTabEvent.Register event)
    {
        event.registerCreativeModeTab(new ResourceLocation(Insanometer.MOD_ID, "tab"), builder -> {
            builder.title(Component.translatable("item_group." + Insanometer.MOD_ID + ".tab"))
                    .icon(() -> new ItemStack(ModItems.NIGHTMARE_FUEL.get()))
                    .displayItems((enabledFlags, populator, hasPermissions) -> {
                        populator.accept(ModItems.NIGHTMARE_FUEL.get());
                    });
        });
    }
}
