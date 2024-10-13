package nequi.franquicias;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import nequi.franquicias.domain.common.SucursalGatewayRepository;
import nequi.franquicias.domain.common.model.Sucursal;
import nequi.franquicias.mapper.SucursalRepositoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class SucursalRepositoryAdapter implements SucursalGatewayRepository {

    private final SucursalRepository repository;

    @Override
    @Transactional
    public Sucursal save(Sucursal sucursal) {
        var sucursalCreada = repository.save(SucursalRepositoryMapper.mapSucursalToEntity(sucursal));
        return SucursalRepositoryMapper.mapEntityToSucursal(sucursalCreada);
    }

    @Override
    public Sucursal findById(int id) {
        var sucursalOptional = repository.findById(id);
        return sucursalOptional.map(SucursalRepositoryMapper::mapEntityToSucursal).orElse(null);
    }

    @Override
    public List<Sucursal> finByIdFranchise(int id) {
        var sucursales = repository.finByIdFranchise(id);
        return sucursales.stream().map(SucursalRepositoryMapper::mapEntityToSucursal).toList();
    }

}
