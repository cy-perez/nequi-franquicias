package nequi.franquicias.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@Entity
@Table(name = "franquicias")
@NoArgsConstructor
@AllArgsConstructor
public class FranquiciaData {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_franquicia", nullable = false, length = 50)
    private String nombre;
}
