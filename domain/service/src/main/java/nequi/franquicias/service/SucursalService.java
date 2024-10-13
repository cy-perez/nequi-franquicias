package nequi.franquicias.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import nequi.franquicias.domain.common.SucursalGatewayRepository;
import nequi.franquicias.domain.common.model.Sucursal;

@Log
@RequiredArgsConstructor
public class SucursalService {

    private final SucursalGatewayRepository sucursalRepository;

    public Sucursal save(Sucursal sucursal){
        return sucursalRepository.save(sucursal);
    }
}
