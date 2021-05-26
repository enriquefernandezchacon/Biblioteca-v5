package org.iesalandalus.programacion.biblioteca.mvc.modelo;

import org.iesalandalus.programacion.biblioteca.mvc.modelo.negocio.ficheros.FactoriaFuenteDatosFicheros;
import org.iesalandalus.programacion.biblioteca.mvc.modelo.negocio.mongodb.FactoriaFuenteDatosMongoDB;

/**
 * @author Enrique
 *
 */
public enum FactoriaFuenteDatos {
	
	FICHEROS {
		public IFuenteDatos crear() {
			return new FactoriaFuenteDatosFicheros();
		}
	},

	MONGODB {
		public IFuenteDatos crear() {
			return new FactoriaFuenteDatosMongoDB();
		}
	};
	
	FactoriaFuenteDatos() {
		
	}
	
	public abstract IFuenteDatos crear();
	
	
}
