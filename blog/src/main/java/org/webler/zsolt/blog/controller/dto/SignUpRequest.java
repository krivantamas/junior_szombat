package org.webler.zsolt.blog.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpRequest {

    @Size(min = 3)
    @NotNull
    private String username;

    @Email
    @NotBlank
    @NotNull
    private String email;

    @Size(min = 8)
    @NotNull
    private String password;

    @Size(min = 8)
    @NotNull
    private String passwordAgain;



}
