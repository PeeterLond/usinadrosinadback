INSERT INTO public.type (id, name) VALUES (1, 'Pakun teenust');
INSERT INTO public.type (id, name) VALUES (2, 'Otsin teenust');

INSERT INTO public.county (id, name) VALUES (1, 'Harju maakond');
INSERT INTO public.county (id, name) VALUES (2, 'Hiiu maakond');
INSERT INTO public.county (id, name) VALUES (3, 'Ida-Viru maakond');
INSERT INTO public.county (id, name) VALUES (4, 'Jõgeva maakond');
INSERT INTO public.county (id, name) VALUES (5, 'Järva maakond');
INSERT INTO public.county (id, name) VALUES (6, 'Lääne maakond');
INSERT INTO public.county (id, name) VALUES (7, 'Lääne-Viru maakond');
INSERT INTO public.county (id, name) VALUES (8, 'Põlva maakond');
INSERT INTO public.county (id, name) VALUES (9, 'Pärnu maakond');
INSERT INTO public.county (id, name) VALUES (10, 'Rapla maakond');
INSERT INTO public.county (id, name) VALUES (11, 'Saare maakond');
INSERT INTO public.county (id, name) VALUES (12, 'Tartu maakond');
INSERT INTO public.county (id, name) VALUES (13, 'Valga maakond');
INSERT INTO public.county (id, name) VALUES (14, 'Viljandi maakond');
INSERT INTO public.county (id, name) VALUES (15, 'Võru maakond');

INSERT INTO public.role (id, name) VALUES (1, 'admin');
INSERT INTO public.role (id, name) VALUES (2, 'klient');

INSERT INTO public.tool (id, name) VALUES (1, 'Vahendid koristaja poolt');
INSERT INTO public.tool (id, name) VALUES (2, 'Vahendid kliendi poolt');

INSERT INTO public.city (id, county_id, name) VALUES (32, 1, 'Kehra');
INSERT INTO public.city (id, county_id, name) VALUES (17, 1, 'Saue');
INSERT INTO public.city (id, county_id, name) VALUES (27, 1, 'Paldiski');
INSERT INTO public.city (id, county_id, name) VALUES (14, 1, 'Keila');
INSERT INTO public.city (id, county_id, name) VALUES (33, 1, 'Loksa');
INSERT INTO public.city (id, county_id, name) VALUES (1, 1, 'Tallinn');
INSERT INTO public.city (id, county_id, name) VALUES (7, 1, 'Maardu');
INSERT INTO public.city (id, county_id, name) VALUES (28, 2, 'Kärdla');
INSERT INTO public.city (id, county_id, name) VALUES (45, 3, 'Püssi');
INSERT INTO public.city (id, county_id, name) VALUES (10, 3, 'Sillamäe');
INSERT INTO public.city (id, county_id, name) VALUES (31, 3, 'Narva-Jõesuu');
INSERT INTO public.city (id, county_id, name) VALUES (6, 3, 'Kohtla-Järve');
INSERT INTO public.city (id, county_id, name) VALUES (13, 3, 'Jõhvi');
INSERT INTO public.city (id, county_id, name) VALUES (4, 3, 'Narva');
INSERT INTO public.city (id, county_id, name) VALUES (24, 3, 'Kiviõli');
INSERT INTO public.city (id, county_id, name) VALUES (25, 4, 'Põltsamaa');
INSERT INTO public.city (id, county_id, name) VALUES (23, 4, 'Jõgeva');
INSERT INTO public.city (id, county_id, name) VALUES (42, 4, 'Mustvee');
INSERT INTO public.city (id, county_id, name) VALUES (21, 5, 'Türi');
INSERT INTO public.city (id, county_id, name) VALUES (16, 5, 'Paide');
INSERT INTO public.city (id, county_id, name) VALUES (15, 6, 'Haapsalu');
INSERT INTO public.city (id, county_id, name) VALUES (29, 7, 'Kunda');
INSERT INTO public.city (id, county_id, name) VALUES (8, 7, 'Rakvere');
INSERT INTO public.city (id, county_id, name) VALUES (19, 7, 'Tapa');
INSERT INTO public.city (id, county_id, name) VALUES (36, 7, 'Tamsalu');
INSERT INTO public.city (id, county_id, name) VALUES (35, 8, 'Räpina');
INSERT INTO public.city (id, county_id, name) VALUES (20, 8, 'Põlva');
INSERT INTO public.city (id, county_id, name) VALUES (26, 9, 'Sindi');
INSERT INTO public.city (id, county_id, name) VALUES (37, 9, 'Kilingi-Nõmme');
INSERT INTO public.city (id, county_id, name) VALUES (41, 9, 'Lihula');
INSERT INTO public.city (id, county_id, name) VALUES (3, 9, 'Pärnu');
INSERT INTO public.city (id, county_id, name) VALUES (22, 10, 'Rapla');
INSERT INTO public.city (id, county_id, name) VALUES (9, 11, 'Kuressaare');
INSERT INTO public.city (id, county_id, name) VALUES (2, 12, 'Tartu');
INSERT INTO public.city (id, county_id, name) VALUES (18, 12, 'Elva');
INSERT INTO public.city (id, county_id, name) VALUES (47, 12, e'Kallaste	');
INSERT INTO public.city (id, county_id, name) VALUES (11, 13, 'Valga');
INSERT INTO public.city (id, county_id, name) VALUES (34, 13, 'Otepää');
INSERT INTO public.city (id, county_id, name) VALUES (30, 13, 'Tõrva');
INSERT INTO public.city (id, county_id, name) VALUES (39, 14, 'Võhma');
INSERT INTO public.city (id, county_id, name) VALUES (46, 14, 'Mõisaküla');
INSERT INTO public.city (id, county_id, name) VALUES (38, 14, 'Karksi-Nuia');
INSERT INTO public.city (id, county_id, name) VALUES (43, 14, 'Suure-Jaani');
INSERT INTO public.city (id, county_id, name) VALUES (44, 14, 'Abja-Paluoja');
INSERT INTO public.city (id, county_id, name) VALUES (5, 14, 'Viljandi');
INSERT INTO public.city (id, county_id, name) VALUES (40, 15, 'Antsla');
INSERT INTO public.city (id, county_id, name) VALUES (12, 15, 'Võru');

