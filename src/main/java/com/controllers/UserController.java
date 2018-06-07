package com.controllers;

import com.DTOs.UserDTO;
import com.domain_services.UserDomainService;
import com.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value= "api")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDomainService userService;

    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> register(@RequestBody UserDTO userDTO) {

        logger.info("> register  user");

        User retuser = userService.register(userDTO);

        if (retuser == null) {
            System.out.println(" User not created");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("< register user");
        System.out.println("User successfully created");

        return new ResponseEntity<>(retuser, HttpStatus.OK);
    }

    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> login(@RequestBody UserDTO userDTO) {

        logger.info("> login  user");
        logger.info(userDTO.getEmail());
        User retuser = userService.login(userDTO);

        if (retuser == null) {
            System.out.println(" User not existing");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("< user logged in");
        System.out.println("User successfully logged");

        return new ResponseEntity<>(retuser, HttpStatus.OK);
    }

    @RequestMapping(value = "/change/name",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> changeName(@RequestBody UserDTO userDTO) {

        logger.info("> name");

        User retUser = userService.changeName(userDTO.getEmail(), userDTO.getName());


        return new ResponseEntity<User>(retUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/change/surname",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> changeSurname(@RequestBody UserDTO userDTO) {

        logger.info("> name");

        User retUser = userService.changeSurname(userDTO.getEmail(), userDTO.getSurname());


        return new ResponseEntity<User>(retUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/change/address",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> changeAddress(@RequestBody UserDTO userDTO) {

        logger.info("> address");

        User retUser = userService.changeAddress(userDTO.getEmail(), userDTO.getAddress());


        return new ResponseEntity<User>(retUser, HttpStatus.OK);
    }



}
