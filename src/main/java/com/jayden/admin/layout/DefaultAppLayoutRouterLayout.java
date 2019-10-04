package com.jayden.admin.layout;

import com.github.appreciated.app.layout.addons.notification.DefaultNotificationHolder;
import com.github.appreciated.app.layout.addons.notification.component.NotificationButton;
import com.github.appreciated.app.layout.addons.profile.ProfileButton;
import com.github.appreciated.app.layout.addons.profile.builder.AppBarProfileButtonBuilder;
import com.github.appreciated.app.layout.component.appbar.AppBarBuilder;
import com.github.appreciated.app.layout.component.applayout.LeftLayouts;
import com.github.appreciated.app.layout.component.builder.AppLayoutBuilder;
import com.github.appreciated.app.layout.component.menu.left.LeftSubmenu;
import com.github.appreciated.app.layout.component.menu.left.builder.LeftAppMenuBuilder;
import com.github.appreciated.app.layout.component.menu.left.builder.LeftSubMenuBuilder;
import com.github.appreciated.app.layout.component.menu.left.items.LeftNavigationItem;
import com.github.appreciated.app.layout.component.router.AppLayoutRouterLayout;
import com.jayden.admin.service.login.LoginService;
import com.jayden.admin.view.list.BasicListView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.beans.factory.annotation.Autowired;

@Theme(value = Lumo.class, variant = Lumo.DARK)
public class DefaultAppLayoutRouterLayout extends AppLayoutRouterLayout {

    public static final String TITLE = "Admin App Pro";

    private DefaultNotificationHolder notifications = new DefaultNotificationHolder();

    @Autowired
    private LoginService loginService;

    public DefaultAppLayoutRouterLayout() {
        notifications.addClickListener(notification -> {/* ... */});

        ProfileButton profileButton = AppBarProfileButtonBuilder.get()
                .withItem("Your profile", event -> openProfile())
                .withItem("Settings", event -> openSettings())
                .withItem("Sign out", event -> doSignOut())
                .build();

        Component appBar = AppBarBuilder.get()
                .add(new NotificationButton<>(VaadinIcon.BELL, notifications), profileButton)
                .build();

        LeftSubmenu grid = LeftSubMenuBuilder
                .get("List", VaadinIcon.PLUS.create())
                .add(new LeftNavigationItem("Basic List", VaadinIcon.GRID.create(), BasicListView.class))
                .build();

        LeftAppMenuBuilder leftAppMenuBuilder = LeftAppMenuBuilder.get();
        leftAppMenuBuilder.add(grid).build();

        Component appMenu = leftAppMenuBuilder
                .build();

        init(AppLayoutBuilder
                .get(LeftLayouts.LeftResponsive.class)
                .withIcon("images/logo.png")
                .withTitle(TITLE)
                .withAppBar(appBar)
                .withAppMenu(appMenu)
                .build());
    }

    private void openProfile() {
        Dialog dialog = new Dialog();
        dialog.setCloseOnEsc(false);
        dialog.setCloseOnOutsideClick(false);

        dialog.add(new Label("Close me with the esc-key or an outside click"));
        NativeButton confirmButton = new NativeButton("Confirm", event -> {
            dialog.close();
        });
        NativeButton cancelButton = new NativeButton("Cancel", event -> {
            dialog.close();
        });
        dialog.add(confirmButton, cancelButton);
        dialog.open();
    }

    private void openSettings() {
        Dialog dialog = new Dialog();
        dialog.setCloseOnEsc(false);
        dialog.setCloseOnOutsideClick(false);

        dialog.add(new Label("Close me with the esc-key or an outside click"));
        NativeButton confirmButton = new NativeButton("Confirm", event -> {
            dialog.close();
        });
        NativeButton cancelButton = new NativeButton("Cancel", event -> {
            dialog.close();
        });
        dialog.add(confirmButton, cancelButton);
        dialog.open();
    }

    private void doSignOut() {
        loginService.logout();
        UI.getCurrent().getSession().close();
        UI.getCurrent().getPage().reload();
    }
}
