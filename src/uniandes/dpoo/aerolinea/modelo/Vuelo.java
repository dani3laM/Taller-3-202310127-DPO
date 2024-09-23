package uniandes.dpoo.aerolinea.modelo;

import java.util.HashMap;
import java.util.Map;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Map<String,Tiquete> tiquetes;
	
	public Vuelo(String fecha, Ruta ruta, Avion avion) {
        this.fecha = fecha;
        this.ruta = ruta;
        this.avion = avion;
        this.tiquetes = new HashMap<>(); // Inicializa el mapa de tiquetes vacío
    }
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	public Avion getAvion() {
		return avion;
	}
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	public Map<String, Tiquete> getTiquetes() {
		return tiquetes;
	}
	public void setTiquetes(Map<String, Tiquete> tiquetes) {
		this.tiquetes = tiquetes;
	}
	
	public void agregarTiquete(Tiquete tiquete) {
        if (tiquete != null) {
            tiquetes.put(tiquete.getCodigo(), tiquete);
        }
    }

    public Tiquete getTiquete(String codigoTiquete) {
        return tiquetes.get(codigoTiquete);
    }

    public Tiquete eliminarTiquete(String codigoTiquete) {
        return tiquetes.remove(codigoTiquete);
    }

    public boolean hayEspacioDisponible() {
        return tiquetes.size() < avion.getCapacidad();
    }

 
    public int obtenerTotalTiquetesVendidos() {
        return tiquetes.size();
    }

    public boolean estaLleno() {
        return tiquetes.size() >= avion.getCapacidad();
        
    }
    
    public int venderTiquete(Cliente cliente, int tarifa) throws Exception {
        
        if (estaLleno()) {
            throw new Exception("No hay espacio disponible en el vuelo.");
        }

     
        Tiquete nuevoTiquete = GeneradorTiquetes.generarTiquete(this, cliente, tarifa);

    
        agregarTiquete(nuevoTiquete);

 
        GeneradorTiquetes.registrarTiquete(nuevoTiquete);

        cliente.agregarTiquete(nuevoTiquete);

        
        return nuevoTiquete.getCodigo();
    }

}
