package com.wheelsapp.services.users;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import com.wheelsapp.utils.RoleEnum;
import com.wheelsapp.dto.users.UserDto;
import com.wheelsapp.entities.users.User;
import com.wheelsapp.dto.users.UserAdminDto;
import com.wheelsapp.exception.ExceptionType;
import com.wheelsapp.exception.ExceptionGenerator;
import com.wheelsapp.repositories.users.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Laura Garcia
 */
@Service
public class UserServiceMongo implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserServiceMongo(@Autowired UserRepository userRepository, @Autowired ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User(userDto);
        userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserAdminDto createAdmin(UserAdminDto userAdminDto) {
        User user = new User(userAdminDto);
        userRepository.save(user);
        return modelMapper.map(user, UserAdminDto.class);
    }

    @Override
    public UserDto createDriver(String userId) {
        User user = findById(userId);
        user.addRole(RoleEnum.DRIVER);
        userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User findById(String userId) {
        Optional<User>  possibleUser = userRepository.findById(userId);
        if(possibleUser.isPresent()){
            return possibleUser.get();
        }else
            throw ExceptionGenerator.getException(ExceptionType.DUPLICATE_ENTITY, "User not found");
    }

    @Override
    public UserDto findUserDtoById(String userId) {
       return modelMapper.map(findById(userId), UserDto.class);
    }

    @Override
    public User findByEmail(String email) {
        Optional<User>  possibleUser = userRepository.findByEmail(email);
        if(possibleUser.isPresent()){
            return possibleUser.get();
        }else
            throw ExceptionGenerator.getException(ExceptionType.DUPLICATE_ENTITY, "Email not found");
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> {
                    return modelMapper.map(user, UserDto.class);
                }).collect(Collectors.toList());
    }

    @Override
    public UserDto deleteUser(String userId) {
        User user = findById(userId);
        user.setActive(false);
        userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        User userToUpdate = findById(userId);
        userToUpdate.updateUser(userDto);
        userRepository.save(userToUpdate);
        return modelMapper.map(userToUpdate, UserDto.class);
    }

}
