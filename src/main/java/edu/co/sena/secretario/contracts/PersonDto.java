package edu.co.sena.secretario.contracts;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private String name;

    private String lastName;

    private String dni;

    private char gender;

}
