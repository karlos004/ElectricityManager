package com.emApi.base.abstr.basicComponent;

public abstract class BaseAbstractComponent {

    public boolean isNull(Object arg) {
        if(arg == null) {
            return true;
        }
        return false;
    }

    public boolean notNull(Object arg) {
        if(arg == null) {
            return false;
        }
        return true;
    }
}
