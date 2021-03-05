package profe.empleadosdpts.negocio;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import profe.empleadosdpts.daos.DptosDAO;
import profe.empleadosdpts.daos.EmpDAO;
import profe.empleadosdpts.model.Empleado;

@Service
@Transactional
public class EmpNegocioImpl implements EmpNegocio {

	@Resource(name="daoEmpsJdbc")
	private EmpDAO empDao;

	@Autowired
	private DptosDAO dptosDao;

	public Empleado getEmpleado(String cif) {
		return empDao.getEmpleado(cif);
	}

	public List<Empleado> getAllEmpleados() {
		return empDao.getAllEmpleados();
	}

	public boolean insertaEmpleado(Empleado emp) {
		return empDao.insertaEmpleado(emp);
	}

	public boolean modificaEmpleado(Empleado emp) {
		return empDao.modificaEmpleado(emp);
	}

	public boolean eliminaEmpleado(String cif) {
		return empDao.eliminaEmpleado(cif);
	}

	@Override
	public void insertaVariosEmpleados(List<Empleado> empleados) {
		for (Empleado emp : empleados) {
			empDao.insertaEmpleado(emp);
		}
	}

	@Override
	public void eliminaVariosEmpleados(List<Empleado> empleados) {
		for (Empleado emp : empleados) {
			empDao.eliminaEmpleado(emp.getCif());
		}
	}

	@Override
	public void insertaEmpleadoYAsignaADpto(Empleado emp, String dptoId) {
		empDao.insertaEmpleado(emp);
		dptosDao.asignaEmpleadoADpto(emp.getCif(), dptoId);
	}
	
}









