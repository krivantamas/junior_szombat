package org.webler.zsolt.SpringTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.webler.zsolt.SpringTest.model.Item;
import org.webler.zsolt.SpringTest.service.ItemService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @PostMapping
    public Item save(@RequestBody Item entity) {
        return itemService.save(entity);
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable Long id) throws NoSuchElementException {
        try {
            return itemService.findById(id);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        itemService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        itemService.deleteAll();
    }
}
