package com.jayden.admin.view.dashboard.sample;

import com.jayden.admin.layout.DefaultAppLayoutRouterLayout;
import com.jayden.admin.model.Business;
import com.jayden.admin.service.business.BusinessService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "SearchGridTest", layout = DefaultAppLayoutRouterLayout.class)
public class SearchGridTest extends VerticalLayout {

    private Grid<Business> grid = new Grid<>();

    @Autowired
    private BusinessService businessService;

    public SearchGridTest() {
        Button addButton = new Button("Add Item", event -> {
            grid.getDataProvider().refreshAll();
        });

        Button removeButton = new Button("Remove last", event -> {
            grid.getDataProvider().refreshAll();
        });

        HorizontalLayout toolbar = new HorizontalLayout();
        toolbar.add(addButton, removeButton);

        grid.addColumn(Business::getYear).setHeader("Year");
        grid.addColumn(Business::getIndustry_aggregation_NZSIOC).setHeader("Industry_aggregation_NZSIOC");
        grid.addColumn(Business::getIndustry_code_ANZSIC06).setHeader("Industry_code_NZSIOC");
        grid.addColumn(Business::getIndustry_name_NZSIOC).setHeader("Industry_name_NZSIOC");
        grid.addColumn(Business::getUnits).setHeader("Units");
        grid.addColumn(Business::getVariable_code).setHeader("Variable_code");
        grid.addColumn(Business::getVariable_name).setHeader("Variable_name");
        grid.addColumn(Business::getVariable_category).setHeader("Variable_category");
        grid.addColumn(Business::getValue).setHeader("Value");
        grid.addColumn(Business::getIndustry_code_ANZSIC06).setHeader("Industry_code_ANZSIC06");
        grid.setItems(businessService.fetchAll());
        grid.setSizeFull();

        VerticalLayout gridWrapper = new VerticalLayout(toolbar, grid);
        gridWrapper.setMargin(false);
        gridWrapper.setPadding(false);
        gridWrapper.setSpacing(false);
        gridWrapper.setFlexGrow(1, grid);
        gridWrapper.setSizeFull();

        add(gridWrapper);
        setMargin(false);
        setPadding(false);
        setSpacing(false);
        setAlignItems(Alignment.STRETCH);
        setFlexGrow(1, gridWrapper);
        setSizeFull();
    }
}