package com.wheelsapp.controllers.users;

import java.util.List;
import javax.validation.Valid;
import com.wheelsapp.dto.users.UserDto;
import org.springframework.http.HttpStatus;
import com.wheelsapp.dto.users.UserAdminDto;
import com.wheelsapp.exception.ExceptionType;
import org.springframework.http.ResponseEntity;
import com.wheelsapp.services.users.UserService;
import org.springframework.web.bind.annotation.*;
import com.wheelsapp.exception.ExceptionGenerator;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;

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
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String userId) {
        return new ResponseEntity<>(userService.findUserDtoById(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto,
                                              BindingResult bindingResult) {
        if(bindingResult.hasErrors()) throw ExceptionGenerator.getException(ExceptionType.INVALID_OBJECT, "Incorrectly formed request");
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @PostMapping("/admin")
    public ResponseEntity<UserAdminDto> createAdmin(@RequestBody @Valid UserAdminDto userAdminDto,
                                                    BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(userService.createAdmin(userAdminDto), HttpStatus.CREATED);
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<UserDto> update(@RequestBody @Valid UserDto userDto,
                                          @PathVariable String userId,BindingResult bindingResult ) {
        if(bindingResult.hasErrors()) throw ExceptionGenerator.getException(ExceptionType.INVALID_OBJECT, "Incorrectly formed request");
        return new ResponseEntity<>(userService.updateUser(userDto, userId), HttpStatus.OK);
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<UserDto> delete(@PathVariable String id ) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
}
