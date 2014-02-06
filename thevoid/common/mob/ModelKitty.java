package thevoid.common.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

	public class ModelKitty extends ModelBase
		{
		  //fields
		ModelRenderer Body;
	    ModelRenderer leftLeg1;
	    ModelRenderer leftLeg2;
	    ModelRenderer RightLeg2;
	    ModelRenderer RightLeg1;
	    ModelRenderer Head;
	    ModelRenderer tail;
	    ModelRenderer mouth;
	    ModelRenderer Ear1;
	    ModelRenderer Ear2;
			  
	          public ModelKitty()
			  {
	        	  textureWidth = 64;
	        	    textureHeight = 32;
	        	    
	        	      Body = new ModelRenderer(this, 24, 4);
	        	      Body.addBox(-2.5F, -2.5F, -6F, 6, 5, 13);
	        	      Body.setRotationPoint(1F, 14.5F, 2F);
	        	      Body.setTextureSize(64, 32);
	        	      Body.mirror = true;
	        	      setRotation(Body, 0F, 0F, 0F);
	        	      leftLeg1 = new ModelRenderer(this, 0, 23);
	        	      leftLeg1.addBox(-1F, 0F, -1F, 2, 7, 2);
	        	      leftLeg1.setRotationPoint(3F, 17F, 7F);
	        	      leftLeg1.setTextureSize(64, 32);
	        	      leftLeg1.mirror = true;
	        	      setRotation(leftLeg1, 0F, 0F, 0F);
	        	      leftLeg2 = new ModelRenderer(this, 8, 23);
	        	      leftLeg2.addBox(-1F, 0F, -1F, 2, 7, 2);
	        	      leftLeg2.setRotationPoint(3F, 17F, -2F);
	        	      leftLeg2.setTextureSize(64, 32);
	        	      leftLeg2.mirror = true;
	        	      setRotation(leftLeg2, 0F, 0F, 0F);
	        	      RightLeg2 = new ModelRenderer(this, 28, 23);
	        	      RightLeg2.addBox(-1F, 0F, -1F, 2, 7, 2);
	        	      RightLeg2.setRotationPoint(0F, 17F, 7F);
	        	      RightLeg2.setTextureSize(64, 32);
	        	      RightLeg2.mirror = true;
	        	      setRotation(RightLeg2, 0F, 0F, 0F);
	        	      RightLeg1 = new ModelRenderer(this, 20, 23);
	        	      RightLeg1.addBox(-1F, 0F, -1F, 2, 7, 2);
	        	      RightLeg1.setRotationPoint(0F, 17F, -2F);
	        	      RightLeg1.setTextureSize(64, 32);
	        	      RightLeg1.mirror = true;
	        	      setRotation(RightLeg1, 0F, 0F, 0F);
	        	      Head = new ModelRenderer(this, 10, 10);
	        	      Head.addBox(-2F, -1.5F, -3F, 5, 4, 3);
	        	      Head.setRotationPoint(1F, 12.5F, -4F);
	        	      Head.setTextureSize(64, 32);
	        	      Head.mirror = true;
	        	      setRotation(Head, 0F, 0F, 0F);
	        	      tail = new ModelRenderer(this, 0, 8);
	        	      tail.addBox(-0.5F, 1F, -0.5F, 1, 7, 1);
	        	      tail.setRotationPoint(1.5F, 13F, 7.5F);
	        	      tail.setTextureSize(64, 32);
	        	      tail.mirror = true;
	        	      setRotation(tail, 2.342252F, 0F, 0F);
	        	      mouth = new ModelRenderer(this, 13, 18);
	        	      mouth.addBox(-1.5F, -1F, -1F, 3, 2, 1);
	        	      mouth.setRotationPoint(1.5F, 14F, -6.5F);
	        	      mouth.setTextureSize(64, 32);
	        	      mouth.mirror = true;
	        	      setRotation(mouth, 0F, 0F, 0F);
	        	      Ear1 = new ModelRenderer(this, 10, 7);
	        	      Ear1.addBox(-0.5F, -1F, -1F, 1, 1, 2);
	        	      Ear1.setRotationPoint(0F, 11F, -5F);
	        	      Ear1.setTextureSize(64, 32);
	        	      Ear1.mirror = true;
	        	      setRotation(Ear1, 0F, 0F, 0F);
	        	      Ear2 = new ModelRenderer(this, 18, 7);
	        	      Ear2.addBox(-0.5F, -1F, -1F, 1, 1, 2);
	        	      Ear2.setRotationPoint(3F, 11F, -5F);
	        	      Ear2.setTextureSize(64, 32);
	        	      Ear2.mirror = true;
	        	      setRotation(Ear2, 0F, 0F, 0F);
			  }
		  
	        public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
		  {
	        super.render(entity, f, f1, f2, f3, f4, f5);
	        setRotationAngles( f, f1, f2, f3, f4, f5, entity);
		    Body.render(f5);
		    leftLeg1.render(f5);
		    leftLeg2.render(f5);
		    RightLeg2.render(f5);
		    RightLeg1.render(f5);
		    Head.render(f5);
		    tail.render(f5);
		    mouth.render(f5);
		    Ear1.render(f5);
		    Ear2.render(f5);
		    }
		  
		  private void setRotation(ModelRenderer model, float x, float y, float z)
		  {
		    model.rotateAngleX = x;
		    model.rotateAngleY = y;
		    model.rotateAngleZ = z;
		  }
		  
		  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		    this.RightLeg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 * 0.5F;
		    this.leftLeg1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1 * 0.5F;
		    this.RightLeg2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 * 0.5F;
		    this.leftLeg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1 * 0.5F;


		  }

		}