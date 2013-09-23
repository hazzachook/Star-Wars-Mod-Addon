package hazzachook.addons.starwars.core;

import hazzachook.addons.starwars.items.DarkBlade;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
	
//Just Some Basic Info
@Mod(modid = "hazzachooks_star_wars_addon", name = "Hazzchooks Star Wars Mod Addon", version = "1.0.0-Pre-Alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

         public class StarWarsAddon_Core {
	
	     
	     //Creative Tab
         public CreativeTabs hazzachooks_star_wars_addon_tab;
	
	     //Our Items
	     public static Item darkBlade;
	
	     //Our Armor
	     public static Item deathwatchArmor_helmet;
	     public static Item deathwatchArmor_chestplate;
	     public static Item deathwatchArmor_leggings;
	     public static Item deathwatchArmor_boots;
	     
	     //Enum Material 
	     public static EnumToolMaterial dark_blade_enum = EnumHelper.addToolMaterial("dark_blade_enum", 3, 1507, 8.0F, 4.0F, 0);
	     
	     @EventHandler
	     public void Load(FMLPreInitializationEvent Event) {
	    	 
	     //Settings For Our Creative Tab
	     hazzachooks_star_wars_addon_tab = new CreativeTabs("hazzachooks_star_wars_addon_tab") {
	    	 public ItemStack getIconItemStack() {
	    		 return new ItemStack(darkBlade, 1, 0);
	    	 }
	     };
	     LanguageRegistry.instance().addStringLocalization("itemGroup.hazzachooks_star_wars_addon_tab", "en_US", "Hazzachooks Star Wars Addon Tab");
	     
	     //Settings For Our Items
         darkBlade = new DarkBlade(2000, dark_blade_enum).setUnlocalizedName("dark blade").setCreativeTab(this.hazzachooks_star_wars_addon_tab);
	     
         //Register Our Items
         GameRegistry.registerItem(darkBlade, "darkBlade");
         LanguageRegistry.addName(darkBlade, "Dark Saber");
         

            }

        }
  
       





