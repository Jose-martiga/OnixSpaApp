package com.onixspa.onixspaweb.controller;


import com.onixspa.onixspaweb.model.Reserva;
import com.onixspa.onixspaweb.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepo;

    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reserva"; // archivo HTML
    }

    @PostMapping("/guardar")
    public String guardarReserva(
            @RequestParam String nombreCliente,
            @RequestParam String servicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime hora
    ) {
        Reserva r = new Reserva(null, nombreCliente, servicio, fecha, hora);
        reservaRepo.save(r);
        return "redirect:/reservas/lista";
    }

    @GetMapping("/lista")
    public String listarReservas(Model model) {
        List<Reserva> reservas = reservaRepo.findAll();
        model.addAttribute("reservas", reservas);
        return "lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Long id) {
        reservaRepo.deleteById(id);
        return "redirect:/reservas/lista";
    }
}
