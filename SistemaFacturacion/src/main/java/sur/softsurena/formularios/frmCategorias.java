package sur.softsurena.formularios;

import java.awt.Image;
import java.io.File;
import java.util.Objects;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sur.softsurena.entidades.Categoria;
import sur.softsurena.metodos.M_Categoria;
import sur.softsurena.metodos.M_Producto;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;

/**
 * Clase que nos permite mostrar las categorias del sistema.
 *
 * @author jhironsel
 */
public class frmCategorias extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    private Integer idCategoria;
    private boolean nuevo = false, estado;
    private int respuestaFileChooser = JFileChooser.CANCEL_OPTION;
    private String nombreCategoria;
    private File imagenCategoria;
    private static frmPrincipal principal;
    private static boolean modal;

    public static frmCategorias getInstance(frmPrincipal parent, boolean modal) {
        principal = parent;
        frmCategorias.modal = modal;
        return NewSingletonHolder.INSTANCE;
    }
    
    private static class NewSingletonHolder {
        private static final frmCategorias INSTANCE = new frmCategorias (
                principal, modal
        );
    }
    
    private frmCategorias(frmPrincipal parent, boolean modal) {
        super(parent, modal);
        initComponents();
        actualizarCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlImagen = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonGradientIcon_new();
        btnModificar = new newscomponents.RSButtonGradientIcon_new();
        btnBorrar = new newscomponents.RSButtonGradientIcon_new();
        jLabel1 = new javax.swing.JLabel();
        jlfecha = new RSMaterialComponent.RSLabelTextIcon();
        btnCancelar = new newscomponents.RSButtonGradientIcon_new();
        jlEstado = new RSMaterialComponent.RSLabelTextIcon();
        cbCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(339, 218));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jlImagen.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jlImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sur/softsurena/imagenes/NoImageTransp 96 x 96.png"))); // NOI18N
        jlImagen.setToolTipText("");
        jlImagen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Imagen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jlImagen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlImagen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setMaximumSize(new java.awt.Dimension(504, 102));
        jPanel2.setMinimumSize(new java.awt.Dimension(504, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(504, 102));
        jPanel2.setLayout(new java.awt.GridLayout(1, 3, 10, 3));

        btnNuevo.setText("Nuevo");
        btnNuevo.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo);

        btnModificar.setText("Editar");
        btnModificar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar);

        btnBorrar.setText("Borrar");
        btnBorrar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre de la Categoria");

        jlfecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlfecha.setText("Fecha de creacción: -");
        jlfecha.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DATE_RANGE);

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.setColorPrimario(new java.awt.Color(255, 0, 0));
        btnCancelar.setColorPrimarioHover(new java.awt.Color(255, 102, 102));
        btnCancelar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jlEstado.setForeground(new java.awt.Color(255, 0, 0));
        jlEstado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlEstado.setText("Inactivo");
        jlEstado.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);

        cbCategoria.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbCategoriaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cbCategoriaPopupMenuWillBecomeInvisible(null);
    }//GEN-LAST:event_formWindowOpened

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (cbCategoria.getItemCount() == 0) {
            return;
        }

        String categoria = ((Categoria) cbCategoria.getSelectedItem()).getDescripcion();

        int rta = JOptionPane.showConfirmDialog(
                this,
                "Está seguro de eliminar la Categoria { " + (categoria) + " } del Sistema?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (rta == JOptionPane.NO_OPTION) {
            return;
        }

        /*
            Verificamos que la categoria no cuente con productos asociados.
         */
        idCategoria = ((Categoria) cbCategoria.getSelectedItem()).getId_categoria();

        if (M_Producto.existeCategoriaProductos(idCategoria)) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se permite eliminar categoria porque existe producto Asociados.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        Resultado resultados = M_Categoria.delete(idCategoria);

        JOptionPane.showMessageDialog(
                this,
                resultados,
                "",
                resultados.getIcono()
        );

        if (cbCategoria.getItemCount() > 0) {
            cbCategoria.setSelectedIndex(0);
        }

        actualizarCombo();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (cbCategoria.getItemCount() == 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe de crear una categoria!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        nuevo = false;

        Categoria categoria = (Categoria) cbCategoria.getSelectedItem();

        idCategoria = categoria.getId_categoria();

        nombreCategoria = categoria.getDescripcion();

        estado = categoria.getEstado();

        frmCategoriasAdmin miCategoria = frmCategoriasAdmin.getInstance(
                principal, nombreCategoria, estado, false
        );

        miCategoria.setLocationRelativeTo(null);
        miCategoria.setVisible(true);

        if (miCategoria.getAceptar()) {
            if (!nombreCategoria.equals(miCategoria.txtCategoria.getText())) {
                if (M_Categoria.exist(
                        miCategoria.txtCategoria.getText()
                )) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Este nombre de Categoria Existe",
                            "",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
            }
            nombreCategoria = miCategoria.txtCategoria.getText().toUpperCase();
            if (buscarImagen()) {
                guardar();
            } else {
                int resp = JOptionPane.showConfirmDialog(
                        this,
                        "Desea solo guardar el nombre?",
                        "",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (resp == JOptionPane.YES_OPTION) {
                    guardar();
                }
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //Activamos el Flag de registro Nuevo
        nuevo = true;

        jlImagen.setIcon(
                new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/sur/softsurena/imagenes/NoImageTransp 96 x 96.png"
                        )
                )
        );

        frmCategoriasAdmin miCategoria = frmCategoriasAdmin.getInstance(
                principal, "", false, true
        );
        miCategoria.setVisible(true);
        miCategoria.setLocationRelativeTo(null);

        //Pedimos el nombre de la categoria a crear.
        nombreCategoria = miCategoria.txtCategoria.getText();
        estado = miCategoria.jcbEstado.isSelected();

        if (Objects.isNull(nombreCategoria) || nombreCategoria.isBlank()) {
            return;
        }

        //Consultamos la base de datos para saber si ese nombre de categoria existe.
        if (M_Categoria.exist(nombreCategoria.toUpperCase())) {
            JOptionPane.showMessageDialog(
                    this,
                    "Este nombre de Categoria ya existe en el sistema.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        //Avisamos al usuario que le toca elegir la imagen de la categoria.
        JOptionPane.showMessageDialog(
                this,
                "Siguiente paso es para elejir una imagen para la Categoria " + nombreCategoria.toUpperCase(),
                "",
                JOptionPane.INFORMATION_MESSAGE
        );

        if (buscarImagen()) {
            guardar();
        } else {
            jlImagen.setIcon(
                    new javax.swing.ImageIcon(
                            getClass().getResource(
                                    "/sur/softsurena/imagenes/NoImageTransp 96 x 96.png"
                            )
                    )
            );
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbCategoriaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbCategoriaPopupMenuWillBecomeInvisible
        String fechaCreacion;
        try {
            fechaCreacion = ((Categoria) cbCategoria.getSelectedItem()).getFecha_creacion().toString();
        } catch (java.lang.NullPointerException e) {
            fechaCreacion = "01.01.2000";
        }

        jlImagen.setIcon(
                Utilidades.imagenDecode64(
                        ((Categoria) cbCategoria.getSelectedItem()).getImage_texto(),
                        96,
                        96
                )
        );

        if (((Categoria) cbCategoria.getSelectedItem()).getEstado()) {
            jlEstado.setForeground(new java.awt.Color(37, 45, 223));
            jlEstado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            jlEstado.setText("Activo");
            jlEstado.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK_BOX);
        } else {
            jlEstado.setForeground(new java.awt.Color(255, 0, 0));
            jlEstado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            jlEstado.setText("Inactivo");
            jlEstado.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK_BOX_OUTLINE_BLANK);
        }

        jlfecha.setText("Fecha de creacción: " + fechaCreacion);
    }//GEN-LAST:event_cbCategoriaPopupMenuWillBecomeInvisible

    /**
     *
     */
    private void guardar() {
        Resultado resultado;
        Categoria categoria = Categoria
                .builder()
                .id_categoria(nuevo ? -1 : idCategoria)
                .descripcion(nombreCategoria.strip())
                .estado(estado)
                .build();
        if (nuevo) {
            resultado = M_Categoria.insert(categoria);
        } else {
            resultado = M_Categoria.update(categoria);
        }

        JOptionPane.showMessageDialog(
                this,
                resultado,
                "",
                resultado.getIcono()
        );

        if (!resultado.getEstado()) {
            return;
        }

        if (respuestaFileChooser == JFileChooser.APPROVE_OPTION) {

            Utilidades.copyFileUsingFileChannels(
                    imagenCategoria,
                    new File("imagenCategoria/".concat(imagenCategoria.getName()))
            );

            ImageIcon imagen = new ImageIcon(imagenCategoria.getPath());

            Icon icon = new ImageIcon(
                    imagen.getImage().getScaledInstance(
                            72,
                            72,
                            Image.SCALE_DEFAULT
                    )
            );
            imagen.getImage().flush();
            jlImagen.setIcon(icon);
            jlImagen.validate();
        }

        respuestaFileChooser = JFileChooser.CANCEL_OPTION;

        actualizarCombo();
    }

    private void actualizarCombo() {

        cbCategoria.removeAllItems();

        cbCategoria.addItem(
                Categoria
                        .builder()
                        .id_categoria(-1)
                        .descripcion("Seleccione una categoria")
                        .image_texto("")
                        .fecha_creacion(null)
                        .estado(false)
                        .build()
        );

        M_Categoria.select(
                Categoria
                        .builder()
                        .build()
        ).stream().forEach(
                categoria -> {
                    cbCategoria.addItem(
                            Categoria
                                    .builder()
                                    .id_categoria(categoria.getId_categoria())
                                    .descripcion(categoria.getDescripcion())
                                    .image_texto(categoria.getImage_texto())
                                    .fecha_creacion(categoria.getFecha_creacion())
                                    .estado(categoria.getEstado())
                                    .build()
                    );
                }
        );

        if (cbCategoria.getItemCount() > 0) {
            cbCategoria.setSelectedIndex(0);
        }
    }

    private boolean buscarImagen() {
        //Creamos un JFileChooser para buscar una imagen en el sistema.
        JFileChooser jfileChooser = new JFileChooser();

        //Preparamos el tipo de extension que se van a filtrar en el JFileChooser.
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Imagenes", "jpg", "png", "PNG", "JPG"
        );

        //Colocamos el filtro a jFileChooser.
        jfileChooser.setFileFilter(filter);

        //Abrimos la ventana para conocer la opcion elegida por el usuario.
        respuestaFileChooser = jfileChooser.showOpenDialog(this);

        //Si el usuario cancelo' devolvemos false.
        if (respuestaFileChooser == JFileChooser.CANCEL_OPTION) {
            return false;
        }

        imagenCategoria = jfileChooser.getSelectedFile();

        ImageIcon imagen = new ImageIcon(imagenCategoria.getPath());

        //Tamaño de icono
        Icon icon = new ImageIcon(
                imagen.getImage().getScaledInstance(
                        72,
                        72,
                        Image.SCALE_DEFAULT
                )
        );

        imagen.getImage().flush();

        jlImagen.setIcon(icon);
        jlImagen.validate();

        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonGradientIcon_new btnBorrar;
    private newscomponents.RSButtonGradientIcon_new btnCancelar;
    private newscomponents.RSButtonGradientIcon_new btnModificar;
    private newscomponents.RSButtonGradientIcon_new btnNuevo;
    private javax.swing.JComboBox<Categoria> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private RSMaterialComponent.RSLabelTextIcon jlEstado;
    private javax.swing.JLabel jlImagen;
    private RSMaterialComponent.RSLabelTextIcon jlfecha;
    // End of variables declaration//GEN-END:variables
}
