package isi.project.banking.rest.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseMapper<From, To> {

	To map(From from);
	From unmap(To from);
	
	default List<To> map(List<From> from) {
		return from.stream().map(this::map).collect(Collectors.toList());
	}
	
	default List<From> unmap(List<To> from) {
		return from.stream().map(this::unmap).collect(Collectors.toList());
	}
}
