package com.navent.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.navent.dto.AltaPedidoDto;
import com.navent.services.PedidoService;

@RestController
@RequestMapping("pedidos")
public class PedidosRest {

//import org.springframework.web.bind.annotation.RestController;

		@Autowired
		private PedidoService pedidoService;

		@RequestMapping(path = "/guardar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE) 
		public void altaPedido(@RequestBody AltaPedidoDto altaPedidoDto) { 
			pedidoService.altaPedido(altaPedidoDto);
		}
		
		@RequestMapping(path = "/recuperar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
		public void recuperarPedido(@RequestBody int idPedido) { 
			pedidoService.recuperarPedido(idPedido);
		}
		
		@RequestMapping(path = "/borrar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
		public void borrarPedido(@RequestBody int idPedido) { 
			pedidoService.borrarPedido(idPedido);
		}
		
		@RequestMapping(path = "/actualizarr", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE) 
		public void modificarPedido(@RequestBody AltaPedidoDto pedidoDto) { 
			pedidoService.modificarPedido(pedidoDto);
		}

}
