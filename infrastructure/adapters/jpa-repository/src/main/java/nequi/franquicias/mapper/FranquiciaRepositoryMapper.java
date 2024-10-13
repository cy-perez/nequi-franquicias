package nequi.franquicias.mapper;

import nequi.franquicias.domain.common.model.Franquicia;
import nequi.franquicias.entity.FranquiciaData;

public class FranquiciaRepositoryMapper {

    public static Franquicia mapEntityToFranquicia(FranquiciaData franquiciaData){
        return Franquicia.builder()
                .id(franquiciaData.getId())
                .nombre(franquiciaData.getNombre())
                .build();
    }

    public static FranquiciaData mapFranquiciaToCreateEntity(Franquicia franquicia){
        return FranquiciaData.builder()
                .nombre(franquicia.getNombre())
                .build();
    }
}
