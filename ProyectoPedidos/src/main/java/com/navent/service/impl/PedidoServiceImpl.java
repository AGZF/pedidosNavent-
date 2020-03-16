package com.navent.service.impl;

import com.navent.cached.BumexMemCached;
import com.navent.dao.PedidoDao;
import com.navent.dto.AltaPedidoDto;
import com.navent.model.entity.Pedido;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PedidoServiceImpl {
	
	@Autowired
	private PedidoDao pedidoDao;
	
	private BumexMemCached memCached = new BumexMemCached();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PedidoServiceImpl.class);
	public static final String ERROR_AL_PROCESAR_LA_SOLICITUD = "Ocurrio un error al procesar la solitud";
	
	public void altaPedido(AltaPedidoDto altaPedido){
		try{
			pedidoDao.save(mapAltaPedidoDtoAPedido(altaPedido));
			
		} catch (Exception e ) {
			LOGGER.error(ERROR_AL_PROCESAR_LA_SOLICITUD, e);
		}
	}
	
	public Pedido recuperarPedido(Integer idPedido){
		Pedido ped = (Pedido) memCached.get(idPedido);
		if(ped != null){
			Pedido pedido = pedidoDao.findById(idPedido).get();
			memCached.set(pedido.getId() , pedido );
			return pedido;
		}
		return ped;
				
	}
	
    public void borrarPedido(int idPedido){
    	//encontrar elemento a eliminar , borrarlo de cache y de base
    	Pedido pedido = pedidoDao.findById(idPedido).get();
    	if( pedido != null){
    		memCached.delete(pedido.getId());
    		pedidoDao.delete(pedido);
    	}
    	
    }
	
	public void modificarPedido(AltaPedidoDto pedido){
		//actualizar en base , cache
		Pedido pedidoA = pedidoDao.findById(pedido.getId()).get();
		if( pedido != null){
			pedidoDao.save(pedidoA);
    		memCached.actualizar(pedido.getId(), pedido);
    		
    	}
	}
	
	private Pedido mapAltaPedidoDtoAPedido(AltaPedidoDto altaPedidoDto){
		Pedido pedido = new Pedido();

		pedido.setNombre(altaPedidoDto.getNombre());
		pedido.setMonto(altaPedidoDto.getMonto());
		pedido.setDescuento(altaPedidoDto.getDescuento());

		return pedido;
	}
}
