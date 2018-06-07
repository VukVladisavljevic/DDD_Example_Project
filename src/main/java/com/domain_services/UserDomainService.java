package com.domain_services;

import com.DTOs.UserDTO;
import com.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface UserDomainService {

    User register(UserDTO userDTO);

    User login(UserDTO userDTO);

    public User changeName(String email, String name);

    public User changeSurname(String email, String surname);

    public User changeAddress(String email, String address);


}
