package com.jayden.admin.view.login;

import com.jayden.admin.service.login.LoginService;
import com.jayden.admin.view.dashboard.DashboardView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@PageTitle("Login")
@Route(value = LoginView.ROUTE)
public class LoginView extends VerticalLayout {

    public static final String ROUTE = "login";

    private TextField idField;
    private PasswordField passwordField;
    private Button loginButton;

    private LoginService loginService;

    public LoginView(LoginService loginService) {
        this.loginService = loginService;
        initComponent();
    }

    private void initComponent() {
        VerticalLayout layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        layout.setSizeFull();

        idField = new TextField("Username");
        idField.setPlaceholder("admin");
        idField.setRequiredIndicatorVisible(true);
        idField.focus();

        passwordField = new PasswordField("Password");
        passwordField.setPlaceholder("!@#");

        layout.add(idField, passwordField);

        loginButton = new Button("Sign in");
        loginButton.addClickListener(event -> doLogin());

        layout.add(loginButton);

        add(layout);
    }

    private void doLogin() {
        if (StringUtils.isEmpty(idField.getValue())) {
            Notification.show("Please enter your username");
        }

        if (StringUtils.isEmpty(passwordField.getValue())) {
            Notification.show("Please enter your password");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(idField.getValue(), passwordField.getValue());

        if (loginService.login(authentication)) {
            UI.getCurrent().navigate(DashboardView.class);
        }
    }

}