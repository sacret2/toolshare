package com.mar.toolshare.databases.dao;

import com.mar.toolshare.model.Item;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
}
