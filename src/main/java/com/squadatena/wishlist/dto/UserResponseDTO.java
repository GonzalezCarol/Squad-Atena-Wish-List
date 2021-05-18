package com.squadatena.wishlist.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.management.relation.Role;
import java.util.List;

@Data
public class UserResponseDTO {
    @ApiModelProperty(position = 0)
    private Integer id;
    @ApiModelProperty(position = 1)
    private String username;
    @ApiModelProperty(position = 2)
    private String email;
    @ApiModelProperty(position = 3)
    List<Role> roles;

}