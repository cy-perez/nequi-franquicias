package nequi.franquicias.domain.common;

import nequi.franquicias.domain.common.model.Producto;

import java.util.List;

public interface ProductoGatewayRepository {

    Producto save(Producto producto);

    Producto findById(int id);

    void deleteById(int id);

    List<Producto> findProductGreatStock(List<Integer> idsSucursales);
}
