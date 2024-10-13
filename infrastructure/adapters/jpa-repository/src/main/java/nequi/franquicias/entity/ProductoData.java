package nequi.franquicias.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@Entity
@Table(name = "productos")
@NoArgsConstructor
@AllArgsConstructor
public class ProductoData {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_producto", nullable = false, length = 50)
    private String nombre;

    @Column
    private int cantidad;

    @OneToOne
    @JoinColumn(name = "sucursal")
    private SucursalData sucursal;
}
