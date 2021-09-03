package com.bolsadeideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.domain.Producto;
import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicioComplejo;

@Configuration
public class AppConfig {
	
	@Bean("miServicioPrincipal")
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}

	
	@Bean("miServicioComplejo")
	@Primary
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}
	
	//@Primary
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		Producto producto1 = new Producto("nombre del producto 1", 100);
		Producto producto2 = new Producto("nombre del producto 2", 300);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto1, 4);
		
		return Arrays.asList(linea1, linea2);
	}
	@Primary
	@Bean("itemsFactura2")
	public List<ItemFactura> registrarItems2(){
		Producto producto1 = new Producto("nombre del producto 3", 250);
		Producto producto2 = new Producto("nombre del producto 4", 650);
		Producto producto3 = new Producto("nombre del producto 5", 750);
		
		ItemFactura linea1 = new ItemFactura(producto1, 3);
		ItemFactura linea2 = new ItemFactura(producto2, 5);
		ItemFactura linea3 = new ItemFactura(producto3, 5);
		
		return Arrays.asList(linea1, linea2, linea3);
	}
	
}
