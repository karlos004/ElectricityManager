package com.emApi.base.abstr.controller;

import com.emApi.base.abstr.basicComponent.BaseAbstractComponent;

import java.util.List;

public abstract class AbstractCRUDController<T> extends BaseAbstractComponent {

    public abstract void create(T entity);
    public abstract void create(List<T> entities);
    public abstract T read(Long id);
    public abstract List<T> read(List<Long> ids);
    public abstract void update(T entity);
    public abstract void update(List<T> entities);
    public abstract void delete(Long id);
    public abstract void delete(List<Long> ids);
}
