package isi.project.banking.mappers;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseMapper <From, To> {

	To map(From from);
	
	default List<To> map(List<From> from) {
		return from.stream().map(this::map).collect(Collectors.toList());
	}
}
