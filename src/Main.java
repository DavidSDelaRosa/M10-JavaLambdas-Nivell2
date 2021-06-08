import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		
		String[] strArray = new String[] {"L32rem", "ipsum", "12322336", "dolor", "sit", "am1et", "consectetur",
	            "adipis3sscing", "elit", "sed", "doremifasol", "123", "e2i32smod", "tem33po3r", "inci2dsdidu4nt", "ut", "lab5o333re", "Ejercicio","Ejercicia"};
		
		//1. De más corta a más larga:
		System.out.println("EJERCICIO 1 forma 1: ");
		Arrays.stream(strArray).sorted(Comparator.comparing(String::length)).forEach(System.out::println);;
		System.out.println("EJERCICIO 1 forma 2: ");
		Arrays.stream(strArray)
			.sorted((s1,s2)->s1.length() - s2.length())
			.forEach(System.out::println);
		
		//2. De más larga a más corta:
		System.out.println("\nEJERCICIO 2: ");
		Arrays.stream(strArray)
			.sorted((s1,s2)->s2.length() - s1.length())
			.forEach(System.out::println);;
			
		//3. Alfabeticamente por la primera letra:
		System.out.println("\nEJERCICIO 3: ");
		Arrays.stream(strArray)
			.sorted((s1,s2)->s1.compareToIgnoreCase(s2))
			.forEach(System.out::println);
		
		//4. Los que empiecen por 'e' primero:
		System.out.println("\nEJERCICIO 4: ");
		Arrays.stream(strArray).sorted((s1,s2) -> s1.toLowerCase().startsWith("e") && !s2.toLowerCase().startsWith("e") ? -1 : !s1.startsWith("e") && s2.startsWith("e") ? 1 : s1.compareTo(s2)).forEach(System.out::println);
		
		Arrays.stream(strArray).sorted((s1,s2) ->{
			if(s1.toLowerCase().startsWith("e") && !s2.toLowerCase().startsWith("e")) {
				return -1; 
			}else if(!s1.startsWith("e") && s2.startsWith("e")) {
				return 1;
			}else {
				return s1.compareTo(s2);
			}
		}).forEach(System.out::println);
		
		//5. Modificar las 'a' por 4:
		System.out.println("\nEJERCICIO 5: ");
		Arrays.stream(strArray).forEach(s->{
			System.out.println(s.replaceAll("a", "4"));
		});
		
		//6. Mostrar solo números: 
		System.out.println("\nEJERCICIO 6: ");
		Arrays.stream(strArray).filter(s-> s.chars().allMatch(Character::isDigit)).forEach(System.out::println);
			
		//7. Implementar Functional Interface (línea de código 81):
		System.out.println("\nEJERCICIO 7: ");
		
		Calculadora suma = (x, y) -> {
			return x+y;
		};
		System.out.println("La suma es: " +suma.operacion(6, 8));
		
		Calculadora resta = (x, y) -> {
			return x-y;
		};
		System.out.println("La resta es: " +resta.operacion(7.9f, 10f));
		
		Calculadora multiplicacion = (x, y) -> {
			return x*y;
		};
		System.out.println("La multiplicacion es: " + multiplicacion.operacion(4.6f, 12));
		
		Calculadora division = (x, y) -> {
			return x/y;
		};
		System.out.println("La division es: " + division.operacion(10, 2));
		
	}
}

interface Calculadora{
	abstract float operacion(float x, float y);
}
