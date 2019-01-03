# Examples-JUnit-Mockito



¿Qué es log4j?
Log4j es una librería adicional de java que permite a nuestra aplicación mostrar mensajes de información de lo que está sucediendo 
en ella, lo que habitualmente se conoce como un log. Tiene la ventaja sobre un vulgar System.out.println() que es mucho más
 configurable, permitiendo desde un fichero de configuración, eliminar determinados mensajes o sacarlos a un fichero, a una 
base de datos, por pantalla, a una ventana separada o símplemente por la salida estándar.


DEPENDENCIAS DE JUNIT Y MOCKITO:

<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.8.2</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>3.2.4.RELEASE</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>1.8.5</version>
    <scope>test</scope>
</dependency>



Los test JUnit te permiten escribir código más rápidamente e incrementa su calidad. 
JUnit es elegantemente simple. 
Los test JUnit chequean sus propios resultados y proporcionan feedback inmediato. 
Los tests JUnit pueden componerse como un árbol de suites de tests. 
Escribir tests JUnit no es costoso. 
Los tests JUnit incrementan la estabilidad del software. 
Los tests JUnit son tests del desarrollador. 
Los tests JUnit se escriben en Java. 
Un test no debe implementar ninguna lógica de negocio (nada de if...else...for...etc)
Comprobación del test (assert). No debe haber más de 1 assert en cada test.
Sólo pruebas los métodos públicos de cada clase.
	

JUnit está diseñado alrededor de dos patrones de diseño principales: el patrón Command y el patrón Composite.

Unit proporciona métodos estáticos en la clase Assert para probar ciertas condiciones. Estos métodos de afirmación típicamente 
comienzan con assert y le permiten especificar el mensaje de error, el esperado y el resultado real. Un método afirmación compara 
el valor real devuelto por una prueba para el valor esperado, y se produce una AssertionException si la prueba de comparación falla. 

assertArrayEquals (): probará si dos matrices son iguales entre sí. En otras palabras, si las dos matrices contienen el mismo número 
de elementos, y si todos los elementos de la matriz son iguales entre sí. 
Para comprobar si hay elemento de la igualdad, los elementos de la matriz se comparan utilizando sus métodos equals (). 
Más específicamente, los elementos de cada matriz se comparan uno a uno usando su método equals (). Eso quiere decir, que no es 
suficiente que las dos matrices contienen los mismos elementos. También deben estar presentes en el mismo orden. 

El método assertEquals() compara si dos objetos son iguales, utiliza el método equals().

Los métodos assertTrue() y assertFalse() simplemente validan un resultado si es verdadero o falso.

Los métodos assertNull() y assertNotNull() simplemente validan un resultado si es nulo o no.

Los métodos assertSame () y assertNotSame () prueban si dos referencias a objetos apuntan al mismo objeto o no. 
No es suficiente que los dos objetos son iguales . Debe ser exactamente el mismo objeto al que apunta. 

El método assertThat() compara un objeto con una org.hamcrest.Matcher para ver si el objeto concuerda con la comparacion.
Matcher es una adición externa al framework JUnit. El macher es agregado por el framework called Hamcrest.

----------------------------------------------------------------------------------------------------------------------------

Tipos de Pruebas

En este post nos concentraremos en dos tipos de prueba principalmente

Pruebas Unitarias Se prueban funcionalidades muy específicas del código, por ejemplo, un solo método de una clase; cualquier 
componente externo, distinto a la clase actual se debe simular, para evitar que este afecte la prueba.(Stub o Mock)

Pruebas de Integración Estas garantinzan que un conjunto de componentes interactúen de manera adecuada. Por ejemplo 
en Spring se podría probar un endpoint y sus respectivos servicios y repositorio. Se prueba que toda la aplicación esté bien y 
la interacción de sus componentes funcione como deseamos.
@SpringBootTest es la cual especificamos en nuestra clase main para cargar el contexto de Spring


@Test: esta anotacion se debe poner en todos los métodos que ejecuten pruebas
Assert.assertEquals(<lo que espero que devuelva el metodo>,<metodo que lo devuelve>): verifica que dos parámetros sean iguales
@Before: ejecuta el método que la contiene justo antes de cada test.
En  JUnit4 no existe la función setUp() o  tearDown(), en ves de eso tenemos las anotaciones @Before and @After. 

@After: ejecuta el método que la contiene justo después de cada test.
@BeforeClass: ejecuta el método (estático) que la contiene justo antes del primer test.
@AfterClass: ejecuta el método (estático) que la contiene justo después del último test.

@RunWith :se utiliza para indicar que dicha clase se correrá como una extensión o tipo de otra clase.




Los métodos Mockito.mock y Mockito.when permiten crear un objeto simulado y cambiar su comportamiento

-----------------------------------------------------------------------------------------------------------------------------

Cuando hablamos de unit tests debemos hablar de “Mocking“, este es uno de los skills principales que debemos tener a la 
hora de hacer tests en nuestras aplicaciones.
Al momento de desarrollar aplicaciones las dividimos en capas, web, negocio y datos, entonces al escribir tests 
unitarios en una capa, no queremos preocuparnos por otra, así que la simulamos, a este proceso se le conoce como Mocking.


