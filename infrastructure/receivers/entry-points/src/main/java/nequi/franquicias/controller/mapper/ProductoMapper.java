package nequi.franquicias.controller.mapper;

import nequi.franquicias.controller.dto.ProductoRequestDTO;
import nequi.franquicias.controller.dto.ProductoResponseDTO;
import nequi.franquicias.domain.common.model.Producto;
import nequi.franquicias.domain.common.model.Sucursal;

public class ProductoMapper {

    public static ProductoResponseDTO mapProductoToDto(Producto producto){
        return ProductoResponseDTO.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .cantidad(producto.getCantidad())
                .sucursal(SucursalMapper.mapSucursalToDto(producto.getSucursal()))
                .build();
    }

    public static Producto mapDtoToProducto(ProductoRequestDTO productoRequestDTO, Sucursal sucursal){
        return Producto.builder()
                .nombre(productoRequestDTO.getNombreProducto())
                .cantidad(productoRequestDTO.getCantidad())
                .sucursal(sucursal)
                .build();
    }
}
