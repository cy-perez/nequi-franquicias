package nequi.franquicias;

import nequi.franquicias.entity.ProductoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<ProductoData, Integer> {

    @Query(value = "SELECT * FROM productos WHERE sucursal = ?1 ORDER BY cantidad DESC LIMIT 1", nativeQuery = true)
    ProductoData findProductGreatStock(int idSucursal);

}
