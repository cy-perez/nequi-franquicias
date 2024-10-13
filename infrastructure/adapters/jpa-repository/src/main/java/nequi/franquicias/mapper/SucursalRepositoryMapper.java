package nequi.franquicias.mapper;

import nequi.franquicias.domain.common.model.Franquicia;
import nequi.franquicias.domain.common.model.Sucursal;
import nequi.franquicias.entity.FranquiciaData;
import nequi.franquicias.entity.SucursalData;

public class SucursalRepositoryMapper {

    public static Sucursal mapEntityToSucursal(SucursalData sucursalData){
        return Sucursal.builder()
                .id(sucursalData.getId())
                .nombre(sucursalData.getNombre())
                .franquicia(mapEntityToFranquicia(sucursalData.getFranquicia()))
                .build();
    }

    public static SucursalData mapSucursalToCreateEntity(Sucursal sucursal){
        return SucursalData.builder()
                .nombre(sucursal.getNombre())
                .franquicia(mapDomainToEntity(sucursal.getFranquicia()))
                .build();
    }

    private static Franquicia mapEntityToFranquicia(FranquiciaData franquiciaData){
        return Franquicia.builder()
                .id(franquiciaData.getId())
                .nombre(franquiciaData.getNombre())
                .build();
    }

    private static FranquiciaData mapDomainToEntity(Franquicia franquicia){
        return FranquiciaData.builder()
                .id(franquicia.getId())
                .nombre(franquicia.getNombre())
                .build();
    }
}
