package com.garyortiz.org.restaurantReservation.application.service.User;




import com.garyortiz.org.restaurantReservation.domain.dto.UserDto;
import com.garyortiz.org.restaurantReservation.domain.entity.mongo.User;

import com.garyortiz.org.restaurantReservation.domain.repository.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MongoUserService implements UserGenericService<UserDto> {

    @Autowired
    private MongoUserRepository userRepository;

    @Override
    public void register(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setId(UUID.randomUUID().toString());

        userRepository.save(user);
    }

    @Override
    public void update(Object id, UserDto dto) {
        User user = userRepository.findById(String.valueOf(id)).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setName(dto.getName());
        // Actualizar otros campos si es necesario
        userRepository.save(user);
    }

    @Override
    public UserDto findById(Object id) {
        User user = userRepository.findById(String.valueOf(id)).orElseThrow(() -> new IllegalArgumentException("User not found"));
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
        userDto.setName(user.getName());
        userDto.setId(user.getId());

        // Convertir otros campos si es necesario
        return userDto;
    }

    // Método auxiliar para convertir una lista de User a una lista de UserDto
    private List convertToDtoList(List<User> users) {
        return users; // Recolectar los resultados en una lista
    }
}