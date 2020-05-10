package com.xiao6.usercenter;

import com.sun.javafx.iio.gif.GIFImageLoader2;
import com.xiao6.usercenter.entity.Girl;
import org.flowable.engine.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsercenterApplicationTests {

	@Autowired
	private TaskService taskService;

	@Test
	public void contextLoads() {
		Optional<Girl> op = Optional.of(new Girl());
		if(op.isPresent()){
			Girl girl = op.get();
			System.out.println(girl.getCupSize());
		}
	}


	@Test
	public void flowableTest(){
		taskService.createTaskQuery().includeProcessVariables()
				.or()
				.taskVariableValueEquals("type", "firstAudit")
				.taskVariableValueEquals("type", "secondAudit")
				.endOr()
				.list();
	}

}
