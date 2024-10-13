package nequi.franquicias.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import nequi.franquicias.domain.common.FranquiciaGatewayRepository;
import nequi.franquicias.domain.common.model.Franquicia;

import java.util.List;

@Log
@RequiredArgsConstructor
public class FranquiciaService {

    private final FranquiciaGatewayRepository franquiciaRepository;

    public List<Franquicia> findAll(){
        return franquiciaRepository.findAll();
    }

    public Franquicia save(Franquicia franquicia){
        return franquiciaRepository.save(franquicia);
    }
}
