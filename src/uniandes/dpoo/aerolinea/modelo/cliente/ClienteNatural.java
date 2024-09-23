package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural  extends Cliente{
	
	private String nombre;
	public static final String NATURAL = "Natural";
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ClienteNatural(String nombre) {
		super(NATURAL);
		this.nombre = nombre;
	}
	
}
