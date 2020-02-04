package com.mar.toolshare.service.entities;

import com.mar.toolshare.model.entities.Item;

import java.util.List;

public interface ItemService {
    Iterable<Item> findAll();

    Item findById(long itemId);

    void save(Item item);

    void deleteById(Long id);

    void saveAll(List<Item> asList);
}
