package mx.uv.fei.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

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
    @GetMapping("/saludador/{nombre}")
    public Saludador nuevoSaludo(@PathVariable String nombre){
        saludador = new Saludador(nombre);
        return saludador;
    }

    @RequestMapping("/saludador2/{nombreX}")
    public Saludador nuevoSaludo1(@PathVariable("nombreX") String nombre){
        saludador = new Saludador(nombre);
        return saludador;
    }

    @RequestMapping("/")
    public String indice(){
        return """
            <h1>menú principal</h1>
            <ul>
                <li><a href='/saludos'>saludos</a></li>
                <li><a href='/despedidas'>despedidas</a></li>
                <li>/nombramientos (Post - Put - Delete)</li>
                <li><a href='/saludador/default'>/saludador/{nombre}</a></li>
                <li><a href='/saludador2/default2'>/saludador2/{nombreX}</a></li>
                <li>/crearSaludador (Post)</li>
                <li><a href='/obtenerSaludador'>obtenerSaludador</a></li>
            </ul>    
                """;
    }

    Saludador saludador;

    @PostMapping("/crearSaludador")
    public void crearSaludador(@RequestBody Saludador nombre){
        saludador = nombre;
    }

    @GetMapping("/obtenerSaludador")
    public Saludador obtenerSaludador(){
        return saludador;
    }

    @GetMapping("/getQuery")
    public String GetQueryString(@RequestParam String nombre, @RequestParam String apellidoP){
        return nombre + " " + apellidoP;
    }

    @GetMapping("/getQuery2")
    public String GetQueryString2(@RequestParam String nombre, @RequestParam (defaultValue = "") String apellidoP){
        return nombre + " " + apellidoP;
    }

}