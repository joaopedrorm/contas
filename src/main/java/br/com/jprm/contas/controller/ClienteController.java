package br.com.jprm.contas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.jprm.contas.model.Cliente;
import br.com.jprm.contas.service.ClienteService;

@Controller
public class ClienteController {

	private ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping("/clientes")
	public String getClientes(Cliente cliente, Model model){
		model.addAttribute("listaClientes", clienteService.getClientes());
		model.addAttribute("formCliente", cliente);
		return "clientes";
	}
	
	@PostMapping("/cliente")
	public String saveClientes(@Valid Cliente cliente, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors()){
			redirectAttributes.addFlashAttribute("errorMessage", "Erro ao tentar salvar cliente");
		} else {
			clienteService.saveCliente(cliente);
		}
		return "redirect:/clientes";
	}
	
	
	@GetMapping("/genMock")
	public String getClientes(RedirectAttributes redirectAttributes){
		
		clienteService.generateMockData();
		
		return "redirect:/clientes";
	}
}
