package com.github.den666bah666;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

import java.util.HashMap;
import java.util.Map;

public class AssetManager {
    private static Map<String, Texture> textures = new HashMap<>();
    private static Map<String, Class<?>> types = new HashMap<>();

    public static void load(String path, String registryName, Class<?> type) {
        textures.put(registryName.toLowerCase(), new Texture(path));
        types.put(registryName, type);
    }

    public static Texture get(String name) {
        return textures.get(name.toLowerCase());
    }

    public static void dispose() {
        textures.values().forEach(Disposable::dispose);
    }
}
