package dev.farzad.fancy_a_cuppa.client.model.item;

import dev.farzad.fancy_a_cuppa.FancyACuppa;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Unit;

public class MugModel extends Model<Unit> {
    public static Identifier TEXTURE = FancyACuppa.id("textures/entity/mug/mug_ent.png");

    private final ModelPart mug;
    private final ModelPart rim;
    private final ModelPart fluid;

    public MugModel(ModelPart root) {
        super(root, RenderTypes::itemCutout);
        this.mug = root.getChild("mug");
        this.rim = this.mug.getChild("rim");
        this.fluid = this.mug.getChild("fluid");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition mug = partdefinition.addOrReplaceChild("mug", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                        .texOffs(24, 0).addBox(-1.0F, -6.0F, -5.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(8.0F, 0.0F, -3.0F));

        PartDefinition rim = mug.addOrReplaceChild("rim", CubeListBuilder.create()
                        .texOffs(0, 7).addBox(2.0F, -8.0F, -3.0F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 19).addBox(-2.0F, -8.0F, 2.0F, 5.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(12, 7).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
                        .texOffs(12, 19).addBox(-3.0F, -8.0F, -3.0F, 5.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid = mug.addOrReplaceChild("fluid", CubeListBuilder.create()
                        .texOffs(16, 27).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }
}
