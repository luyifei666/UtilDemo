package com.billylu.android.utildemo.presenter.impl;

import com.billylu.android.utildemo.presenter.IBasePresenter;

/**
 * Created by maning on 16/6/21.
 */
public class BasePresenterImpl<T> implements IBasePresenter {

    public T mView;

    protected void attachView(T mView) {
        this.mView = mView;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
}
