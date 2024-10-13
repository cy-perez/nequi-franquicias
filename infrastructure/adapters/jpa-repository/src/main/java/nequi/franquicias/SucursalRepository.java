package nequi.franquicias;

import nequi.franquicias.domain.common.model.Sucursal;
import nequi.franquicias.entity.SucursalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SucursalRepository extends JpaRepository<SucursalData, Integer> {

    @Query(value = "SELECT * FROM sucursales s WHERE s.franquicia = ?1", nativeQuery = true)
    List<SucursalData> finByIdFranchise(int id);
}
