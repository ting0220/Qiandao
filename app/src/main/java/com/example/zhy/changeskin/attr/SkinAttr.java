package com.example.zhy.changeskin.attr;

import android.view.View;

/**
 * Created by zhy on 15/9/22.
 */
public class SkinAttr
{
    public String resName;
    public com.example.zhy.changeskin.attr.SkinAttrType attrType;


    public SkinAttr(com.example.zhy.changeskin.attr.SkinAttrType attrType, String resName)
    {
        this.resName = resName;
        this.attrType = attrType;
    }

    public void apply(View view)
    {
        attrType.apply(view, resName);
    }
}
