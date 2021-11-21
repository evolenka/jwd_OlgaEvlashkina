package by.jwd.task01basic.service.impl;

import by.jwd.task01basic.entity.Text;
import by.jwd.task01basic.service.TextOperationService;

public class TextOperationServiceImpl implements TextOperationService {
	@Override
	public String[] doAction(Text sequence, String ch) {

		String[] result = new String[3];

		int index = -1;
		String nextChar = "No";
		String previousChar = "No";

		for (int i = 0; i < sequence.getSequence().length; i++) {
			if (sequence.getSequence()[i].equals(ch)) {
				index = i;
				if (index < (sequence.getSequence().length - 1) && (index > 0)) {
					nextChar = sequence.getSequence()[index + 1];
					previousChar = sequence.getSequence()[index - 1];
				} else if (index == 0) {
					nextChar = sequence.getSequence()[index + 1];

				} else {

					previousChar = sequence.getSequence()[index - 1];
				}

				break;
			}
		}

		result[0] = Integer.toString(index);
		result[1] = nextChar;
		result[2] = previousChar;
		return result;
	}
}