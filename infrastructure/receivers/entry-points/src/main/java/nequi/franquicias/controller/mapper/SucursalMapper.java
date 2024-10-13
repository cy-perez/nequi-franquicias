package nequi.franquicias.controller.mapper;

import nequi.franquicias.controller.dto.SucursalRequestDTO;
import nequi.franquicias.controller.dto.SucursalResponseDTO;
import nequi.franquicias.domain.common.model.Franquicia;
import nequi.franquicias.domain.common.model.Sucursal;

public class SucursalMapper {

    public static SucursalResponseDTO mapSucursalToDto(Sucursal sucursal){
        return SucursalResponseDTO.builder()
                .id(sucursal.getId())
                .nombre(sucursal.getNombre())
                .franquicia(FranquiciaMapper.mapFranquiciaToDto(sucursal.getFranquicia()))
                .build();
    }

    public static Sucursal mapDtoToSucursal(SucursalRequestDTO sucursalRequestDTO, Franquicia franquicia){
        return Sucursal.builder()
                .nombre(sucursalRequestDTO.getNombreSucursal())
                .franquicia(franquicia)
                .build();
    }

    public static Sucursal mapDtoToSucursalModificadA(SucursalRequestDTO sucursalRequestDTO, Sucursal sucursal,
                                                      Franquicia franquicia) {
        return Sucursal.builder()
                .id(sucursal.getId())
                .nombre(sucursalRequestDTO.getNombreSucursal())
                .franquicia(franquicia)
                .build();
    }
}