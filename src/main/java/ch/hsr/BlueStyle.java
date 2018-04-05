package ch.hsr;

import ch.adv.lib.core.domain.styles.ADVStyle;

public class BlueStyle implements ADVStyle {

    private String fillColor;
    private String strokeColor;
    private String strokeStyle;
    private String strokeThickness;

    public BlueStyle() {
        this.fillColor = "blue";
        this.strokeColor = "blue";
        this.strokeStyle = "dotted";
        this.strokeThickness = "thin";
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getStrokeColor() {
        return strokeColor;
    }

    @Override
    public String getStrokeStyle() {
        return strokeStyle;
    }

    @Override
    public String getStrokeThickness() {
        return strokeThickness;
    }
}
