package ch.hsr;

import ch.adv.lib.core.domain.ADVRelation;
import ch.adv.lib.core.domain.styles.ADVStyle;

public class ArrayRelation implements ADVRelation {

    private String label;
    private long sourceElementId;
    private long targetElementId;
    private ADVStyle advStyle;

    @Override
    public long getSourceElementId() {
        return sourceElementId;
    }

    @Override
    public void setSourceElementId(long sourceElementId) {
        this.sourceElementId = sourceElementId;
    }

    @Override
    public long getTargetElementId() {
        return targetElementId;
    }

    @Override
    public void setTargetElementId(long targetElementId) {
        this.targetElementId = targetElementId;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public ADVStyle getStyle() {
        return advStyle;
    }

    @Override
    public void setStyle(ADVStyle advStyle) {
        this.advStyle = advStyle;
    }
}
