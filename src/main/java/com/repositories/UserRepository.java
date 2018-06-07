package com.repositories;

import com.entities.Customer;
import com.entities.User;
import com.value_objects.Address;
import com.value_objects.Name;
import com.value_objects.Surname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT user FROM User user WHERE user.email=:email AND user.password=:password")
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("SELECT user FROM User user WHERE user.email=:email")
    User findByEmail(@Param("email")String email);

    @Query("SELECT user FROM User user WHERE user.email=:email")
    Customer findCustomer(@Param("email")String email);

  /*  @Modifying
    @Transactional
    @Query("UPDATE User user SET user.name=:name WHERE user.email=:email")
    int changeName(@Param("email") String email, @Param("name") Name name);

    @Modifying
    @Transactional
    @Query("UPDATE User user SET user.surname=:surname WHERE user.email=:email")
    int changeSurname(@Param("email") String email, @Param("surname") Surname surname);

    @Modifying
    @Transactional
    @Query("UPDATE User user SET user.address=:address WHERE user.email=:email")
    int changeAddress(@Param("email") String email, @Param("address") Address address);*/

}
