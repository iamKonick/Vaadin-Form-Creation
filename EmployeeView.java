package de.hsm.exam.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.selection.SingleSelect;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "edit", layout = MainView.class)
@PageTitle("Add Employee")
public class EmployeeView extends Div {
	private static final long serialVersionUID = 1L;

	public EmployeeView() {
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.setAlignItems(Alignment.CENTER);
		H2 h2 = new H2();
		h2.setText("Add Employee");
		TextField firstNameTextField = new TextField("First Name");
		TextField lastNameTextField = new TextField("Last Name");
		RadioButtonGroup<String> specialityRadioOptions = new RadioButtonGroup<>();
		specialityRadioOptions.setItems("IT", "Personal", "Marketing");
		specialityRadioOptions.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
		specialityRadioOptions.setValue("IT");
		
		DatePicker startDate = new DatePicker("Start Of Contract");
		Select<String> status = new Select();
		status.setItems("Limited","Unlimited", "External");
		status.setValue("External");
		Button addButton = new Button("Add");
		addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
		verticalLayout.add(h2, firstNameTextField, lastNameTextField, specialityRadioOptions, startDate, status, addButton);
		add(verticalLayout);
	}

}
