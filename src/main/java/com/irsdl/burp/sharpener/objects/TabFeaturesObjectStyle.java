// Burp Suite Sharpener
// Released as open source by MDSec - https://www.mdsec.co.uk
// Developed by Soroush Dalili (@irsdl)
// Project link: https://github.com/mdsecresearch/BurpSuiteSharpener
// Released under AGPL see LICENSE for more information

package com.irsdl.burp.sharpener.objects;

import com.irsdl.burp.sharpener.uimodifiers.subtabs.SubTabContainerHandler;

import java.awt.*;
import java.io.Serializable;

public class TabFeaturesObjectStyle implements Serializable {
    public String name;
    public String fontName;
    public float fontSize;
    public boolean isBold;
    public boolean isItalic;
    public boolean isCloseButtonVisible;
    private String colorCode;

    public TabFeaturesObjectStyle(String styleName, String fontName, float fontSize, boolean isBold, boolean isItalic, boolean isCloseButtonVisible, Color colorCode) {
        this.name = styleName;
        this.fontName = fontName;
        this.fontSize = fontSize;
        this.isBold = isBold;
        this.isItalic = isItalic;
        this.isCloseButtonVisible = isCloseButtonVisible;
        setColorCode(colorCode);
    }

    public Color getColorCode() {
        Color color;
        try {
            color = Color.decode(this.colorCode);
        } catch (Exception e1) {
            // old system
            try {
                color = new Color(Integer.parseInt(this.colorCode), true);
            } catch (Exception e2) {
                color = Color.BLACK;
            }
        }
        return color;
    }

    public void setColorCode(Color _colorObj) {
        this.colorCode = String.format("#%06x", _colorObj.getRGB() & 0xFFFFFF); // new system!
        // this.colorCode = Integer.toString(_colorObj.getRGB()); // old easy approach!
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof TabFeaturesObjectStyle) {
            TabFeaturesObjectStyle temp = (TabFeaturesObjectStyle) o;
            if (temp.fontName == fontName && temp.fontSize == fontSize && Boolean.compare(temp.isBold, isBold) == 0 &&
                    Boolean.compare(temp.isItalic, isItalic) == 0 &&
                    Boolean.compare(temp.isCloseButtonVisible, isCloseButtonVisible) == 0 && temp.colorCode.equals(colorCode)) {
                result = true;
            }
        }
        return result;
    }

    /*
    public String get_uid() {
        return _uid;
    }

    private void set_uid() {
        this._uid = UUID.randomUUID().toString();
    }
*/
}
