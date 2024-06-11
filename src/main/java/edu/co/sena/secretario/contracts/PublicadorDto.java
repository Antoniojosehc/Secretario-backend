package edu.co.sena.secretario.contracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicadorDto {

    private Long id;

    private String fullName;

    private Date bornDate;

    private Date baptismDate;

    private String sex;

    private String notes;


}