package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	protected ArrayList<Tiquete> tiquetesSinUsar;
	protected ArrayList<Tiquete> tiquetesUsados;
	protected String identificador;
	
	public Cliente(String identificador) {
		this.identificador = identificador;
        tiquetesSinUsar = new ArrayList<>();
        tiquetesUsados = new ArrayList<>();
    }

    public String getTipoCliente() {
		return identificador;

    }

	public ArrayList<Tiquete> getTiquetesSinUsar() {
		return tiquetesSinUsar;
	}

	public void setTiquetesSinUsar(ArrayList<Tiquete> tiquetesSinUsar) {
		this.tiquetesSinUsar = tiquetesSinUsar;
	}

	public ArrayList<Tiquete> getTiquetesUsados() {
		return tiquetesUsados;
	}

	public void setTiquetesUsados(ArrayList<Tiquete> tiquetesUsados) {
		this.tiquetesUsados = tiquetesUsados;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	
	
	public double calcularValorTotalTiquetes() {
        double total = 0.0;

        for (Tiquete tiquete : tiquetesSinUsar) {
            total += tiquete.getTarifa();
        }

        for (Tiquete tiquete : tiquetesUsados) {
            total += tiquete.getTarifa();
        }

        return total;
    }
	
	public void usarTiquetes(Vuelo vuelo) {
        ArrayList<Tiquete> tiquetesUsadosAhora = new ArrayList<>();
        
        // Iterar sobre los tiquetes sin usar
        for (Tiquete tiquete : tiquetesSinUsar) {
        	tiquetesUsadosAhora.add(tiquete);
        }
        
        // Marcar los tiquetes como usados
        for (Tiquete tiquete : tiquetesUsadosAhora) {
            tiquetesSinUsar.remove(tiquete);
            tiquetesUsados.add(tiquete);
        }
    }
	

}
