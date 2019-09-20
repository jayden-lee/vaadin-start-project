package com.jayden.myapp;

import com.jayden.myapp.domain.Customer;
import com.jayden.myapp.domain.CustomerForm;
import com.jayden.myapp.domain.CustomerService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route
@PWA(name = "Project Base for Vaadin Flow with Spring", shortName = "Project Base")
public class MainView extends VerticalLayout {

    private TextField filterText = new TextField();

    private CustomerService customerService = CustomerService.getInstance();
    private Grid<Customer> grid = new Grid<>(Customer.class);

    private CustomerForm form = new CustomerForm(this);

    public MainView() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(event -> updateList());

        grid.setColumns("firstName", "lastName", "status");
        grid.asSingleSelect().addValueChangeListener(event ->
            form.setCustomer(grid.asSingleSelect().getValue()));

        Button addCustomerBtn = new Button("Add new customer");
        addCustomerBtn.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setCustomer(new Customer());
        });

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addCustomerBtn);

        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(toolbar, mainContent);

        updateList();
        setSizeFull();

        form.setCustomer(null);
    }

    public void updateList() {
        grid.setItems(customerService.findAll(filterText.getValue()));
    }

}
