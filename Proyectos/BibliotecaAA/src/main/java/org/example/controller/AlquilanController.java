package org.example.bibliotecaAA.controller;

import org.example.bibliotecaAA.model.Alquilan;
import org.example.bibliotecaAA.service.AlquilanService;
import org.example.bibliotecaAA.service.ClienteService;
import org.example.bibliotecaAA.service.LibroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alquilan")
public class AlquilanController {
    private final AlquilanService alquilanService;
    private final ClienteService clienteService;
    private final LibroService libroService;

    public AlquilanController(AlquilanService alquilanService, ClienteService clienteService, LibroService libroService) {
        this.alquilanService = alquilanService;
        this.clienteService = clienteService;
        this.libroService = libroService;
    }

    @GetMapping
    public String getAllAlquilan(Model model) {
        List<Alquilan> alquilan = alquilanService.getAllAlquilan();
        model.addAttribute("alquilan", alquilan);
        return "alquilan";
    }

    @GetMapping("/new")
    public String createAlquilanForm(Model model) {
        model.addAttribute("alquilan", new Alquilan());
        model.addAttribute("clientes", clienteService.getAllClientes());
        model.addAttribute("libros", libroService.getAllLibros());
        return "create_alquilan";
    }

    @PostMapping
    public String saveAlquilan(@ModelAttribute("alquilan") Alquilan alquilan) {
        alquilanService.saveAlquilan(alquilan);
        return "redirect:/alquilan";
    }

    @GetMapping("/edit/{id}")
    public String editAlquilanForm(@PathVariable Long id, Model model) {
        Alquilan alquilan = alquilanService.getAlquilanById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid rental Id:" + id));
        model.addAttribute("alquilan", alquilan);
        model.addAttribute("clientes", clienteService.getAllClientes());
        model.addAttribute("libros", libroService.getAllLibros());
        return "edit_alquilan";
    }

    @PostMapping("/{id}")
    public String updateAlquilan(@PathVariable Long id, @ModelAttribute("alquilan") Alquilan alquilan) {
        alquilanService.saveAlquilan(alquilan);
        return "redirect:/alquilan";
    }

    @GetMapping("/delete/{id}")
    public String deleteAlquilan(@PathVariable Long id) {
        alquilanService.deleteAlquilan(id);
        return "redirect:/alquilan";
    }
}
