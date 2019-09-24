package com.jayden.admin.view.dashboard.sample;

import com.jayden.admin.layout.DefaultAppLayoutRouterLayout;
import com.jayden.admin.view.AbstractView;
import com.vaadin.flow.router.Route;

@Route(value = "view5", layout = DefaultAppLayoutRouterLayout.class)
public class View5 extends AbstractView {

    @Override
    public String getViewName() {
        return getClass().getName();
    }
}
