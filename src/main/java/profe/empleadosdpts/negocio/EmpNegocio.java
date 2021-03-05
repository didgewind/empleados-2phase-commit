package profe.empleadosdpts.negocio;

import java.util.List;

import profe.empleadosdpts.model.Empleado;

public interface EmpNegocio {

	Empleado getEmpleado(String cif);
	
	List<Empleado> getAllEmpleados();
	
	boolean insertaEmpleado(Empleado emp);

	boolean modificaEmpleado(Empleado emp);

	boolean eliminaEmpleado(String cif);
	
	void insertaVariosEmpleados(List<Empleado> empleados);
	
	void eliminaVariosEmpleados(List<Empleado> empleados);
	
	void insertaEmpleadoYAsignaADpto(Empleado emp, String dptoId);

}
