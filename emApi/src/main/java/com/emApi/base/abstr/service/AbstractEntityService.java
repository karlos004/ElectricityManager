package com.emApi.base.abstr.service;

import com.emApi.base.abstr.basicComponent.BaseAbstractComponent;

import java.util.List;

public abstract class AbstractEntityService<T> extends BaseAbstractComponent {

    public abstract T read(Long id);
    public abstract List<T> read(List<Long> ids);
    public abstract void delete(Long id);
    public abstract void delete(List<Long> ids);
    public abstract void saveOrUpdate(T entity);
    public abstract void saveOrUpdate(List<T> entities);
}
