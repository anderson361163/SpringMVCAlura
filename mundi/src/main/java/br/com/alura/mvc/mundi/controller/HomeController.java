package br.com.alura.mvc.mundi.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mundi.model.Pedido;
import br.com.alura.mvc.mundi.model.StatusPedido;
import br.com.alura.mvc.mundi.repository.PedidoRepository;


@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping
	public String home(Model model) {
//		Pedido pedido = new Pedido();
//		pedido.setNomeProduto("Xaiomi Redmi 9");
//		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/51oT5k%2BXRrS._AC_SL1000_.jpg");
//		pedido.setUrlProduto("https://www.amazon.com.br/Celular-Xiaomi-Redmi-64GB-Dual/dp/B08B3QSVM6/ref=sr_1_5?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=GVI0TW0CH8P6&dchild=1&keywords=redmi+9&qid=1627002759&sprefix=redmi+%2Caps%2C276&sr=8-5&ufe=app_do%3Aamzn1.fos.25548f35-0de7-44b3-b28e-0f56f3f96147");
//		pedido.setDescricao("Uma descrição qualquer para esse pedido");
//		pedido.setValorNegociado(new BigDecimal(299.90));
//		List<Pedido> pedidos = Arrays.asList(pedido);
		
		//List<Pedido> pedidos = repository.recuperaTodosOsPedidos();
		List<Pedido> pedidos = repository.findAll();
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
	
	@GetMapping("{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {

		List<Pedido> pedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "home";
	}
	
	//Quando der o Exception no porstatus ele vai redirecionar para a tela home
	@ExceptionHandler(IllegalArgumentException.class)
	public String onErro() {
		return "redirect:/home";
	}
	
}
