package es.ifp.waiterapp;

public class Restaurante {

    // Variables
    protected int idRestaurante;
    protected String nombre;
    protected String direccion;
    protected int codigoPostal;
    protected String razonSocial;
    protected String email;
    protected String sitioWeb;
    protected String contactoNombre;
    protected int telefono;
    protected String codigoRestaurante;


    // Constructor
    public Restaurante(){
        this.idRestaurante = 0;
        this.nombre = "";
        this.direccion = "";
        this.codigoPostal = 0;
        this.razonSocial = "";
        this.email = "";
        this.sitioWeb = "";
        this.contactoNombre = "";
        this.telefono = 0;
        this.codigoRestaurante = "";
    }

    // GETTERS & SETTERS
    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getContactoNombre() {
        return contactoNombre;
    }

    public void setContactoNombre(String contactoNombre) {
        this.contactoNombre = contactoNombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCodigoRestaurante() {
        return codigoRestaurante;
    }

    public void setCodigoRestaurante(String codigoRestaurante) {
        this.codigoRestaurante = codigoRestaurante;
    }


}
