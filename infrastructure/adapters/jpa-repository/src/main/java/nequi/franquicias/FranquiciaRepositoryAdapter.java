package nequi.franquicias;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import nequi.franquicias.domain.common.FranquiciaGatewayRepository;
import nequi.franquicias.domain.common.model.Franquicia;
import nequi.franquicias.mapper.FranquiciaRepositoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class FranquiciaRepositoryAdapter implements FranquiciaGatewayRepository {

    private final FranquiciaRepository repository;

    @Override
    public List<Franquicia> findAll() {
        var franquiciasData = repository.findAll();
        return franquiciasData.stream().map(FranquiciaRepositoryMapper::mapEntityToFranquicia).toList();
    }

    @Override
    @Transactional
    public Franquicia save(Franquicia franquicia) {
        var franquiciaCreada = repository.save(FranquiciaRepositoryMapper.mapFranquiciaToEntity(franquicia));
        return FranquiciaRepositoryMapper.mapEntityToFranquicia(franquiciaCreada);
    }

    @Override
    public Franquicia findById(int id) {
        var franquiciaOptional = repository.findById(id);
        return franquiciaOptional.map(FranquiciaRepositoryMapper::mapEntityToFranquicia).orElse(null);
    }
}
