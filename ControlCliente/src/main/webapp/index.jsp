<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Control de clientes</title>
        <jsp:include page="WEB-INF/paginas/comunes/scriptArriba.jsp"/>
    </head>
    <body>
        <jsp:include page="WEB-INF/paginas/comunes/cabecero.jsp"/>
        <fieldset>
            <legend> Formulario de autorización </legend>
            <form action="/ControlCliente/Acceso" method="POST">
                Usuario: <input type="text" id="txtUsuario" name="txtUsuario">
                <br>
                Password: <input type="password" id="txtPassword" name="txtPassword">
                <br>
                <br>
                <input type="submit" value="Enviar Datos">
            </form>
        </fieldset>
        
        <jsp:include page="WEB-INF/paginas/comunes/piePagina.jsp"/>
        <jsp:include page="WEB-INF/paginas/comunes/scriptAbajo.jsp"/>
    </body>
</html>
