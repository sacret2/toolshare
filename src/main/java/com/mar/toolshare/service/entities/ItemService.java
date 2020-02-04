package com.mar.toolshare.service.entities;

import com.mar.toolshare.databases.dao.ItemRepository;
import com.mar.toolshare.model.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepo;

    public Iterable<Item> findAll() {
        return itemRepo.findAll();
    }

    public Item findById(long itemId) {
        return itemRepo.findById(itemId).orElse(null);
    }

    public void save(Item item) {
        itemRepo.save(item);
    }

    public void deleteById(Long id) {
        itemRepo.deleteById(id);
    }

    public void saveAll(List<Item> asList) {
        itemRepo.saveAll(asList);
    }
}
