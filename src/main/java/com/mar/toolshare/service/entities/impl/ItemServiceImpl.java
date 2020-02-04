package com.mar.toolshare.service.entities.impl;

import com.mar.toolshare.databases.dao.ItemRepository;
import com.mar.toolshare.model.entities.Item;
import com.mar.toolshare.service.entities.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepo;

    @Override
    public Iterable<Item> findAll() {
        return itemRepo.findAll();
    }

    @Override
    public Item findById(long itemId) {
        return itemRepo.findById(itemId).orElse(null);
    }

    @Override
    public void save(Item item) {
        itemRepo.save(item);
    }

    @Override
    public void deleteById(Long id) {
        itemRepo.deleteById(id);
    }

    @Override
    public void saveAll(List<Item> asList) {
        itemRepo.saveAll(asList);
    }
}
