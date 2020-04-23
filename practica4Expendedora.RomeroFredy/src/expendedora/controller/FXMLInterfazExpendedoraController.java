package expendedora.controller;

import java.net.URL;
import java.util.ResourceBundle;

import expendedora.model.CambioInsuficienteException;
import expendedora.model.CreditoInsuficienteException;
import expendedora.model.Expendedora;
import expendedora.model.StockInsuficienteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLInterfazExpendedoraController implements Initializable {

    @FXML
    private Button id20;

    @FXML
    private Button id2;

    @FXML
    private Button id5;

    @FXML
    private Button id10;

    @FXML
    private Button id1;

    @FXML
    private Button id05;

    @FXML
    private Button id50;

    @FXML
    private Button id02;

    @FXML
    private TextField idcredito;

    @FXML
    private TextField idvuelta;

    @FXML
    private Button idcomprar;

    @FXML
    private TextField idcambio;

    @FXML
    private Button idcancelar;

    @FXML
    private Button idp1;

    @FXML
    private Button idp2;

    @FXML
    private Button idp4;

    @FXML
    private Button idp5;

    @FXML
    private Button idp3;

    @FXML
    private Button idp6;
    
    @FXML
    private TextField iderror;

    @FXML
    void id02Action(ActionEvent event) {
    	idvuelta.setText("");
    	ex.anyadirDinero(0.02);
    	mostrarEstadoExpendedora();
    }

    @FXML
    void id05Action(ActionEvent event) {
    	idvuelta.setText("");
    	ex.anyadirDinero(0.05);
    	mostrarEstadoExpendedora();
    }

    @FXML
    void id10Action(ActionEvent event) {
    	idvuelta.setText("");
    	ex.anyadirDinero(0.10);
    	mostrarEstadoExpendedora();
    }

    @FXML
    void id1Action(ActionEvent event) {
    	idvuelta.setText("");
    	ex.anyadirDinero(1);
    	mostrarEstadoExpendedora();
    }

    @FXML
    void id20Action(ActionEvent event) {
    	idvuelta.setText("");
    	ex.anyadirDinero(0.20);
    	mostrarEstadoExpendedora();
    }

    @FXML
    void id2Action(ActionEvent event) {
    	idvuelta.setText("");
    	ex.anyadirDinero(2);
    	mostrarEstadoExpendedora();
    }

    @FXML
    void id50Action(ActionEvent event) {
    	idvuelta.setText("");
    	ex.anyadirDinero(0.50);
    	mostrarEstadoExpendedora();
    }

    @FXML
    void id5Action(ActionEvent event) {
    	idvuelta.setText("");
    	ex.anyadirDinero(5);
    	mostrarEstadoExpendedora();
    }

    @FXML
    void idcancelarAction(ActionEvent event) {
    	idvuelta.setText("");
    	ex.devolverCredito();
    	mostrarEstadoExpendedora();
    }
    


    @FXML
    void idp1Action(ActionEvent event) {
		try {
			idvuelta.setText(String.valueOf(ex.comprar(0)));
			mostrarEstadoExpendedora();
			
		} catch (CreditoInsuficienteException e) {
			iderror.setText("Credito Insuficiente");
		
		} catch (CambioInsuficienteException e) {
			iderror.setText("Cambio Insuficiente");
			
		} catch (StockInsuficienteException e) {
			iderror.setText("Stock Insuficiente");
	
		
		}
    }

    @FXML
    void idp2Action(ActionEvent event) {
		try {
			idvuelta.setText(String.valueOf(ex.comprar(1)));
			mostrarEstadoExpendedora();
			
		} catch (CreditoInsuficienteException e) {
			iderror.setText("Credito Insuficiente");
		
		} catch (CambioInsuficienteException e) {
			iderror.setText("Cambio Insuficiente");
			
		} catch (StockInsuficienteException e) {
			iderror.setText("Stock Insuficiente");
	
			
		}
    }

    @FXML
    void idp3Action(ActionEvent event) {
		try {
		
			idvuelta.setText(String.valueOf(ex.comprar(2)));
			mostrarEstadoExpendedora();
			
		} catch (CreditoInsuficienteException e) {
			iderror.setText("Credito Insuficiente");
		
		} catch (CambioInsuficienteException e) {
			iderror.setText("Cambio Insuficiente");
			
		} catch (StockInsuficienteException e) {
			iderror.setText("Stock Insuficiente");
	
			
		}
    }

    @FXML
    void idp4Action(ActionEvent event) {
		try {
	   
			idvuelta.setText(String.valueOf(ex.comprar(3)));
			mostrarEstadoExpendedora();
			
		} catch (CreditoInsuficienteException e) {
			iderror.setText("Credito Insuficiente");
		
		} catch (CambioInsuficienteException e) {
			iderror.setText("Cambio Insuficiente");
			
		} catch (StockInsuficienteException e) {
			iderror.setText("Stock Insuficiente");
	
		}
    }

    @FXML
    void idp5Action(ActionEvent event) {
		try {
			idvuelta.setText(String.valueOf(ex.comprar(4)));
			mostrarEstadoExpendedora();
			
		} catch (CreditoInsuficienteException e) {
			iderror.setText("Credito Insuficiente");
		
		} catch (CambioInsuficienteException e) {
			iderror.setText("Cambio Insuficiente");
			
		} catch (StockInsuficienteException e) {
			iderror.setText("Stock Insuficiente");
	
		}
    }

    @FXML
    void idp6Action(ActionEvent event) {
		try {
			idvuelta.setText(String.valueOf(ex.comprar(5)));
			mostrarEstadoExpendedora();
			
		} catch (CreditoInsuficienteException e) {
			iderror.setText("Credito Insuficiente");
		
		} catch (CambioInsuficienteException e) {
			iderror.setText("Cambio Insuficiente");
			
		} catch (StockInsuficienteException e) {
			iderror.setText("Stock Insuficiente");
	
		
		}
    }
    
    Expendedora ex;
    
    public void initialize(URL arg0, ResourceBundle arg1) {
		mostrarEstadoExpendedora();
	}
    
    
    public FXMLInterfazExpendedoraController(){
    	String [] productos = {"Agua","Aquarius","Coca Cola","Doritos","Chicle","Pizza"};
    	double [] precios ={1.25,2.05,2.50,1.50,0.80,6};
    	int [] stock= {6,4,2,3,10,5};
    	ex = new Expendedora (15,productos,precios,stock);
    }

	private void mostrarEstadoExpendedora() {
		//Mostrar credito y cambio disponible
		idcredito.setText(String.valueOf(ex.getCredito()));
		idcambio.setText(String.valueOf(ex.getCambioDisponible()));
		iderror.setText("");
		
		//Mostrar Productos
		idp1.setText(String.valueOf(ex.getNombre(0))+"\n"+ String.valueOf(ex.getPrecio(0))+
				"\n"+ String.valueOf(ex.getStock(0))+ "uds");
		idp2.setText(String.valueOf(ex.getNombre(1))+"\n"+ String.valueOf(ex.getPrecio(1))+
				"\n"+ String.valueOf(ex.getStock(1))+ "uds");
		idp3.setText(String.valueOf(ex.getNombre(2))+"\n"+ String.valueOf(ex.getPrecio(2))+
				"\n"+ String.valueOf(ex.getStock(2))+ "uds");
		idp4.setText(String.valueOf(ex.getNombre(3))+"\n"+ String.valueOf(ex.getPrecio(3))+
				"\n"+ String.valueOf(ex.getStock(3))+ "uds");
		idp5.setText(String.valueOf(ex.getNombre(4))+"\n"+ String.valueOf(ex.getPrecio(4))+
				"\n"+ String.valueOf(ex.getStock(4))+ "uds");
		idp6.setText(String.valueOf(ex.getNombre(5))+"\n"+ String.valueOf(ex.getPrecio(5))+
				"\n"+ String.valueOf(ex.getStock(5))+ "uds");
	
	}

	
    
}
