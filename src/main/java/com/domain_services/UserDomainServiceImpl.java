package com.domain_services;

import com.DTOs.UserDTO;
import com.entities.Customer;
import com.entities.User;
import com.value_objects.Address;
import com.value_objects.Name;
import com.value_objects.Surname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repositories.UserRepository;


@Service
public class UserDomainServiceImpl implements UserDomainService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail());

        if(user == null){
            System.out.println(userDTO.getAddress());
            User retval = userRepository.save(new Customer(userDTO.getEmail(),userDTO.getPassword(),
                    userDTO.getName(),userDTO.getSurname(), userDTO.getAddress()));
            return retval;
        }
        return null;
    }


    @Override
    public User login(UserDTO userDTO) {
        System.out.println(userDTO.getEmail());
        User user2 = userRepository.findByEmail(userDTO.getEmail());

        System.out.println(user2.getEmail());
        User user = userRepository.findByEmailAndPassword(userDTO.getEmail(),userDTO.getPassword());

        if(user != null){
            if(user.getPassword().equals(userDTO.getPassword())){
                return user;
            }
        }

        return null;
    }

    @Override
    public User changeName(String email, String name) {
        User user = userRepository.findByEmail(email);


        if(user == null){
            return null;
        }

        user.setName(new Name(name));
        userRepository.save(user);

        userRepository.flush();
        User retUser = userRepository.findByEmail(email);


        return retUser;
    }

    @Override
    public User changeSurname(String email, String surname) {
        User user = userRepository.findByEmail(email);


        if(user == null){
            return null;
        }

        user.setSurname(new Surname(surname));
        userRepository.save(user);

        userRepository.flush();
        User retUser = userRepository.findByEmail(email);


        return retUser;
    }

    @Override
    public User changeAddress(String email, String address) {
        Customer customer = userRepository.findCustomer(email);


        if(customer == null){
            return null;
        }

        customer.setAddress(address);
        userRepository.save(customer);

        userRepository.flush();
        User retUser = userRepository.findByEmail(email);


        return retUser;
    }


}
