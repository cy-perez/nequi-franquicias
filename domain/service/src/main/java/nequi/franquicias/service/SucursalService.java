package nequi.franquicias.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import nequi.franquicias.domain.common.SucursalGatewayRepository;
import nequi.franquicias.domain.common.model.Sucursal;

import java.util.List;

@Log
@RequiredArgsConstructor
public class SucursalService {

    private final SucursalGatewayRepository sucursalRepository;

    public Sucursal save(Sucursal sucursal){
        return sucursalRepository.save(sucursal);
    }

    public Sucursal findById(int id){
        return sucursalRepository.findById(id);
    }

    public List<Sucursal> findBranchesByFranchise(int id){
        return sucursalRepository.finByIdFranchise(id);
    }
}
