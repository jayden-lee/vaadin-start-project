package com.jayden.admin.view.dashboard;

import com.jayden.admin.layout.DefaultAppLayoutRouterLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Dashboard")
@Route(value = DashboardView.ROUTE, layout = DefaultAppLayoutRouterLayout.class)
public class DashboardView extends VerticalLayout {

    public static final String ROUTE = "dashboard";

    public DashboardView(@Autowired MessageBean bean) {
        Button button = new Button("Click me",
            e -> Notification.show(bean.getMessage()));
        add(button);
    }

}
