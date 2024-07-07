<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h4 class="modal-title">Agregar cliente</h4>
                <button class="close" data-dismiss="modal">
                    <span>&timesb;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/Acceso?accion=insertar" 
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="txtPNombre">Primero nombre</label>
                        <input type="text" class="form-control" name="txtPNombre" required>
                    </div>
                    <div class="form-group">
                        <label for="txtSNombre">Segundo nombre</label>
                        <input type="text" class="form-control" name="txtSNombre">
                    </div>
                    <div class="form-group">
                        <label for="txtApellidos">Apellidos</label>
                        <input type="text" class="form-control" name="txtApellidos" required>
                    </div>
                    <div class="form-group">
                        Seleccione el sexo:<br>
                        <input type="radio" id="M" name="cbSexo" value="M" required>
                        <label for="M">Masculino</label><br>
                        <input type="radio" id="F" name="cbSexo" value="F" required>
                        <label for="F">Femenino</label><br>
                    </div>
                    <div class="form-group">
                        <label for="txtCorreo">Correo</label>
                        <input type="email" class="form-control" name="txtCorreo" required>
                    </div>
                    <div class="form-group">
                        <label for="txtSaldo">Saldo</label>
                        <input type="number" class="form-control" name="txtSaldo" required step="any">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
