package nequi.franquicias.domain.common;

import nequi.franquicias.domain.common.model.Sucursal;

public interface SucursalGatewayRepository {

    Sucursal save(Sucursal sucursal);
}
