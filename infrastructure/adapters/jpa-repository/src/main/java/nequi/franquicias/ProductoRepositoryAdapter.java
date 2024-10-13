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
}
