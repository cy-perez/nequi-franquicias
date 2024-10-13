package nequi.franquicias;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import nequi.franquicias.domain.common.ProductoGatewayRepository;
import nequi.franquicias.domain.common.model.Producto;
import nequi.franquicias.mapper.ProductoRepositoryMapper;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductoRepositoryAdapter implements ProductoGatewayRepository {

    private final ProductoRepository repository;

    @Override
    @Transactional
    public Producto save(Producto producto) {
        var productoCreado = repository.save(ProductoRepositoryMapper.mapProductoToEntity(producto));
        return ProductoRepositoryMapper.mapEntityToProducto(productoCreado);
    }

    @Override
    public Producto findById(int id) {
        var productoOptional = repository.findById(id);
        return productoOptional.map(ProductoRepositoryMapper::mapEntityToProducto).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
