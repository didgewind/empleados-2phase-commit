package profe.empleadosdpts.daos;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value="daoDptosJdbc")
@Lazy
public class DptosDAOJdbc implements DptosDAO {

	private JdbcTemplate jdbcTemplate;
	
	private interface ConstantesSQL {
		String INSERTA_EMPLEADO_DPTO =
				"insert into empleados_departamentos values(?, ?)";
	}
	
	private Logger logger = Logger.getLogger(DptosDAOJdbc.class
			.getName());


	@Autowired
	public void setDataSource(DataSource departamentosDataSource) {
		this.jdbcTemplate = new JdbcTemplate(departamentosDataSource);
	}

	@Override
	public boolean asignaEmpleadoADpto(String cif, String idDpto) {
		this.jdbcTemplate.update(ConstantesSQL.INSERTA_EMPLEADO_DPTO,
				cif, idDpto);
		return true;
	}

}
