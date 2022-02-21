package de.hsm.exam.views;



import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import de.hsm.exam.logic.Product;
import de.hsm.exam.logic.ProductManager;

@Route(value = "showProducts", layout = MainView.class)
@PageTitle("Show Products")
public class ProductView extends Div{

	private static final long serialVersionUID = 1L;
	
	public ProductView() {
		
		VerticalLayout verticalLayout = new VerticalLayout();
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		
		TextField searchText = new TextField();
		searchText.setPlaceholder("type here");
		
		Button searchButton = new Button("Search",VaadinIcon.SEARCH.create());
		searchButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
		horizontalLayout.add(searchText, searchButton);
		verticalLayout.add(horizontalLayout);
		
		ProductManager pM =new ProductManager();
		Grid<Product> productGrid = new Grid<>(Product.class, true);
		verticalLayout.add(productGrid);
		
		searchButton.addClickListener(e->
		{
			fillGrid(productGrid, searchText.getValue());
		});
		
		add(verticalLayout);
		
		
	}
	public void fillGrid(Grid productGrid, String searchedText)
	{
		ProductManager pM = new ProductManager();
		List<Product> products = pM.findProducts(searchedText); 
		productGrid.setItems(products);
		productGrid.getDataProvider().refreshAll();
	}
	

}
