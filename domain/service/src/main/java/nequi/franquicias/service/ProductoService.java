package nequi.franquicias.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import nequi.franquicias.domain.common.ProductoGatewayRepository;
import nequi.franquicias.domain.common.model.Producto;

import java.util.List;

@Log
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoGatewayRepository productoRepository;

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto findById(int id){
        return productoRepository.findById(id);
    }

    public Producto deleteById(int id){

        var producto = productoRepository.findById(id);
        if(producto == null) return null;

        productoRepository.deleteById(id);
        return producto;
    }

    public List<Producto> findProductsGreatStock(List<Integer> idsSucursales){
        return productoRepository.findProductGreatStock(idsSucursales);
    }
}
