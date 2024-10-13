package nequi.franquicias;

import nequi.franquicias.entity.SucursalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<SucursalData, Integer> {
}
