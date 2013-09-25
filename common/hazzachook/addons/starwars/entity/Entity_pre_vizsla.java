package hazzachook.addons.starwars.entity;

import hazzachook.addons.starwars.core.StarWarsAddon_Core;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Entity_pre_vizsla extends EntityMob {

	public Entity_pre_vizsla(World par1World) {
		super(par1World);
		this.experienceValue = 10;
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.5D, false));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.tasks.addTask(6, new EntityAIWander(this, 0.4D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
	}

    protected boolean isAIEnabled() {
    	return true;
    
    }


    public int getMaxHealth() {
        	return 20;
    }
    protected void addRandomArmor()
    {
        this.setCurrentItemOrArmor(0, new ItemStack(StarWarsAddon_Core.darkBlade));
    }

    

    }

    

    
    
 
    
   
    
    
        