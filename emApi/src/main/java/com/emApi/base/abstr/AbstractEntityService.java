package com.emApi.base.abstr;

import java.util.List;

public abstract class AbstractEntityService<T> extends BaseAbstract {

    public abstract void create(T entity);
    public abstract void create(List<T> entities);
    public abstract T read(Long id);
    public abstract List<T> read(List<Long> ids);
    public abstract void update(T entity);
    public abstract void update(List<T> entities);
    public abstract void delete(Long id);
    public abstract void delete(List<Long> ids);
}
