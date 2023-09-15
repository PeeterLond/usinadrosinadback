INSERT INTO public.type (id, name) VALUES (DEFAULT, 'Pakun teenust');
INSERT INTO public.type (id, name) VALUES (DEFAULT, 'Otsin teenust');

INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Harju maakond');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Hiiu maakond');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Ida-Viru maakond');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Jõgeva maakond');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Järva maakond');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Lääne maakond');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Lääne-Viru maakond');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Põlva maakond');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Pärnu maakond');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Rapla maakond');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Saare maakond');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Tartu maakond');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Valga maakond');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Viljandi maakond');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Võru maakond');

INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'klient');

INSERT INTO public.tool (id, name) VALUES (DEFAULT, 'Vahendid koristaja poolt');
INSERT INTO public.tool (id, name) VALUES (DEFAULT, 'Vahendid kliendi poolt');

INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 1, 'Kehra');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 1, 'Saue');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 1, 'Paldiski');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 1, 'Keila');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 1, 'Loksa');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 1, 'Tallinn');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 1, 'Maardu');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 2, 'Kärdla');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 3, 'Püssi');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 3, 'Sillamäe');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 3, 'Narva-Jõesuu');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 3, 'Kohtla-Järve');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 3, 'Jõhvi');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 3, 'Narva');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 3, 'Kiviõli');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 4, 'Põltsamaa');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 4, 'Jõgeva');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 4, 'Mustvee');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 5, 'Türi');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 5, 'Paide');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 6, 'Haapsalu');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 7, 'Kunda');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 7, 'Rakvere');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 7, 'Tapa');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 7, 'Tamsalu');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 8, 'Räpina');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 8, 'Põlva');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 9, 'Sindi');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 9, 'Kilingi-Nõmme');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 9, 'Lihula');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 9, 'Pärnu');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 10, 'Rapla');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 11, 'Kuressaare');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 12, 'Tartu');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 12, 'Elva');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 12, e'Kallaste	');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 13, 'Valga');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 13, 'Otepää');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 13, 'Tõrva');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 14, 'Võhma');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 14, 'Mõisaküla');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 14, 'Karksi-Nuia');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 14, 'Suure-Jaani');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 14, 'Abja-Paluoja');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 14, 'Viljandi');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 15, 'Antsla');
INSERT INTO public.city (id, county_id, name) VALUES (DEFAULT, 15, 'Võru');

INSERT INTO public.chore (id, name) VALUES (DEFAULT, 'Põranda puhastus/pesu');
INSERT INTO public.chore (id, name) VALUES (DEFAULT, 'Akende pesu');
INSERT INTO public.chore (id, name) VALUES (DEFAULT, 'Pindade puhastus');
INSERT INTO public.chore (id, name) VALUES (DEFAULT, 'Ahju puhastus/pliidi puhastus');
INSERT INTO public.chore (id, name) VALUES (DEFAULT, 'Vannitoa puhastus/katlakivi eemaldus');
INSERT INTO public.chore (id, name) VALUES (DEFAULT, 'Pesu triikimine');
INSERT INTO public.chore (id, name) VALUES (DEFAULT, 'Asjade koristus');
INSERT INTO public.chore (id, name) VALUES (DEFAULT, 'Lillede hooldus');

INSERT INTO public."user" (id, role_id, username, password, status) VALUES (DEFAULT, 2, 'usin', '123', 'A');
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (DEFAULT, 2, 'rosin', '123', 'A');

INSERT INTO public.contact (id, user_id, county_id, city_id, image_id, first_name, last_name, mobile_number, email, introduction) VALUES (DEFAULT, 1, 6, 21, null, 'Usin', 'Rosin', '555666777', 'usin@rosin.com', 'Tere minu nimi on Usin');
INSERT INTO public.contact (id, user_id, county_id, city_id, image_id, first_name, last_name, mobile_number, email, introduction) VALUES (DEFAULT, 2, 15, 47, null, 'Rosin', 'Usin', '111222333', 'rosin@usin.com', 'Tere, minu nimi on Rosin');

INSERT INTO public.advertisement (id, user_id, county_id, city_id, tool_id, type_id, coordinate_id, description, area, price, time) VALUES (DEFAULT, 1, 1, 1, 1, 1, null, 'Pakun koristusteenust Tallinnas. Olen usin tööline', null, 5.50, '2023-09-15 11:00:46.000000');
INSERT INTO public.advertisement (id, user_id, county_id, city_id, tool_id, type_id, coordinate_id, description, area, price, time) VALUES (DEFAULT, 1, 1, 1, 2, 2, null, 'Otsin koristusteenust. Mul on vahendid endal olemas. Otsin Usinat koristajat.', 50, 8.00, '2023-09-15 11:03:57.000000');
INSERT INTO public.advertisement (id, user_id, county_id, city_id, tool_id, type_id, coordinate_id, description, area, price, time) VALUES (DEFAULT, 2, 14, 44, 2, 2, null, 'Tere, otsin endale akende pesijat Abja-Paluojasse. Mul on suur maja, palju keskmise suurusega aknaid, 15tk. Asjaga kiire', null, 10.00, '2023-09-15 11:07:59.000000');



INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (DEFAULT, 1, 1);
INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (DEFAULT, 2, 1);
INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (DEFAULT, 3, 1);
INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (DEFAULT, 1, 2);
INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (DEFAULT, 2, 2);
INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (DEFAULT, 3, 2);
INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (DEFAULT, 4, 2);
INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (DEFAULT, 5, 2);
INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (DEFAULT, 6, 2);
INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (DEFAULT, 7, 2);
INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (DEFAULT, 8, 2);
INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (DEFAULT, 2, 3);
