package ru.myhome.dao.interfaces;

import org.springframework.data.repository.CrudRepository;

import ru.myhome.model.DbModelWorkday;
import ru.myhome.model.DbModelWorkdayPK;


public interface WorkdayRepository extends CrudRepository<DbModelWorkday, DbModelWorkdayPK>{

}
