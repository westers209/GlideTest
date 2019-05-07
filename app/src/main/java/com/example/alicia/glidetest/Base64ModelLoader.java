package com.example.alicia.glidetest;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

import java.nio.ByteBuffer;

public final class Base64ModelLoader implements ModelLoader<String, ByteBuffer> {

    @Nullable
    @Override
    public LoadData<ByteBuffer> buildLoadData(@NonNull String s, int width, int height, @NonNull Options options) {
        ObjectKey diskCacheKey = new ObjectKey(s);

        return new LoadData<>(new ObjectKey(s), new Base64DataFetcher(s));
    }

    @Override
    public boolean handles(@NonNull String s) {
        return s.startsWith("data:");
    }
}
