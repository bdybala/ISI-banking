package isi.project.banking.service;

import java.util.List;
import java.util.Optional;

import isi.project.banking.exceptions.EntityNotFoundException;

public interface BaseService <T, ID> {
	
	public Optional<T> findOne(ID id);
	public List<T> findAll();
	public Optional<T> save(T t);
	public Optional<T> update(T t);
	public void remove(ID id) throws EntityNotFoundException;

}
