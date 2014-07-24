/*
 * Copyright (C) 2014 Igor Tkach
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package itkach.fdrawable;

import java.util.HashMap;
import java.util.Map;

import android.content.res.AssetManager;
import android.graphics.Typeface;

/**
 * Helper class that creates {@link Typeface} instances from assets and caches them.
 */
public class TypefaceManager {

    private AssetManager assetManager;

	public TypefaceManager(AssetManager assetManager) {
    	this.assetManager = assetManager;
    }

    private Map<String, Typeface> typefaces = new HashMap<String, Typeface>();

    public Typeface get(String fontAssetName) {
    	Typeface typeface = typefaces.get(fontAssetName);
    	if (typeface == null) {
    		typeface = Typeface.createFromAsset(this.assetManager, fontAssetName);
    		typefaces.put(fontAssetName, typeface);
    	}
    	return typeface;
    }
}