INSERT INTO public."user" (id, role_id, username, password, status) VALUES (1, 2, 'usin', '123', 'A');
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (2, 2, 'rosin', '123', 'A');

INSERT INTO public.message (id, letter_title, letter_body, letter_time, sender_user_id, receiver_user_id, is_read) VALUES (1, 'Pealkiri', 'Sisu', '2023-09-07 09:29:57.000000', 1, 2, false);

INSERT INTO public.feedback (id, receiver_user_id, rating, comment) VALUES (1, 1, 5, 'Ideaalne töö');

INSERT INTO public.contact (id, user_id, city_id, image_id, first_name, last_name, mobile_number, email, introduction) VALUES (1, 1, 1, null, 'Usin', 'Rosin', '55555888', 'usinrosin@gmail.com', 'Olen usin rosin. ');
INSERT INTO public.contact (id, user_id, city_id, image_id, first_name, last_name, mobile_number, email, introduction) VALUES (2, 2, 1, null, 'Rosin', 'Usin', '55584448', 'rosinusin@gmail.com', 'Olen rosin usin.');

INSERT INTO public.chore (id, name) VALUES (1, 'Põranda puhastus/pesu');
INSERT INTO public.chore (id, name) VALUES (2, 'Akende pesu');
INSERT INTO public.chore (id, name) VALUES (3, 'Pindade puhastus');
INSERT INTO public.chore (id, name) VALUES (4, 'Ahju puhastus/pliidi puhastus');
INSERT INTO public.chore (id, name) VALUES (5, 'Vannitoa puhastus/katlakivi eemaldus');
INSERT INTO public.chore (id, name) VALUES (6, 'Pesu triikimine');
INSERT INTO public.chore (id, name) VALUES (7, 'Asjade koristus');
INSERT INTO public.chore (id, name) VALUES (8, 'Lillede hooldus');

INSERT INTO public.advertisement (id, user_id, city_id, tool_id, type_id, location_id, description, area, price, time) VALUES (1, 1, 1, 1, 1, null, 'Otsin head koristajat!', 200, 10.50, '2023-09-07 09:38:36.000000');

INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (1, 1, 1);
INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (2, 2, 1);
INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (3, 4, 1);
INSERT INTO public.advertisement_chore (id, chore_id, advertisement_id) VALUES (4, 5, 1);

