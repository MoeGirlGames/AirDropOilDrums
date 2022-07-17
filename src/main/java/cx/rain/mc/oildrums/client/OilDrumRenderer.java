package cx.rain.mc.oildrums.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import cx.rain.mc.oildrums.entity.OilDrumEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class OilDrumRenderer extends EntityRenderer<OilDrumEntity> {

	private EntityModel<OilDrumEntity> model;

	public OilDrumRenderer(EntityRendererProvider.Context arg) {
		super(arg);
		model = new OilDrumModel();
	}


	@Override
	public ResourceLocation getTextureLocation(OilDrumEntity entity) {
		return null;
	}

	public void render(OilDrumEntity entity, float yaw, float partialTicks, PoseStack stack, MultiBufferSource buffer, int light) {
		super.render(entity, yaw, partialTicks, stack, buffer, light);
		stack.pushPose();
		stack.mulPose(Quaternion.fromXYZDegrees(new Vector3f(0, 45, 0)));
		VertexConsumer consumer = buffer.getBuffer(this.model.renderType(this.getTextureLocation(entity)));
		this.model.renderToBuffer(stack, consumer, light, OverlayTexture.NO_OVERLAY, 1F, 1F, 1F, 1F);
		stack.popPose();
	}
}
