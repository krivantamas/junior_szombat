package org.webler.zsolt.SpringTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webler.zsolt.SpringTest.model.Item;
import org.webler.zsolt.SpringTest.repository.ItemRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item save(Item entity) {
        return itemRepository.save(entity);
    }

    public Item findById(Long aLong) throws NoSuchElementException {
        return itemRepository.findById(aLong).orElseThrow();
    }

    public void deleteById(Long aLong) {
        itemRepository.deleteById(aLong);
    }

    public void deleteAll() {
        itemRepository.deleteAll();
    }
}
