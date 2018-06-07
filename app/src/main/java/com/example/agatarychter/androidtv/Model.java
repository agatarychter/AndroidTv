package com.example.agatarychter.androidtv;
import android.support.v17.leanback.widget.HeaderItem;
/**
 * Created by Agata Rychter on 29.05.2018.
 */

public class Model extends HeaderItem {

    public static final int ICON_NONE = -1;
    private int mIconResId = ICON_NONE;

    public Model(long id, String name, int iconResId) {
        super(id, name);
        mIconResId = iconResId;
    }

    public int getIconResId() {
        return mIconResId;
    }
}