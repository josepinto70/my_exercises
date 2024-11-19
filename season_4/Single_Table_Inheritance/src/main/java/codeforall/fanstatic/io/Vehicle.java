package codeforall.fanstatic.io;

import javax.persistence.*;

@Entity(name="VehicleSingleTable")
@Table(name = "vehicle_single_table")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "vehicle_type",
        discriminatorType = DiscriminatorType.STRING
)
public abstract class Vehicle {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer maxSpeed;
}