package com.jayden.admin.view.dashboard.sample;

import com.jayden.admin.layout.DefaultAppLayoutRouterLayout;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "view1", layout = DefaultAppLayoutRouterLayout.class)
public class View1 extends VerticalLayout {

    public View1() {
        add(getLabel());
        add(getLabel());
        add(getLabel());
        add(getLabel());
        add(getLabel());
        add(getLabel());
    }

    Paragraph getLabel() {
        Paragraph label = new Paragraph("........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ");
        label.setWidth("100%");
        return label;
    }

}
