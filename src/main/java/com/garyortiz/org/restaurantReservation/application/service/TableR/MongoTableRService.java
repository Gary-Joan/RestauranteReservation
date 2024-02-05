package com.garyortiz.org.restaurantReservation.application.service.TableR;

import com.garyortiz.org.restaurantReservation.domain.dto.TableDto;

import com.garyortiz.org.restaurantReservation.domain.entity.mongo.TableR;
import com.garyortiz.org.restaurantReservation.domain.repository.MongoTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MongoTableRService implements TableRGenericService<TableDto> {

    @Autowired
    private MongoTableRepository tableRepository;

    @Override
    public void register(TableDto tableDto) {
        TableR table = new TableR();
        table.setCapacity(tableDto.getCapacity());
        table.setStatus(tableDto.getStatus());

        tableRepository.save(table);
    }

    @Override
    public void update(Object id, TableDto tableDto) {
        TableR table = tableRepository.findById((String) id)
                .orElseThrow(() -> new IllegalArgumentException("Table not found"));

        // Solo actualiza los campos que pueden cambiar
        table.setCapacity(tableDto.getCapacity());
        table.setStatus(tableDto.getStatus());

        tableRepository.save(table);
    }

    @Override
    public TableDto findById(Object id) {
        TableR table = tableRepository.findById((String) id)
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
        tableRepository.deleteById((String) id);
    }

    private TableDto convertToDto(TableR table) {
        TableDto tableDto = new TableDto();
        tableDto.setId(table.getId());
        tableDto.setRestaurantId(table.getRestaurantId());
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
