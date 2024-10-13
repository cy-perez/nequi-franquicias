package nequi.franquicias.mapper;

import nequi.franquicias.domain.common.model.Sucursal;
import nequi.franquicias.entity.SucursalData;

public class SucursalRepositoryMapper {

    public static Sucursal mapEntityToSucursal(SucursalData sucursalData){
        return Sucursal.builder()
                .id(sucursalData.getId())
                .nombre(sucursalData.getNombre())
                .franquicia(FranquiciaRepositoryMapper.mapEntityToFranquicia(sucursalData.getFranquicia()))
                .build();
    }

    public static SucursalData mapSucursalToEntity(Sucursal sucursal){
        return SucursalData.builder()
                .id(sucursal.getId())
                .nombre(sucursal.getNombre())
                .franquicia(FranquiciaRepositoryMapper.mapFranquiciaToEntity(sucursal.getFranquicia()))
                .build();
    }
}