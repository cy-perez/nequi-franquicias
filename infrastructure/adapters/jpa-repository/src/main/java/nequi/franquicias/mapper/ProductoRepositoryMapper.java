package nequi.franquicias.mapper;

import nequi.franquicias.domain.common.model.Producto;
import nequi.franquicias.entity.ProductoData;

public class ProductoRepositoryMapper {

    public static Producto mapEntityToProducto(ProductoData productoData){
        return Producto.builder()
                .id(productoData.getId())
                .nombre(productoData.getNombre())
                .cantidad(productoData.getCantidad())
                .sucursal(SucursalRepositoryMapper.mapEntityToSucursal(productoData.getSucursal()))
                .build();
    }

    public static ProductoData mapProductoToEntity(Producto producto){
        return ProductoData.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .cantidad(producto.getCantidad())
                .sucursal(SucursalRepositoryMapper.mapSucursalToEntity(producto.getSucursal()))
                .build();
    }
}
