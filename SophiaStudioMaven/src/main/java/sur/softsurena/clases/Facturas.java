package sur.softsurena.clases;
import java.util.Date;
public class Facturas {
    private int codigoFactura;//Codigo de la Factura
    private String matricula;//Matricula del Estudiante
    private String nombreEstudiante;//Nombre del Estudiante
    private String formaDePago;/*Forma de Pago Efectivo, 
                                Cheque, Tarjeta de Credicto o Debito*/
    private String concepto;// Mensualidad por el Mes X
    private double monto;//Monto de la Mensualidad
    private double abono;//Si Abona
    private double deuda;//Si Adeuda
    private Date fechaPago;//Fecha de Pago
    private String estado;

    public Facturas(int codigoFactura, String matricula, 
            String nombreEstudiante, String formaDePago, String concepto, 
            double monto, double abono, double deuda, Date fechaPago, 
            String estado) {
        this.codigoFactura = codigoFactura;
        this.matricula = matricula;
        this.nombreEstudiante = nombreEstudiante;
        this.formaDePago = formaDePago;
        this.concepto = concepto;
        this.monto = monto;
        this.abono = abono;
        this.deuda = deuda;
        this.fechaPago = fechaPago;
        this.estado = estado;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getBono() {
        return abono;
    }

    public void setBono(double abono) {
        this.abono = abono;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
