package com.prestashop.testing;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
public class User {

    private String gender;
    private String firstName;
    private String lastName;
    private String password;
    private String day;
    private String month;
    private String year;


}
