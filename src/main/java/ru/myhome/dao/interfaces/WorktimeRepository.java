package ru.myhome.dao.interfaces;

import org.springframework.data.repository.CrudRepository;

import ru.myhome.model.DbModelWorktime;


public interface WorktimeRepository extends CrudRepository<DbModelWorktime, Integer>{

	//void saveWorktime(Worktime worktime);
	void deleteById(Integer id);
}
