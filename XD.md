Rbd


Logowanie do bazy na szuflandii:
mysql -u s22436 -p

Listowanie baz:
show databases -> pokazuje wszystkie bazy danych

Wejście:
use s22436 -> otwiera podaną bazę

Listowanie tabelek:
show tables;	-> pokazuje wszystkie tabelki
describe USER; -> zwraca strukturę tabeli (tak samo jak explain USER;)

SQL:
DDL (Manipulacja samych tabeli):
CREATE:
-  CREATE TABLE USER3 (ID INT AUTO_INCREMENT PRIMARY KEY, IMIE VARCHAR(30), NAZWISKO VARCHAR(40), WIEK INT); <- Stworzenie tabeli z samo zwiększającym się kluczem podstawowym;
- CREATE USER2_BAK AS SELECT * FROM USER2; <- tworzy kopię tabeli (kopiuje strukturę i dane), jak nie chcemy kopiować wszystkich danych to na końcu możemy dodać WHERE
ALTER:
- ALTER TABLE USER3 ADD COLUMN WZROST INT; <- Dodanie pola
- ALTER TABLE USER3 DROP COLUMN WZROST; <- Usuwanie pola 
- ALTER TABLE USER3 CHANGE WZROST WZROST2 INT; <- Zmiana pola (jego nazwy i typu)
- ALTER TABLE USER3 CHANGE WZROST2 INT; <- Zmiana pola (jego tylko jego typu typu)
- ALTER TABLE MOVIES ADD COLUMN isAvailable boolean not null default 0; 
DROP:
- DROP TABLE USER3; <- usuwa podaną tabelkę
DML (Operacje na rekordach):
INSERT:
- INSERT INTO USER VALUES(1,'PAWEL', 'KOT', 21); <- dodawanie danych niejawne
- INSERT INTO USER(ID, IMIE, NAZWISKO, WIEK) VALUES(1,'PAWEL', 'KOT', 21); <- dodawanie danych jawne
- INSERT INTO USER(ID, IMIE, NAZWISKO, WIEK) VALUES(1,'PAWEL', 'KOT', 21), (2, “Piotr”, “Nazw”, 45) <- po przecinku możesz dodać więcej rekordów
UPDATE:
- UPDATE USER2 SET WIEK=40; <- ustawia tą samą wartość dla wszystkich rekordów w tabeli
- UPDATE USER2 SET WIEK=40 WHERE ID=2; <- ustawia tą samą wartość dla  tylko tych rekordów które sprecyzujemy w WHERE
- UPDATE USER2 SET WIEK=40, WZROST=23 WHERE ID=2; <- ustawia te same wiele wartości (po przecinku) dla tylko tych rekordów które sprecyzujemy w WHERE
DELETE:
- DELETE FROM USER 2 WHERE ID=2 <- Usuwa record w tabeli, (jak nie podamy warunków po WHERE usuwa wszystkie dane z tabeli)
SELECT (Wyciąganie danych):
- SELECT * FROM USER <- wyciąga wszystkie (to oznacza *) dane z podanej tabeli
- SELECT ID FROM USER <- wyciąga pole ID z USER
- SELECT * FROM USER WHERE ID > 5 <- tylko pola z ID większym od 5
- SELECT * FROM USER WHERE f(ID) > 5 <- można zmieniać dane funkcjami, w tym wypadku funkcją f
- SELECT a.* FROM TAB a <- Można aliasować nazwy tabeli, w tym wypadku TAB = a
- SELECT a.*, b.* FROM TABA a JOIN TABB b ON a.id = b.id <- złączenie wewnętrzne, Inner Join, to co się złączy to się wyświeli
- SELECT a.*, b.* FROM TABA a LEFT OUTER JOIN TABB b ON a.id = b.id <- złączenie zewnętrze, wyświetla wszystkie wyniki z lewej tabelki  i tylko te co pasują z prawej
- SELECT a.*, b.* FROM TABA a RIGHT OUTER JOIN TABB b ON a.id = b.id <- złączenie zewnętrze, wyświetla wszystkie wyniki z prawej tabelki  i tylko te co pasują z lewej
- 
<p style=“font-style: what”/>

Opis projektu:
Tworzymy bazę danych dla cmentarza. W naszym przypadku, cmentarz oznacza miejsce, w którym można zamówić usługę pogrzebową. Z skład tej usługi wchodzi zapewnienie miejsca na grób oraz wyznaczenie daty pogrzebu.

W naszej bazie danych główną rzeczą (produktem) są miejsca cmentarne. Każde z nich ma przypisane swój sektor, numer, cenę, dostępność, typ oraz w przypadku miejsc już zajętych, dane odbytego pogrzebu. Dane te składają się z imienia, nazwiska i numeru rodzinnego osoby pogrzebanej oraz daty pochówku i jego przeprowadzającego. 


Trzeba poprawić syntax procedury, bo nie jest zgodny z tym co wymaga MySQL, takie coś zadziała:

DELIMITER //

CREATE PROCEDURE SelectAllFunerals(IN typ VARCHAR(30))
BEGIN
	SELECT *  FROM POGRZEB WHERE NAZWA = typ;
END //

DELIMITER ;

CALL SelectAllFunerals('CIALO');


Trzeba wymyśleć innego triggera, dbms_output nie istnieje w MySQL, jak chcesz coś printować to będziesz potrzebować osobnej tabeli:
￼

Tak samo trzeba zmienić kryteria odpalania triggera, w MySQLu nie można używać AND i OR przy definicji tego kiedy ma się odpalić, najlepiej będzie wymyśleć jakiegoś prostrzego triggera, który będzie się odpalał tylko na np. INSERT:
￼

W insertach masz MILY WAY, a potem przy DELETE dajesz MILKY WAY, zmień jedno albo drugie bo aktualnie DELETE nic nie robi


Jak tworzysz tabelę z domem pogrzebowym to na diagramie mamy varchar(30), a w poleceniach masz varchar(20)

Używaj ' zamiast “,  tam się potem to lubi psuć, zmienić trzeba przy: DELETE FROM DOM_POGRZEBOWY WHERE NAZWA = „MILKY WAY”;
SELECT CAST(AVG(CENA) AS DECIMAL(10,2)) AS „ŚREDNIA CENA GROBU” FROM MIEJSCE WHERE TYP="Grób"; 

