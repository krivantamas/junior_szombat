package org.webler.zsolt.SpringTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webler.zsolt.SpringTest.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
