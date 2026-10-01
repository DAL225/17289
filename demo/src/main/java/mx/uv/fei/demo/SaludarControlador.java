package mx.uv.fei.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class SaludarControlador {

    String nombre;

    @GetMapping("/saludos")
    public String saludar(){
        return "chiao mundo " + nombre;
    }

    @GetMapping("/despedidas")
    public String despedirse(){
        return "adiós mundo cruel";
    }

    @PostMapping("/nombramientos")
    public void nombre(){
        nombre = "DAL225";
    }

    @PutMapping("/nombramientos")
    public void poner(){
        nombre = "actualizar";
    }

    @DeleteMapping("/nombramientos")
    public void borrar(){
        nombre = null;
    }
}