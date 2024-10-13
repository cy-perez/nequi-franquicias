package nequi.franquicias.domain.common;

import nequi.franquicias.domain.common.model.Franquicia;

import java.util.List;

public interface FranquiciaGatewayRepository {

    List<Franquicia> findAll();

    Franquicia save(Franquicia franquicia);

    Franquicia findById(int id);
}
