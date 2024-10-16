package nequi.franquicias.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import nequi.franquicias.controller.dto.*;
import nequi.franquicias.controller.mapper.FranquiciaMapper;
import nequi.franquicias.controller.util.ResponseBuilder;
import nequi.franquicias.service.FranquiciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/nequi-franquicias")
public class FranquiciaController {

    private final FranquiciaService franquiciaService;

    @GetMapping("/franquicias")
    public ResponseEntity<ResponseDTO<List<FranquiciaResponseDTO>>> obtenerFranquicias() {

        try {
            var franquiciasConsult = franquiciaService.findAll();
            var franquiciasDtoConsult = franquiciasConsult.stream().map(FranquiciaMapper::mapFranquiciaToDto).toList();
            return ResponseBuilder.build200Response(franquiciasDtoConsult);
        } catch (Exception ex) {
            return ResponseBuilder.build500Response(ex.getMessage());
        }
    }

    @PostMapping("/franquicia")
    public ResponseEntity<ResponseDTO<FranquiciaResponseDTO>> crearFranquicia(
            @RequestBody FranquiciaRequestDTO franquiciaRequestDTO){
        try {
            var franquiciaCreada = franquiciaService.save(FranquiciaMapper.mapDtoToFranquicia(franquiciaRequestDTO));
            return ResponseBuilder.build201Response(FranquiciaMapper.mapFranquiciaToDto(franquiciaCreada));
        } catch (Exception ex) {
            return ResponseBuilder.build500Response(ex.getMessage());
        }
    }

    @PutMapping("/franquicia/{id}")
    public ResponseEntity<ResponseDTO<FranquiciaResponseDTO>> modificarFranquiciaPorId(
            @PathVariable("id") int id, @RequestBody FranquiciaRequestDTO franquiciaRequestDto){

        var franquicia = franquiciaService.findById(id);
        if(franquicia == null) return ResponseBuilder.build400FranquiciaNoExisteResponse();

        var franquiciaModificada = franquiciaService.save(
                FranquiciaMapper.mapDtoToFranquiciaModificada(franquiciaRequestDto, franquicia));

        return ResponseBuilder.build200Response(FranquiciaMapper.mapFranquiciaToDto(franquiciaModificada));
    }
}