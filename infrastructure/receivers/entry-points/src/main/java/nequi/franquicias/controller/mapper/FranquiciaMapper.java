package nequi.franquicias.controller.mapper;

import nequi.franquicias.controller.dto.FranquiciaRequestDTO;
import nequi.franquicias.controller.dto.FranquiciaResponseDTO;
import nequi.franquicias.domain.common.model.Franquicia;

public class FranquiciaMapper {

    public static FranquiciaResponseDTO mapFranquiciaToDto(Franquicia franquicia){
        return FranquiciaResponseDTO.builder()
                .id(franquicia.getId())
                .nombre(franquicia.getNombre())
                .build();
    }

    public static Franquicia mapDtoToFranquicia(FranquiciaRequestDTO franquiciaRequestDTO){
        return Franquicia.builder()
                .nombre(franquiciaRequestDTO.getNombreFranquicia())
                .build();
    }

    public static Franquicia mapDtoToFranquiciaModificada(FranquiciaRequestDTO franquiciaRequestDTO, Franquicia franquicia){
        return Franquicia.builder()
                .id(franquicia.getId())
                .nombre(franquiciaRequestDTO.getNombreFranquicia())
                .build();
    }
}
