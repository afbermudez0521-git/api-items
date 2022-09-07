package com.items.services;

import java.util.List;

import com.items.entitys.Items;

public interface IItemsService {

	public List<Items> FindAll();
	public Items FindById(Long id, Integer cantidad);
	
}
