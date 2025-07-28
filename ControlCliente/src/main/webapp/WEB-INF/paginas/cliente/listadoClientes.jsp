<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_DO"/>
<section id="clientes" class="">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h3>Listado de clientes</h3>
                    </div>
                    <table class="table table-striped">
                        <caption>Listados de clientes</caption>
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Primer Nombre</th>
                                <th>Segundo Nombre</th>
                                <th>Apellidos</th>
                                <th>Sexo</th>
                                <th>Correo</th>
                                <th>Saldo</th>
                                <th> </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cliente" items="${clientes}" >
                                <tr>
                                    <td>${cliente.id_persona}</td>
                                    <td>${cliente.pnombre}</td>
                                    <td>${cliente.snombre}</td>
                                    <td>${cliente.apellidos}</td>
                                    <td>${cliente.sexo}</td>
                                    <td>${cliente.correo}</td>
                                    <td><fmt:formatNumber value="${cliente.saldo}" type="currency"/></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/Acceso?accion=editar&idCliente=${cliente.id_persona}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Saldo Total</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${saldoTotal}" type="currency"/>
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total clientes</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalClientes}
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp"/>