package ru.myhome.dao.interfaces;

import org.springframework.data.repository.CrudRepository;

import ru.myhome.model.intefaces.Worktime;


public interface WorktimeRepository extends CrudRepository<Worktime, Integer>{

	//void saveWorktime(Worktime worktime);
	void deleteById(Integer id);
}
