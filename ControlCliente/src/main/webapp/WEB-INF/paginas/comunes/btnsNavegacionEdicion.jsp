<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
                <a href="panelClientes.jsp" class="btn btn-light btn-block">
                    <i class="fas fa-arrow-left"></i> Regresar al inicio
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fas-check"></i> Guardar Cliente
                </button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/Acceso?accion=eliminar&idCliente=${cliente.id_persona}" 
                   class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i> Eliminar
                </a>
            </div>
        </div>
    </div>
</section>