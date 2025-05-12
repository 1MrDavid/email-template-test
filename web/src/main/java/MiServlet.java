import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

@WebServlet("/MiServlet")
public class MiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Obtener parámetros del formulario
        String tipo = request.getParameter("tipo");
        String codigo = request.getParameter("codigo");
        String contenido = request.getParameter("contenido");
        String accion = request.getParameter("accion");
        String asunto = request.getParameter("asunto");
        
        String[] lineas = contenido.split("\r?\n");
        int totalLineas = lineas.length;
        
        if (totalLineas == 0) {
        	System.out.println("Error: No hay mensaje!");
        	return;
        }
        
        // Calcular número de iteraciones (bloques de 10 líneas)
        int iteraciones = (totalLineas + 9) / 10;
        
        List<EmailMessage> emails = new ArrayList<>();
        boolean allSuccess = true;
        
        for (int i = 0; i < iteraciones; i++) {
            EmailMessage email = new EmailMessage(); // Nuevo objeto por cada bloque
            email.setTipo(tipo);
            email.setCodigo(codigo);
            email.setAsunto(asunto);
            
            mapLinesToEmailMessage(email, lineas, i * 10);
            email.printEmailMessage();
            emails.add(email);
            
            // Convertir a DTO y enviar al API
            EmailRequestDTO requestDTO = convertToDTO(email);
            if (!enviarAlAPI(requestDTO)) {
                allSuccess = false;
                break;
            }
        }
        
        if (allSuccess) {
            response.sendRedirect("form.jsp?status=success");
        } else {
            response.sendRedirect("form.jsp?status=error");
        }
    }
    
    public void mapLinesToEmailMessage(EmailMessage email, String[] lineas, int startIndex) {
        try {
            for (int i = 0; i < 10; i++) { // Siempre 10 campos
                int globalLineNumber = startIndex + i + 1; // Línea global (1-based)
                int arrayIndex = startIndex + i; // Índice del array (0-based)
                
                if (arrayIndex >= lineas.length) {
                    break; // Salir si no hay más líneas
                }
                
                // Asignar el número de línea
                Field lineaField = EmailMessage.class.getDeclaredField("linea" + (i + 1));
                lineaField.setAccessible(true);
                lineaField.setInt(email, globalLineNumber);
                
                // Asignar el mensaje
                Field mensajeField = EmailMessage.class.getDeclaredField("mensaje" + (i + 1));
                mensajeField.setAccessible(true);
                mensajeField.set(email, lineas[arrayIndex]); // Usar arrayIndex, no lineNumber
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static final String API_URL = "http://localhost:8092/api/plantillas/email";
    
    private boolean enviarAlAPI(EmailRequestDTO request) {
    	final Gson gson = new Gson();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(request)))
                .build();
        
        try {
            HttpResponse<String> response = client.send(
                httpRequest, HttpResponse.BodyHandlers.ofString());
            return response.statusCode() >= 200 && response.statusCode() < 300;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private EmailRequestDTO convertToDTO(EmailMessage email) {
        EmailRequestDTO dto = new EmailRequestDTO();
        dto.setTipo(email.getTipo());
        dto.setCodigo(email.getCodigo());
        dto.setLineas(new ArrayList<>());
        
        try {
            for (int i = 1; i <= 10; i++) {
                Field lineaField = EmailMessage.class.getDeclaredField("linea" + i);
                Field mensajeField = EmailMessage.class.getDeclaredField("mensaje" + i);
                lineaField.setAccessible(true);
                mensajeField.setAccessible(true);
                
                Integer numeroLinea = (Integer) lineaField.get(email);
                String contenido = (String) mensajeField.get(email);
                
                if (contenido != null) {
                    EmailRequestDTO.LineaMensaje lineaDTO = new EmailRequestDTO.LineaMensaje();
                    lineaDTO.setLinea(numeroLinea);
                    lineaDTO.setMensaje(contenido);
                    dto.getLineas().add(lineaDTO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dto;
    }
 }