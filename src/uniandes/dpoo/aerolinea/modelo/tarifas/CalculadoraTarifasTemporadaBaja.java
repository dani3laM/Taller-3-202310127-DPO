package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	protected static final int COSTO_POR_KM_NATURAL = 600;
    protected static final int COSTO_POR_KM_CORPORATIVO = 900;
    protected static final double DESCUENTO_PEQ = 0.02;
    protected static final double DESCUENTO_MEDIANAS = 0.1;
    protected static final double DESCUENTO_GRANDES = 0.2;

    // Implementación del método para calcular el costo base
    @Override
    protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        // Suponiendo que cliente tiene un método para determinar si es corporativo o no
        int costoPorKm = cliente.getTipoCliente() == "CORPORATIVO" ? COSTO_POR_KM_CORPORATIVO : COSTO_POR_KM_NATURAL;
        int distancia = calcularDistanciaVuelo(vuelo.getRuta());
        return costoPorKm * distancia;
    }

    // Implementación del método para calcular el porcentaje de descuento
    @Override
    protected double calcularPorcentajeDescuento(Cliente cliente) {
    	
    }

	@Override
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int calcularDistanciaVuelo(Ruta ruta) {
		// TODO Auto-generated method stub
		return 0;
	}

}
