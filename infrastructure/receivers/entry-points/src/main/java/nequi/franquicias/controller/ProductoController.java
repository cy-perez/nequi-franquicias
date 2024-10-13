package nequi.franquicias.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import nequi.franquicias.controller.dto.ResponseDTO;
import nequi.franquicias.controller.dto.ProductoRequestDTO;
import nequi.franquicias.controller.dto.ProductoResponseDTO;
import nequi.franquicias.controller.util.ResponseBuilder;
import nequi.franquicias.service.ProductoService;
import nequi.franquicias.service.SucursalService;
import nequi.franquicias.controller.mapper.ProductoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Log
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/nequi-franquicias")
public class ProductoController {

    private final ProductoService productoService;
    private final SucursalService sucursalService;

    @PostMapping("/producto")
    public ResponseEntity<ResponseDTO<ProductoResponseDTO>> crearProducto(
            @RequestBody ProductoRequestDTO productoRequestDto){
        try {
            var sucursalAsociada = sucursalService.findById(productoRequestDto.getIdSucursal());
            if(Objects.isNull(sucursalAsociada)){
                return ResponseBuilder.build400SucursalNoExisteResponse();
            }

            var productoCreado = productoService.save(
                    ProductoMapper.mapDtoToProducto(productoRequestDto, sucursalAsociada));

            return ResponseBuilder.build201Response(ProductoMapper.mapProductoToDto(productoCreado));
        } catch (Exception ex) {
            return ResponseBuilder.build500Response(ex.getMessage());
        }
    }
}
