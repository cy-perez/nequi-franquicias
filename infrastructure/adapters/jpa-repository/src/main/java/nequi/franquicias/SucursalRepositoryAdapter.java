package nequi.franquicias;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import nequi.franquicias.domain.common.SucursalGatewayRepository;
import nequi.franquicias.domain.common.model.Sucursal;
import nequi.franquicias.mapper.SucursalRepositoryMapper;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SucursalRepositoryAdapter implements SucursalGatewayRepository {

    private final SucursalRepository repository;

    @Override
    @Transactional
    public Sucursal save(Sucursal sucursal) {
        var sucursalCreada = repository.save(SucursalRepositoryMapper.mapSucursalToCreateEntity(sucursal));
        return SucursalRepositoryMapper.mapEntityToSucursal(sucursalCreada);
    }
}
