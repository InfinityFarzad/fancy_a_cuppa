package dev.farzad.fancy_a_cuppa.client.render.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.farzad.fancy_a_cuppa.client.model.item.MugModel;
import dev.farzad.fancy_a_cuppa.client.render.state.MugEntityRenderState;
import dev.farzad.fancy_a_cuppa.common.block.entity.MugBlockEntity;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class MugBlockEntityRenderer implements BlockEntityRenderer<MugBlockEntity, MugEntityRenderState> {

    private MugModel model;

    @Override
    public MugEntityRenderState createRenderState() {
        return new MugEntityRenderState();
    }

    @Override
    public void submit(MugEntityRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        submitNodeCollector.submitModelPart(this.model.root(), poseStack, this.model.renderType(MugModel.TEXTURE), state.lightCoords, OverlayTexture.pack(16,16), null, false, false, -1, null,-1);

    }
}
