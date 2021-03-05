<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
<spring:message code="saludo"/>
</p>
<p>
Esta app no requiere autenticación. La usamos para probar transacciones distribuidas con spring
y atomikos. El api es el siguiente:
</p>
<p><pre>
- GET /empleados/: devuelve todos los empleados
- GET /empleados/x: devuelve el empleado con cif x
- PUT /empleados/: inserta un empleado
- DELETE /empleados/x: elimina el empleado con cif x
- POST /empleados/: modifica un empleado
- POST /empleados/dptos/{dptoId}: inserta un empleado y lo asigna al dpto dptoId</pre></p>
<p>En la doc del proyecto explicamos mejor las cosas</p>

</body>
</html>