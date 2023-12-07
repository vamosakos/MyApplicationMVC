package com.akos.vamos.MyApplication.view;
import com.akos.vamos.MyApplication.entity.Car;
import com.akos.vamos.MyApplication.service.CarService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.List;

@Route("")
@PageTitle("Cars project main view")
public class MainView extends HorizontalLayout {
    private final CarService carService;

    private final Button buttonAdd = new Button("Add");
    private final TextField textFieldNumber = new TextField("Car number:");
    private final TextField textFieldType = new TextField("Type:");
    private final Grid<Car> grid = new Grid<>(Car.class);
    private final Span label = new Span("Cars:");

    public MainView(CarService carService) {
        this.carService = carService;

        addClassName("main-view");
        setSizeFull();
        updateGrid();
        add(createForm(), createGrid());
    }

    private VerticalLayout createForm() {
        setSizeFull();
        buttonAdd.addClickListener(event -> {
            String number = textFieldNumber.getValue();
            String type = textFieldType.getValue();

            Car newCar = new Car();
            newCar.setNumber(number);
            newCar.setType(type);

            carService.saveCar(newCar);

            updateGrid();
        });
        buttonAdd.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonAdd.addClickShortcut(Key.ENTER);

        return new VerticalLayout(textFieldNumber, textFieldType, buttonAdd);
    }

    private VerticalLayout createGrid() {
        setSizeFull();
        return new VerticalLayout(label, grid);
    }

    private void updateGrid() {
        List<Car> allCars = carService.getAllCars();
        grid.setItems(allCars);
    }
}
