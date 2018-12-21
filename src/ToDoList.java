
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class ToDoList {
	private int input;
	//private List<ToDoListVO> todolist_ArrayList;
	public List<ToDoListVO> todolist_ArrayList;
	private ToDoListVO todolist_information;
	public Scanner scan=new Scanner(System.in);
	public int i=0;
	
	public ToDoList() {
		this.todolist_ArrayList=new ArrayList<ToDoListVO>();
		this.input=0;		
		this.todolist_information=new ToDoListVO("", 0, 0, "");
	}
	//Getter,Setter-todolist_ArrayList
	public List<ToDoListVO> getTodolist_ArrayList(){
		return todolist_ArrayList;
	}
	public void setTodolist_ArrayList(List<ToDoListVO>todolist_ArrayList) {
		this.todolist_ArrayList=todolist_ArrayList;
	}
	//Getter,Setter-input
	public int getInput() {
		return this.input;
	}
	public void setInput(int input) {
		this.input=input;
	}
	//Add
	public int update(int index, ToDoListVO todolist_information) {
		todolist_ArrayList.set(index, todolist_information);
		return 1;
	}
	public String toString() {
		return todolist_information.getName()+todolist_information.getDate()+todolist_information.getDue()+todolist_information.getDescription();
	}
	

	public void startProgram() {

		while(true) {
			System.out.println("0.Main Menu");
			System.out.println("1.Create");
			System.out.println("2.View");
			System.out.println("3.Update");
			System.out.println("4.Delete");
			System.out.print("Choice number =>");
			this.setInput(scan.nextInt());
			if(input==1) {
				//System.out.println(getInput());
				this.inputInfo(todolist_information);
				String addItemName=ToDoListCreate(todolist_information,todolist_ArrayList);				
			}
			else if(input==2) {
				String lastItemName=ToDoListView(todolist_information,todolist_ArrayList);
			}
			else if(input==3) {
				ToDoListUpdate(todolist_information,todolist_ArrayList);
			}
			else
				ToDoListDelete(todolist_information,todolist_ArrayList);
		}
		
	}
	public ToDoListVO inputInfo(ToDoListVO todolist_information) {
		System.out.print("name: ");
		todolist_information.setName(scan.next());
		System.out.print("date(YYMMDD): ");
		todolist_information.setDate(scan.nextLong());
		System.out.print("due(YYMMDD): ");
		todolist_information.setDue(scan.nextLong());		
		System.out.print("description: ");
		todolist_information.setDescription(scan.next());
		/*todolist_information.setName("ss");
		todolist_information.setDescription("ss");
		todolist_information.setDate(0);
		todolist_information.setDue(0);*/

		return todolist_information;
	}

	public String ToDoListCreate(ToDoListVO ti, List<ToDoListVO> todolist_ArrayList) {
		ToDoListVO todolist_information = new ToDoListVO(ti.getName(), ti.getDate(), ti.getDue(), ti.getDescription());
		todolist_ArrayList.add(todolist_information);
		//System.out.println(todolist_information.getName()+todolist_information.getDate()+todolist_information.getDue()+todolist_information.getDescription());

		return ti.getName();
		

	}

	public String ToDoListView(ToDoListVO todolist_information,List<ToDoListVO> todolist_ArrayList){
		System.out.println("name\t\tdate\tdue\tdescription\t\t\t");
		System.out.println("===================================================");

		Collections.sort(todolist_ArrayList, new Comparator<ToDoListVO>() {
			public int compare(ToDoListVO o1, ToDoListVO o2) {
				if(o1.getDue()>o2.getDue()) {
					return 1;
				}
				else if(o1.getDue()<o2.getDue()) {
					return -1;
				}
				else return 0;
				
			}
		});	
    

		for(int i=0; i<todolist_ArrayList.size();i++) {
			//System.out.println(todolist_information.getName()+todolist_information.getDate()+todolist_information.getDue()+todolist_information.getDescription());
			System.out.println(todolist_ArrayList.get(i).getName() + "\t" 
			+ todolist_ArrayList.get(i).getDate() + "\t" 
			+ todolist_ArrayList.get(i).getDue() + "\t"
			+ todolist_ArrayList.get(i).getDescription());
		}
		System.out.println();
		return todolist_ArrayList.get(i).getName();
	}
	public void ToDoListUpdate(ToDoListVO todolist_information,List<ToDoListVO> todolist_ArrayList){
		String changeItemName="";
		int changeItemIndex=0;
		String newName="", newDescription="";
		long newDate=0, newDue=0;
		Collections.sort(todolist_ArrayList, new Comparator<ToDoListVO>() {
			public int compare(ToDoListVO o1, ToDoListVO o2) {
				if(o1.getDate()<o2.getDate()) {
					return 1;
				}
				else if(o1.getDate()>o2.getDate()) {
					return -1;
				}
				else return 0;
				
			}
		});	
		Scanner scan2 = new Scanner(System.in);
	
		System.out.println("name");
		System.out.println("===================================================");
		int j=todolist_ArrayList.size();
		for(int i=0; i<todolist_ArrayList.size();i++) {
			//System.out.println(todolist_information.getName()+todolist_information.getDate()+todolist_information.getDue()+todolist_information.getDescription());
			System.out.println(todolist_ArrayList.get(i).getName() + "\t" );
		}
		
		System.out.println();
		System.out.print("Choice name");
		changeItemName = scan2.nextLine();
		for(int i=0; i<todolist_ArrayList.size();i++) {
			
			if((todolist_ArrayList.get(i).getName()).equals(changeItemName)) {
				changeItemIndex=i;
				//changeItemIndex=todolist_ArrayList.indexOf(changeItemName);
				System.out.print("name: ");
				newName=scan2.next();
				//todolist_information.set(changeItemIndex,scan2.next());
				System.out.print("date(YYMMDD): ");
				newDate=scan2.nextLong();
				//todolist_information.setDate(scan2.nextLong());
				System.out.print("due(YYMMDD): ");
				//todolist_information.setDue(scan2.nextLong());		
				newDue=scan2.nextLong();
				System.out.print("description: ");
				//todolist_information.setDescription(scan2.next());
				newDescription=scan2.next();
				//System.out.print(changeItemIndex);
				todolist_information= new ToDoListVO(newName, newDate, newDue, newDescription);
				int result=this.update(changeItemIndex, todolist_information);
			}
		}	
	}
	public void ToDoListDelete(ToDoListVO todolist_information,List<ToDoListVO> todolist_ArrayList){
		String changeItemName="";
		int changeItemIndex=0;
		String newName="", newDescription="";
		long newDate=0, newDue=0;
		Scanner scan2 = new Scanner(System.in);
		System.out.println("name");
		System.out.println("===================================================");
		Collections.sort(todolist_ArrayList, new Comparator<ToDoListVO>() {
			public int compare(ToDoListVO o1, ToDoListVO o2) {
				if(o1.getDate()<o2.getDate()) {
					return 1;
				}
				else if(o1.getDate()>o2.getDate()) {
					return -1;
				}
				else return 0;
				
			}
		});		
		for(int i=0; i<todolist_ArrayList.size();i++) {
			//System.out.println(todolist_information.getName()+todolist_information.getDate()+todolist_information.getDue()+todolist_information.getDescription());
			System.out.println(todolist_ArrayList.get(i).getName() + "\t" );
		}
		
		System.out.println();
		System.out.print("Choice name");
		changeItemName = scan2.nextLine();
		for(int i=0; i<todolist_ArrayList.size();i++) {
			if((todolist_ArrayList.get(i).getName()).equals(changeItemName)) {
				todolist_ArrayList.remove(i);
			}
		}	
	}	
	public static void main(String[] args) {
		ToDoList todolist_Program = new ToDoList();
		todolist_Program.startProgram();
	}

}
