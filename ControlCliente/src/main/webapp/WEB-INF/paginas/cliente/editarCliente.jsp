<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Clientes</title>
        <jsp:include page="/WEB-INF/paginas/comunes/scriptArriba.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>

        <form action="${pageContext.request.contextPath}/Acceso?accion=modificar&idCliente=${cliente.id_persona}"
              method="POST" class="was-validated">
            <jsp:include page="/WEB-INF/paginas/comunes/btnsNavegacionEdicion.jsp"/>

            <section id="details">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Cliente.</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="txtPNombre">Primero nombre</label>
                                        <input type="text" class="form-control" name="txtPNombre" required value="${cliente.pnombre}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="txtSNombre">Segundo nombre</label>
                                        <input type="text" class="form-control" name="txtSNombre" value="${cliente.snombre}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="txtApellidos">Apellidos</label>
                                        <input type="text" class="form-control" name="txtApellidos" required value="${cliente.apellidos}"/>
                                    </div>
                                    <div class="form-group">
                                        Seleccione el sexo:<br>
                                        <input type="radio" id="M" name="cbSexo" value="M" required ${cliente.sexo == 'Masculino' ? 'checked':''}/>
                                        <label for="M">Masculino </label><br>
                                        <input type="radio" id="F" name="cbSexo" value="F" required ${cliente.sexo == 'Femenino' ? 'checked':''}/>
                                        <label for="F">Femenino </label><br>
                                    </div>
                                    <div class="form-group">
                                        <label for="txtCorreo">Correo</label>
                                        <input type="email" class="form-control" name="txtCorreo" required value="${cliente.correo}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="txtSaldo">Saldo</label>
                                        <input type="number" class="form-control" name="txtSaldo" required value="${cliente.saldo}" step="any"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>

        <jsp:include page="/WEB-INF/paginas/comunes/scriptAbajo.jsp"/>
    </body>
</html>