Mockito es una librería Java que permite simular el comportamiento de una clase de forma dinámica. De esta forma nos aislamos de las 
dependencias con otras clases y sólo testeamos la funcionalidad concreta que queremos.


Un test unitario debe probar un componente aislado de nuestra aplicación, los errores o efectos secundarios de otros componentes 
deben ser eliminados. La pregunta normal sería ¿Cómo aislar mi componente de sus dependencias para así probarlo? la respuesta es 
a través del uso de “test doubles“, estos se clasifican del siguiente modo:

Dummy objects: Este tipo de objetos son asignados al componente pero nunca se llaman y por lo general están vacíos.

Fake objects: Este tipo de objetos tienen implementaciones funcionales pero simplificadas, normalmente utilizan datos 
que no vienen de la base de datos principal, sino que se tienen en cache u otra fuente más simple.

Stub classes: Es una implementación parcial de una interfaz o clase con el propósito de utilizarla durante el test, 
normalmente solo cuentan con los métodos implementados que serán utilizados durante el test.

Mock objects: Es una implementación Dummy de una interfaz o clase en la cual se define la salida que tendrá la llamada de un método.


un @Spy mantendrá los objetos originales y solo reemplazará algunos métodos, a esto se le conoce como partial mocking.

Por ejemplo se crea un mock de la clase ArrayList, y se ejecuta el método add 3 veces pero al realizar la validación 
assertEquals(0, mockArrayList.size()); esta devuelve verdadero y el test es exitoso.
La pregunta natural es ¿Por qué si se agregaron 3 objetos a la lista, al ejecutar el método mockArrayList.size() devuelve 0? 
La respuesta es simple, el objeto mock que creamos no contiene una implementación real de los métodos add() o size(), 
ni tampoco especificamos su comportamiento a travez de when y thereturn, si no que solo su definición que será utilizada 
para pruebas.	

@Spy
private ArrayList spyArrayList;
 
@Test
public void spyTest() {
    spyArrayList.add("Object 1");
    spyArrayList.add("Object 2");
    spyArrayList.add("Object 3");
 
    assertEquals(3, spyArrayList.size()); //aca mantenemos el comportamiento original del objeto
 
    when(spyArrayList.size()).thenReturn(20); //aca sobreescribimos el comportamientos para que la prueba sea exitosa
    assertEquals(20, spyArrayList.size());
}





El ejemplo clásico de un objeto mock es un proveedor de datos, cuando se ejecuta la aplicación el componente se conectará a 
una base de datos y proveerá datos reales, pero cuando se ejecuta un test unitario lo que buscamos es aislarlo y para esto 
necesitamos un objeto mock que simulará la fuente de datos, esto asegurará que las condiciones de prueba sean siempre las mismas.

@RunWith(MockitoJUnitRunner.class) : Se utiliza para definir que se utilizará el Runner de Mockito para ejecutar nuestras pruebas
y no ejecutor normal de JUnit.

@InjectMocks : Se utiliza para informar a Mockito que los mocks serán inyectados en el servicio definido, 
es necesario que se cuente con métodos setters en los que se coloca.


@Mock : Se utiliza para informar a Mockito que un objeto mock será inyectado en la referencia dataService, como se puede ver no es 
necesario escribir la clase implementación, Mockito lo hace por nosotros.

Ej.:
@Mock
private UsuariosDao dao;
Esto permite llamar a UsuariosDao dentro de UsuariosService sin que nos dé una NullPointerException. 
Pero en el caso de los métodos a los que pedimos datos, necesitamos decirle a Mockito qué datos debe devolvernos. 
Esto lo hacemos en el método marcado con el @Before:

// getTodosLosUsuarios
       when(dao.getTodosLosUsuarios()).thenReturn(todosLosUsuarios);
 
       // getUsuario
       when(dao.getUsuario(anyInt())).thenReturn(dto);


when(dataService.getListOfNumbers()).thenReturn(new int[] { 1, 2, 3, 4, 5 }) : Define que cuando se ejecute el método 
getListOfNumbers se devolverá el resultado new int[] { 1, 2, 3, 4, 5 }.

anyInt(): metodo estatico de mockito.

La etiqueta @Test admite como parámetro expected=la clase de la excepción. Por ejemplo:
@Test(expected = ValidationException.class)
En este caso, el test fallará si el método no lanza una ValidationException.


-------------------------------------------------------------------------------------------------------------------------------------

Test Suite: Los Test Suite, es un conjunto de test agrupados, generalmente los test automatizados se encuentran separados lo 
cual es bastante engorroso probar uno por uno, por eso mismo lo idea es agruparlos y correr/lanzar el agrupador de test.

@RunWith(Suite.class):le estamos indicando que se correra con la clase Suite
@Suite.SuiteClasses({ PerroTest.class, PersonaTest.class}): le decimos que va a correr los test de PerroTest y PersonaTest.



