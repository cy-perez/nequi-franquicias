package nequi.franquicias.domain.common;

import nequi.franquicias.domain.common.model.Sucursal;

import java.util.List;

public interface SucursalGatewayRepository {

    Sucursal save(Sucursal sucursal);

    Sucursal findById(int id);

    List<Sucursal> finByIdFranchise(int id);
}
