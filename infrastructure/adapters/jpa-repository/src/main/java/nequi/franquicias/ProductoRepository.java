package nequi.franquicias;

import nequi.franquicias.entity.ProductoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoData, Integer> {
}
