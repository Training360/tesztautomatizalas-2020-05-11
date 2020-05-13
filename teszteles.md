## Ismétlő kérdések

* Mi az a tesztpiramis, milyen részekből áll? Miért ilyen az alakja?
* Mi az a unit tesztelés, mit tesztel?
* Milyen részekből áll egy unit teszt?
* Mik a unit tesztelés ígéretei? Miért írjunk unit teszteket? Tényleg pluszmunka?
* Honnan ismerjük meg, hogy valami nem unit teszt?
* Hogyan épül fel egy JUnit teszt?
* Milyen Maven plugin futtatja a teszteseteket?
* Mit jelent a teszt scope?
* Mire való a `@BeforeAll`, `@BeforeEach`, `@AfterAll`, `@AfterEach` annotáció?
* Mit jelent az tesztesetek izoláltsága? Hogyan biztosítja ezt a JUnit?
* Mit tudsz mondani a tesztesetek lefutásának sorrendjéről?
* Mit kell csinálnod, ha a tesztelendő osztálynak van külső függősége?
* Hogyan asszertálsz lebegőpontos számra?
* Hogyan asszertálsz pl. egy `List<Employee>` adatszerkezetre?
* Hány assert lehet egy teszt metódusban?
* Mi az a teszt lefedettség?
* Unit teszteljük a perzisztens réteget?
* Milyen lehetőségei vannak a Spring Bootnak integrációs tesztelésre?
* Milyen Maven plugin futtassa az integrációs teszteket?
* Lehet bizonyos szabályokat lazítani integrációs teszteknél?
* Hogyan kezeljük az adatbázis miatti állapotátmenetet? Spring Boot milyen támogatást ad erre?
* Milyen integrációs teszt eszközöket ismertek?

## Néhány ökölszabály

* Hogyan illeszkedik a tesztelés az arcihtektúrába?
* Mit érdemes felületi teszteléssel lefedni?
* Microservice-ek tesztelésének felosztása.


public class CalculatorTest {

  Calculator calculator;

  @Test
  void testAdd() {
    calculator = new Calculator(5);
    ///...
  }

  @Test
  void testSub() {
    calculator.sub(10);
  }


}

assertEquals(2, employees.size());
assertEquals("John Doe", employees.get(0).getName());

assertEquals(List.of("John Doe", "Jane Doe"), employees.stream().map(Employee::getName)
.collect(Collectors.toList()));


Employee
  baseSalary = 200
  bonus = 10

  SumSalary();

findById(): Employee

getS

getName()
getAge()

if () {
  dao.a();

}
else {
  dao.b();
}

public AkarDTO getAkar() {
  toDto(dao.getAkar());

}


WireMock
