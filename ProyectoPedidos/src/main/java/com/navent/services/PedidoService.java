package com.navent.services;

import com.navent.dto.AltaPedidoDto;


//import org.springframework.web.bind.annotation.RestController;
public interface PedidoService {
	
	void altaPedido(AltaPedidoDto altaPedido);
	
	void recuperarPedido(int idPedido);
	
    void borrarPedido(int idPedido);
	
	void modificarPedido(AltaPedidoDto pedido);

}
