package uniandes.dpoo.aerolinea.persistencia;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public class PersistencaAerolineaJson implements IPersistenciaAerolinea {
	@Override
    public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws Exception {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(archivo)) {
            Aerolinea datosCargados = gson.fromJson(reader, Aerolinea.class);
            aerolinea.setAviones(datosCargados.getAviones() != null ? datosCargados.getAviones() : new ArrayList<>());
            aerolinea.setRutas(datosCargados.getRutas() != null ? datosCargados.getRutas() : new HashMap<>());
            aerolinea.setVuelos(datosCargados.getVuelos() != null ? datosCargados.getVuelos() : new ArrayList<>());
            aerolinea.setClientes(datosCargados.getClientes() != null ? datosCargados.getClientes() : new HashMap<>());
        }
    }

    @Override
    public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws Exception {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(aerolinea, writer);
        }
    }

}
