package nequi.franquicias;

import nequi.franquicias.entity.FranquiciaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranquiciaRepository extends JpaRepository<FranquiciaData, Integer> {
}
