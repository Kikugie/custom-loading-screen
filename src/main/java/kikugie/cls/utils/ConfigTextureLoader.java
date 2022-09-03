package kikugie.cls.utils;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.resource.metadata.TextureResourceMetadata;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.ResourceTexture;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConfigTextureLoader extends ResourceTexture {
    public Identifier defaultLocation;

    public ConfigTextureLoader(Identifier location, Identifier defaultLocation) {
        super(location);
        this.defaultLocation = defaultLocation;
    }

    protected TextureData loadTextureData(ResourceManager resourceManager) {
        try {
            File configPath = new File(FabricLoader.getInstance().getConfigDir() + "/custom-loading-screen/" + this.location.getPath());
            InputStream input;

            if (configPath.exists()) {
                input = new FileInputStream(configPath.toString());
            } else {
                input = MinecraftClient.getInstance().getResourcePackProvider().getPack().open(ResourceType.CLIENT_RESOURCES, defaultLocation);
            }
            assert input != null;

            TextureData texture;

            try {
                texture = new TextureData(new TextureResourceMetadata(true, true), NativeImage.read(input));
            } finally {
                input.close();
            }

            return texture;
        } catch (IOException var18) {
            return new TextureData(var18);
        }
    }
}
