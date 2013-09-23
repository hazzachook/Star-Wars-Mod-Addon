package hazzachook.addons.starwars.items;

import hazzachook.addons.starwars.core.StarWarsAddon_Core;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class DarkBlade extends ItemSword{

	public DarkBlade(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		
	               }
		
		@SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister register) {
	    	this.itemIcon = register.registerIcon("Hazzachooks_Starwars_Addon:dark_saber");
	    }
	}


