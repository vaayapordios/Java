package org.example.bibliotecaAA.controller;

import org.example.bibliotecaAA.model.Cliente;
import org.example.bibliotecaAA.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String getAllClientes(Model model) {
        List<Cliente> clientes = clienteService.getAllClientes();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/new")
    public String createClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "create_cliente";
    }

    @PostMapping
    public String saveCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/edit/{id}")
    public String editClienteForm(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.getClienteById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("cliente", cliente);
        return "edit_cliente";
    }

    @PostMapping("/{id}")
    public String updateCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/delete/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return "redirect:/clientes";
    }
}
