package com.petmuc.decision.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @Past(message = "Birth date should be in the past")
    private LocalDate birthDate;

    @NotBlank(message = "Email address cannot be blank")
    @Email(message = "Invalid email address")
    private String emailAddress;

    @NotBlank(message = "Phone number cannot be blank")
    private String phone;

    @NotNull(message = "Social Security Number should not be null")
    private  Integer ssn;


}
