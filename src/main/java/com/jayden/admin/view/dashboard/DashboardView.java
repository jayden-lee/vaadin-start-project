package com.jayden.admin.view.dashboard;

import com.jayden.admin.layout.DefaultAppLayoutRouterLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Dashboard")
@Route(value = DashboardView.ROUTE, layout = DefaultAppLayoutRouterLayout.class)
public class DashboardView extends VerticalLayout {

    public static final String ROUTE = "";

    public DashboardView() {
        Button button = new Button("Click me",
            e -> Notification.show("Click me"));
        add(button);
    }

}
