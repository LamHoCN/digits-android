/*
 * Copyright (C) 2015 Twitter, Inc.
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
 *
 */

package com.digits.sdk.android;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;


public class LinkTextView extends TextView {
    public LinkTextView(Context context) {
        super(context);
        init(context);
    }

    public LinkTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public LinkTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setTextColor(getLinkColor(context));
    }

    private int getLinkColor(Context context) {
        final TypedValue value = ThemeUtils.getTypedValueColor(context.getTheme(),
                android.R.attr.textColorLink);
        if (value == null) {
            return ThemeUtils.getAccentColor(context.getResources(), context.getTheme());
        }
        return value.data;
    }

}
