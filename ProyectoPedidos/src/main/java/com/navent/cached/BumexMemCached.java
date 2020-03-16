package com.navent.cached;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class BumexMemCached {

	//Otra manera de inicializar es con una cadena que tenga los servidores separados por espacios
	private MemcachedClient mc;
	
	  // Connecting to Memcached server on localhost
	
	private MemcachedClient inicializar() throws IOException{
		this.mc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		return mc; 
	}
    
	public BumexMemCached(){
		try {
			inicializar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	public void set(Integer key, Object value){
		String clave = Integer.toString(key);
		mc.set(clave,3600, value );
	}
	public Object get(Integer key){
		String clave = Integer.toString(key);
		return mc.get(clave);
	}
	public void delete(Integer key){
		String clave = Integer.toString(key);
		mc.delete(clave);
	}
	
	public void actualizar(Integer key, Object value){
		String clave = Integer.toString(key);
		mc.replace(clave, 3600, value);
	}

}
