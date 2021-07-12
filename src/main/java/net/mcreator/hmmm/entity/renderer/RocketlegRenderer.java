package net.mcreator.hmmm.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.hmmm.entity.RocketlegEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class RocketlegRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(RocketlegEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelrocketleg(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("hmmm:textures/villager-1.png_1.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelrocketleg extends EntityModel<Entity> {
		private final ModelRenderer bone;
		public Modelrocketleg() {
			textureWidth = 16;
			textureHeight = 16;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone.setTextureOffset(0, 1).addBox(-2.0F, -11.0F, -3.0F, 4.0F, 11.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(0, 1).addBox(-1.0F, -11.0F, -4.0F, 2.0F, 11.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(0, 1).addBox(-1.0F, -11.0F, -2.0F, 2.0F, 11.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(0, 4).addBox(-1.0F, -2.0F, -8.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			bone.setTextureOffset(0, 3).addBox(1.0F, -1.0F, -6.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			bone.setTextureOffset(0, 3).addBox(-2.0F, -1.0F, -6.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			bone.setTextureOffset(0, 1).addBox(1.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(0, 1).addBox(-2.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(0, 8).addBox(-4.0F, -18.0F, -6.0F, 8.0F, 7.0F, 8.0F, 0.0F, false);
			bone.setTextureOffset(0, 7).addBox(3.0F, -18.0F, 2.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(0, 7).addBox(-4.0F, -18.0F, 2.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(0, 6).addBox(-3.0F, -18.0F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(0, 6).addBox(-3.0F, -12.0F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(0, 3).addBox(-2.0F, -16.0F, 2.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);
			bone.setTextureOffset(0, 3).addBox(0.0F, -17.0F, 5.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
			bone.setTextureOffset(0, 3).addBox(0.0F, -17.0F, 5.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
			bone.setTextureOffset(0, 3).addBox(-3.0F, -17.0F, 5.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
			bone.setTextureOffset(0, 1).addBox(-3.0F, -18.0F, 8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(0, 3).addBox(-1.0F, -15.0F, 5.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
			bone.setTextureOffset(0, 1).addBox(-1.0F, -14.0F, 8.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
