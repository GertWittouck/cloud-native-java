package com.gwi.accountservice.model;

import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class User {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
}
