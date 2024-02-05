package com.garyortiz.org.restaurantReservation.application.service.TableR;

import com.garyortiz.org.restaurantReservation.domain.dto.TableDto;
import com.garyortiz.org.restaurantReservation.domain.entity.jpa.Restaurant;
import com.garyortiz.org.restaurantReservation.domain.entity.jpa.TableR;

import com.garyortiz.org.restaurantReservation.domain.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JpaTableRService implements TableRGenericService<TableDto> {

    @Autowired
    private TableRepository tableRepository;

    @Override
    public void register(TableDto tableDto) {

        TableR table = TableR.builder()
                .estado(tableDto.getStatus())
                .capacidad(tableDto.getCapacity())
                .restaurante((Restaurant) tableDto.getRestaurantId()).build();

        tableRepository.save(table);
    }

    @Override
    public void update(Object id, TableDto tableDto) {
        TableR table = tableRepository.findById((Integer) id)
                .orElseThrow(() -> new IllegalArgumentException("Table not found"));

        // Solo actualiza los campos que pueden cambiar
        table.setCapacity(tableDto.getCapacity());
        table.setStatus(tableDto.getStatus());

        tableRepository.save(table);
    }

    @Override
    public TableDto findById(Object id) {
        TableR table = tableRepository.findById((Integer) id)
                .orElseThrow(() -> new IllegalArgumentException("Table not found"));
        return convertToDto(table);
    }

    @Override
    public List<TableDto> findAll() {
        List<TableR> tables = tableRepository.findAll();
        return convertToDtoList(tables);
    }

    @Override
    public void remove(Object id) {

        tableRepository.deleteById(id);
    }

    private TableDto convertToDto(TableR table) {
        TableDto tableDto = new TableDto();
        tableDto.setId(table.getId());
        tableDto.setRestaurantId(table.getRestaurant().getId());
        tableDto.setCapacity(table.getCapacity());
        tableDto.setStatus(table.getStatus());

        return tableDto;
    }

    private List<TableDto> convertToDtoList(List<TableR> tables) {
        return tables.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}