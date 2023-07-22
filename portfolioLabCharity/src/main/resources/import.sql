
insert into categories(id, name) VALUES (1, 'ubrania, które nadają się do ponownego użycia'), (2, 'ubrania do wyrzucenia'), (3, 'zabawki'), (4, 'ksiązki'), (5, 'inne');

insert into institutions(id, description, name) VALUES (1, 'Pomoc dla osób nie posiadających nmiejsca zamieszkania', 'Fundacja "Bez Domu"'), (2, 'Pomoc osobom znajdującym się w trudnej sytuacji życiowej', 'Fundacja "Dla dzieci"'), (3, 'Pomoc dzieciom z ubogich rodzin', 'Fundacja "Miś"'), (4, 'Pomoc ośrodkom opiekuńczym i domom dziecka', 'Fundacja "Nowy Dom"'), (5, 'Zapobieganie ludzkim cierpieniom i łagodzenie ich skutków oraz ochrona ludzkiej godności', 'PCK'), (6, 'Pomoc dzieciom z ubogich rodzin.','Fundacja "Dbam o Zdrowie'), (7, 'Pomoc wybudzaniu dzieci ze śpiączki.','Fundacja "A kogo"'), (8, 'Pomoc osobom znajdującym się w trudnej sytuacji życiowej.','Fundacja “Dla dzieci"'), (9, 'Pomoc dla osób nie posiadających miejsca zamieszkania', 'Fundacja “Bez domu”');

# insert into donations(id, city, pickUpComment, pickUpDate, pickupTime, quantity, street, zipCode, category_id, institution_id) values (1, 'Warszawa', 'no comnment', '2023-04-01', '10:10:00', 3, 'Prosta', '00-001', 1, 1), (2, 'Warszawa', 'all ok', '2023-04-24', '12:12:00', 8, 'Długa', '00-002', 1, 2), (3, 'Warszawa', 'super easy', '2023-04-30', '12:20:00', 5, 'Szeroka', '00-003', 2, 3),  (4, 'Warszawa', 'no problems', '2023-04-30', '18:10:00', 10, 'Szewska', '00-004', 3, 4), (5, 'Warszawa', 'no comnment', '2023-05-01', '14:40:00', 20, 'Krótka', '00-005', 2, 1);
# insert into donations(id, city, pickUpComment, pickUpDate, pickupTime, quantity, street, zipCode, category_id, institution_id) values (6, 'Poznan', 'ok', '2023-04-02', '12:40', 4, 'Łódzka', '60-001', 2, 3), (7, 'Poznan', '', '2023-04-11', '11:40', 12, 'Kręta', '60-002', 4, 1), (8, 'Poznan', 'tu bylem - Tony Halik', '2023-04-21', '19:40', 5, 'Konińska', '60-003', 5, 3), (9, 'Poznan', '', '2023-05-01', '10:00', 6, 'Niska', '60-004', 3, 4), (10, 'Poznan', 'all well that ends well', '2023-05-10', '10:50', 2, 'Niecała', '60-005', 4, 1);
# insert into donations(id, city, pickUpComment, pickUpDate, pickupTime, quantity, street, zipCode, category_id, institution_id) values (11, 'Kraków', '', '2023-05-10', '10:50', 6, 'Rynek', '30-005', 1, 1), (12, 'Kraków', 'no probs', '2023-05-10', '10:50', 4, 'Mały Rynek', '30-005', 2, 1), (13, 'Kraków', 'peace & love', '2023-05-10', '10:50', 12, 'Mariacka', '30-005', 4, 2), (14, 'Kraków', 'no comment', '2023-05-10', '10:50', 9, 'Kazimierza', '30-005', 3, 1), (15, 'Kraków', 'ok', '2023-05-10', '10:50', 5, 'Jagielońska', '30-005', 2, 2);

insert into donations(id, city, pickUpComment, pickUpDate, pickupTime, quantity, street, zipCode, institution_id) values (1, 'Warszawa', 'no comnment', '2023-04-01', '10:10:00', 3, 'Prosta', '00-001', 1), (2, 'Warszawa', 'all ok', '2023-04-24', '12:12:00', 8, 'Długa', '00-002',  2), (3, 'Warszawa', 'super easy', '2023-04-30', '12:20:00', 5, 'Szeroka', '00-003',  3),  (4, 'Warszawa', 'no problems', '2023-04-30', '18:10:00', 10, 'Szewska', '00-004', 4), (5, 'Warszawa', 'no comnment', '2023-05-01', '14:40:00', 20, 'Krótka', '00-005', 1);
insert into donations(id, city, pickUpComment, pickUpDate, pickupTime, quantity, street, zipCode, institution_id) values (6, 'Poznan', 'ok', '2023-04-02', '12:40', 4, 'Łódzka', '60-001',  3), (7, 'Poznan', '', '2023-04-11', '11:40', 12, 'Kręta', '60-002', 1), (8, 'Poznan', 'tu bylem - Tony Halik', '2023-04-21', '19:40', 5, 'Konińska', '60-003', 3), (9, 'Poznan', '', '2023-05-01', '10:00', 6, 'Niska', '60-004', 4), (10, 'Poznan', 'all well that ends well', '2023-05-10', '10:50', 2, 'Niecała', '60-005', 1);
insert into donations(id, city, pickUpComment, pickUpDate, pickupTime, quantity, street, zipCode, institution_id) values (11, 'Kraków', '', '2023-05-10', '10:50', 6, 'Rynek', '30-005',  1), (12, 'Kraków', 'no probs', '2023-05-10', '10:50', 4, 'Mały Rynek', '30-005', 1), (13, 'Kraków', 'peace & love', '2023-05-10', '10:50', 12, 'Mariacka', '30-005', 2), (14, 'Kraków', 'no comment', '2023-05-10', '10:50', 9, 'Kazimierza', '30-005', 1), (15, 'Kraków', 'ok', '2023-05-10', '10:50', 5, 'Jagielońska', '30-005', 2);


insert into donations_categories(donations_id, categories_id) VALUES (1,1);
insert into donations_categories(donations_id, categories_id) VALUES (2,1);
insert into donations_categories(donations_id, categories_id) VALUES (3,2);
insert into donations_categories(donations_id, categories_id) VALUES (4,3);
insert into donations_categories(donations_id, categories_id) VALUES (5,2);
insert into donations_categories(donations_id, categories_id) VALUES (6,2);
insert into donations_categories(donations_id, categories_id) VALUES (7,4);
insert into donations_categories(donations_id, categories_id) VALUES (8,5);
insert into donations_categories(donations_id, categories_id) VALUES (9,3);
insert into donations_categories(donations_id, categories_id) VALUES (10,4);
insert into donations_categories(donations_id, categories_id) VALUES (11,1);
insert into donations_categories(donations_id, categories_id) VALUES (12,2);
insert into donations_categories(donations_id, categories_id) VALUES (13,4);
insert into donations_categories(donations_id, categories_id) VALUES (14,3);
insert into donations_categories(donations_id, categories_id) VALUES (15,2);