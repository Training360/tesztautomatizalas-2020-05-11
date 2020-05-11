# Postman

## Ismétlés

* Mire való az URL, és hogyan épül fel?
* Mire való a port?
* Mire való a HTTP protokoll?
* Milyen tulajdonságokkal rendelkezik a HTTP protokoll?
* Hogyan lehet az URL-ben paramétereket átadni?
* Mik azok a HTTP státuszkódok, melyek a gyakori státuszkódok?
* Űrlap esetén hogyan néz ki a HTTP kérés?
* Mit hívunk RESTful webszolgáltatásoknak? Milyen tulajdonságai vannak?
* Mi az a JSON?
* Miért lett ennyire elterjedt?
* Hogyan épül fel a JSON?
* Vannak-e típusok a JSON-ben?
* A RESTful webszolgáltatások a HTTP milyen tulajdonságait használják ki?
* RESTful webszolgáltatásoknál mire valók a paraméterek?
* Milyen metódusokkal használjuk a create és update műveleteket?
* A CRUD műveleteknél milyen értékeket adjunk vissza?
* Mi az a `Content-Type` header és Mime-type
* Mi az, mire való a Postman?
* Mennyivel tud többet a kereskedelmi verzió az ingyenesnél? (https://www.postman.com/pricing/)
* Az API fejlesztés mely részét fedi le a Postman?
* Hogyan kell egy kérést megfogalmazni?
* Mibe lehet szervezni a kéréseket?
* Hogyan épül fel a felhasználói felület?
* Mi az a History?
* Mi az a Workspace?
* Hol kapcsolható be a konzol?

## Gyakorlat

### Alkalmazás bemutatása

https://github.com/Training360/locations-app

https://hub.docker.com/repository/docker/training360/locations

* MySQL indítása Dockerben

```
docker run --name locationsdb -e MYSQL_DATABASE=locations -e MYSQL_USER=locations -e MYSQL_PASSWORD=locations -e MYSQL_ROOT_PASSWORD=admin1234 -p 3306:3306 -d mysql
```

* Locations alkalmazás indítása Dockerben

```
docker run -d --name locations -p 8080:8080 -e spring_datasource_url=jdbc:mysql://locationsdb:3306/locations --link locationsdb:locationsdb training360/locations
```

http://localhost:8080/
http://localhost:8080/server
http://localhost:8080/swagger-ui
http://localhost:8080/
http://localhost:8080/v3/api-docs

### GET kérés elküldése (gyakorlat)

Hozd létre a következő kéréseket a `Locations` collectionben!

* Kedvenc helyek listázása
* Egy kedvenc hely lekérdezése

Mi a visszatérési státusz kód és válasz tartalma?

### URL paraméterek használata (gyakorlat)

* Használd a lapozást!

* `page` és `size` paraméterek

Vizsgáld meg a visszatérési értéket!

### POST kérés elküldése (gyakorlat)

* Hozz létre egy kedvenc helyet!

* `/api/locations`
* Body: raw, JSON (application/json)

```javascript
{
    "name":"Budapest",
    "coords":"47.497912,19.040235"
}
```

* Módosíts egy kedvenc helyet!

Mi a visszatérési státusz kód és válasz tartalma?

### DELETE (gyakorlat)

* Törölj egy kedvenc helyet!
* Töröld az összes kedvenc helyet!

Mi a visszatérési státusz kód és válasz tartalma?

## Postman Echo

* Példa REST webszolgáltatások pl. eszközök tesztelésére
* https://docs.postman-echo.com/?version=latest

## Postman Echo (gyakorlat)

* GET
* POST

## Hibakezelés

* Pl. helytelen JSON dokumentum beküldése
* Validáció
* Státuszkód
* Body tartalma

### RFC 7807

* Problem Details for HTTP APIs
* `application/problem+json` mime-type

```javascript
{
    "type": "locations/invalid-json-request",
    "title": "JSON error",
    "status": 400,
    "detail": "JSON parse error: Unexpected character (':' (code 58)): expected a valid value (JSON String, Number, Array, Object or token 'null', 'true' or 'false'); nested exception is com.fasterxml.jackson.core.JsonParseException: Unexpected character (':' (code 58)): expected a valid value (JSON String, Number, Array, Object or token 'null', 'true' or 'false')\n at [Source: (PushbackInputStream); line: 2, column: 13]"
}
```

### RFC 7807 mezők

* `type`: URI, mely azonosítja a hiba típusát
* `title`: ember által olvasható üzenet
* `status`: http státuszkód
* `detail`: részletek, ember által olvasható
* `instance`: URI, mely azonosítja a hibát, és később is elérhető (pl. valamilyen log hivatkozás)
* Egyedi saját mezők definiálhatók

### RFC 7807 saját mezővel

```javascript
{
    "type": "locations/validation-error",
    "title": "Validation error",
    "status": 400,
    "detail": "Validation error",
    "validationErrors": [
        {
            "field": "name",
            "message": "Name must not be blank"
        }
    ]
}
```

## Dátum kezelése

* JSON-ben nincs típus rá
* Javasolt átküldési forma

```javascript
console.log(JSON.stringify({'now': new Date()});) // {"now":"2013-10-21T13:28:06.419Z"}
```

* Ember által is olvasható
* Rendezhető
* ISO 8601 szabványnak megfelel
* UTC időzónában, `Z`, mint `Zulu` - military time zones szabvány szerint

## Megosztás

* Collection, Request documentation (supports Markdown)
* Collection/View in web
* Collection alatt további folderek vehetők fel
* Save Response/Save as Example - megjelenik a weben is
* Examples/Add Example

## Environments

* Különböző környezetek
* Variable:
    * Initial value (megosztott)
    * Current value (csak lokálisan)
* Exportálható

## Environments (gyakorlat)

* `local` környezet
* `url` változó létrehozása

## Exportálás különböző programozási nyelvekben

* cURL, Java, C#, JavaScript, NodeJs, PHP, Python, stb.
* Code

## Tesztesetek

* JavaScript
* Tests tab (Assert és After fixture)
* Code snippets
* Test Results tab
* Pre-request Script (Before fixture)
* Collection szinten is
* Postman Sandboxon belül futnak

https://learning.postman.com/docs/postman/scripts/postman-sandbox-api-reference/

## Assert

* Status code
* Response body: Contains string
* Response body: JSON value check

## Rekurzív JSON összehasonlítás Postmanben

Az összehasonlításhoz a [deep-diff](https://github.com/flitbit/diff) könyvtárat fogjuk használni.

A lépések a következők:

* Át kell másolni a könyvtár minify-olt forráskódját a Collection Pre-request Scripts közé
* Deklarálni kell ugyanitt a DeepDiff változót, és értéket adni neki
* Meg kell hívni a DeepDiff függvényt

A forráskódot a következő címről kell átmásolni:

https://raw.githubusercontent.com/flitbit/diff/master/dist/deep-diff.min.js

Ez a `this` objektumba definiál egy `DeepDiff` függvényt, és ahhoz, hogy egyszerűen el lehessen érni a tesztjeinkből, a bemásolt forráskód végére a következőt kell írni:

```javascript
DeepDiff = this.DeepDiff;
```

Ezután már meg is lehet hívni a Request Tests fülében:

```javascript
a = {"name":"John Doe"};
b = {"name":"John Doe"};
result = DeepDiff(a, b);
console.log(result);
```

Ekkor egyezőség van, ekkor `undefined` értéket ad vissza.

Nézzük két különböző JSON esetén:

```javascript
a = {"name":"John Doe",
     "phones": [{"type": "mobile", "number": "123"}, {"type": "mobile2", "number": "123"}]};
b = {"name":"John Doe",
     "phones": [{"type": "mobile", "number": "123"}, {"type": "mobile2", "number": "124"}]};
result = DeepDiff(a, b);
console.log(result);
```

Ennek hatására a következő JSON-t fogja visszaadni:

```javascript
[
   {
      "kind":"E",
      "path":[
         "phones",
         1,
         "number"
      ],
      "lhs":"123",
      "rhs":"124"
   }
]
```

Ez azt mondja, hogy értékbeli különbség van, a `$.phones[1]/number` path-on, az első JSON-ben a `123`, a második JSON-ben a `124` szöveg szerepel.

## Séma ellenőrzés

* [JSON Schema](http://json-schema.org/)

Példa séma:

```javascript
{
    "type": "object",
    "properties": {
        "id": {
            "type": "integer",
            "description": "id of the location",
            "format": "int64",
            "example": 1
        },
        "name": {
            "type": "string",
            "description": "name of the location",
            "example": "Budapest"
        },
        "lat": {
            "type": "number",
            "description": "Latitude",
            "format": "double",
            "example": 47.497912
        },
        "lon": {
            "type": "number",
            "description": "Longitude",
            "format": "double",
            "example": 19.040235
        },
        "interestingAt": {
            "type": "string",
            "description": "Interesting at",
            "format": "date-time"
        },
        "tags": {
            "type": "array",
            "description": "Tags",
            "example": "capital,favourite",
            "items": {
                "type": "string",
                "description": "Tags",
                "example": "capital,favourite"
            }
        }
    }
}
```

Ellenőrzés Postmanben:

[Tiny Validator (for v4 JSON Schema)](http://geraintluff.github.io/tv4/)

```javascript
let schema = {
  // ...
};

pm.test('Schema is valid', function() {
    let location = pm.response.json();
    console.log(location);
    let result = tv4.validateResult(location, schema);
    console.log(result);
    pm.expect(result.valid).to.be.true;
});
```

## Random adatok használata

[faker.js](https://github.com/marak/Faker.js/) for dummy data

Explicit változóként generálva:

https://learning.postman.com/docs/postman/variables-and-environments/variables-list/

```JavaScript
{
    "name": "{{$randomCity}}",
    "coords":"{{$randomLatitude}},{{$randomLongitude}}"
}
```

## Visualize

* HTML template
* Bármilyen JavaScript könyvtár használható
* [Handlebars](https://handlebarsjs.com/) template

```javascript
var template = `

    <table bgcolor="#FFFFFF">
        <tr>
            <th>Name</th>
            <th>Lat</th>
            <th>Lon</th>
        </tr>

        {{#each response.content}}
            <tr>
                <td>{{name}}</td>
                <td>{{lat}}</td>
                <td>{{lon}}</td>
            </tr>
        {{/each}}
    </table>
`;



pm.visualizer.set(template, {
    // Pass the response body parsed as JSON as `data`
    response: pm.response.json()
});
```

https://learning.postman.com/docs/postman/sending-api-requests/visualizer/

További példák:

https://documenter.getpostman.com/view/4946945/SVzz4KxB?version=latest

`Run in Postman`

## Változók scope-ja

* Global
* Collection
* Environment
* Data (külső adatforrásból importált)
* Local
* Fentről lefele erősebb prioritás

## Változók hozzáférése

* Builder: url, paraméter, header, body
* Kódból

```javascript
pm.global.set("username", "John Doe");
pm.global.get("username");
```

## Base64

* [btoa.js](https://git.coolaj86.com/coolaj86/btoa.js.git)

```javascript
let text = "Hello Postman";
let encoded = btoa(text);
console.log(encoded);

let decoded = atob(encoded);
console.log(decoded);
```

## Collection run

* Több lépésből álló tesztesetet külön collectionbe
* Runner (Collection Runner)

## Futtatás parancssorban

* Node.js
* `npm install -g newman`
* Export collection
* `newman run Locations.postman_collection.json`

## Futtatás Dockerrel

* Docker hálózat
* Environment használata

```
docker run --link locations:locations -v C:\newman:/etc/newman -t postman/newman:alpine run Locations.postman_collection.json -e docker.postman_environment.json
```

## Data Driven testing

* Collection Runner / Data
* CSV/JSON
* https://mockaroo.com/

## Branching and looping

* Következő lépés beállítható a `postman.setNextRequest("request_name");` hívással
* Futtatás leállítható a `postman.setNextRequest("null");`
* Amennyiben az assert elbukik, nem hajtja végre a további utasításokat
* Lehet használni arra, hogy megállítsuk a további teszt lépések futtatását

## Branching and looping (gyakorlat)

* Egyesével törlés, egészen addig, míg van kedvenc hely

## Proxy

* Capture requests and cookies
* Source: Proxy
* Capture Requests
* Port
* Save requests to

https://github.com/Training360/locations-app-client

```
java -Dlocations.client.proxy.enabled=true -jar locations-app-client.jar
```

## Verziókezelés

* Fork
* Merge
* Create Pull Request

## Mock server

* Mock collection
* Example alapján
* Copy Mock URL

## Monitoring

* https://github.com/public-apis/public-apis
* https://cat-fact.herokuapp.com/facts
* Monitor Collection
* Select requests to Monitor
* Configuration
* Next steps
* Lefuttatja a teszteket is

## Import

* Pl. Swagger OpenAPI URL

## API fejlesztés

* APIs fül
* Generate Collection
* Develop
    * Mock
    * Documentation
    * Environments
* Test
    * Három kategóriába csoportosítva, Collection alapján
    * Test suites
    * Integration tests
    * Contract tests
* Observe
    * Monitors

## Autentikáció

```
docker run -d --name jwt -p 8080:8080 training360/jwt
```

POST http://localhost:8080/api/auth

```javascript
{
	"username": "user",
	"password": "user"
}
```

http://localhost:8080/api/hello

Cookies

## Automatikus bejelentkezés

```javascript
pm.sendRequest({
  url: 'http://localhost:8080/api/auth',
  method: 'POST',
  header: 'headername1:value1',
  body: {
    mode: 'raw',
    raw: JSON.stringify({
	"username": "user",
	"password": "user"
})
  }
}, function (error, response) {
    console.log(error ? err : response.json());

    let cookie = response.headers.find(x => x.key == "Set-Cookie").value;
    let token = cookie.substring(9, cookie.indexOf(";"));
    console.log(token);
});
```
