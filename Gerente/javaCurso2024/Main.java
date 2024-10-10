package javaCurso2024;

public class Main {
	
	public static void main(String[] args) {
		//Criação e array de empregados:
		Employee[] employees = new Employee[3];
		
		//Preenchendo o array com 2 empregados e 1 gerente:
		employees[0] = new Employee("João", 3000);
		employees[1] = new Employee("Maria", 2500);
		employees[2] = new Manager("Yago", 5000, "TI");
		
		//Percorrendo o array e exibindo os dados:
		for ( Employee employee : employees) {
			employee.showEmployeeData();
			System.out.println();
		}
	}
}
