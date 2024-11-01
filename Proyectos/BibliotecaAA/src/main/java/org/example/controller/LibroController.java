package org.example.bibliotecaAA.controller;

import org.example.bibliotecaAA.model.Libro;
import org.example.bibliotecaAA.service.ClienteService;
import org.example.bibliotecaAA.service.LibroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/libros")
public class LibroController {
    private final LibroService libroService;
    private final ClienteService clienteService;

    public LibroController(LibroService libroService, ClienteService clienteService) {
        this.libroService = libroService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public String getAllLibros(Model model) {
        List<Libro> libros = libroService.getAllLibros();
        model.addAttribute("libros", libros);
        return "libros";
    }

    @GetMapping("/new")
    public String createLibroForm(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("clientes", clienteService.getAllClientes());
        return "create_libro";
    }

    @PostMapping
    public String saveLibro(@ModelAttribute("libro") Libro libro) {
        libroService.saveLibro(libro);
        return "redirect:/libros";
    }

    @GetMapping("/edit/{id}")
    public String editLibroForm(@PathVariable Long id, Model model) {
        Libro libro = libroService.getLibroById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("libro", libro);
        model.addAttribute("clientes", clienteService.getAllClientes());
        return "edit_libro";
    }

    @PostMapping("/{id}")
    public String updateLibro(@PathVariable Long id, @ModelAttribute("libro") Libro libro) {
        libroService.saveLibro(libro);
        return "redirect:/libros";
    }

    @GetMapping("/delete/{id}")
    public String deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
        return "redirect:/libros";
    }
}
