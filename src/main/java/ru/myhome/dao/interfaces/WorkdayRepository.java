package ru.myhome.dao.interfaces;

import org.springframework.data.repository.CrudRepository;

import ru.myhome.model.Workday;
import ru.myhome.model.WorkdayPK;


public interface WorkdayRepository extends CrudRepository<Workday, WorkdayPK>{

}
