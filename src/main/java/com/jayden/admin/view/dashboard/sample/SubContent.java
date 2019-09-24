package com.jayden.admin.view.dashboard.sample;

import com.jayden.admin.layout.DefaultAppLayoutRouterLayout;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "view2/subcontent", layout = DefaultAppLayoutRouterLayout.class)
public class SubContent extends VerticalLayout {

    public SubContent() {
        add(getLabel());
        add(getLabel());
        add(getLabel());
        add(getLabel());
        add(getLabel());
        add(getLabel());
    }

    Paragraph getLabel() {
        Paragraph label = new Paragraph(" SubContent ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ........................................ ");
        label.setWidth("100%");
        return label;
    }

}