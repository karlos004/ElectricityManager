package com.emApi.base.abstr;

public abstract class BaseAbstract {

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
