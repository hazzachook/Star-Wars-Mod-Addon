package hazzachook.addons.starwars.render;

import hazzachook.addons.starwars.entity.Entity_deathwatch;
import hazzachook.addons.starwars.entity.Entity_pre_vizsla;
import hazzachook.addons.starwars.model.Model_deathwatch;
import hazzachook.addons.starwars.model.Model_pre_vizsla;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class Renderprevizsla extends RenderLiving {

	protected Model_pre_vizsla model;
	
	public Renderprevizsla(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = ((Model_pre_vizsla)mainModel);
	}
	
	public void renderpre_vizsla(Entity_pre_vizsla entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		renderpre_vizsla((Entity_pre_vizsla)par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
			 renderpre_vizsla((Entity_pre_vizsla)entity, d0, d1, d2, f, f1);
              
	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return new ResourceLocation("hazzachooks_starwars_addon:textures/mobs/pre_vizsla.png");
	}

}

