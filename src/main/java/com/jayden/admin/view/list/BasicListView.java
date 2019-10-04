package com.jayden.admin.view.list;

import com.jayden.admin.layout.DefaultAppLayoutRouterLayout;
import com.jayden.admin.model.Customer;
import com.jayden.admin.service.customer.CustomerService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridMultiSelectionModel;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@PageTitle("Basic List")
@Route(value = BasicListView.ROUTE, layout = DefaultAppLayoutRouterLayout.class)
public class BasicListView extends VerticalLayout {

    public static final String ROUTE = "list/basic-list";

    private CustomerService customerService;
    private Grid<Customer> grid;

    public BasicListView(CustomerService customerService) {
        this.customerService = customerService;

        createGrid();

        setMargin(false);
        setPadding(false);
        setSpacing(false);
        setAlignItems(Alignment.STRETCH);
        setSizeFull();
    }

    private void createGrid() {
        grid = getGrid();
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.setSizeFull();

        HorizontalLayout gridWrapper = new HorizontalLayout(grid);
        gridWrapper.setMargin(false);
        gridWrapper.setPadding(false);
        gridWrapper.setSpacing(false);
        gridWrapper.setFlexGrow(1, grid);
        gridWrapper.setSizeFull();

        add(gridWrapper);
    }

    private Grid<Customer> getGrid() {
        Grid<Customer> grid = new Grid<>();
        grid.setItems(customerService.fetch());
        grid.addColumn(Customer::getCustomerId).setHeader("Customer Id");
        grid.addColumn(Customer::getStoreId).setHeader("Store Id");
        grid.addColumn(Customer::getFirstName).setHeader("First Name");
        grid.addColumn(Customer::getLastName).setHeader("Last Name");
        grid.addColumn(Customer::getEmail).setHeader("Email");
        grid.addColumn(Customer::getAddressId).setHeader("Address Id");
        grid.addColumn(Customer::isActive).setHeader("Active");
        grid.addColumn(Customer::getCreateDate).setHeader("Create Date");
        grid.addColumn(Customer::getLastUpdate).setHeader("Last Update");
        return grid;
    }
}