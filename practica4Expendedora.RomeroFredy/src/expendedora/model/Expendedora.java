package expendedora.model;

public class Expendedora {
	final static double CREDITOMAXIMO = 10;
	private double credito;
	private double cambioDisponible;
	private double importeVentas;
	private String[] nombreProductos;
	private double[] precioProductos;
	private int[] stockProductos;

	public Expendedora(double cambioDisponible, String[] nombreProductos, double[] precioProductos,
	int[] stockProductos) {

		this.credito = credito = 0;
		this.cambioDisponible = cambioDisponible;
		this.importeVentas = importeVentas = 0;

		if(nombreProductos.length == precioProductos.length && nombreProductos.length == stockProductos.length){
		this.nombreProductos = new String[nombreProductos.length] ;
		for (int i = 0; i < nombreProductos.length; i++) {
			this.nombreProductos[i] = nombreProductos[i];
		}
		
		this.precioProductos = new double [precioProductos.length];
		for (int i = 0; i < nombreProductos.length; i++) {
			this.precioProductos[i] = precioProductos[i];
		}
		
		this.stockProductos = new int [stockProductos.length];
		for (int i = 0; i < precioProductos.length; i++) {
			this.stockProductos[i] = stockProductos[i];
		}
		
		
		}else{
			throw new IllegalArgumentException("");
		}
	}

	public double getCredito() {
		return credito;
	}

	public double getCambioDisponible() {
		return cambioDisponible;
	}

	public double getImporteVentas() {
		return importeVentas;
	}

	public int getNumeroProductos() {
		return nombreProductos.length;
	}
	
	public String getNombre(int i) {
		String nombre ;
		return  nombre = nombreProductos[i];
	}
	
	public double getPrecio(int i) {
		double precio;
		return precio = precioProductos[i];
	}
		
	public int getStock(int i) {
		int stock = 0;
		
		return stock = stockProductos[i];
	}
	

	public String toString() {
		System.out.println("Credito	: " + credito + "\n" + "Cambio : " + cambioDisponible + "\n" + "Importe de ventas : "
				+ importeVentas + "\n" + "Productos : " + nombreProductos.length);
			for (int i = 0; i < getNumeroProductos(); i++) {
			      System.out.println("    " + getNombre(i) + " - " + getPrecio(i) + " euros - " + getStock(i) + " uds ");
			      };
	return "";  
	}

	public void anyadirDinero(double importe) {
			credito =  Math.round((credito + importe)*100) /100d ;
			if(credito > CREDITOMAXIMO){
			credito = Math.round((credito - importe)*100) /100d ;
			}
			
	}

	public double devolverCredito() {
		return credito = 0;
	}

	public double comprar(int producto) throws CreditoInsuficienteException,
	CambioInsuficienteException, StockInsuficienteException{
		double resu= 0, vuelta = 0;
		vuelta = credito - precioProductos[producto];
		
		
		if(credito < precioProductos[producto]){ 
			throw new CreditoInsuficienteException("Credio Insuficiente");
		}else{
		if(getCambioDisponible() < vuelta) {
			throw new CambioInsuficienteException("Cambio Insuficiente");
		}else{
		if(stockProductos[producto] == 0){
			throw new StockInsuficienteException("Stock Insuficiente");
		}else{
			resu = vuelta; 
			stockProductos[producto]--;
			cambioDisponible = Math.round((cambioDisponible - resu)*100) /100d;
			credito = 0;
			importeVentas += precioProductos[producto];
		}
		}
		}
		
		return Math.round((vuelta)*100) /100d ;
		
	}


}
