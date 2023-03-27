package co.edu.uniquindio.concesionarioCarros.model;

public class Camioneta extends Sedan {

    private Boolean es4x4;

    /**
     * Es el constructor de la Camioneta
     * 
     * @param placa
     * @param marca
     * @param modelo
     * @param cilindraje
     * @param velocidadMaxima
     * @param estado
     * @param tipo
     * @param tieneAireAcondicionado
     * @param tieneCamaraReversa
     * @param tieneABS
     * @param capacidadMaletero
     * @param tieneVelocidadCrucero
     * @param tieneSensorColision
     * @param tieneSensorTrafico
     * @param tieneAsistentePermanencia
     * @param es4x4
     */
    public Camioneta(String placa, String marca, String modelo, Double cilindraje, Double velocidadMaxima,
            EstadoVehiculo estado, TipoCambio tipo, Boolean tieneAireAcondicionado, Boolean tieneCamaraReversa,
            Boolean tieneABS, Double capacidadMaletero, Boolean tieneVelocidadCrucero, Boolean tieneSensorColision,
            Boolean tieneSensorTrafico, Boolean tieneAsistentePermanencia, Boolean es4x4) {
        super(placa, marca, modelo, cilindraje, velocidadMaxima, estado, tipo, tieneAireAcondicionado,
                tieneCamaraReversa,
                tieneABS, capacidadMaletero, tieneVelocidadCrucero, tieneSensorColision, tieneSensorTrafico,
                tieneAsistentePermanencia);
        this.es4x4 = es4x4;
    }

    /**
     * Obtiene si la camioneta es 4x4 o no
     * 
     * @return
     */
    public Boolean getEs4x4() {
        return es4x4;
    }

    /**
     * Obtiene si la camioneta es 4x4 o no
     * 
     * @param
     */
    public void setEs4x4(final Boolean es4x4) {
        this.es4x4 = es4x4;
    }

}
