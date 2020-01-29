package com.mar.toolshare.databases.dao;

import com.mar.toolshare.model.entities.Item;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
}
