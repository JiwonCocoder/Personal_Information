
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FirstJunitTest {
	@BeforeAll
	static void inintAll() {
		//ToDoListVO todolist_information;

		//ToDoList todolist_Program=new ToDoList();
		//todolist_Program.startProgram();
	}

	@Test
	void testView() {
		ToDoListVO todolist_information1 = new ToDoListVO("buy a new car",181004,181105, "good one");
		ToDoListVO todolist_information2 = new ToDoListVO("buy a gift",181104,181111, "a doll");
		ToDoListVO todolist_information3 = new ToDoListVO("submit a HW",181112,181112, "SE");
		ToDoListVO todolist_information = new ToDoListVO(null, 0, 0, null);

		List<ToDoListVO> todolist_ArrayList = new ArrayList<ToDoListVO>();
		todolist_ArrayList.add(todolist_information1);
		todolist_ArrayList.add(todolist_information2);
		todolist_ArrayList.add(todolist_information3);

		ToDoList todolist_Program = new ToDoList();
		String result=todolist_Program.ToDoListView(todolist_information1,todolist_ArrayList);
		assertEquals("buy a new car",result);
	}
	@Test
	void testCreate() {
		ToDoListVO todolist_information1 = new ToDoListVO("buy a new car",181004,181105, "good one");
		ToDoListVO todolist_information = new ToDoListVO(null, 0, 0, null);

		List<ToDoListVO> todolist_ArrayList = new ArrayList<ToDoListVO>();
		//todolist_ArrayList.add(todolist_information1);

		ToDoList todolist_Program = new ToDoList();
		String result=todolist_Program.ToDoListCreate(todolist_information1,todolist_ArrayList);
		assertEquals("buy a new car",result);
	}
}
