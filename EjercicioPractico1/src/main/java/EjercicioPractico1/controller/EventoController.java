package EjercicioPractico1.controller;



import EjercicioPractico1.domain.Evento;
import EjercicioPractico1.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/listado")
    public String listarEventos(Model model) {
        var eventos = eventoService.getEventos(false);
        model.addAttribute("eventos", eventos);
        model.addAttribute("totalEventos", eventos.size());
        return "evento/listado"; // Asegúrate de que el archivo listado.html esté en templates/evento
    }

    @GetMapping("/formulario")
    public String formularioEvento() {
        return "evento/formulario"; // Asegúrate de que el archivo formulario.html esté en templates/evento
    }

    @GetMapping("/nuevo")
    public String nuevoEvento(Evento evento) {
        return "evento/modifica"; // Asegúrate de que el archivo modifica.html esté en templates/evento
    }

    @PostMapping("/guardar")
    public String guardarEvento(Evento evento, @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            // Implementa lógica de guardado de la imagen si es necesario
        }
        eventoService.save(evento);
        return "redirect:/evento/listado"; // Redirige a la lista de eventos
    }

    @GetMapping("/eliminar/{idEvento}")
    public String eliminarEvento(Evento evento) {
        eventoService.delete(evento);
        return "redirect:/evento/listado";
    }

    @GetMapping("/modificar/{idEvento}")
    public String modificarEvento(Evento evento, Model model) {
        evento = eventoService.getEvento(evento);
        model.addAttribute("evento", evento);
        return "evento/modifica"; // Usa el nombre de la vista correspondiente
    }
}
