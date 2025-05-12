import java.lang.reflect.Field;

public class EmailMessage {
	
    private String tipo;
    private String codigo;
    private String asunto;
    private int linea1;
    private String mensaje1;
    private int linea2;
    private String mensaje2;
    private int linea3;
    private String mensaje3;
    private int linea4;
    private String mensaje4;
    private int linea5;
    private String mensaje5;
    private int linea6;
    private String mensaje6;
    private int linea7;
    private String mensaje7;
    private int linea8;
    private String mensaje8;
    private int linea9;
    private String mensaje9;
    private int linea10;
    private String mensaje10;

    // Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public int getLinea1() {
        return linea1;
    }

    public void setLinea1(int linea1) {
        this.linea1 = linea1;
    }

    public String getMensaje1() {
        return mensaje1;
    }

    public void setMensaje1(String mensaje1) {
        this.mensaje1 = mensaje1;
    }

    public int getLinea2() {
        return linea2;
    }

    public void setLinea2(int linea2) {
        this.linea2 = linea2;
    }

    public String getMensaje2() {
        return mensaje2;
    }

    public void setMensaje2(String mensaje2) {
        this.mensaje2 = mensaje2;
    }

    public int getLinea3() {
        return linea3;
    }

    public void setLinea3(int linea3) {
        this.linea3 = linea3;
    }

    public String getMensaje3() {
        return mensaje3;
    }

    public void setMensaje3(String mensaje3) {
        this.mensaje3 = mensaje3;
    }

    public int getLinea4() {
        return linea4;
    }

    public void setLinea4(int linea4) {
        this.linea4 = linea4;
    }

    public String getMensaje4() {
        return mensaje4;
    }

    public void setMensaje4(String mensaje4) {
        this.mensaje4 = mensaje4;
    }

    public int getLinea5() {
        return linea5;
    }

    public void setLinea5(int linea5) {
        this.linea5 = linea5;
    }

    public String getMensaje5() {
        return mensaje5;
    }

    public void setMensaje5(String mensaje5) {
        this.mensaje5 = mensaje5;
    }

    public int getLinea6() {
        return linea6;
    }

    public void setLinea6(int linea6) {
        this.linea6 = linea6;
    }

    public String getMensaje6() {
        return mensaje6;
    }

    public void setMensaje6(String mensaje6) {
        this.mensaje6 = mensaje6;
    }

    public int getLinea7() {
        return linea7;
    }

    public void setLinea7(int linea7) {
        this.linea7 = linea7;
    }

    public String getMensaje7() {
        return mensaje7;
    }

    public void setMensaje7(String mensaje7) {
        this.mensaje7 = mensaje7;
    }

    public int getLinea8() {
        return linea8;
    }

    public void setLinea8(int linea8) {
        this.linea8 = linea8;
    }

    public String getMensaje8() {
        return mensaje8;
    }

    public void setMensaje8(String mensaje8) {
        this.mensaje8 = mensaje8;
    }

    public int getLinea9() {
        return linea9;
    }

    public void setLinea9(int linea9) {
        this.linea9 = linea9;
    }

    public String getMensaje9() {
        return mensaje9;
    }

    public void setMensaje9(String mensaje9) {
        this.mensaje9 = mensaje9;
    }

    public int getLinea10() {
        return linea10;
    }

    public void setLinea10(int linea10) {
        this.linea10 = linea10;
    }

    public String getMensaje10() {
        return mensaje10;
    }

    public void setMensaje10(String mensaje10) {
        this.mensaje10 = mensaje10;
    }
    
    public void printEmailMessage() {
        System.out.println("=== Email Message ===");
        System.out.println("Tipo: " + tipo);
        System.out.println("Código: " + codigo);
        System.out.println("Asunto: " + asunto);
        
        for (int i = 1; i <= 10; i++) {
            try {
                Field lineaField = this.getClass().getDeclaredField("linea" + i);
                Field mensajeField = this.getClass().getDeclaredField("mensaje" + i);
                lineaField.setAccessible(true);
                mensajeField.setAccessible(true);
                
                int linea = (int) lineaField.get(this);
                String mensaje = (String) mensajeField.get(this);
                
                if (mensaje != null && !mensaje.isEmpty()) {
                    System.out.printf("Línea %d: %s%n", linea, mensaje);
                }
            } catch (Exception e) {
                // Ignorar campos no accesibles
            }
        }
    }
}