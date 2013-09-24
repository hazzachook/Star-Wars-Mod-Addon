package hazzachook.addons.starwars.core;

import hazzachook.addons.starwars.armor.deathwatch_armor_boots;
import hazzachook.addons.starwars.armor.deathwatch_armor_chestplate;
import hazzachook.addons.starwars.armor.deathwatch_armor_helmet;
import hazzachook.addons.starwars.armor.deathwatch_armor_leggings;
import hazzachook.addons.starwars.entity.Entity_deathwatch;
import hazzachook.addons.starwars.items.DarkBlade;
import hazzachook.addons.starwars.model.Model_deathwatch;
import hazzachook.addons.starwars.render.Renderdeathwatch;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
	
        //Just Some Basic Info
        @Mod(modid = "hazzachooks_star_wars_addon", name = "Hazzchooks Star Wars Mod Addon", version = "1.0.1-Pre-Alpha")
        @NetworkMod(clientSideRequired = true, serverSideRequired = false)

         public class StarWarsAddon_Core {
	
	     
	     //Creative Tab
         public static CreativeTabs hazzachooks_star_wars_addon_tab;
	
	     //Our Items
	     public static Item darkBlade;
	
	     //Our Armor
	     public static Item deathwatchArmor_helmet;
	     public static Item deathwatchArmor_chestplate;
	     public static Item deathwatchArmor_leggings;
	     public static Item deathwatchArmor_boots;
	    
	     //Mob ID's
	     static int startEntityId = 300;
	     
	     //Enum Material 
	     public static EnumToolMaterial dark_blade_enum = EnumHelper.addToolMaterial("dark_blade_enum", 3, 1507, 8.0F, 4.0F, 0);
	     public static EnumArmorMaterial deathwatchArmor = EnumHelper.addArmorMaterial("deathwatchArmor", 15, new int[] {2, 6, 5, 2}, 0);
	     
	     //Mob Generation
	     public static int getUniqueEntityId() {	 
	         do {
	        	startEntityId++;
	         }
	         while(EntityList.getStringFromID(startEntityId) != null);
	         return startEntityId++;
	            
	             }
	     
	     public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
	    	 int id = getUniqueEntityId();
	    	 EntityList.IDtoClassMapping.put(id, entity);
	    	 EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	    	 
	              }
	     
	     @EventHandler
	     public void Load(FMLPreInitializationEvent Event) {
	    	 
		     //Settings For Our Creative Tab
	         hazzachooks_star_wars_addon_tab = new CreativeTabs("hazzachooks_star_wars_addon_tab") {
	    	 public ItemStack getIconItemStack() {
	    		 return new ItemStack(darkBlade, 1, 0);
	    	 }
	     };
	     LanguageRegistry.instance().addStringLocalization("itemGroup.hazzachooks_star_wars_addon_tab", "en_US", "Hazzachooks Star Wars Addon Tab");
	     
	     //Settings For Our Armor
	     deathwatchArmor_helmet = new deathwatch_armor_helmet(2001, deathwatchArmor, ModLoader.addArmor("deathwatchArmor"), 0).setUnlocalizedName("deathwatch_helmet").setCreativeTab(this.hazzachooks_star_wars_addon_tab);
	     deathwatchArmor_chestplate = new deathwatch_armor_chestplate(2001, deathwatchArmor, ModLoader.addArmor("deathwatchArmor"), 0).setUnlocalizedName("deathwatch_chestplate").setCreativeTab(this.hazzachooks_star_wars_addon_tab);
	     deathwatchArmor_leggings = new deathwatch_armor_leggings(2001, deathwatchArmor, ModLoader.addArmor("deathwatchArmor"), 0).setUnlocalizedName("deathwatch_leggings").setCreativeTab(this.hazzachooks_star_wars_addon_tab);
	     deathwatchArmor_boots = new deathwatch_armor_boots(2001, deathwatchArmor, ModLoader.addArmor("deathwatchArmor"), 0).setUnlocalizedName("deathwatch_boots").setCreativeTab(this.hazzachooks_star_wars_addon_tab);
	     
	     //Settings For Our Items
         darkBlade = new DarkBlade(2000, dark_blade_enum).setUnlocalizedName("dark blade").setCreativeTab(this.hazzachooks_star_wars_addon_tab);
	     
         //Settings For Our Armor
         GameRegistry.registerItem(deathwatchArmor_helmet, "deathwatchArmor_helmet");
         LanguageRegistry.addName(deathwatchArmor_helmet, "Deathwatch Helmet");
         
         GameRegistry.registerItem(deathwatchArmor_chestplate, "deathwatchArmor_chestplate");
         LanguageRegistry.addName(deathwatchArmor_chestplate, "Deathwatch Chestplate");
         
         GameRegistry.registerItem(deathwatchArmor_leggings, "deathwatchArmor_leggings");
         LanguageRegistry.addName(deathwatchArmor_leggings, "Deathwatch Leggings");
         
         GameRegistry.registerItem(deathwatchArmor_boots, "deathwatchArmor_boots");
         LanguageRegistry.addName(deathwatchArmor_boots, "Deathwatch Boots");

         //Settings For Our Mobs
         EntityRegistry.registerGlobalEntityID(Entity_deathwatch.class, "Deathwatch", 1);
         EntityRegistry.addSpawn(Entity_deathwatch.class, 20, 5, 20, EnumCreatureType.monster);
         EntityRegistry.findGlobalUniqueEntityId();
         registerEntityEgg(Entity_deathwatch.class, 0x0020C2, 0xb50000);
         RenderingRegistry.registerEntityRenderingHandler(Entity_deathwatch.class, new Renderdeathwatch(new Model_deathwatch(), 0.3F));
         
         //Register Our Items
         GameRegistry.registerItem(darkBlade, "darkBlade");
         LanguageRegistry.addName(darkBlade, "Dark Saber");
         

            }

        }
  
       





