package nequi.franquicias.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import nequi.franquicias.controller.dto.ResponseDTO;
import nequi.franquicias.controller.dto.SucursalRequestDTO;
import nequi.franquicias.controller.dto.SucursalResponseDTO;
import nequi.franquicias.controller.mapper.SucursalMapper;
import nequi.franquicias.controller.util.ResponseBuilder;
import nequi.franquicias.service.FranquiciaService;
import nequi.franquicias.service.SucursalService;
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
public class SucursalController {

    private final SucursalService sucursalService;
    private final FranquiciaService franquiciaService;

    @PostMapping("/sucursal")
    public ResponseEntity<ResponseDTO<SucursalResponseDTO>> crearSucursal(
            @RequestBody SucursalRequestDTO sucursalRequestDto){
        try {
            var franquiciaAsociada = franquiciaService.findById(sucursalRequestDto.getIdFranquicia());
            if(Objects.isNull(franquiciaAsociada)){
                return ResponseBuilder.build400FranquiciaNoExisteResponse();
            }

            var sucursalCreada = sucursalService.save(
                    SucursalMapper.mapDtoToSucursal(sucursalRequestDto, franquiciaAsociada));
            return ResponseBuilder.build201Response(SucursalMapper.mapSucursalToDto(sucursalCreada));
        } catch (Exception ex) {
            return ResponseBuilder.build500Response(ex.getMessage());
        }
    }

}
