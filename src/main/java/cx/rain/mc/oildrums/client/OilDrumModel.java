package cx.rain.mc.oildrums.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import cx.rain.mc.oildrums.entity.OilDrumEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class OilDrumModel extends EntityModel<OilDrumEntity> {

	// private final ModelPart root;

	public OilDrumModel() {

	}

	public static MeshDefinition createModel() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition part = mesh.getRoot();

		return mesh;
	}

	public static LayerDefinition createLayer() {
		MeshDefinition mesh = createModel();
		PartDefinition def = mesh.getRoot();
		return LayerDefinition.create(mesh, 128, 128);
	}

	@Override
	public void setupAnim(OilDrumEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		// this.root.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
