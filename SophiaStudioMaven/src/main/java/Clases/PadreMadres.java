package Clases;

public class PadreMadres {
    private Integer idUsuario;
    private Integer idPadreMadre;
    private String cedula;//Documento del Tutor de Estudiante
    private String nombres;//Nombre del Tutor
    private String apellidos;//Apellidos del Tutor
    private String Sexo;
    private String telefono;//Telefono del Tutor, Este Campo Completa al del Estudiante
    private String telefono2;//Telefono del Tutor, Este Campo Completa al del Estudiante
    private String direccion;//Direccion del Tutor
    private String estado;//Estado del Tutor y Estudiante igual
    private String correo;
    
    public PadreMadres(Integer idPadreMadre, String cedula, String nombres, 
            String apellidos, String Sexo, String telefono, String telefono2, 
            String direccion, String estado, String correo, Integer idUsuario) {
        this.idUsuario = idUsuario;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.Sexo = Sexo;
        this.telefono = telefono;
        this.telefono2 = telefono2;
        this.direccion = direccion;
        this.estado = estado;
        this.correo = correo;
        this.idPadreMadre = idPadreMadre;
    }

    public Integer getIdPadreMadre() {
        return idPadreMadre;
    }

    public void setIdPadreMadre(Integer idPadreMadre) {
        this.idPadreMadre = idPadreMadre;
    }
    
    public PadreMadres(String cedula, String nombres, String apellidos, 
            String Sexo, String telefono, String telefono2, String direccion, 
            String estado, String correo) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.Sexo = Sexo;
        this.telefono = telefono;
        this.telefono2 = telefono2;
        this.direccion = direccion;
        this.estado = estado;
        this.correo = correo;
    }
    
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTelefono2() {
        return telefono2;
    }
    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getSexo() {
        return Sexo;
    }
    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
    @Override
    public String toString() {
        return "PadreMadre{" + "cedula=" + cedula 
                + ", \nnombres=" + nombres 
                + ", \napellidos=" + apellidos 
                + ", \nSexo=" + Sexo 
                + ", \ntelefono=" + telefono 
                + ", \ntelefono2=" + telefono2 
                + ", \ndireccion=" + direccion 
                + ", \nestado=" + estado + '}';
    }
}
