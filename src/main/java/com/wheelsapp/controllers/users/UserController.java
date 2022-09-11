package com.wheelsapp.controllers.users;

import com.wheelsapp.dto.users.UserAdminDto;
import com.wheelsapp.dto.users.UserDto;
import com.wheelsapp.entities.users.User;
import com.wheelsapp.services.users.UserService;
import com.wheelsapp.utils.RoleEnum;
import com.wheelsapp.utils.errors.ErrorUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Laura Garcia
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<User> users = userService.getAll();
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = modelMapper.map(user, UserDto.class);
            usersDto.add(userDto);
        }
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        ModelMapper modelMapper = new ModelMapper();
        try {
            User user = userService.findById(id);
            UserDto userDto = modelMapper.map(user, UserDto.class);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        ModelMapper modelMapper = new ModelMapper();
        try {
            User user = new User(userDto);
            userService.createUser(user);
            userDto = modelMapper.map(user, UserDto.class);
            return new ResponseEntity<>(userDto, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/admin")
    public ResponseEntity<UserAdminDto> createAdmin(@RequestBody @Valid UserAdminDto userAdminDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ModelMapper modelMapper = new ModelMapper();
        try {
            User user = new User(userAdminDto);
            userService.createUser(user);
            userAdminDto = modelMapper.map(user, UserAdminDto.class);
            return new ResponseEntity<>(userAdminDto, HttpStatus.CREATED);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
