package br.com.alura.mvc.mundi.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mundi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mundi.model.Pedido;
import br.com.alura.mvc.mundi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	private PedidoRepository pedidorepository;
	
	@GetMapping("/formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao,
						//o campo result, caso seja detectado erros no formulário,
						//vai ser mostrado aqui
						BindingResult result) {
		
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		Pedido pedido = requisicao.toPedido();
		pedidorepository.save(pedido);
		return "redirect:/home";
	}
}
