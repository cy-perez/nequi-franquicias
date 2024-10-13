package nequi.franquicias.domain.common;

import nequi.franquicias.domain.common.model.Producto;

public interface ProductoGatewayRepository {

    Producto save(Producto producto);

    Producto findById(int id);

    void deleteById(int id);
}
