package by.jwd.task01basic.service;

import java.util.List;
import by.jwd.task01basic.entity.NumberData;

public interface GuessNumberService {

	public List<NumberData<Integer>> guess(NumberData<Integer> numberData);
}