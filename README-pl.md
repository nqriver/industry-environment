## Projekt

Projekt zestawia dane rozwoju przemysłu z kompleksowymi pomiarami temperatury w zakresie lat 1950-2022 dla państw członkowskich grupy G7.

## Technologie

### Backend

* Java 17
* Quarkus
* PostgreSQL
* Redis
* SmallRye Rest Client Reactive
* Hibernate & Panache
* Flyway
* Gradle
* Docker
* Swagger & OpenAPI

### Frontend

* JavaScript
* React

## Podział zadań

* Kamil Kończyński - wykonanie aplikacji webowej - frontend
* Łukasz Karasek - wykonanie aplikacji backendowej

Przebieg prac można prześledzić w repozytoriach z kodem na platformie github:

Backend: [https://github.com/nqriver/industry-environment](https://github.com/nqriver/industry-environment)

Frontend: [https://github.com/nqriver/industry-environment-front](https://github.com/nqriver/industry-environment-front)

## Opis projektu

Do opracowania zagadnienia wybrano po 10 największych okręgów przemysłowych z każdego państwa członkowskiego grupy G7. Dane te utrwalane są w bazie danych w ramach skryptów migracyjnych Flyway. Dane na temat historycznych indeksów rozwoju przemysłu wyeksportowano z oficjalnej Organizacji Współpracy Gospodarczej i Rozwoju [OECD](https://data.oecd.org/industry/industrial-production.html) do pliku json. Dane te są importowane do bazy danych PostgreSQL w ramach procesu batchowego obserwującego proces uruchomienia aplikacji.

Dane pogodowe pobierane są z oficjalnego API Open Meteo z modułu danych archiwalnych [Open Meteo](https://open-meteo.com/en/docs/historical-weather-api). Ponieważ proces pobierania i obliczenia pożądanych parametrów (np. średnia temperatura roczna dla konkretnych koordynatów) wiązał się z przetwarzaniem dużych wolumenów danych i skutkował czasami odpowiedzi z API rzędu 1s. dla maksymalnego zakresu dat (1950-2022), zdecydowano się wprowadzić rozwiązanie optymalizacyjne.

Dane z OpenMeteo są importowane z API do bazy danych PostgreSQL w ramach kolejnego procesu batchowego przy uruchomieniu aplikacji. Proces ten można wyłączyć ustawiając flagę:

```properties
data-importer.historical-weather.enabled=false
```

w pliku `application.properties` mikroserwisu backendowego. Domyślnie mikroserwis korzysta z gotowych wyeksportowanych danych umiesczonych w plikach migracyjnych sql. Zaleca się taką właśnie konfigurację. Alternatywnie, aby prześledzić naocznie proces importu z API, należy usunąć trzy ostatnie pliki migracyjne i ustawić wyżej wspomnianą flagę na `true`.

W ramach dalszych optymalizacji wprowadzono cacheowanie generow

anych zbiorów danych używając nieralacyjnej bazy danych Redis.

## Uruchomienie

### Backend

1. Przejść do katalogu `industry-environment/database` i uruchomić skrypt `docker-compose.yml` poleceniem `docker compose up`. Pozwoli to uruchomić wymagane bazy danych w kontenerach.
2. Przejść do katalogu `industry-environment` i uruchomić aplikację w trybie developerskim poleceniem `./gradlew quarkus dev`

### Frontend

1. Przejść do katalogu `industry-environment-front` i uruchomić `npm install --force` a następnie `npm start`

## Obserwacje i Wnioski

Generowane wykresy pozwalają zaobserwować korelację pomiędzy wzrostem rozwoju gospodarczego a wzrostem:

* Średniej rocznej temperatury
* Średniej rocznej maksymalnej temperaturze dziennej
* Średniej rocznej minimalnej temperaturze dziennej
* Średniej dziennej amplitudy temperatur

we wszystkich państwach grupy G7 z wyjątkiem Kanady. Ze względu na specyfikę strefy klimatycznej, Kanadę można potraktować jako element odstający, zatem w ogólności korelacja jest prawdziwa. Rozwój przemysłu jest kluczowym czynnikiem w kontekście zachodzących zmian klimatycznych.

## Źródła

Archiwalne dane pogodowe: [OpenMeteo](https://open-meteo.com/en/docs/historical-weather-api)

Rozwój przemysłu krajów grupy G7 na przestrzeni lat: [OCED](https://data.oecd.org/industry/industrial-production.html)