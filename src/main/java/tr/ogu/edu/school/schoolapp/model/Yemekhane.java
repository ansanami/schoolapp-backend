package tr.ogu.edu.school.schoolapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Table(name = "yemekhane")
public class Yemekhane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gun")
    private String gun;

    @Column(name = "yemek1")
    private String yemek1;

    @Column(name = "yemek2")
    private String yemek2;

    @Column(name = "yemek3")
    private String yemek3;

    @Column(name = "yemek4")
    private String yemek4;
}
