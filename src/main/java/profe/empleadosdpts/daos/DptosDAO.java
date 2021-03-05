package profe.empleadosdpts.daos;

import java.util.List;

import profe.empleadosdpts.model.Empleado;

public interface DptosDAO {

	boolean asignaEmpleadoADpto(String cif, String idDpto);

}
