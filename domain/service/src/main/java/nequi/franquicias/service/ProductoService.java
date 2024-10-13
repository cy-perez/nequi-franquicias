package nequi.franquicias.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import nequi.franquicias.domain.common.ProductoGatewayRepository;
import nequi.franquicias.domain.common.model.Producto;

@Log
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoGatewayRepository productoRepository;

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }
}
