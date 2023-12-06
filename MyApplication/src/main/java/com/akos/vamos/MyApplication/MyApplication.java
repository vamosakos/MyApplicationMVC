package com.akos.vamos.MyApplication;

import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class MyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// 1. ArrayList<Car>
		ArrayList<Car> carList = new ArrayList<>();

		// 2. Példányosítás
		Car car1 = new Car(1, "ABC-123", "Audi");
		Car car2 = new Car(2, "DEF-456", "BMW");
		Car car3 = new Car(3, "XYZ-789", "Mercedes");

		// 3. Hozzáadás az ArrayListhez
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);

		// 4. GSON felhasználásával String kimenet készítése
		Gson gson = new Gson();
		String jsonString = gson.toJson(carList);

		// 5. Kiíratás
		System.out.println(jsonString);
	}
}
