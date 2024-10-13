package nequi.franquicias.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import nequi.franquicias.controller.dto.*;
import nequi.franquicias.controller.mapper.ProductoMapper;
import nequi.franquicias.controller.mapper.SucursalMapper;
import nequi.franquicias.controller.util.ResponseBuilder;
import nequi.franquicias.service.FranquiciaService;
import nequi.franquicias.service.SucursalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/sucursal/{id}")
    public ResponseEntity<ResponseDTO<SucursalResponseDTO>> modificarSucursalPorId(
            @PathVariable("id") int id, @RequestBody SucursalRequestDTO sucursalRequestDto){

        var sucursal = sucursalService.findById(id);
        if(sucursal == null) return ResponseBuilder.build400SucursalNoExisteResponse();

        var franquiciaAsociada = franquiciaService.findById(sucursalRequestDto.getIdFranquicia());
        if(franquiciaAsociada == null) return ResponseBuilder.build400FranquiciaNoExisteResponse();

        var sucursalModificada = sucursalService.save(
                SucursalMapper.mapDtoToSucursalModificadA(sucursalRequestDto, sucursal, franquiciaAsociada));

        return ResponseBuilder.build200Response(SucursalMapper.mapSucursalToDto(sucursalModificada));
    }

}
