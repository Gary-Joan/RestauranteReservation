package com.garyortiz.org.restaurantReservation.application.service.User;

import com.garyortiz.org.restaurantReservation.domain.dto.UserDto;
import com.garyortiz.org.restaurantReservation.domain.entity.jpa.User;
import com.garyortiz.org.restaurantReservation.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JpaUserService implements UserGenericService<UserDto> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(UserDto dto) {
        User user = new User();
        user.setNombre(dto.getName());

        userRepository.save(user);
    }

    @Override
    public void update(Object id, UserDto dto) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setNombre(dto.getName());
        // Actualizar otros campos si es necesario
        userRepository.save(user);
    }

    @Override
    public UserDto findById(Object id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return convertToDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return convertToDtoList(users);
    }

    @Override
    public void remove(Object id) {
        userRepository.deleteById(id);
    }

    // Método auxiliar para convertir User a UserDto
    private UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getNombre());
        // Convertir otros campos si es necesario
        return userDto;
    }

    // Método auxiliar para convertir una lista de User a una lista de UserDto
    private List<UserDto> convertToDtoList(List<User> users) {
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}