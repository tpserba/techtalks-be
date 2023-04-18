package com.serbatic.tpraga.techtalks;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TechtalksApplicationTests {
Calculator calcUnderTest  = new Calculator();
	@Test
	void itShouldAddNumbers() {
		int firstNum = 1;
		int secondNum = 4;
		// Given
		int result = calcUnderTest.add(firstNum, secondNum);

		//then
		int expected = 5;
		assertThat(result).isEqualTo(expected);


	}

	class Calculator{
		int add(int a, int b){
			return a + b;
		}
	}

}
