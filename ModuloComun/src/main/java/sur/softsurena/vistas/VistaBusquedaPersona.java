package sur.softsurena.vistas;

import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lombok.Getter;
import sur.softsurena.abstractas.Persona;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.Empleado;
import sur.softsurena.entidades.Estudiante;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Paciente;
import sur.softsurena.entidades.Padre;
import sur.softsurena.entidades.Paginas;
import sur.softsurena.entidades.Proveedor;
import sur.softsurena.metodos.M_Cliente;
import sur.softsurena.metodos.M_Empleado;
import sur.softsurena.metodos.M_Estudiante;
import sur.softsurena.metodos.M_Generales;
import sur.softsurena.metodos.M_Paciente;
import sur.softsurena.metodos.M_Persona;

/**
 *
 * @author jhironsel
 */
@Getter
public final class VistaBusquedaPersona extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    private transient Persona persona;

    private final String[] titulos = {"Lista de Persona"};
    private final DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
    private final transient Object[] registro = new Object[titulos.length];

    public VistaBusquedaPersona(Frame parent, boolean modal, String[] entidades) {
        super(parent, modal);
        initComponents();
        cbEntidades.setModel(
                new javax.swing.DefaultComboBoxModel<>(
                        entidades
                )
        );
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        btnCancelar = new newscomponents.RSButtonGradientIcon_new();
        btnAceptar = new newscomponents.RSButtonGradientIcon_new();
        txtCriterio = new rojeru_san.RSMTextFull();
        jPanel1 = new javax.swing.JPanel();
        cbEntidades = new RSMaterialComponent.RSComboBoxMaterial<>();
        rbCedula = new javax.swing.JRadioButton();
        rbNombresApellidos = new javax.swing.JRadioButton();
        jcbEstado = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busqueda de Clientes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblTabla.setForeground(new java.awt.Color(1, 1, 1));
        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTabla.setAutoscrolls(false);
        tblTabla.setGridColor(new java.awt.Color(1, 1, 1));
        jScrollPane1.setViewportView(tblTabla);

        btnCancelar.setText("Cancelar");
        btnCancelar.setColorPrimario(new java.awt.Color(153, 0, 0));
        btnCancelar.setColorPrimarioHover(new java.awt.Color(255, 51, 51));
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DONE);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        txtCriterio.setToolTipText("");
        txtCriterio.setPlaceholder("Ingrese criterio de busqueda ya sea Identificador de cliente, nombres o apellidos.");
        txtCriterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriterioActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 255)), "Filtrado por:"));
        jPanel1.setLayout(new java.awt.GridLayout(1, 8, 10, 0));

        cbEntidades.setBackground(new java.awt.Color(37, 45, 223));
        cbEntidades.setForeground(new java.awt.Color(255, 255, 255));
        cbEntidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Clientes", "Empleados", "Estudiantes", "Pacientes", "Padres", "Proveedores" }));
        cbEntidades.setToolTipText("");
        cbEntidades.setColorMaterial(new java.awt.Color(255, 255, 255));
        cbEntidades.setDoubleBuffered(true);
        jPanel1.add(cbEntidades);

        buttonGroup1.add(rbCedula);
        rbCedula.setSelected(true);
        rbCedula.setText("Cedula");
        jPanel1.add(rbCedula);

        buttonGroup1.add(rbNombresApellidos);
        rbNombresApellidos.setText("Nombres o Apellidos");
        jPanel1.add(rbNombresApellidos);

        jcbEstado.setSelected(true);
        jcbEstado.setText("Activos");
        jcbEstado.setEnabled(false);
        jPanel1.add(jcbEstado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCriterio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Encargador de llenar la tabla de persona y colocar focus en criterio.
     *
     * @param evt
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //Llenamos la tabla de la primera entidad.
        llenarTabla();

        //Tenemos focus en el campo criterio.
        txtCriterio.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    /**
     *
     * @param evt
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     *
     * @param evt
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (tblTabla.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un/a %s".formatted(cbEntidades.getSelectedItem().toString()),
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        persona = (Persona) tblTabla.getValueAt(tblTabla.getSelectedRow(), 0);
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     *
     * @param evt
     */
    private void txtCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioActionPerformed
        llenarTabla();
    }//GEN-LAST:event_txtCriterioActionPerformed

    /**
     * Permite obtener la lista de clietne que cumplan con el criterio de
     * busqueda, dichos criterios seran la cedula, nombres o apellidos.
     *
     */
    private void llenarTabla() {

        mostrarTodos();
        mostrarClientes();
        mostrarEmpleados();
        mostrarEstudiantes();
        mostrarPacientes();
        mostrarPadres();
        mostrarProveedores();

        tblTabla.setModel(miTabla);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonGradientIcon_new btnAceptar;
    private newscomponents.RSButtonGradientIcon_new btnCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private RSMaterialComponent.RSComboBoxMaterial<Object> cbEntidades;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbEstado;
    private javax.swing.JRadioButton rbCedula;
    private javax.swing.JRadioButton rbNombresApellidos;
    private javax.swing.JTable tblTabla;
    private rojeru_san.RSMTextFull txtCriterio;
    // End of variables declaration//GEN-END:variables

    private void mostrarTodos() {
        if (cbEntidades.getSelectedItem().toString().equalsIgnoreCase("Todos")) {
            if (rbCedula.isSelected()) {
                M_Generales.select(
                        Generales
                                .builder()
                                .cedula(txtCriterio.getText().strip())
                                .build()
                ).stream().forEach(
                        general -> {
                            M_Persona.select(
                                    Cliente
                                            .builder()
                                            .idPersona(general.getIdPersona())
                                            .build()
                            ).stream().forEach(
                                    obj -> {
                                        registro[0] = obj;
                                        miTabla.addRow(registro);
                                    }
                            );
                        }
                );
            }

            if (rbNombresApellidos.isSelected()) {
                M_Persona.select(
                        Cliente
                                .builder()
                                .pnombre(txtCriterio.getText().strip())
                                .snombre(txtCriterio.getText().strip())
                                .apellidos(txtCriterio.getText().strip())
                                .pagina(
                                        Paginas
                                                .builder()
                                                .nPaginaNro(1)
                                                .nCantidadFilas(20)
                                                .build()
                                )
                                .build()
                ).stream().forEach(
                        obj -> {
                            registro[0] = obj;
                            miTabla.addRow(registro);
                        }
                );
            }
        }
    }

    private void mostrarClientes() {
        if (cbEntidades.getSelectedItem().toString().equalsIgnoreCase("Clientes")) {

            if (rbCedula.isSelected()) {
                M_Generales.select(
                        Generales
                                .builder()
                                .cedula(txtCriterio.getText().strip())
                                .pagina(
                                        Paginas
                                                .builder()
                                                .nCantidadFilas(20)
                                                .nPaginaNro(1)
                                                .build()
                                )
                                .build()
                ).stream().forEach(
                        general -> {
                            if (!M_Cliente.select(
                                    Cliente
                                            .builder()
                                            .idPersona(general.getIdPersona())
                                            .build()
                            ).isEmpty()) {
                                M_Persona.select(
                                        Cliente
                                                .builder()
                                                .idPersona(general.getIdPersona())
                                                .build()
                                ).stream().forEach(
                                        obj -> {
                                            registro[0] = obj;
                                            miTabla.addRow(registro);
                                        }
                                );
                            }
                        }
                );
            }

            if (rbNombresApellidos.isSelected()) {
                M_Persona.select(
                        Proveedor
                                .builder()
                                .pnombre(txtCriterio.getText().strip())
                                .snombre(txtCriterio.getText().strip())
                                .apellidos(txtCriterio.getText().strip())
                                .build()
                ).stream().forEach(
                        obj -> {
                            if (!M_Cliente.select(
                                    Cliente
                                            .builder()
                                            .idPersona(obj.getIdPersona())
                                            .build()
                            ).isEmpty()) {
                                registro[0] = obj;
                                miTabla.addRow(registro);
                            }

                        }
                );
            }
        }
    }

    private void mostrarEmpleados() {
        if (cbEntidades.getSelectedItem().toString().equalsIgnoreCase("Empleados")) {

            if (rbNombresApellidos.isSelected()) {
                M_Empleado.select(
                        Empleado
                                .builder()
                                .pnombre(txtCriterio.getText().strip())
                                .snombre(txtCriterio.getText().strip())
                                .apellidos(txtCriterio.getText().strip())
                                .build()
                ).stream().forEach(
                        obj -> {
                            registro[0] = obj;
                            miTabla.addRow(registro);
                        }
                );
            }

            if (rbCedula.isSelected()) {
                M_Generales.select(
                        Generales
                                .builder()
                                .cedula(txtCriterio.getText().strip())
                                .build()
                ).stream().forEach(
                        general -> {
                            M_Persona.select(
                                    Empleado
                                            .builder()
                                            .idPersona(general.getIdPersona())
                                            .build()
                            ).stream().forEach(
                                    obj -> {
                                        registro[0] = obj;
                                        miTabla.addRow(registro);
                                    }
                            );
                        }
                );
            }
        }
    }

    private void mostrarEstudiantes() {
        if (cbEntidades.getSelectedItem().toString().equalsIgnoreCase("Estudiantes")) {

            if (rbNombresApellidos.isSelected()) {
                M_Estudiante.select(
                        Estudiante
                                .builder()
                                .pnombre(txtCriterio.getText().strip())
                                .snombre(txtCriterio.getText().strip())
                                .apellidos(txtCriterio.getText().strip())
                                .build()
                ).stream().forEach(
                        obj -> {
                            registro[0] = obj;
                            miTabla.addRow(registro);
                        }
                );
            }

            if (rbCedula.isSelected()) {
                M_Generales.select(
                        Generales
                                .builder()
                                .cedula(txtCriterio.getText().strip())
                                .build()
                ).stream().forEach(
                        general -> {
                            M_Persona.select(
                                    Estudiante
                                            .builder()
                                            .idPersona(general.getIdPersona())
                                            .build()
                            ).stream().forEach(
                                    obj -> {
                                        registro[0] = obj;
                                        miTabla.addRow(registro);
                                    }
                            );
                        }
                );
            }
        }
    }

    private void mostrarPacientes() {
        if (cbEntidades.getSelectedItem().toString().equalsIgnoreCase("Pacientes")) {

            if (rbNombresApellidos.isSelected()) {
                M_Paciente.select(
                        Paciente
                                .builder()
                                .pnombre(txtCriterio.getText().strip())
                                .snombre(txtCriterio.getText().strip())
                                .apellidos(txtCriterio.getText().strip())
                                .build()
                ).stream().forEach(
                        obj -> {
                            registro[0] = obj;
                            miTabla.addRow(registro);
                        }
                );
            }

            if (rbCedula.isSelected()) {
                M_Generales.select(
                        Generales
                                .builder()
                                .cedula(txtCriterio.getText().strip())
                                .build()
                ).stream().forEach(
                        general -> {
                            M_Persona.select(
                                    Paciente
                                            .builder()
                                            .idPersona(general.getIdPersona())
                                            .build()
                            ).stream().forEach(
                                    obj -> {
                                        registro[0] = obj;
                                        miTabla.addRow(registro);
                                    }
                            );
                        }
                );
            }
        }
    }

    private void mostrarPadres() {
        if (cbEntidades.getSelectedItem().toString().equalsIgnoreCase("Padres")) {

            if (rbNombresApellidos.isSelected()) {
                M_Persona.select(
                        Padre
                                .builder()
                                .pnombre(txtCriterio.getText().strip())
                                .snombre(txtCriterio.getText().strip())
                                .apellidos(txtCriterio.getText().strip())
                                .build()
                ).stream().forEach(
                        $persona -> {
                            registro[0] = $persona;
                            miTabla.addRow(registro);
                        }
                );
            }

            if (rbCedula.isSelected()) {
                M_Generales.select(
                        Generales
                                .builder()
                                .cedula(txtCriterio.getText().strip())
                                .build()
                ).stream().forEach(
                        general -> {
                            M_Persona.select(
                                    Padre
                                            .builder()
                                            .idPersona(general.getIdPersona())
                                            .build()
                            ).stream().forEach(
                                    obj -> {
                                        registro[0] = obj;
                                        miTabla.addRow(registro);
                                    }
                            );
                        }
                );
            }
        }
    }

    private void mostrarProveedores() {
        if (cbEntidades.getSelectedItem().toString().equalsIgnoreCase("Proveedores")) {
            if (rbNombresApellidos.isSelected()) {
                M_Persona.select(
                        Proveedor
                                .builder()
                                .pnombre(txtCriterio.getText().strip())
                                .snombre(txtCriterio.getText().strip())
                                .apellidos(txtCriterio.getText().strip())
                                .build()
                ).stream().forEach(
                        obj -> {
                            registro[0] = obj;
                            miTabla.addRow(registro);
                        }
                );
            }
            if (rbCedula.isSelected()) {
                M_Generales.select(
                        Generales
                                .builder()
                                .cedula(txtCriterio.getText().strip())
                                .build()
                ).stream().forEach(
                        general -> {
                            M_Persona.select(
                                    Proveedor
                                            .builder()
                                            .idPersona(general.getIdPersona())
                                            .build()
                            ).stream().forEach(
                                    obj -> {
                                        registro[0] = obj;
                                        miTabla.addRow(registro);
                                    }
                            );
                        }
                );
            }
        }
    }
}
