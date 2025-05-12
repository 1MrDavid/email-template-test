package com.mrd.test_pai_rest.controller;

import com.mrd.test_pai_rest.model.EmailMessage;
import com.mrd.test_pai_rest.model.Plantilla;
import com.mrd.test_pai_rest.repository.PlantillaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/plantillas")  // Ruta base del API
public class PlantillaController {

    @Autowired
    private PlantillaRepository plantillaRepository;

    // Endpoint para insertar datos
    @PostMapping("/email")
    @Transactional  // Añade esta anotación
    public ResponseEntity<List<Plantilla>> guardarMensajesEmail(@RequestBody EmailMessage emailMessage) {
        List<Plantilla> plantillasGuardadas = new ArrayList<>();

        System.out.println("Número de líneas recibidas: " + emailMessage.getLineas().size());
        emailMessage.getLineas().forEach(linea ->
                System.out.println("Línea " + linea.getLinea() + ": " + linea.getMensaje()));

        for (EmailMessage.LineaMensaje lineaMensaje : emailMessage.getLineas()) {
            Plantilla plantilla = new Plantilla();
            plantilla.setTipo(emailMessage.getTipo());
            plantilla.setCodigo(emailMessage.getCodigo());
            plantilla.setLinea(lineaMensaje.getLinea());
            plantilla.setDescripcion(lineaMensaje.getMensaje());

            plantillasGuardadas.add(plantillaRepository.save(plantilla));
        }

        return ResponseEntity.ok(plantillasGuardadas);
    }
}