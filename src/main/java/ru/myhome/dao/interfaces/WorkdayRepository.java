package ru.myhome.dao.interfaces;

import org.springframework.data.repository.CrudRepository;

import ru.myhome.model.intefaces.Workday;
import ru.myhome.model.intefaces.WorkdayPK;


public interface WorkdayRepository extends CrudRepository<Workday, WorkdayPK>{

}
