package co.edu.uniquindio.concesionariouq.model;

import java.util.HashMap;

import co.edu.uniquindio.concesionariouq.exceptions.ConcesionarioException;

public class Administrador extends Empleado {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<String, Empleado> listaEmpleados;

	/**
	 * Este es el metodo constructor de la clase Administrador
	 * 
	 * @param id
	 * @param nombre
	 * @param contrasena
	 * @param email
	 * @param respuestaDeSeguridad
	 */
	public Administrador(String id, String nombre, String contrasena, String email, String respuestaDeSeguridad) {
		super(id, nombre, contrasena, email, respuestaDeSeguridad);
		this.listaEmpleados = new HashMap<String, Empleado>();
	}

	@Override
	public TipoUsuario getTipoUsuario() {
		return TipoUsuario.ADMIN;
	}

	/**
	 * Este metodo registra un empleado
	 * 
	 * @throws ConcesionarioException
	 */
	public void registrarEmpleado(Empleado empleado) throws ConcesionarioException {
		if (validarEmpleado(empleado.getId()))
			throw new ConcesionarioException("El empleado ya se encuentra trabajando para el admin");
		listaEmpleados.put(empleado.getId(), empleado);
	}

	private boolean validarEmpleado(String id) {
		return listaEmpleados.containsKey(id);
	}

	/**
	 * Este metodo elimina un empleado
	 */
	public void eliminarEmpleado(String id) throws ConcesionarioException {
		if (!validarEmpleado(id))
			throw new ConcesionarioException("El empleado no se encuentra trabajando para el admin");
		listaEmpleados.remove(id);
	}

	/**
	 * Este metodo actualiza un empleado
	 * 
	 * @param empleado
	 * @throws ConcesionarioException
	 */
	public void actualizarEmpleado(Empleado empleado) throws ConcesionarioException {
		if (!validarEmpleado(empleado.getId()))
			throw new ConcesionarioException("El empleado no se encuentra trabajando para el admin");
		listaEmpleados.put(empleado.getId(), empleado);
	}

	/**
	 * Este metodo bloquea a un empleado
	 * 
	 * @param id
	 * @throws ConcesionarioException
	 */
	public void bloquearEmpleado(String id) throws ConcesionarioException {
		if (!validarEmpleado(id))
			throw new ConcesionarioException("El empleado no fue encontrado");
		Empleado empleado = listaEmpleados.get(id);
		empleado.setIsActivo(false);
		actualizarEmpleado(empleado);
	}

	/**
	 * Este metodo genera un reporte
	 */
	public void generarReporte() {

	}

	/**
	 * Este metodo es la que recupera contraseñas
	 */
	public void recuperarContrasena() {

	}

	public HashMap<String, Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(HashMap<String, Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

}
